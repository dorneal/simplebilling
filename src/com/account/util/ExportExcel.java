package com.account.util;

import com.account.entity.AccountsEx;
import com.account.service.AccountService;
import com.account.service.impl.AccountServiceImpl;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

/**
 * 导出Excel工具类
 *
 * @author Neal
 */
public class ExportExcel {
    /**
     * Excel导出类
     *
     * @param id       用户ID
     * @param date1    起始时间
     * @param date2    截止时间
     * @param fileName 内容名
     * @return HSSFWorkbook
     * @throws SQLException SQLException
     */
    public static HSSFWorkbook export(int id, Date date1, Timestamp date2, String fileName) throws SQLException {
        //第一步，创建一个workbook,对应一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();

        //第二步，在workbook中添加一个sheet，对应Excel中的sheet
        HSSFSheet sheet = workbook.createSheet("我的账本");

        //第三步，在sheet中添加表头第0行，注意老版本poi对Excel的行列数有限制short
        // 创建第一行
        HSSFRow row2 = sheet.createRow(0);

        // 创建单元格
        HSSFCell cell1 = row2.createCell(0);

        //设置一个居中样式
        HSSFCellStyle style = workbook.createCellStyle();

        // 设置单元格内容
        // 设置水平居中
        style.setAlignment(HorizontalAlignment.CENTER);

        // 单元行背景色
        style.setFillBackgroundColor(Short.MAX_VALUE);

        // 设置垂直居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        //设置字体
        HSSFFont fontStyle = workbook.createFont();
        fontStyle.setFontName("宋体");
        fontStyle.setFontHeight((short) 465);
        fontStyle.setBold(true);
        style.setFont(fontStyle);

        // 设置第一行第一列
        cell1.setCellValue(fileName);
        cell1.setCellStyle(style);

        // 合并单元格CellRangeAddress构造依次表示起始行，截止行，起始列，截止列
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 6));

        //第四步，创建单元格，并设置表头，设置表头居中
        // 在sheet里创建第二行
        HSSFRow row = sheet.createRow(2);

        //设置第二行标题
        int index = 0;
        HSSFCellStyle style2 = workbook.createCellStyle();
        style2.setAlignment(HorizontalAlignment.CENTER);
        style2.setVerticalAlignment(VerticalAlignment.CENTER);
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style2.setFont(font);
        HSSFCell cell = row.createCell(index++);
        cell.setCellValue("收/支");
        cell.setCellStyle(style2);
        cell = row.createCell(index++);
        cell.setCellValue("类型");
        cell.setCellStyle(style2);
        cell = row.createCell(index++);
        cell.setCellValue("支付方式");
        cell.setCellStyle(style2);
        cell = row.createCell(index++);
        cell.setCellValue("金额");
        cell.setCellStyle(style2);
        cell = row.createCell(index++);
        cell.setCellValue("日期");
        cell.setCellStyle(style2);
        cell = row.createCell(index);
        cell.setCellValue("备注");
        cell.setCellStyle(style2);

        //第五步，写入实体数据，实际应用中这些数据从数据库得到
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        AccountService accountService = new AccountServiceImpl();
        List<AccountsEx> list = accountService.listAccountsByDateOfExcel(id, date1, date2);
        for (int i = 0; i < list.size(); i++) {
            int index2 = 0;
            row = sheet.createRow(i + 3);
            AccountsEx accountsEx = list.get(i);
            // 创建单元格
            row.createCell(index2++).setCellValue(accountsEx.getRecordName());
            row.createCell(index2++).setCellValue(accountsEx.getRecordType());
            row.createCell(index2++).setCellValue(accountsEx.getRecordMode());
            row.createCell(index2++).setCellValue(String.valueOf(accountsEx.getMoney()));
            row.createCell(index2++).setCellValue(format.format(accountsEx.getRecordDate()));
            row.createCell(index2).setCellValue(accountsEx.getRecordRemark());
        }
        return workbook;
    }
}
