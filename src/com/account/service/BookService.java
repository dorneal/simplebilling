package com.account.service;

import com.account.entity.BooksEx;

import java.sql.SQLException;
import java.util.List;

/**
 * 账本服务接口
 *
 * @author Neal
 */
public interface BookService {

    /**
     * 查询所有账本
     *
     * @return List
     * @throws SQLException SQLException
     */
    List<BooksEx> listBook() throws SQLException;

}
