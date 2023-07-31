package model;

import java.sql.Date;

public class Evento {
    
    private int idEvento;
    private Date diaInicial;
    private Date diaFinal;
    private int horaInicial;
    private int minutoInicial;
    private int horaFinal;
    private int minutoFinal;
    private String descricao;
    private int importancia;
    private String cor;
    private int contraste;
    private String categoria;
    private String loginProprietario;

    public Evento(){}
    
    public Evento(Date diaInicial,Date diaFinal,int horaInicial,int minutoInicial,int horaFinal,int minutoFinal,
            String descricao,int importancia,String cor,String categoria,String loginProprietario){
        this.diaInicial = diaInicial;
        this.diaFinal = diaFinal;
        this.horaInicial = horaInicial;
        this.minutoInicial = minutoInicial;
        this.horaFinal = horaFinal;
        this.minutoFinal = minutoFinal;
        this.descricao = descricao;
        this.importancia = importancia;
        this.cor = cor;
        this.categoria = categoria;
        this.loginProprietario = loginProprietario;
    }
    
    public Date getDiaInicial() {
        return diaInicial;
    }
    
    public void setDiaInicial(Date diaInicial) {
        this.diaInicial = diaInicial;
    }

    public Date getDiaFinal() {
        return diaFinal;
    }

    public void setDiaFinal(Date diaFinal) {
        this.diaFinal = diaFinal;
    }

    public int getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(int horaInicial) {
        this.horaInicial = horaInicial;
    }

    public int getMinutoInicial() {
        return minutoInicial;
    }

    public void setMinutoInicial(int minutoInicial) {
        this.minutoInicial = minutoInicial;
    }

    public int getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(int horaFinal) {
        this.horaFinal = horaFinal;
    }

    public int getMinutoFinal() {
        return minutoFinal;
    }

    public void setMinutoFinal(int minutoFinal) {
        this.minutoFinal = minutoFinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getImportancia() {
        return importancia;
    }

    public void setImportancia(int importancia) {
        this.importancia = importancia;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLoginProprietario() {
        return loginProprietario;
    }

    public void setLoginProprietario(String loginProprietario) {
        this.loginProprietario = loginProprietario;
    }
 
    public int getIdEvento(){
        return idEvento;
    }
    
    public void setIdEvento(int id){
        this.idEvento = id;
    }
    
}