package model;

import java.sql.Date;

public class Usuario {
    
    private String nome;
    private String login;
    private String senha;
    private Date nascimento;

    public Usuario(){}
    
    public Usuario(String nome, String login, String senha, Date nascimento){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.nascimento = nascimento;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
    
}
