/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Buttons;

import dcc025.genius.Testes.UI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Nitro 5
 */
public class BotaoConta implements ActionListener {
 public BotaoConta(UI teste)
  {
      Jogo = teste;
  }
  private UI Jogo;
    @Override
    public void actionPerformed(ActionEvent e) {
        Jogo.TelaConta();
    }
    
}
