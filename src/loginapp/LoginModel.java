package loginapp;

import dbUtil.dbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    Connection connection;

    public LoginModel() {
        try {
            this.connection = dbConnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(this.connection == null) {
            System.exit(1);
        }
    }

    public boolean isDbConnected() {
        System.out.print("here");
        return this.connection != null;
    }

    public boolean isLoggedIn(String user, String password) throws Exception{
        PreparedStatement pr = null;
        ResultSet res = null;

        String sql = "SELECT * FROM login where username = ? and password = ?";
        try {
            pr = this.connection.prepareStatement(sql);
            pr.setString(1, user);
            pr.setString(2, password);

            res = pr.executeQuery();

            while (res.next()) {
                return true;
            }
            return false;

        } catch (SQLException e) {
            return false;

        }

        finally {
            pr.close();
            res.close();
        }

    }
}
