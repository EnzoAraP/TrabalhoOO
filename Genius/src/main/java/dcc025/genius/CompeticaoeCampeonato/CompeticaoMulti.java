/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.CompeticaoeCampeonato;

import dcc025.genius.CompeticaoeCampeonato.Competicao;
import dcc025.genius.Usuario.Usuario;
import java.util.List;

/**
 *
 * @author Renan
 */
public abstract class CompeticaoMulti extends Competicao {

    protected final List<Usuario> jogadores;
    private int melhorPontuacao;
    protected final int numJogadores ;
    private boolean finalizado;
    private int indiceAtual;
    private Usuario jogadorAtual;
    int dificuldade;

    public List<Usuario> getJogadores() {
        return jogadores;
    }

    public int getMelhorPontuacao() {
        return melhorPontuacao;
    }

    public int getNumeroJogadores() {
        return numJogadores;
    }
    
    public CompeticaoMulti(List<Usuario> jogadores,int dificuldade) throws Exception {
        if(jogadores==null || jogadores.size()<2)
            throw new Exception("Numero de jogadores inválidos");
        this.jogadores=jogadores;
        this.dificuldade=dificuldade;
        this.numJogadores=jogadores.size();
        finalizado=false;
    }

    public abstract void organizar();
    @Override
    public void iniciar(){
        indiceAtual=jogadores.indexOf(Usuario.atual);
        jogadorAtual=Usuario.atual;
    }

    
    @Override
    public abstract boolean finalizado();

    @Override
    public void mudarTurno() {
        
    }
    
}
