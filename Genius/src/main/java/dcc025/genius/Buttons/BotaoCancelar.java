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
public class BotaoCancelar implements ActionListener {
    
    public TelaInicial inic;
    public TelaRegistro registro;
    public BotaoCancelar(TelaInicial inic,TelaRegistro registro)
    {
        this.inic=inic;
        this.registro=registro;
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      
        if(inic!=null)
      {
       inic.mostrar(true);
       registro.getTela().dispose();
      }
    }
    
}
