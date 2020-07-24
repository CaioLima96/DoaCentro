/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Centro {
    private int idCentro;
    private String nomeCentro;
    private String telefone;
    private Endereco endereco;
    private boolean alimento;
    private boolean higiene;
    private boolean limpeza;
    private String descricao;

    public Centro (){
    }
    public Centro(
        String nomeCentro,
        String telefone,
        Endereco endereco,
        boolean alimento,
        boolean higiene,
        boolean limpeza,
        String descricao){
    
    this.setNomeCentro(nomeCentro);
    this.setTelefone(telefone);
    this.setEndereco(endereco);
    this.setAlimento(alimento);
    this.setHigiene(higiene);
    this.setLimpeza(limpeza);
    this.setDescricao(descricao);
    }
    
    public int getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }

    public String getNomeCentro() {
        return nomeCentro;
    }

    public void setNomeCentro(String nomeCentro) {
        this.nomeCentro = nomeCentro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isAlimento() {
        return alimento;
    }

    public void setAlimento(boolean alimento) {
        this.alimento = alimento;
    }

    public boolean isHigiene() {
        return higiene;
    }

    public void setHigiene(boolean higiene) {
        this.higiene = higiene;
    }

    public boolean isLimpeza() {
        return limpeza;
    }

    public void setLimpeza(boolean limpeza) {
        this.limpeza = limpeza;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
