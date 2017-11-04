package com.account.servlet.account;

import com.account.entity.UsersEx;
import com.account.util.ExportExcel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 将所有账目导出Excel
 *
 * @author Neal
 */
public class ExportAccountByAllServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersEx usersEx = (UsersEx) request.getSession().getAttribute("user");
        java.util.Date date = usersEx.getRegisterDate();
        try {
            // 调用Excel工具类导出方法
            HSSFWorkbook wb = ExportExcel.export(usersEx.getUserId(),
                    new Date(date.getTime()),
                    new Timestamp(System.currentTimeMillis()), "所有账目");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=myAccountOfAll.xls");
            OutputStream ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
