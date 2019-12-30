package com.maike.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {
    private static String url = "jdbc:mysql://127.0.0.1:3306/webstore?useSSL=false&serverTimezone=UTC";
    private static String rootName = "root";
    private static String rootPwd = "123456";

    private ConnectionUtil() {
    }

    ;

    static {
        try {
            /*加载驱动*/
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * getConnection:创建连接.<br/>
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, rootName, rootPwd);
    }

    /**
     * closeRe:关闭连接.<br/>
     *
     * @param con
     * @param pt
     * @param rs
     */
    public static void closeRe(Connection con, PreparedStatement pt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                if (pt != null) {
                    try {
                        pt.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } finally {
                        if (con != null) {
                            try {
                                con.close();
                            } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * closeRe:关闭连接.<br/>
     *
     * @param con
     * @param pt
     */
    public static void closeRe(Connection con, PreparedStatement pt) {
        if (pt != null) {
            try {
                pt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}