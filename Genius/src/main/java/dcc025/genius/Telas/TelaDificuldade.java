/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Telas;

/**
 *
 * @author Nitro 5
 */   import dcc025.genius.Buttons.*;
import dcc025.genius.CompeticaoeCampeonato.*;
import dcc025.genius.Usuario.Usuario;
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
public class TelaDificuldade {
     private final JFrame tela ;
    private final int WIDTH = 600;
    private final int HEIGHT = 350;
    private TelaSelecao Telselecao;
    private Font fonteMedia;
    private Font fonte;
    int tipo;
    public TelaDificuldade(TelaSelecao recpetor,int tipo)
    {
        tela = new JFrame();
        tela.setSize(WIDTH,HEIGHT);
        tela.setPreferredSize(new Dimension (WIDTH, HEIGHT));
        tela.addWindowListener(new TelaDificuldade.ControleJanela());
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               fonte = new Font("Arial", 5, 17);
        fonteMedia = new Font("Arial", 5, 23);
        this.tipo=tipo;
         tela.setLayout(new BorderLayout());
        Telselecao = recpetor;
        
    }
    public void DesenhaTela()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
              panel.setSize(WIDTH,HEIGHT);
              panel.setBackground(new Color(140, 200, 220, 80));
              {//Add DificuladeLabel
                  JLabel Dificulade=new JLabel("Escolha a dificuldade :");
                  Dificulade.setFont(fonteMedia);
                  constraints.gridx = 3; // Grid column
                  constraints.gridy = 0; // Grid row
                  constraints.gridwidth = 2; 
                  constraints.gridheight = 1; 
                  constraints.insets = new Insets(10, 10, 10, 10); // Padding
                  panel.add(Dificulade,constraints);
              }
               {//Add ButtonFacil
                  JButton Facil=new JButton(" Facil");
                  constraints.gridx = 3; // Grid column
                  constraints.gridy = 1; // Grid row
                  constraints.gridwidth = 2; 
                  constraints.gridheight = 1;
                  constraints.insets = new Insets(10, 10, 10, 10); // Padding
                  Facil.setFont(fonte);
                  Facil.setBackground(new Color(140, 200, 220));
                  Facil.addActionListener(new BotaoDificuldade(this,1));
                  panel.add(Facil,constraints);
              }
                              {//Add Medio
                  JButton Medio=new JButton(" Medio");
                  constraints.gridx = 3; // Grid column
                  constraints.gridy = 2; // Grid row
                  constraints.gridwidth = 2; 
                  constraints.gridheight = 1; 
                  constraints.insets = new Insets(10, 10, 10, 10); // Padding
                  Medio.setBackground(new Color(140, 200, 220));
                  Medio.setFont(fonte);
                  Medio.addActionListener(new BotaoDificuldade(this,2));
                  panel.add(Medio,constraints);
              }
                        {//Add Dificil
                  JButton Dificil=new JButton(" Dificil");
                  constraints.gridx = 3; // Grid column
                  constraints.gridy = 3; // Grid row
                  constraints.gridwidth = 2; 
                  constraints.gridheight = 1; 
                  constraints.insets = new Insets(10, 10, 10, 10); // Padding
                   Dificil.setBackground(new Color(140, 200, 220));
                   Dificil.setFont(fonte);
                   Dificil.addActionListener(new BotaoDificuldade(this,3));
                  panel.add(Dificil,constraints);
              }
                   {//Add Impossivel
                  JButton Impossivel=new JButton(" Impossivel");
                  constraints.gridx = 3; // Grid column
                  constraints.gridy = 4; // Grid row
                  constraints.gridwidth = 2; 
                  constraints.gridheight = 1; 
                  constraints.insets = new Insets(10, 10, 10, 10); // Padding
                  Impossivel.setBackground(new Color(140, 200, 220));
                  Impossivel.setFont(fonte);
                  Impossivel.addActionListener(new BotaoDificuldade(this,4));
                  panel.add(Impossivel,constraints);
              }
                   {//Add Cancelar
                       JButton Impossivel=new JButton("Voltar");
                  constraints.gridx = 5; // Grid column
                  constraints.gridy = 5; // Grid row
                  constraints.gridwidth = 2; 
                  constraints.gridheight = 1; 
                  constraints.insets = new Insets(10, 10, 10, 10); // Padding
                  Impossivel.setBackground(new Color(140, 200, 220));
                  Impossivel.setFont(fonte);
                  Impossivel.addActionListener(new BotaoVoltarDif(Telselecao,this));
                  panel.add(Impossivel,constraints);
                   }
                 tela.add(panel);       
              
    }
     public void mostrar(boolean verificador)
     {
         System.out.println("Valor do verificador:"+verificador);
         tela.setVisible(verificador);
     }
     public void DesenhaTudo()
     {
         DesenhaTela();
         mostrar(true);
                 
     }
     public void IniciarJogo(Usuario testado,int dificuldade){
     Competicao comp;
        switch(tipo){
         case 1:
             comp = new CompeticaoSolo(testado,dificuldade);
             break;
         case 2:
             comp = new CompeticaoDuo(testado,dificuldade);
             break;
         default:
             comp = new CompeticaoSolo(testado,dificuldade);
             break;
        } 
     comp.iniciar();
    }
     public JFrame getTela()
     {
         return tela;
     }
     private class ControleJanela implements WindowListener{

        @Override
        public void windowOpened(WindowEvent e) {
         
        }

        @Override
        public void windowClosing(WindowEvent e) {
            if(Telselecao!=null)
         Telselecao.mostrar(true);
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