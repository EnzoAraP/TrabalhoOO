/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Renan
 */
public class Usuario {
    private int id;
    private String nome;
    private Email email;
    private String senha;
    private int recorde;
    private List<Competicao> competicoesAtivas;
    private List<Competicao> competicoesPassadas;
    private static int numUsuariosCriados=0;
    private static int numUsuariosTotal=0;
    public static Usuario atual=null;
    public static int recordeSessao=0;
    
    public static void mudarRecordes(int novaPontuacao){
        if(novaPontuacao>recordeSessao){
            recordeSessao=novaPontuacao;
            atual.setRecorde(novaPontuacao);
        }
    }
    
    public Usuario(String nome, String email, String senha) throws EmailUnicoException, EmailFormatoException {
        this.nome = nome;
        this.email = new Email(email);
        this.senha = senha;
        numUsuariosCriados++;
        this.id=numUsuariosCriados;
        competicoesAtivas = new ArrayList<>();
        competicoesPassadas = new ArrayList<>();
        recorde=0;
    }
    public Usuario(String nome, Email email, String senha) throws Exception {
        if(nome==null || email==null || senha== null)
            throw new Exception("Variáveis nulas passadas");
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        numUsuariosCriados++;
        this.id=numUsuariosCriados;
        recorde=0;
    }

    public int getRecorde() {
        return recorde;
    }
    public void adicionaCompeticao(Competicao c){
        competicoesAtivas.add(c);
    }
    public int numeroCompeticoesAtivas(){
        return competicoesAtivas.size();
    }
    public int numeroCompeticoesPassadas(){
        return competicoesPassadas.size();
    }
    public void finalizaCompeticao(Competicao c){
        boolean removeu=competicoesAtivas.remove(c);
        if(removeu)
            competicoesPassadas.add(c);
    }
    public void setRecorde(int novoRecorde) {
        if(novoRecorde>this.recorde)
          this.recorde = novoRecorde;
    }
    

    public void apagarUsuario(){
        numUsuariosTotal--;
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Email getEmail() {
        return email;
    }
    public String getEmailTexto(){
        return email.getEmail();
    }
    public String getSenha() {
        return senha;
    }

    public static int getNumUsuariosCriados() {
        return numUsuariosCriados;
    }
    
    public void setEmail(String email) throws EmailUnicoException, EmailFormatoException {
        this.email.setEmail(email);
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
    
}
