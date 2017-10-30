package com.account.dao.impl;

import com.account.dao.UserDao;
import com.account.entity.UsersEx;
import com.account.util.DBPoolUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用户DAO实现类
 *
 * @author Neal
 */
public class UserDaoImpl implements UserDao {
    private static Connection conn;

    static {
        try {
            conn = DBPoolUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UsersEx login(UsersEx usersEx) throws SQLException {
        UsersEx usersEx1 = new UsersEx();
        String sql = "SELECT * FROM users WHERE User_password=? AND User_name=? OR  User_email=? OR User_phonenum=?;";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            int index2 = 1;
            preparedStatement.setString(index2++, usersEx.getUserPassword());
            preparedStatement.setString(index2++, usersEx.getUserName());
            preparedStatement.setString(index2++, usersEx.getUserEmail());
            preparedStatement.setString(index2, usersEx.getUserPhonenum());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int index = 1;
                usersEx1.setUserId(resultSet.getInt(index++));
                usersEx1.setUserName(resultSet.getString(index++));
                usersEx1.setUserAvatar(resultSet.getString(index++));
                usersEx1.setUserPassword(resultSet.getString(index++));
                usersEx1.setUserSex(resultSet.getString(index++));
                usersEx1.setUserPhonenum(resultSet.getString(index++));
                usersEx1.setUserSignature(resultSet.getString(index++));
                usersEx1.setUserEmail(resultSet.getString(index++));
                usersEx1.setRegisterDate(resultSet.getTimestamp(index));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (usersEx1.getUserId() != null) {
            return usersEx1;
        }
        return null;
    }

    @Override
    public void saveUser(UsersEx usersEx) throws SQLException {
        String sql = "INSERT INTO users VALUES(?,?,?,?,?,?,?,?);";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            int index = 1;
            preparedStatement.setString(index++, usersEx.getUserName());
            preparedStatement.setString(index++, usersEx.getUserAvatar());
            preparedStatement.setString(index++, usersEx.getUserPassword());
            preparedStatement.setString(index++, usersEx.getUserSex());
            preparedStatement.setString(index++, usersEx.getUserPhonenum());
            preparedStatement.setString(index++, usersEx.getUserSignature());
            preparedStatement.setString(index++, usersEx.getUserEmail());
            preparedStatement.setTimestamp(index, usersEx.getRegisterDate());
            preparedStatement.execute();
            preparedStatement.close();
        }
    }

    @Override
    public void update(UsersEx usersEx) throws SQLException {
        String sql = "UPDATE users SET User_name=?,User_Avatar=?,User_password=?,User_sex=?,User_phoneNum=?,User_signature=?,User_email=?,Register_date=? WHERE User_id=?;";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            int index = 1;
            preparedStatement.setString(index++, usersEx.getUserName());
            preparedStatement.setString(index++, usersEx.getUserAvatar());
            preparedStatement.setString(index++, usersEx.getUserPassword());
            preparedStatement.setString(index++, usersEx.getUserSex());
            preparedStatement.setString(index++, usersEx.getUserPhonenum());
            preparedStatement.setString(index++, usersEx.getUserSignature());
            preparedStatement.setString(index++, usersEx.getUserEmail());
            preparedStatement.setTimestamp(index++, usersEx.getRegisterDate());
            preparedStatement.setInt(index, usersEx.getUserId());
            preparedStatement.execute();
            preparedStatement.close();
        }
    }

    @Override
    public boolean existPhoneNum(UsersEx usersEx) throws SQLException {
        String sql = "SELECT COUNT(*) FROM users WHERE User_phoneNum=?;";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, usersEx.getUserPhonenum());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            if (count < 1) {
                return true;
            }
            preparedStatement.close();
        }
        return false;
    }

    @Override
    public boolean existUserName(UsersEx usersEx) throws SQLException {
        String sql = "SELECT COUNT(*) FROM users WHERE User_name=?;";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, usersEx.getUserName());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            if (count < 1) {
                return true;
            }
            preparedStatement.close();
        }
        return false;
    }

    @Override
    public boolean existEmail(UsersEx usersEx) throws SQLException {
        String sql = "SELECT COUNT(*) FROM users WHERE User_email=?;";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, usersEx.getUserEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            if (count < 1) {
                return true;
            }
            preparedStatement.close();
        }
        return false;
    }
}
