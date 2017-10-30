package com.account.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 账目实体类
 *
 * @author Neal
 */
public class Accounts implements Serializable {
    private Integer recordId;

    private Integer bookId;

    private Integer recordName;

    private Integer recordType;

    private Integer recordMode;

    private BigDecimal money;

    private Timestamp recordDate;

    private String recordRemark;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getRecordName() {
        return recordName;
    }

    public void setRecordName(Integer recordName) {
        this.recordName = recordName;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Integer getRecordMode() {
        return recordMode;
    }

    public void setRecordMode(Integer recordMode) {
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
                ", bookId=" + bookId +
                ", recordName=" + recordName +
                ", recordType=" + recordType +
                ", recordMode=" + recordMode +
                ", money=" + money +
                ", recordDate=" + recordDate +
                ", recordRemark='" + recordRemark + '\'' +
                '}';
    }
}