package com.account.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * 账目实体类
 *
 * @author Neal
 */
public class Accounts implements Serializable {
    private Integer recordId;

    private Integer userId;

    private String recordName;

    private String recordType;

    private String recordMode;

    private BigDecimal money;

    private Timestamp recordDate;

    private String recordRemark;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getRecordMode() {
        return recordMode;
    }

    public void setRecordMode(String recordMode) {
        this.recordMode = recordMode;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Timestamp getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Timestamp recordDate) {
        this.recordDate = recordDate;
    }

    public String getRecordRemark() {
        return recordRemark;
    }

    public void setRecordRemark(String recordRemark) {
        this.recordRemark = recordRemark == null ? null : recordRemark.trim();
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "recordId=" + recordId +
                ", userId=" + userId +
                ", recordName=" + recordName +
                ", recordType=" + recordType +
                ", recordMode=" + recordMode +
                ", money=" + money +
                ", recordDate=" + recordDate +
                ", recordRemark='" + recordRemark + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Accounts)) {
            return false;
        }
        Accounts accounts = (Accounts) o;
        return Objects.equals(getRecordId(), accounts.getRecordId()) &&
                Objects.equals(getUserId(), accounts.getUserId()) &&
                Objects.equals(getRecordName(), accounts.getRecordName()) &&
                Objects.equals(getRecordType(), accounts.getRecordType()) &&
                Objects.equals(getRecordMode(), accounts.getRecordMode()) &&
                Objects.equals(getMoney(), accounts.getMoney()) &&
                Objects.equals(getRecordDate(), accounts.getRecordDate()) &&
                Objects.equals(getRecordRemark(), accounts.getRecordRemark());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecordId(), getUserId(), getRecordName(), getRecordType(), getRecordMode(), getMoney(), getRecordDate(), getRecordRemark());
    }
}