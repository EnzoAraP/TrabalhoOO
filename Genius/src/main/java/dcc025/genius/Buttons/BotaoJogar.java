/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Buttons;

import dcc025.genius.Telas.TelaSelecao;
import dcc025.genius.Usuario.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Renan
 */
public class BotaoJogar implements ActionListener {

  
     private TelaSelecao telao;
     private Usuario enviado;
     private int tipo;
   public BotaoJogar(TelaSelecao receptor,Usuario a,int tipo)
    {
        this.tipo=tipo;
        telao = receptor;
        enviado =a;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        telao.jogoTeste2(enviado,tipo);
    }
    
}
