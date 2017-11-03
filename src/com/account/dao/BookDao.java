package com.account.dao;

import com.account.entity.BooksEx;

import java.sql.SQLException;
import java.util.List;

/**
 * 账本DAO接口
 *
 * @author Neal
 */
public interface BookDao {

    /**
     * 查询所有账本
     *
     * @return List
     * @throws SQLException SQLException
     */
    List<BooksEx> listBook() throws SQLException;
}
