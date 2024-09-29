/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Buttons;

import dcc025.genius.Telas.*;
import dcc025.genius.Usuario.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Nitro 5
 */
public class BotaoDificuldade implements ActionListener {
    private TelaDificuldade Tldificuldade;
    private int dificuldade;
   
  
public BotaoDificuldade( TelaDificuldade tldificuldade,int dificuldade)
{
 this.Tldificuldade =tldificuldade;
 
 this.dificuldade = dificuldade;
 
}
    @Override
    public void actionPerformed(ActionEvent e) {
       
     Tldificuldade.IniciarJogo(Usuario.atual,dificuldade);
    }
    
}
