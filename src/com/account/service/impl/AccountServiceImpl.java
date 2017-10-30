package com.account.service.impl;

import com.account.dao.AccountDao;
import com.account.dao.impl.AccountDaoImpl;
import com.account.entity.AccountsEx;
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
    public AccountsEx getAccounts(int id, Date date) throws SQLException {
        return accountDao.getAccounts(id, date);
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
}
