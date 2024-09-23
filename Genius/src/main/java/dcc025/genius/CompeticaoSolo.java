/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius;

/**
 *
 * @author Renan
 */
public class CompeticaoSolo implements Competicao{

    private int melhor;
    private Usuario jogador;
    private int dificuldade;

    public CompeticaoSolo(Usuario jogador) {
        this.jogador = jogador;
    }
    @Override
    public void iniciar() {
        //Inicializa um objeto de jogo
    }

    @Override
    public boolean finalizado() {
        //Usa um método do jogo para ver se acabouy
        return true;
    }

    @Override
    public void mudarTurno() {
        //Ver qual foi a pontuacao do jogo e verificar os recordes
    }
    
}
