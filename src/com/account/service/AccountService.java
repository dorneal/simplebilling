package com.account.service;

import com.account.entity.AccountsEx;
import com.account.entity.PageBean;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * 账目服务接口
 *
 * @author Neal
 */
public interface AccountService {
    /**
     * 查询所有账目记录
     *
     * @param id 用户ID
     * @return List
     * @throws SQLException SQLException
     */
    List<AccountsEx> listAccounts(int id) throws SQLException;

    /**
     * 根据用户跟日期，搜索查询一条记录
     *
     * @param id   用户ID
     * @param date 时间
     * @return Accounts
     * @throws SQLException SQLException
     */
    AccountsEx getAccountsByDate(int id, Date date) throws SQLException;

    /**
     * 查询指定日期范围的记录,用于图表显示
     *
     * @param id    用户ID
     * @param date  日期端1
     * @param date2 日期端2
     * @return List
     * @throws SQLException SQLException
     */
    List<AccountsEx> listAccountsByDate(int id, Date date, Date date2) throws SQLException;

    /**
     * 查询指定日期范围的记录
     *
     * @param id    用户ID
     * @param date  日期端1
     * @param date2 日期端2
     * @return List
     * @throws SQLException SQLException
     */
    List<AccountsEx> listAccountsByDateOfExcel(int id, Date date, Date date2) throws SQLException;

    /**
     * 插入一条账目
     *
     * @param accountsEx 账目对象
     * @throws SQLException SQLException
     */
    void saveAccounts(AccountsEx accountsEx) throws SQLException;

    /**
     * 修改账目
     *
     * @param accountsEx 账目对象
     * @throws SQLException SQLExcption
     */
    void updateAccounts(AccountsEx accountsEx) throws SQLException;

    /**
     * 删除一条账目记录
     *
     * @param id 账目id
     * @throws SQLException SQLException
     */
    void removeAccounts(int id) throws SQLException;

    /**
     * 分页查询显示记录
     *
     * @param id          用户ID
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return PageBean对象
     * @throws SQLException SQLException
     */
    PageBean<AccountsEx> pageListAccounts(int currentPage, int id, int pageSize) throws SQLException;


    /**
     * 根据账目ID,获取单条账目
     *
     * @param id 账目ID
     * @return AccountsEx
     * @throws SQLException SQLException
     */
    AccountsEx getAccounts(int id) throws SQLException;
}
