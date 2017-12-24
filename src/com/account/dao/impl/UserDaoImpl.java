package com.account.dao.impl;

import com.account.dao.UserDao;
import com.account.entity.UsersEx;
import com.account.util.DbPoolUtil;

import java.sql.*;

/**
 * 用户DAO实现类
 *
 * @author Neal
 */
public class UserDaoImpl implements UserDao {
    private static Connection conn;

    static {
        try {
            conn = DbPoolUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UsersEx login(UsersEx usersEx) {
        UsersEx usersEx1 = new UsersEx();
        String sql = "SELECT * FROM users WHERE User_password=? AND User_phoneNum=?;";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, usersEx.getUserPassword());
            preparedStatement.setString(2, usersEx.getUserPhonenum());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int index = 1;
                usersEx1.setUserId(resultSet.getInt(index++));
                usersEx1.setUserName(resultSet.getString(index++));
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
        String sql = "INSERT INTO users(User_name, User_password, User_sex,User_phoneNum,User_signature, User_email,Register_date) VALUES(?,?,?,?,?,?,?);";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            int index = 1;
            preparedStatement.setString(index++, usersEx.getUserName());
            preparedStatement.setString(index++, usersEx.getUserPassword());
            preparedStatement.setString(index++, usersEx.getUserSex());
            preparedStatement.setString(index++, usersEx.getUserPhonenum());
            preparedStatement.setString(index++, usersEx.getUserSignature());
            preparedStatement.setString(index++, usersEx.getUserEmail());
            preparedStatement.setTimestamp(index, usersEx.getRegisterDate());
            preparedStatement.execute();
        }
    }

    @Override
    public void update(UsersEx usersEx) throws SQLException {
        String sql = "UPDATE users SET User_name=?,User_sex=?,User_phoneNum=?,User_signature=?,User_email=? WHERE User_id=?;";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            int index = 1;
            preparedStatement.setString(index++, usersEx.getUserName());
            preparedStatement.setString(index++, usersEx.getUserSex());
            preparedStatement.setString(index++, usersEx.getUserPhonenum());
            preparedStatement.setString(index++, usersEx.getUserSignature());
            preparedStatement.setString(index++, usersEx.getUserEmail());
            preparedStatement.setInt(index, usersEx.getUserId());
            preparedStatement.execute();
        }
    }

    @Override
    public int existPhoneNum(UsersEx usersEx) throws SQLException {
        String sql = "SELECT COUNT(*) FROM users WHERE User_phoneNum=?;";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, usersEx.getUserPhonenum());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            if (count != 0) {
                return count;

            }
        }
        return 0;
    }

    @Override
    public int existUserName(UsersEx usersEx) throws SQLException {
        String sql = "SELECT COUNT(*) FROM users WHERE User_name=?;";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, usersEx.getUserName());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            if (count != 0) {
                return count;
            }
        }
        return 0;
    }

    @Override
    public int existEmail(UsersEx usersEx) throws SQLException {
        String sql = "SELECT COUNT(*) FROM users WHERE User_email=?;";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, usersEx.getUserEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            if (count != 0) {
                return count;

            }
        }
        return 0;
    }

    @Override
    public boolean modifyPassword(UsersEx usersEx, String newPassword) throws SQLException {
        String sql = "UPDATE users SET User_password=? WHERE User_id=? AND User_password=? ";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setInt(2, usersEx.getUserId());
            preparedStatement.setString(3, usersEx.getUserPassword());
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet == 1) {
                return true;
            }
        }
        return false;
    }
}
