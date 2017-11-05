package com.account.servlet.account;

import com.account.entity.UsersEx;
import com.account.util.ExportExcelUtil;
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
        // 获取session中的user对象
        UsersEx usersEx = (UsersEx) request.getSession().getAttribute("user");
        // 拿到用户的注册日期
        java.util.Date date = usersEx.getRegisterDate();
        try {
            // 调用Excel工具类导出方法，参数一，用户ID，参数二，注册时的日期，参数三，当前时间
            HSSFWorkbook wb = ExportExcelUtil.export(usersEx.getUserId(),
                    new Date(date.getTime()),
                    new Timestamp(System.currentTimeMillis()), "所有账目");
            // 设置响应类型
            response.setContentType("application/vnd.ms-excel");
            // 设置响应头部
            response.setHeader("Content-disposition", "attachment;filename=myAccountOfAll.xls");
            // 进行输出
            OutputStream ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
