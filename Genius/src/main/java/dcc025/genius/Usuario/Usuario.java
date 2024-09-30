/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Usuario;

import dcc025.genius.CompeticaoeCampeonato.Competicao;
import dcc025.genius.CompeticaoeCampeonato.CompeticaoMulti;
import dcc025.genius.Exceptions.*;
import dcc025.genius.Telas.TelaSelecao;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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
    private List<CompeticaoMulti> competicoesAtivas;
    private List<CompeticaoMulti> competicoesPassadas;
    protected EstadoCompeticao competindo;
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
    public List<CompeticaoMulti> getCompeticoesAtivas() {
        return competicoesAtivas;
    }

    public static void setNumUsuariosTotal(int numUsuariosTotal) {
        Usuario.numUsuariosTotal = numUsuariosTotal;
    }

    public void setCompeticoesAtivas(List<CompeticaoMulti> competicoesAtivas) {
        this.competicoesAtivas = competicoesAtivas;
    }
    public List<CompeticaoMulti> getCompeticoesPassadas() {
        return competicoesPassadas;
    }

    public void setCompeticoesPassadas(List<CompeticaoMulti> competicoesAtivas) {
        this.competicoesPassadas = competicoesAtivas;
    }
    public Usuario(String nome, String email, String senha) throws EmailUnicoException, EmailFormatoException , SenhaException {
        this.nome = nome;
        this.email = new Email(email);
        this.senha = testasenha(senha);
        numUsuariosTotal++;
        this.id=numUsuariosTotal;
        competicoesAtivas = new ArrayList<>();
        competicoesPassadas = new ArrayList<>();
        recorde=0;
        competindo = new EstadoCompeticao();
    }
    public Usuario(String nome, Email email, String senha) throws Exception,SenhaException {
        if(nome==null || email==null || senha== null)
            throw new Exception("Variáveis nulas passadas");
        this.nome = nome;
        this.email = email;
        this.senha = testasenha(senha);
        numUsuariosTotal++;
        this.id=numUsuariosTotal;
        recorde=0;
        competindo = new EstadoCompeticao();
    }

    public int getRecorde() {
        return recorde;
    }
    public void adicionaCompeticao(CompeticaoMulti c){
        competicoesAtivas.add(c);
        competindo.setValor("Sim");
    }
    public int numeroCompeticoesAtivas(){
        if(competicoesAtivas==null)
            return 0;
        return competicoesAtivas.size();
    }
    public int numeroCompeticoesPassadas(){
        if(competicoesPassadas==null)
            return 0;
        return competicoesPassadas.size();
    }
    public void finalizaCompeticao(CompeticaoMulti c){
        boolean removeu=competicoesAtivas.remove(c);
        if(removeu)
            competicoesPassadas.add(c);
    }
    
    public void setRecorde(int novoRecorde) {
        if(novoRecorde>this.recorde)
          this.recorde = novoRecorde;
    }
    public CompeticaoMulti getCompeticaoAtiva(int indice){
        if(indice<competicoesAtivas.size())
         return competicoesAtivas.get(indice);
        return null;
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
    public static String testasenha (String senha) throws SenhaException
    {
        System.out.println("Testou senha");
        int existe=-1;
        if(senha.length()<8)
        {
            throw new SenhaException();
        }
        for (int i=0;i<senha.length();i++ )
        {
            if(senha.charAt(i)>='A'&&senha.charAt(i)<='Z')
                existe++;
        }
        if (existe==-1)
        {
    throw new SenhaException();
        }
        return senha;
    }
    public boolean emCompeticao(){
        if(competicoesAtivas!=null){
          return !competicoesAtivas.isEmpty();
          
        } 
        competicoesAtivas= new ArrayList<>();
        competicoesPassadas= new ArrayList<>();
        return false;
    }
    public boolean retirarCompeticao(CompeticaoMulti c){
        boolean r= competicoesAtivas.remove(c);
        if(competicoesAtivas.isEmpty())
            competindo.setValor("Não");
        return r;
    }
   
    public boolean removivel(){
        return true;
    }
    
    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
         if (this.getClass().equals(obj.getClass()) ){
             Usuario objUs = (Usuario)obj;
             if(this.email.getEmail().equals(objUs.getEmailTexto()) )
                 return true;
             else
                 return false;
         }
         return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.email);
        return hash;
    }
    public String getCargo(){
        return "Usuário Comum";
    }
    public void painelSelecao(TelaSelecao tela){
        
    }
    public String getClassType(){
        return "Usuario";
    }
    public EstadoCompeticao getEstadoCompeticao(){
        return competindo;
    }
    public class EstadoCompeticao{
        private String valor="Não";

        protected void setValor(String valor) {
            this.valor = valor;
        }
       
        @Override
        public String toString() {
            return valor ;
        }
        
    }
    
}


