/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Centro;
import model.Usuario;

public class CentroDao {
    public static boolean insertCentro(Usuario usuario, Centro c) throws Exception {
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
    
}
