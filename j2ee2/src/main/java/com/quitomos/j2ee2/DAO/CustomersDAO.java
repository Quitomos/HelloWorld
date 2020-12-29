package com.quitomos.j2ee2.DAO;

import com.quitomos.j2ee2.Obj.Customers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomersDAO {
    public CustomersDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/crashcourse?characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",
                "root","woshixuziwen");
    }

    public int getTotal() {
        int ans = 0;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "SELECT count(*) FROM customers";

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                ans = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ans;
    }

    public List<Customers> get() {
        List<Customers> ret = new ArrayList<>();
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "SELECT * FROM customers";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                String curname = rs.getNString("cust_name");
                String curcity = rs.getString("cust_city");
                int curid = rs.getInt("cust_id");
                ret.add(new Customers(curname, curcity, curid));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ret;
    }
}
