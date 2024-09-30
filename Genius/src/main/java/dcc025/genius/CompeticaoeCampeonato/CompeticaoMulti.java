/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.CompeticaoeCampeonato;

import dcc025.genius.CompeticaoeCampeonato.Competicao;
import dcc025.genius.Telas.Game;
import dcc025.genius.Telas.TelaRegistro;
import dcc025.genius.Usuario.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Renan
 */
public abstract class CompeticaoMulti implements Competicao {

    protected transient List<Usuario> jogadores;
    private int id;
    protected List<String> emails;
    protected int melhorPontuacao;
    protected final int numJogadores ;
    private boolean finalizado;
    protected transient int indiceAtual;
    protected transient Usuario jogadorAtual;
    private int dificuldade;
    protected transient Game novoJogo;
    protected transient JFrame telaNovoJogo;
    protected List<Integer> pontuacoes;
    protected transient int  pontuacaoAtual;
    protected transient JPanel painelPont;
    protected transient JLabel atualLabel;
    protected transient JPanel pontuacoesPainel;
    protected transient List<JLabel> pontuacoesLabel;
    protected int melhor;
    protected Usuario vencedor;
    protected String mensagem;
    protected static int numCompeticoesMulti=0;

    public static int getNumCompeticoesMulti() {
        return numCompeticoesMulti;
    }

    public static void setNumCompeticoesMulti(int numCompeticoesMulti) {
        CompeticaoMulti.numCompeticoesMulti = numCompeticoesMulti;
    }
    
    
    public static int maxJogadoresGeral(){
        return 4;
    }
    public List<Usuario> getJogadores() {
        return jogadores;
    }

    
    public int getMelhorPontuacao() {
        return melhorPontuacao;
    }

    public int getNumeroJogadores() {
        return numJogadores;
    }
    
    public CompeticaoMulti(List<Usuario> jogadores) throws Exception {
        if(jogadores==null || jogadores.size()<2)
            throw new Exception("Numero de jogadores inválidos");
        mensagem="-";
        emails = new ArrayList<>();
        this.jogadores=jogadores;
        for(Usuario jogador : jogadores)
            emails.add(jogador.getEmailTexto());
        this.numJogadores=jogadores.size();
        finalizado=false;
        pontuacoes = new ArrayList<>();
        
        for (Usuario jogador : jogadores) {
            pontuacoes.add(-1);
        }
        numCompeticoesMulti++;
        id=numCompeticoesMulti;
    }
   protected void atualizaUsuariosEmCompeticao(){
       for(Usuario jogador : jogadores){
           jogador.adicionaCompeticao(this);
       }
   }
    public abstract void organizar();
    public abstract boolean possivelJogar();

    public int getId() {
        return id;
    }
    
    @Override
    public void iniciar(){
        System.out.println("EEEEEE2");
        List<Usuario> listaGeral=TelaRegistro.getListaUsuarios();
        if(jogadores==null || jogadores.isEmpty()){
        jogadores = new ArrayList<>();
        for(String email : emails){
            for(Usuario usuario: listaGeral)
                if(usuario.getEmailTexto().equals(email)){
                    jogadores.add(usuario);
                    break;
                }    
        }
        for(Usuario jogador : jogadores){
            List<CompeticaoMulti> comps = jogador.getCompeticoesAtivas();
            for(int i=0;i<comps.size();i++)
                if(comps.get(i).getId()==this.id){
                    comps.set(i, this);
                    break;
                }
        }
        }
        for(Usuario jogador : jogadores){
            System.out.println(jogador.getEmailTexto());
        }
        System.out.println(Usuario.atual.getEmailTexto());
        indiceAtual=jogadores.indexOf(Usuario.atual);
        jogadorAtual=Usuario.atual;
        pontuacaoAtual=-1;
        melhor=jogadorAtual.getRecorde();
        novoJogo=Game.rodar(this,1,null);
        telaNovoJogo=novoJogo.getFrame();
        if(!mensagem.equals("-") || this.fim()){
            System.out.println("EEEEEE4");   
            if(mensagem.equals("-"))
                   this.mensagemFimJogo();
               JOptionPane.showMessageDialog(telaNovoJogo, mensagem, "Resultado final",JOptionPane.INFORMATION_MESSAGE);
               jogadorAtual.retirarCompeticao(this);
               telaNovoJogo.dispose();
               return;
        }
        if(possivelJogar()){
        System.out.println("EEEEEE3");    
        painelPont = new JPanel();
        
        pontuacoesLabel = new ArrayList<>();
        pontuacoesPainel= new JPanel();
        painelPont.setBorder(BorderFactory.createTitledBorder(BorderFactory.createDashedBorder(Color.DARK_GRAY), "Pontuação", 2, 1, new Font("Arial",5,32), Color.blue));
        painelPont.setSize(300, 200);
        painelPont.setLayout(new GridLayout(2, 1)); // Layout de grade para mostrar as pontuações

        // Adiciona campo de pontuacao do jogador
       atualLabel = new JLabel("Atual : 0 pontos", JLabel.CENTER);
       atualLabel.setFont(new Font("Arial",2,18));
       painelPont.add(atualLabel); // Adiciona o JLabel
        
        telaNovoJogo.setLayout(new GridLayout(3,2));
        telaNovoJogo.setPreferredSize(new Dimension(600,600));
        telaNovoJogo.getContentPane().add(painelPont);
        organizar();
        telaNovoJogo.add(pontuacoesPainel);
        
        novoJogo.startGame();
        }
        else 
            telaNovoJogo.dispose();
           
    }

    
    @Override
    public abstract boolean finalizado();

    public abstract boolean fim();
    
    @Override
    public abstract void mudarTurno();

    @Override
    public void atualizaPontuacao() {
        pontuacaoAtual++;
        atualLabel.setText("Sua Pontuação atual: "+pontuacaoAtual+"pontos ");
    }
    
    public void removerJogador(Usuario jogador){
        int indice = jogadores.indexOf(jogador);
        if(indice!=-1){
            jogador.retirarCompeticao(this);
            jogadores.remove(jogador);
            emails.remove(indice);
            pontuacoes.remove(indice);
            if(fim()){
                mensagemFimJogo();
            }
            
        }
    }
    
    protected abstract void mensagemFimJogo();
    
    public abstract String getClassType();
    
}
