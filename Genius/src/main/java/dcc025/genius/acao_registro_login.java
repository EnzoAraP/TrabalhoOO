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
public class acao_registro_login implements ActionListener {
  TelaRegistro tela;
   TelaInicial telaIni;
    public acao_registro_login(TelaRegistro tela,TelaInicial telaIni) {
        this.tela = tela;
        this.telaIni=telaIni;
    }
  
    
    @Override
    public void actionPerformed(ActionEvent e) {
           telaIni.ocultar();
           tela.desenha();
    }
    
}
