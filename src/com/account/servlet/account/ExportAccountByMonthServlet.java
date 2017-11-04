package com.account.servlet.account;

import com.account.entity.UsersEx;
import com.account.util.DateJudgmentUtil;
import com.account.util.ExportExcel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;

/**
 * 将本月账目导出Excel
 *
 * @author Neal
 */
public class ExportAccountByMonthServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersEx usersEx = (UsersEx) request.getSession().getAttribute("user");
        Date sqlDate = new Date(new java.util.Date().getTime());
        try {
            // 调用Excel工具类导出方法
            HSSFWorkbook wb = ExportExcel.export(usersEx.getUserId(),
                    new Date(DateJudgmentUtil.getPeriodOfWeek(DateJudgmentUtil.dayForMonth(sqlDate)).getTime()),
                    sqlDate, "本月账本");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=myAccountOfMonth.xls");
            OutputStream ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
