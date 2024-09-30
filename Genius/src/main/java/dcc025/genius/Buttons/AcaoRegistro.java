/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Buttons;

import dcc025.genius.Telas.TelaRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Renan
 */
public class AcaoRegistro implements ActionListener {

    TelaRegistro tela;
    boolean criarAdm;
    public AcaoRegistro(TelaRegistro tela) {
        this.tela=tela;
        this.criarAdm=false;
    }
    public AcaoRegistro(TelaRegistro tela,boolean criarAdm) {
        this.tela=tela;
        this.criarAdm=criarAdm;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        tela.registrarUsuario(criarAdm);
    }
    
}
