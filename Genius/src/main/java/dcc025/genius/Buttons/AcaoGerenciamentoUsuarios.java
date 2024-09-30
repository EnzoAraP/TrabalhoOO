/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Buttons;

import dcc025.genius.Telas.TelaControleCompeticao;
import dcc025.genius.Telas.TelaSelecao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Renan
 */
public class AcaoGerenciamentoUsuarios implements ActionListener {
    TelaSelecao tela;
    public AcaoGerenciamentoUsuarios(TelaSelecao tela) {
       this.tela=tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.abrirGerenciamentoUsuarios();
        tela.mostrar(false);
       }
    }
