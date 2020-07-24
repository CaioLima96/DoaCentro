package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

   
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "root";

    public static Connection getConnection() {

        try {

            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro ao abrir conexão com banco de dados! " + ex);
        }

    }

    public static void closeConnection(Connection con)  {

        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar conexão com banco de dados! " + ex);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt)  {

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
               throw new RuntimeException("Erro ao fechar conexão com banco de dados! - PreparedStatement" + ex);
            }
        }

        closeConnection(con);

    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs)  {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar conexão com banco de dados! - ResultSet" + ex);
            }
        }
        
         if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
               throw new RuntimeException("Erro ao fechar conexão com banco de dados! - PreparedStatement" + ex);
            }
        }

        closeConnection(con);

    }

}

