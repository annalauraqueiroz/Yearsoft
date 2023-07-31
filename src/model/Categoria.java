package model;

import controller.CategoriaCTRL;

public class Categoria {
    
    private String nome;
    private String cor;
    private int contraste;
    private String loginProprietario;
    private int ocorrenciasEventos;

    public Categoria(){}
    
    public Categoria(String nome, String cor, int contraste, String loginProprietario){
        this.nome = nome;
        this.cor = cor;
        this.contraste = contraste;
        this.loginProprietario = loginProprietario;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getContraste() {
        return contraste;
    }

    public void setContraste(int contraste) {
        this.contraste = contraste;
    }

    public String getLoginProprietario() {
        return loginProprietario;
    }

    public void setLoginProprietario(String loginProprietario) {
        this.loginProprietario = loginProprietario;
    }

    public int getOcorrenciasEventos() {
        CategoriaCTRL controleCategoria = new CategoriaCTRL();
        return controleCategoria.checarOcorrencias(this);
    }

    public void setOcorrenciasEventos(int ocorrenciasEventos) {
        this.ocorrenciasEventos = ocorrenciasEventos;
    }
 
}
