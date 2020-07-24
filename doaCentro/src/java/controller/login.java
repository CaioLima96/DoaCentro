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
import javax.servlet.http.HttpSession;
import model.Usuario;
import validadores.Validador;

/**
 *
 * @author karinaxavier
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try{
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            
            String loginFormatado = "";
                
            Usuario usuario = new Usuario();
            usuario.setLogin(login);
            usuario.setSenha(senha);
            
            
                if (Validador.isCPF(login)) { //verifica se e cpf e formata ele
                    loginFormatado = Validador.imprimeCPF(usuario.getLogin());
                    usuario.setLogin(loginFormatado);
         
                } else if (Validador.isCNPJ(login)) { //verifica se e cnpj e formata ele
                    loginFormatado = Validador.imprimeCNPJ(usuario.getLogin());
                    usuario.setLogin(loginFormatado);
                    
                } else if (Validador.isEmailValid(login)){
                    
                    usuario.setLogin(login);
                }else{
                    out.print("Login inválido.");
                }
                
                if (UsuarioDAO.login(usuario)) {
                    HttpSession session = request.getSession();

                    session.setAttribute("user", login);
                    
                    
                    session.setAttribute("idUsuarioSession", UsuarioDAO.retornaIdUsuario(usuario));
                    
                    String nome = UsuarioDAO.retornaNome(usuario);
                    session.setAttribute("nomeUsuario", nome);
                    out.print("ok");

                } else {

                    out.print("Não foi possivel localizar usuário!");
                }
        } catch (Exception ex) {
            out.print(ex.getMessage());
        }
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
