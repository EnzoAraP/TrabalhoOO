/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Buttons;
import dcc025.genius.Telas.TelaControleUsuarios;
import dcc025.genius.Telas.TelaInicial;
import dcc025.genius.Telas.TelaRegistro;
import dcc025.genius.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Renan
 */
public class acao_registro_login implements ActionListener {
  TelaRegistro tela;
   TelaInicial telaIni;
   TelaControleUsuarios telaCon;
   
    public acao_registro_login(TelaRegistro tela,TelaInicial telaIni) {
        this.tela = tela;
        this.telaIni=telaIni;
        this.telaCon=null;
    }
    public acao_registro_login(TelaRegistro tela,TelaControleUsuarios telaCon) {
        this.tela = tela;
        this.telaIni=null;
        this.telaCon=telaCon;
    }
  
    
    @Override
    public void actionPerformed(ActionEvent e) {
           if(telaIni!=null)
               telaIni.mostrar(false);
           else if(telaCon!=null)
               telaCon.mostrar(false);
           tela.desenha();
    }
    
}
