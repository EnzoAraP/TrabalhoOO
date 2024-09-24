/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Nitro 5
 */
public class Botaosolo implements ActionListener {

  
     private TelaSelecao telao;
     private Usuario enviado;
   public Botaosolo(TelaSelecao receptor,Usuario a)
    {
        telao = receptor;
        enviado =a;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        telao.jogoteste(enviado);
    }
    
}
