/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Buttons;

import dcc025.genius.CompeticaoeCampeonato.CompeticaoMulti;
import dcc025.genius.Telas.TelaSelecao;
import dcc025.genius.Usuario.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Renan
 */
public class BotaoJogarMulti implements ActionListener {
    private TelaSelecao telao;
     private Usuario enviado;
   public BotaoJogarMulti(TelaSelecao receptor,Usuario a)
    {
        telao = receptor;
        enviado =a;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        telao.competicoesMulti();
    }
}
