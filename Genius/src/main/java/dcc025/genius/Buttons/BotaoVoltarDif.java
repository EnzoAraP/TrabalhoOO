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
public class BotaoVoltarDif implements ActionListener{
     public TelaSelecao selec;
    public TelaDificuldade dific;
    public BotaoVoltarDif(TelaSelecao selec,TelaDificuldade dific )
    {
        this.selec=selec;
        this.dific=dific;
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      
        if(selec!=null)
      {
       selec.mostrar(true);
       dific.getTela().dispose();
      }
}
}
