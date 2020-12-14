package com.fanhf.javastudy.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author fanhf
 * @Description 从platform偷来的雪花算法
 * @date 2020-12-09 15:53
 */
public class SnowflakeIdFactory {
    private static final Logger log = LoggerFactory.getLogger(SnowflakeIdFactory.class);
//    private final long twepoch = 1288834974657L;
//    private final long workerIdBits = 5L;
//    private final long datacenterIdBits = 5L;
//    private final long sequenceBits = 12L;
//    private final long workerIdShift = 12L;
//    private final long datacenterIdShift = 17L;
//    private final long timestampLeftShift = 22L;
//    private final long sequenceMask = 4095L;
    @Value("${snowflake.workerId}")
    private long workerId;
    @Value("${snowflake.datacenterId}")
    private long datacenterId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public SnowflakeIdFactory() {
    }

    @PostConstruct
    public void alterSnowSeed() {
        String osName = System.getProperty("os.name");
        if (StringUtils.containsIgnoreCase(osName, "linux")) {
            log.info("雪花算法 - linux - 使用本机IP作为种子");
            String ip = null;

            try {
                Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();

                label54:
                while(true) {
                    NetworkInterface ni;
                    do {
                        do {
                            if (!netInterfaces.hasMoreElements()) {
                                break label54;
                            }

                            ni = (NetworkInterface)netInterfaces.nextElement();
                        } while(StringUtils.containsIgnoreCase(ni.getName(), "lo"));
                    } while(!StringUtils.equalsIgnoreCase(ni.getName(), "eth0"));

                    Enumeration addresses = ni.getInetAddresses();

                    while(addresses.hasMoreElements()) {
                        InetAddress ips = (InetAddress)addresses.nextElement();
                        if (ips != null && ips instanceof Inet4Address) {
                            ip = ips.getHostAddress();
                            break label54;
                        }
                    }
                }
            } catch (SocketException var7) {
                var7.printStackTrace();
            }

            log.info("获取到的本机IP地址 = {}", ip);
            if (!StringUtils.isEmpty(ip)) {
                String lastIP = ip.substring(ip.lastIndexOf(".") + 1);
                lastIP = lastIP.trim();
                if (lastIP.length() == 1) {
                    lastIP = "00" + lastIP;
                } else if (lastIP.length() == 2) {
                    lastIP = "0" + lastIP;
                }

                this.workerId = Long.parseLong(String.valueOf(lastIP.charAt(1)));
                this.datacenterId = Long.parseLong(String.valueOf(lastIP.charAt(2)));
                log.info("完成修改雪花算法种子 workerId = {}, datacenterId = {}", this.workerId, this.datacenterId);
            } else {
                log.error("获取到的本机IP地址无效，继续使用配置文件中的种子");
            }
        } else {
            log.info("雪花算法 - windows - 使用配置文件中的种子");
        }

    }

    public synchronized long nextId() {
        long timestamp = this.timeGen();
        if (timestamp < this.lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards. Refusing to generate id for %d milliseconds", this.lastTimestamp - timestamp));
        } else {
            if (this.lastTimestamp == timestamp) {
                this.sequence = this.sequence + 1L & 4095L;
                if (this.sequence == 0L) {
                    timestamp = this.tilNextMillis(this.lastTimestamp);
                }
            } else {
                this.sequence = 0L;
            }

            this.lastTimestamp = timestamp;
            return timestamp - 1288834974657L << 22 | this.datacenterId << 17 | this.workerId << 12 | this.sequence;
        }
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp;
        for(timestamp = this.timeGen(); timestamp <= lastTimestamp; timestamp = this.timeGen()) {
        }

        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    public long getWorkerId() {
        return this.workerId;
    }

    public void setWorkerId(long workerId) {
        this.workerId = workerId;
    }

    public long getDatacenterId() {
        return this.datacenterId;
    }

    public void setDatacenterId(long datacenterId) {
        this.datacenterId = datacenterId;
    }
}
