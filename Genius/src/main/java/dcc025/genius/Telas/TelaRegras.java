/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Telas;

/**
 *
 * @author Nitro 5
 */
import dcc025.genius.Buttons.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class TelaRegras {
     private final JFrame tela;
    private final int WIDTH = 900;
    private final int HEIGHT = 625;
    private final TelaInicial telainicial;
    private final Font fonteGrande;
    private final Font fonte;
    private final Font fonteMedia;
    public TelaRegras (TelaInicial telainicial){
        this.telainicial=telainicial;
        tela = new JFrame();
        tela.setSize(WIDTH,HEIGHT);
        tela.setPreferredSize(new Dimension (WIDTH, HEIGHT));
        tela.addWindowListener(new TelaRegras.ControleJanela());
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         tela.setLayout(new BorderLayout());
        fonteGrande = new Font("Arial", 5, 30);
        fonte = new Font("Arial", 5, 17);
        fonteMedia = new Font("Arial", 5, 23);
       
        
    }
    public void Desenhatudo()
    {
         DesenhaRegra();
        mostrar(true);
    }
    public final void DesenhaRegra()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
              GridBagConstraints constraints = new GridBagConstraints();
              panel.setSize(WIDTH,HEIGHT);
              panel.setBackground(new Color(140, 200, 220, 80));
        {//Regras Label
             JLabel regras = new JLabel("               Regras              ");
              JPanel panelregra = new JPanel();
        panelregra.setLayout(new BorderLayout());
              
              
              panelregra.setBackground(new Color(160, 165, 220));
            regras.setFont(fonteGrande);
        constraints.gridx = 1; // Grid column
        constraints.gridy = 0; // Grid row
        constraints.gridwidth = 2; 
        constraints.gridheight = 1; 
        constraints.insets = new Insets(10, 10, 10, 10); // Padding
     
        panelregra.add(regras,BorderLayout.CENTER);
        panel.add(panelregra, constraints);
     
        }
        {//Como Jogar Label
            JLabel como = new JLabel("Como Jogar ?");
            como.setFont(fonteMedia);
              constraints.gridx = 0; // Grid column
        constraints.gridy = 1; // Grid row
        constraints.gridwidth = 1; 
        constraints.gridheight = 1; 
        constraints.insets = new Insets(10, 10, 10, 10); // Padding
        
        
         panel.add(como, constraints);
        } 
        {//ExplicacaoJogo
            String textoJogo = "No Genius, o objetivo principal é repetir \n as sequências de cores que piscarem na sua tela;Existem 4 cores: vermelho, verde, azul e amarelo;A cada acerto seu, mais uma cor é adicionada na sequencia, a qual você deve repetir com a nova adição!";
            JLabel Exjogo = new JLabel ();
            Exjogo.setText("<html><p style=\"width:100px\">"+textoJogo+"</p></html>");
            Exjogo.setFont(fonte);
             constraints.gridx = 0; // Grid column
        constraints.gridy = 2; // Grid row
        constraints.gridwidth = 1; 
        constraints.gridheight = 1; 
        constraints.insets = new Insets(10, 10, 10, 10); // Padding
       panel.add(Exjogo, constraints);
        }
        {//Solo
            JLabel solo = new JLabel ("Solo");
            solo.setFont(fonteMedia);
             constraints.gridx = 1; // Grid column
        constraints.gridy = 1; // Grid row
        constraints.gridwidth = 1; 
        constraints.gridheight = 1; 
        constraints.insets = new Insets(10, 10, 10, 10); // Padding
        
         panel.add(solo, constraints);
        }
        {//ExplicacaoSolo
            String textosolo = "No modo solo, toda a partida é jogada por apenas uma pessoa de maneira continua, caso o jogador perca, outro jogo será começado no mesmo momento!";
            JLabel ExSol = new JLabel ();
             ExSol.setText("<html><p style=\"width:100px\">"+textosolo+"</p></html>");
            ExSol.setFont(fonte);
             constraints.gridx = 1; // Grid column
        constraints.gridy = 2; // Grid row
        constraints.gridwidth = 1; 
        constraints.gridheight = 1; 
        constraints.insets = new Insets(10, 10, 10, 10); // Padding
        
       panel.add(ExSol, constraints);
        }
                {//Dupla
            JLabel dupla = new JLabel ("Dupla");
            dupla.setFont(fonteMedia);
             constraints.gridx = 2; // Grid column
        constraints.gridy = 1; // Grid row
        constraints.gridwidth = 1; 
        constraints.gridheight = 1; 
        constraints.insets = new Insets(10, 10, 10, 10); // Padding
       
         panel.add(dupla, constraints);
        }
                  {//ExplicacaoDupla
            String textodupla = "No modo dupla, você e outro jogador irão jogar na mesma seção de forma alternada e na mesma conta,no final do jogo é dito qual dos dois jogadores chegaram na maior pontuação!";
            JLabel ExDupla = new JLabel ();
             ExDupla.setText("<html><p style=\"width:100px\">"+textodupla+"</p></html>");
            ExDupla.setFont(fonte);
             constraints.gridx = 2; // Grid column
        constraints.gridy = 2; // Grid row
        constraints.gridwidth = 1; 
        constraints.gridheight = 1; 
        
        constraints.insets = new Insets(10, 10, 10, 10); // Padding
        
       panel.add(ExDupla, constraints);
        }
                {//Multiplayer
                    JLabel Multiplayer = new JLabel ("Multiplayer");
            Multiplayer.setFont(fonteMedia);
             constraints.gridx = 3; // Grid column
        constraints.gridy = 1; // Grid row
        constraints.gridwidth = 1; 
        constraints.gridheight = 1; 
        constraints.insets = new Insets(10,10,10,10); // Padding
     
         panel.add(Multiplayer, constraints);
                }
                 {//Explicaçao Multiplayer
            String textoMult = "No modo multiplayer, voce e outro jogador irão jogar uma partida, cada um na sua propria conta!"
                    + "O Adminsitrador é responsavel por criar a competição."
                    + "Tipos: Confronto(2 jogadores):"
                    + " o desafiante deve superar o anfitrião em pontuação."
                    + " Campeonato de pontos(2 a 4 jogadores): os jogadores tem um número de vidas(chances)"
                    + " para alcançar a maior pontuação e vencerem.";
            JLabel ExMult = new JLabel ();
            ExMult.setText("<html><p style=\"width:150px\">"+textoMult+"</p></html>");
            ExMult.setFont(fonte);
             constraints.gridx = 3; // Grid column
        constraints.gridy = 2; // Grid row
        constraints.gridwidth = 1; 
        constraints.gridheight = 1; 
        constraints.insets = new Insets(10, 10, 10, 10); // Padding
     
       panel.add(ExMult, constraints);
        }
                 {//Voltar Button
                      JButton voltar = new JButton("Voltar");
                      voltar.addActionListener(new BotaoVoltar(telainicial,this));
                      JPanel painelBotoes = new JPanel();
                          FlowLayout fLayout = new FlowLayout(FlowLayout.CENTER, 20, 20);
                       painelBotoes.setLayout(fLayout);
                      painelBotoes.setBackground(new Color(140, 200, 220, 0));
                      voltar.setBackground(new Color(140, 200, 220));
                      painelBotoes.add(voltar);
                      constraints.gridx = 3; // Grid column
        constraints.gridy = 3; // Grid row
        constraints.gridwidth = 1; 
        constraints.gridheight = 1; 
        constraints.insets = new Insets(10, 10, 10, 10); // Padding
                      panel.add(painelBotoes, constraints);
                 }
         tela.add(panel);       
        
      
    }
    public JFrame getTela()
    {
        return this.tela;
    }
    public final void mostrar(boolean mostrar) {
      tela.setVisible(mostrar);
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
