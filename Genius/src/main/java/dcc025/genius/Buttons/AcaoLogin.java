/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Buttons;

import dcc025.genius.Telas.TelaRegistro;
import dcc025.genius.Telas.TelaSelecao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Renan
 */
public class AcaoLogin implements ActionListener {

    TelaRegistro tela;
    TelaSelecao tela2;
    public AcaoLogin(TelaRegistro tela) {
        this.tela=tela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        tela.logarUsuario();
    }
    
}
