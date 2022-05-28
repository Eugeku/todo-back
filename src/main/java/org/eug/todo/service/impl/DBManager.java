package org.eug.todo.service.impl;

import org.h2.tools.DeleteDbFiles;
import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Temporary class, it will be reformat
 */
// TODO: review this class and create smth more interesting
public class DBManager {
    private static final String USER = "sa";
    private static final String PASS = "";
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/test";
    private static Server server;

    public static boolean startDB() {
        try {
            server = Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Used only for detecting server status. Now its deprecated method.
     */
    @Deprecated
    public static String status() {
        return server.getStatus();
    }

    public static boolean stopDB() {
        try {
            Server.shutdownTcpServer("tcp://localhost:9092", "", true, true);
            System.out.println("Deleting database...");
            DeleteDbFiles.execute("~", "test", false);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean createTable() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); Statement stmt = conn.createStatement()) {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to a selected database...");
            System.out.println("Creating table in given database...");
            String sql = "CREATE TABLE TASKS (id serial not null AUTO_INCREMENT constraint TASKS_pkey primary key, "
                    + "name VARCHAR(255), "
                    + "description VARCHAR(255), "
                    + "priority INTEGER, "
                    + "startDate DATE);";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean autoFillTable() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); Statement stmt = conn.createStatement()) {
            System.out.println("Connecting to a selected database...");
            System.out.println("Inserting records into the table...");
            populateVehicle(stmt, "name", "description", "priority", "startDate", "'Read book'", "'Read Tom Soyer book'", "1", "2008-11-11");
            System.out.println("Inserted records into the table...");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void populateVehicle(Statement stmt, String... strings) throws SQLException {
        int s = strings.length;
        StringBuffer sql = new StringBuffer("INSERT INTO TASKS (");
        appendSQLCommand(sql, 0, s / 2, strings);
        sql.append(" VALUES (");
        appendSQLCommand(sql, s / 2, s, strings);
        stmt.executeUpdate(sql.toString());
    }

    private static void appendSQLCommand(StringBuffer sql, int first, int finish, String... strings) {
        for (int i = first; i < finish; i++) {
            if (i < finish - 1) {
                sql.append(strings[i] + ", ");
            } else {
                sql.append(strings[i] + ")");
            }
        }
    }
}
