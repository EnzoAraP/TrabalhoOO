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
public class BotaoSair implements ActionListener {
    TelaSelecao tlselecao;
    TelaInicial tlinicial;
    public BotaoSair(TelaSelecao tlselecao, TelaInicial tlinicial)
    {
        this.tlselecao=tlselecao;
        this.tlinicial= tlinicial;
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       tlinicial.mostrar(true);
       tlselecao.deslogar();
       tlselecao.getTela().dispose();
    }
    
}
