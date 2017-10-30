package com.account.dao.impl;

import com.account.dao.BookDao;
import com.account.entity.BooksEx;
import com.account.util.DBPoolUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 账本DAO实现类
 *
 * @author Neal
 */
public class BookDaoImpl implements BookDao {
    private static Connection connection;

    static {
        try {
            connection = DBPoolUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BooksEx> listBook() throws SQLException {
        String sql = "SELECT * FROM books;";
        List<BooksEx> booksExList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int index = 1;
                BooksEx booksEx = new BooksEx();
                booksEx.setBookId(resultSet.getInt(index++));
                booksEx.setBookName(resultSet.getString(index));
                System.out.println(booksEx.toString());
                booksExList.add(booksEx);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booksExList;
    }
}
