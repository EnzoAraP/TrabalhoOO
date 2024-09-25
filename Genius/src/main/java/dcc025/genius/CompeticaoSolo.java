/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius;

/**
 *
 * @author Renan
 */
public class CompeticaoSolo  extends Competicao{

    private int melhor;
    private Usuario jogador;
    private int dificuldade;
    private Game novojogo;

    public CompeticaoSolo(Usuario jogador) {
        this.jogador = jogador;
    }
    @Override
    public void iniciar() {
        
        novojogo=Game.rodar(this,1);
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
            System.out.println("Sua nova melhor pontuacao mudou ! agora vale "+pontuacao);
            melhor =pontuacao;
        }
        novojogo.startGame();
        //Ver qual foi a pontuacao do jogo e verificar os recordes
    }
    
}
