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

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
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