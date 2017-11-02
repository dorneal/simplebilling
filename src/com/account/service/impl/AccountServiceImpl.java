package com.account.service.impl;

import com.account.dao.AccountDao;
import com.account.dao.impl.AccountDaoImpl;
import com.account.entity.AccountsEx;
import com.account.entity.PageBean;
import com.account.service.AccountService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * 账目服务接口实现类
 *
 * @author Neal
 */
public class AccountServiceImpl implements AccountService {
    private static AccountDao accountDao = new AccountDaoImpl();

    @Override
    public List<AccountsEx> listAccounts(int id) throws SQLException {
        return accountDao.listAccounts(id);
    }

    @Override
    public AccountsEx getAccountsByDate(int id, Date date) throws SQLException {
        return accountDao.getAccountsByDate(id, date);
    }

    @Override
    public List<AccountsEx> listAccountsByDate(int id, Date date, Date date2) throws SQLException {
        return accountDao.listAccountsByDate(id, date, date2);
    }

    @Override
    public void saveAccounts(AccountsEx accountsEx) throws SQLException {
        accountDao.saveAccounts(accountsEx);
    }

    @Override
    public void updateAccounts(AccountsEx accountsEx) throws SQLException {
        accountDao.updateAccounts(accountsEx);
    }

    @Override
    public void removeAccounts(int id) throws SQLException {
        accountDao.removeAccounts(id);
    }

    @Override
    public List<AccountsEx> listWeekAccounts() throws SQLException {
        return null;
    }

    @Override
    public List<AccountsEx> listMonthAccounts() throws SQLException {
        return null;
    }

    @Override
    public List<AccountsEx> listAllAccounts() throws SQLException {
        return null;
    }

    @Override
    public PageBean<AccountsEx> pageListAccounts(int currentPage, int id, int pageSize) throws SQLException {
        PageBean<AccountsEx> pageBean = new PageBean<>();
        // 封装当前页
        pageBean.setCurrPage(currentPage);
        // 封装页面大小
        pageBean.setPageSize(pageSize);
        // 封装总记录数
        int totalCount = accountDao.counts(id);
        pageBean.setTotalCount(totalCount);
        // 封装总页数
        Double tc = Math.ceil(totalCount / pageSize);
        pageBean.setTotalPage(tc.intValue());
        // 封装每页数据
        List<AccountsEx> list = accountDao.listLimitAccounts(id, (currentPage - 1) * pageSize, pageSize);
        pageBean.setLists(list);
        return pageBean;
    }

    @Override
    public AccountsEx getAccounts(int id) throws SQLException {
        return accountDao.getAccounts(id);
    }
}
