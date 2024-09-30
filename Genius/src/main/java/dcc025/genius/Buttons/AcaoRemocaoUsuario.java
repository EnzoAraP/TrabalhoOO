/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Buttons;

import dcc025.genius.Telas.TelaControleUsuarios;
import dcc025.genius.Telas.TelaListaUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Renan
 */
public class AcaoRemocaoUsuario implements ActionListener {

    private TelaListaUsuarios tela;

    public AcaoRemocaoUsuario(TelaListaUsuarios tela) {
        this.tela = tela;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        tela.remover();
    }
    
}
