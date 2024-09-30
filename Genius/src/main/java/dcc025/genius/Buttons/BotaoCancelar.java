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
    
    public Tela anterior;
    public TelaRegistro registro;
    public BotaoCancelar(Tela anterior,TelaRegistro registro)
    {
        this.anterior=anterior;
        this.registro=registro;
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       anterior.mostrar(true);
       registro.getTela().dispose();
     
    }
    
}
