/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDAO {
    public static boolean insertUsuario(Usuario usuario) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = ConnectionFactory.getConnection();
            ps = con.prepareStatement("insert into postgres.usuario ("
                    + "nome_completo, "
                    + "cpf_cnpj, "
                    + "telefone, "
                    + "email, "
                    + "senha) values (?,?,?,?,?)");
            
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getCpfCnpj());
            ps.setString(3, usuario.getTelefone());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getSenha());
            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }
            
            
            
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }

        return false;
    }
    public static int retornaIdUsuario(Usuario usuario) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int idUsuario = -1;

        try {
            con = ConnectionFactory.getConnection();
            String query = "SELECT idusuario FROM postgres.usuario WHERE ";
            String query2 = "";
            
            query2 += (usuario.getCpfCnpj()!= null?"cpf_cnpj = '"+ usuario.getCpfCnpj()+"'" : "");
            query2 += (((usuario.getCpfCnpj()!=null) && (usuario.getEmail()!=null))?" and email = '"+usuario.getEmail() +"'" :"");
            
            
            ps = con.prepareStatement(" cpf_cnpj = ? or email = ?");
            ps.setString(1, usuario.getCpfCnpj());
            ps.setString(2, usuario.getEmail());

            rs = ps.executeQuery();

            if (rs.next()) {
                idUsuario = rs.getInt("id_usuario");
            } else {
                throw new Exception(" Não foi possivel buscar o id do usuário!");
            }

            return idUsuario;

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

    }
     public static boolean login(Usuario usuario) throws Exception {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("SELECT * \n" +
                                      "FROM postgres.usuario \n" +
                                      "WHERE cpf_cnpj = ? or  email = ?   AND senha = ?");
            ps.setString(1, usuario.getCpfCnpj());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }

        return false;
    }
     public static String retornaNome(Usuario usuario) throws SQLException{

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int idTipoUsuario = 0;
        String nome = "";
        String sobrenome = "";

        try {
            
            con = ConnectionFactory.getConnection();

            ps = con.prepareStatement("SELECT nome_completo FROM postgres.usuario WHERE login = ?");
            ps.setString(1, usuario.getLogin());

            rs = ps.executeQuery();

            if (rs.next()) {
                nome = rs.getString("nome");
                sobrenome = rs.getString("sobrenome");
                nome = (nome + " " + sobrenome);
            }

            return nome;

        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
    }
    
    
}
