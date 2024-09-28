/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Buttons;

import dcc025.genius.Telas.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Nitro 5
 */
public class BotaoVoltar implements ActionListener {
      public TelaInicial inic;
    public TelaRegras regras;
    public BotaoVoltar(TelaInicial inic,TelaRegras regras )
    {
        this.inic=inic;
        this.regras=regras;
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      
        if(inic!=null)
      {
       inic.mostrar(true);
       regras.getTela().dispose();
      }
    }
    
}


