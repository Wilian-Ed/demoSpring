package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
        public static String driver = "com.mysql.cj.jdbc.Driver";
        public static String dataBase = "PruebaSean";
        public static String host = "database-translate.c8ronwn6tuzp.us-east-1.rds.amazonaws.com";
        public static String user = "admin";
        public static String password = "admin11223344";
        public static String url;
        private static Connection conn;

        public ConnectionDB() {
            conn = null;

            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException | ClassNotFoundException var2) {
                var2.printStackTrace();
                System.out.println("Internal Error: " + var2.getMessage());
            }
        }

        public Connection getConnection() {
            return conn;
        }

        public void offlineDataBase() {
            conn = null;
            System.out.println(conn == null ? "Data base is Desconected succssesful" : "You are connected alredy");
        }

        static {
            url = "jdbc:mysql://" + host + "/" + dataBase + "?verifyServerCertificate=false&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        }
}

