package com.fanhf.javastudy.mybatistest.bean;

public class BondsBean extends  CommonBean{
    private  Integer  bondId;
    private  String  bondCode;
    private  String  bondName;
    private Integer bondType;
    private  Integer  applyTime;
    private  String  applyNumber;
    private  String  choosedLucklyNumber;
    private  Integer  choosedLucklyTime;
    private  String  givenMoney;
    private  String  profit;
    private  Integer  be_listsTime;
    private  Integer  createTime;
    private  Integer  updateTime;

    public Integer getBondId() {
        return bondId;
    }

    public void setBondId(Integer bondId) {
        this.bondId = bondId;
    }

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public String getBondName() {
        return bondName;
    }

    public void setBondName(String bondName) {
        this.bondName = bondName;
    }

    public Integer getBondType() {
        return bondType;
    }

    public void setBondType(Integer bondType) {
        this.bondType = bondType;
    }

    public Integer getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Integer applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyNumber() {
        return applyNumber;
    }

    public void setApplyNumber(String applyNumber) {
        this.applyNumber = applyNumber;
    }

    public String getChoosedLucklyNumber() {
        return choosedLucklyNumber;
    }

    public void setChoosedLucklyNumber(String choosedLucklyNumber) {
        this.choosedLucklyNumber = choosedLucklyNumber;
    }

    public Integer getChoosedLucklyTime() {
        return choosedLucklyTime;
    }

    public void setChoosedLucklyTime(Integer choosedLucklyTime) {
        this.choosedLucklyTime = choosedLucklyTime;
    }

    public String getGivenMoney() {
        return givenMoney;
    }

    public void setGivenMoney(String givenMoney) {
        this.givenMoney = givenMoney;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public Integer getBe_listsTime() {
        return be_listsTime;
    }

    public void setBe_listsTime(Integer be_listsTime) {
        this.be_listsTime = be_listsTime;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "{" +
                "bondId=" + bondId +
                ", bondCode='" + bondCode + '\'' +
                ", bondName='" + bondName + '\'' +
                ", applyTime=" + applyTime +
                ", applyNumber='" + applyNumber + '\'' +
                ", choosedLucklyNumber='" + choosedLucklyNumber + '\'' +
                ", choosedLucklyTime=" + choosedLucklyTime +
                ", givenMoney='" + givenMoney + '\'' +
                ", profit='" + profit + '\'' +
                ", be_listsTime=" + be_listsTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
