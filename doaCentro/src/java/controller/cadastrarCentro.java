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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Centro;
import model.Endereco;
import model.Estado;
import model.Usuario;

/**
 *
 * @author David.Silva
 */
@WebServlet(name = "cadastrarCentro", urlPatterns = {"/cadastrarCentro"})
public class cadastrarCentro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.print("chamou servlet");
            String nome = request.getParameter("nomeUsuario");
            String telefone = request.getParameter("telefone1");
            String cpfCnpj = request.getParameter("numeroCpfCnpjUsuario");
            String email = request.getParameter("emailUsuario");
            String senha = request.getParameter("senha");
            String confSenha = request.getParameter("confirmaSenha");
            out.print("pegou as variaveis");
            
           Endereco endereco = new Endereco();
           Estado estado = new Estado();
                String cep = request.getParameter("cep");
                String logradouro = request.getParameter("logradouro");
                String numeroEndereco = request.getParameter("numeroEndereco");
                String complemento = request.getParameter("complemento");
                String bairro = request.getParameter("bairro");
                String cidade = request.getParameter("cidade");
                String uf = request.getParameter("uf");
                
                Centro c = new Centro();
                String alimento = request.getParameter("alimento");
                String higiene =  request.getParameter("higiene");
                String limpeza =  request.getParameter("limpeza");
                String descricao = request.getParameter("descricao");
         
                c.setAlimento(true);
                c.setHigiene(true);
                c.setLimpeza(true);
                c.setDescricao(descricao);
                
                //out.println(request.getParameter("tipoProduto"));
                
                //CentroDAO.insertCentro(c);
           
                endereco.setCep(cep);
                endereco.setLogradouro(logradouro);
                endereco.setNumero(numeroEndereco);
                endereco.setComplemento(complemento);
                endereco.setBairro(bairro);
                endereco.setCidade(cidade);
                //estado.setUfEstado(uf);
            
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setTelefone(telefone);
            usuario.setCpfCnpj(cpfCnpj);
            usuario.setEmail(email);
            out.print("setou usuario ate o if");
            
            if (senha.equals(confSenha)){
                usuario.setSenha(senha);
                out.print("setou senha");
            }
            out.print("inicio da DAO");
            UsuarioDAO.insertUsuario(usuario);
            out.print(" fim da DAO");
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
