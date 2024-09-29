 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.CompeticaoeCampeonato;

import dcc025.genius.CompeticaoeCampeonato.Competicao;
import dcc025.genius.Telas.Game;
import dcc025.genius.Usuario.Usuario;

/**
 *
 * @author Renan
 */
public class CompeticaoSolo  extends Competicao{

    private int melhor;
    private Usuario jogador;
    private int dificuldade;
    private Game novojogo;
    private int pontuacao;
   

    public CompeticaoSolo(Usuario jogador,int dificuldade) {
        this.jogador = jogador;
        this.dificuldade=dificuldade;
        pontuacao=-1;
    }
    @Override
    public void iniciar() {
        
        novojogo=Game.rodar(this,dificuldade);
        novojogo.startGame();
    }

    @Override
    public boolean finalizado() {
        mudarTurno();
        return true;
    }

    @Override
    public void mudarTurno() {
        System.out.println("Troca de turno");
        int pontuacao=novojogo.pontuacao();
        System.out.println("pontuacao: "+pontuacao);
        System.out.println("melhor:"+melhor);
        if(pontuacao>melhor)
        {
            jogador.setRecorde(pontuacao);
            System.out.println("Sua nova melhor pontuacao mudou ! agora vale "+pontuacao);
            melhor =pontuacao;
        }
        novojogo.startGame();
        //Ver qual foi a pontuacao do jogo e verificar os recordes
    }

    @Override
    public void atualizaPontuacao() {
        pontuacao++;
    }
    
}
