/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.CompeticaoeCampeonato;

/**
 *
 * @author Nitro 5
 */
public abstract interface Competicao {
    
    public abstract void iniciar();
    public abstract boolean finalizado();
    public abstract void mudarTurno();
    public abstract void atualizaPontuacao();
    
}

