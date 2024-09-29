/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Buttons;

import dcc025.genius.Telas.*;
import dcc025.genius.Usuario.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Nitro 5
 */
public class Botaosolo implements ActionListener {

  
     
     private TelaSelecao selecao;
     private TelaDificuldade tldificuldade;
   public Botaosolo(TelaDificuldade tldificuldade,TelaSelecao selecao)
    {
       this.tldificuldade= tldificuldade;
       this.selecao=selecao;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        selecao.mostrar(false);
        tldificuldade.DesenhaTudo();
    }
    
}
