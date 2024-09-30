/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Telas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Nitro 5
 */
public class TelaLeadoerboard {
    private JFrame tela;
    private final int WIDTH = 900;
    private final int HEIGHT = 625;
    private final TelaInicial telainicial;
    private final Font fonteGrande;
    private final Font fonteMedia;
    protected JTable tabela;
    

    public TelaLeadoerboard(TelaInicial telainicial) {
        this.telainicial = telainicial;
        this.fonteGrande = new Font("Arial", 5, 30);
        this.fonteMedia = new Font("Arial", 5, 23);
        tela = new JFrame();
        tela.setSize(WIDTH,HEIGHT);
        tela.setPreferredSize(new Dimension (WIDTH, HEIGHT));
        tela.addWindowListener(new TelaLeadoerboard.ControleJanela());
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         tela.setLayout(new BorderLayout());
    }
    public void mostrar(boolean a)
    {
        tela.setVisible(a);
    }
    public void desenha()
    {
      JPanel panel= new JPanel();
      panel.setLayout(new GridBagLayout());
      panel.setSize(WIDTH,HEIGHT);
      panel.setBackground(new Color(140, 200, 220, 80));
      JLabel leaderboard = new JLabel("Leaderboard");
      leaderboard.setFont(fonteGrande);
        GridBagConstraints constraints = new GridBagConstraints();
      {//add Titulo
               JPanel panelregra = new JPanel();
        panelregra.setLayout(new BorderLayout());
              panelregra.setBackground(new Color(160, 165, 220));
            
        constraints.gridx = 1; // Grid column
        constraints.gridy = 0; // Grid row
        constraints.gridwidth = 2; 
        constraints.gridheight = 1; 
        constraints.insets = new Insets(10, 10, 10, 10); // Padding
     
        panelregra.add(leaderboard,BorderLayout.CENTER);
        panel.add(panelregra, constraints);     
        }
      
      tela.add(panel);
    }
    public void adicionaTable()
    {
        
    }
    public void mostrarTudo()
    {
        desenha();
        mostrar(true);
    }
    private class ControleJanela implements WindowListener{

        @Override
        public void windowOpened(WindowEvent e) {
         
        }

        @Override
        public void windowClosing(WindowEvent e) {
            if(telainicial!=null)
         telainicial.mostrar(true);
        }
        @Override
        public void windowClosed(WindowEvent e) {
         
        }

        @Override
        public void windowIconified(WindowEvent e) {
            
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        
        }

        @Override
        public void windowActivated(WindowEvent e) {
          
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            
        }
    
    
    
}
}
