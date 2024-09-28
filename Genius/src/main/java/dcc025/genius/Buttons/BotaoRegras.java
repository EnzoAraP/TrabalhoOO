/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Buttons;

import dcc025.genius.Telas.TelaInicial;
import dcc025.genius.Telas.TelaRegras;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Nitro 5
 */
public class BotaoRegras  implements ActionListener{
    private TelaInicial inicial;
    private TelaRegras regras;
public BotaoRegras (TelaInicial inicial,TelaRegras regras)
{
    this.inicial = inicial;
    this.regras = regras;
}
    @Override
    public void actionPerformed(ActionEvent e) {
      if(inicial!=null)
      {
          inicial.mostrar(false);
          regras.Desenhatudo();
      }
    }
    
}
