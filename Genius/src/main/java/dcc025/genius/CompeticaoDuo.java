/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius;

/**
 *
 * @author Renan
 */
public class CompeticaoDuo extends Competicao {

    private Usuario[] jogadores;
    private int turno;
    public CompeticaoDuo(Usuario jogador1,Usuario jogador2) {
        jogadores= new Usuario[2];
        jogadores[0]=jogador1;
        jogadores[1]=jogador2;
        
    }

    
    @Override
    public void iniciar() {
        
    }

    @Override
    public boolean finalizado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mudarTurno() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
