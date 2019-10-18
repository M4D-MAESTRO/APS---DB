package com.pdv.db;

import java.sql.*;
/**
 *
 * @author Luís Henrique de C. Corrêa
 */
public class Factory {

    private static Connection connection = null;
    private static final String INSTANCE = "pdv";
    private static final String URL = "jdbc:mysql://localhost:3306/" + INSTANCE;
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            if (connection == null) {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }

        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("Não foi possível carregar o driver do banco");
        } catch (SQLException ex) {
            throw new SQLException("Falha ao conectar: " + ex.getMessage());
        }

        return connection;
    }

    public static void close() throws SQLException {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new SQLException("Falha ao desconectar:" + ex.getMessage());
        }
    }
}
