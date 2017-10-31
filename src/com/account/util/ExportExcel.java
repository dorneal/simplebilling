package com.account.util;

import com.account.entity.AccountsEx;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 导出Excel工具类
 *
 * @param <T>
 * @author Neal
 */
public class ExportExcel<T> {
    private static List<AccountsEx> listAccounts() throws Exception {
        List<AccountsEx> list = new ArrayList();
        AccountsEx accountsEx = new AccountsEx();
        accountsEx.setRecordRemark("测试数据");
        accountsEx.setRecordId(1);
        accountsEx.setRecordType(1);
        accountsEx.setRecordName(1);
        accountsEx.setRecordMode(1);
        accountsEx.setMoney(BigDecimal.TEN);
        accountsEx.setBookId(1);
        accountsEx.setRecordDate(new Timestamp(System.currentTimeMillis()));
        list.add(accountsEx);
        return list;
    }

    public static void main(String[] args) {
        //第一步，创建一个workbook,对应一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //第二步，在workbook中添加一个sheet，对弈Excel中的sheet
        HSSFSheet sheet = workbook.createSheet();
        //第三步，在sheet中添加表头第0行，注意老版本poi对Excel的行列数有限制short
        HSSFRow row = sheet.createRow(0);
        //第四步，创建单元格，并设置表头，设置表头居中
        HSSFCellStyle style = workbook.createCellStyle();
        //设置一个居中样式
        style.setAlignment(HorizontalAlignment.CENTER);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("学号");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("姓名");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("年龄");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("生日");
        cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellValue("生日");
        cell.setCellStyle(style);
        cell = row.createCell(5);
        cell.setCellValue("生日");
        cell.setCellStyle(style);
        cell = row.createCell(6);
        cell.setCellValue("生日");
        cell.setCellStyle(style);
        cell = row.createCell(7);
        cell.setCellValue("生日");
        cell.setCellStyle(style);

        //第五步，写入实体数据，实际应用中这些数据从数据库得到
        try {
            List<AccountsEx> list = ExportExcel.listAccounts();
            for (int i = 0; i < list.size(); i++) {
                row = sheet.createRow(i + 1);
                AccountsEx accountsEx = list.get(i);
                // 创建单元格
                row.createCell(0).setCellValue(accountsEx.getBookId());
                row.createCell(1).setCellValue(accountsEx.getRecordDate());
                row.createCell(2).setCellValue(accountsEx.getRecordId());
                row.createCell(3).setCellValue(accountsEx.getRecordMode());
                row.createCell(4).setCellValue(accountsEx.getRecordName());
                row.createCell(5).setCellValue(accountsEx.getRecordRemark());
                row.createCell(6).setCellValue(String.valueOf(accountsEx.getMoney()));
                row.createCell(7).setCellValue(accountsEx.getRecordType());
            }
            FileOutputStream fileOutputStream = new FileOutputStream("D:/accounts.xls");
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
