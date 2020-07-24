package model;

import validadores.Validador;

public class Usuario {
    private int idUsuario;
    private String login;

   
    private String nome;
    private String telefone;
    private String cpfCnpj;
    private String email;
    private String senha;
    
    public Usuario(){
    }
    public Usuario(
            String login,
            String nome,
            String telefone,
            String cpfCnpj,
            String email,
            String senha) throws Exception{
    this.setLogin(login);
    this.setNome(nome);
    this.setTelefone(telefone);
    this.setCpfCnpj(cpfCnpj);
    this.setEmail(email);
    this.setSenha(senha);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
       if (nome.trim().isEmpty()) {
            throw new Exception("O campo nome não pode estar vazio!");
        } else {
            this.nome = nome;
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws Exception {
        if(Validador.isValidPhone(telefone)){
        this.telefone = telefone;
        }else{
            throw new Exception("Telefone inválido.");
        }
    }

    public String getCpfCnpj()  {
        return this.cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj)throws Exception {
        if(Validador.isCPF(cpfCnpj)) {
           this.cpfCnpj = Validador.imprimeCPF(cpfCnpj);
        }else{
            throw new Exception ("CPF inválido.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (Validador.isEmailValid(email)) {
            this.email = email;
        } else {
            throw new Exception("O email é inválido!");
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws Exception {
        
            this.senha = senha;
        
    }
}
