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
public class CampeonatoPontos extends CompeticaoMulti {
  
    private List<Integer> vidas;
    private int finalizados;
    
    public CampeonatoPontos(List<Usuario> jogadores,int numVidas) throws Exception {
        super(jogadores);
        vidas = new ArrayList<>();
        if(numVidas<1)
            numVidas=1;
        for(int i=0;i<numJogadores;i++)
            vidas.add(numVidas);
        
    }

    @Override
    public void organizar() {
        
    }

    @Override
    public void iniciar() {
       
    }
    
    @Override
    public boolean finalizado() {
        return finalizados==numJogadores;
        
    }

    @Override
    public void atualizaPontuacao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
