/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Buttons;

import dcc025.genius.Telas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Nitro 5
 */
public class BotaoLeaderboard implements ActionListener {
     private TelaInicial inicial;
    private TelaLeadoerboard Leaderboard;
public BotaoLeaderboard (TelaInicial inicial,TelaLeadoerboard Leaderboard)
{
    this.inicial = inicial;
    this.Leaderboard = Leaderboard;
}
    @Override
    public void actionPerformed(ActionEvent e) {
      if(inicial!=null)
      {
          inicial.mostrar(false);
          Leaderboard.mostrarTudo();
      }
    }
    
}   

