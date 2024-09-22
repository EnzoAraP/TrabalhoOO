/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Renan
 */
public class AcaoLogin implements ActionListener {

    TelaRegistro tela;
    public AcaoLogin(TelaRegistro tela) {
        this.tela=tela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        tela.logarUsuario();
    }
    
}
