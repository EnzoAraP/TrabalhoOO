/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Buttons;

import dcc025.genius.Telas.TelaControleCompeticao;
import dcc025.genius.Telas.TelaListaUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Renan
 */
public class AcaoCriarCompeticao implements ActionListener {
    private TelaControleCompeticao tela;

    public AcaoCriarCompeticao(TelaControleCompeticao tela) {
        this.tela = tela;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        tela.criar();
  
}
}
