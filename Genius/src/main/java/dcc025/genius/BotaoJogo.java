/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoJogo implements ActionListener{
BotaoJogo (UI teste)
{
    Jogo = teste;
}
private UI Jogo;
    @Override
    public void actionPerformed(ActionEvent e) {
      Jogo.Board();
      Jogo.telainicial.setVisible(false);
      
    }
    
}
