package com.fanhf.javastudy.performances;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-11-10 10:44
 */
public class MonitorInfoBean {
    private long totalMemory;
    private long freeMemory;
    private long maxMemory;
    private String osName;
    private long totalMemorySize;
    private long freePhysicalMemorySize;
    private long usedMemory;
    private int totalThread;
    private double cpuRatio;

    public MonitorInfoBean() {
    }

    public long getTotalMemory() {
        return this.totalMemory;
    }

    public long getFreeMemory() {
        return this.freeMemory;
    }

    public long getMaxMemory() {
        return this.maxMemory;
    }

    public String getOsName() {
        return this.osName;
    }

    public long getTotalMemorySize() {
        return this.totalMemorySize;
    }

    public long getFreePhysicalMemorySize() {
        return this.freePhysicalMemorySize;
    }

    public long getUsedMemory() {
        return this.usedMemory;
    }

    public int getTotalThread() {
        return this.totalThread;
    }

    public double getCpuRatio() {
        return this.cpuRatio;
    }

    public void setTotalMemory(final long totalMemory) {
        this.totalMemory = totalMemory;
    }

    public void setFreeMemory(final long freeMemory) {
        this.freeMemory = freeMemory;
    }

    public void setMaxMemory(final long maxMemory) {
        this.maxMemory = maxMemory;
    }

    public void setOsName(final String osName) {
        this.osName = osName;
    }

    public void setTotalMemorySize(final long totalMemorySize) {
        this.totalMemorySize = totalMemorySize;
    }

    public void setFreePhysicalMemorySize(final long freePhysicalMemorySize) {
        this.freePhysicalMemorySize = freePhysicalMemorySize;
    }

    public void setUsedMemory(final long usedMemory) {
        this.usedMemory = usedMemory;
    }

    public void setTotalThread(final int totalThread) {
        this.totalThread = totalThread;
    }

    public void setCpuRatio(final double cpuRatio) {
        this.cpuRatio = cpuRatio;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof MonitorInfoBean)) {
            return false;
        } else {
            MonitorInfoBean other = (MonitorInfoBean) o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getTotalMemory() != other.getTotalMemory()) {
                return false;
            } else if (this.getFreeMemory() != other.getFreeMemory()) {
                return false;
            } else if (this.getMaxMemory() != other.getMaxMemory()) {
                return false;
            } else {
                Object this$osName = this.getOsName();
                Object other$osName = other.getOsName();
                if (this$osName == null) {
                    if (other$osName != null) {
                        return false;
                    }
                } else if (!this$osName.equals(other$osName)) {
                    return false;
                }

                if (this.getTotalMemorySize() != other.getTotalMemorySize()) {
                    return false;
                } else if (this.getFreePhysicalMemorySize() != other.getFreePhysicalMemorySize()) {
                    return false;
                } else if (this.getUsedMemory() != other.getUsedMemory()) {
                    return false;
                } else if (this.getTotalThread() != other.getTotalThread()) {
                    return false;
                } else if (Double.compare(this.getCpuRatio(), other.getCpuRatio()) != 0) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MonitorInfoBean;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        long $totalMemory = this.getTotalMemory();
         result = result * 59 + (int) ($totalMemory >>> 32 ^ $totalMemory);
        long $freeMemory = this.getFreeMemory();
        result = result * 59 + (int) ($freeMemory >>> 32 ^ $freeMemory);
        long $maxMemory = this.getMaxMemory();
        result = result * 59 + (int) ($maxMemory >>> 32 ^ $maxMemory);
        Object $osName = this.getOsName();
        result = result * 59 + ($osName == null ? 43 : $osName.hashCode());
        long $totalMemorySize = this.getTotalMemorySize();
        result = result * 59 + (int) ($totalMemorySize >>> 32 ^ $totalMemorySize);
        long $freePhysicalMemorySize = this.getFreePhysicalMemorySize();
        result = result * 59 + (int) ($freePhysicalMemorySize >>> 32 ^ $freePhysicalMemorySize);
        long $usedMemory = this.getUsedMemory();
        result = result * 59 + (int) ($usedMemory >>> 32 ^ $usedMemory);
        result = result * 59 + this.getTotalThread();
        long $cpuRatio = Double.doubleToLongBits(this.getCpuRatio());
        result = result * 59 + (int) ($cpuRatio >>> 32 ^ $cpuRatio);
        return result;
    }

    public String toString() {
        return "MonitorInfoBean(totalMemory=" + this.getTotalMemory() + ", freeMemory=" + this.getFreeMemory() + ", maxMemory=" + this.getMaxMemory() + ", osName=" + this.getOsName() + ", totalMemorySize=" + this.getTotalMemorySize() + ", freePhysicalMemorySize=" + this.getFreePhysicalMemorySize() + ", usedMemory=" + this.getUsedMemory() + ", totalThread=" + this.getTotalThread() + ", cpuRatio=" + this.getCpuRatio() + ")";
    }
}
