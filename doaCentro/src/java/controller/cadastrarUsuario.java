/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author karinaxavier
 */
@WebServlet(name = "cadastrarUsuario", urlPatterns = {"/cadastrarUsuario"})
public class cadastrarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
            String nome = request.getParameter("nomeUsuario");
            String telefone = request.getParameter("telefone1");
            String cpfCnpj = request.getParameter("numeroCpfCnpjUsuario");
            String email = request.getParameter("emailUsuario");
            String senha = request.getParameter("senha");
            String confSenha = request.getParameter("confirmaSenha");
            
            
            Usuario usuario = new Usuario();
            
            usuario.setNome(nome);
            out.print(usuario.getNome()+"<br>");
            usuario.setTelefone(telefone);
             out.print(usuario.getTelefone()+"<br>");
            usuario.setCpfCnpj(cpfCnpj);
            out.print(usuario.getCpfCnpj()+"<br>");
            usuario.setEmail(email);
             out.print(usuario.getEmail()+"<br>");
            
            if (senha.equals(confSenha)){
                usuario.setSenha(senha);
                
            }
            
            
           
            out.print(usuario.getSenha()+"<br>");
//            UsuarioDAO.insertUsuario(usuario);
            
            out.print("ok");
            
            
        } catch (Exception ex) {
            out.print(ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
