package com.account.service.impl;

import com.account.dao.BookDao;
import com.account.dao.impl.BookDaoImpl;
import com.account.entity.BooksEx;
import com.account.service.BookService;

import java.sql.SQLException;
import java.util.List;

/**
 * 用户服务接口实现类
 *
 * @author Neal
 */
public class BookServiceImpl implements BookService {
    private static BookDao bookDao = new BookDaoImpl();

    @Override
    public List<BooksEx> listBook() throws SQLException {
        return bookDao.listBook();
    }
}
