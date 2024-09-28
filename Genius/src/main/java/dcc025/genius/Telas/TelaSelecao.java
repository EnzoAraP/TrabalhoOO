/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Telas;

import dcc025.genius.Telas.TelaInicial;
import dcc025.genius.Exceptions.*;
import dcc025.genius.Buttons.Botaosolo;
import dcc025.genius.Buttons.BotaoJogar;
import dcc025.genius.CompeticaoeCampeonato.Competicao;
import dcc025.genius.CompeticaoeCampeonato.CompeticaoDuo;
import dcc025.genius.CompeticaoeCampeonato.CompeticaoSolo;
import dcc025.genius.Usuario.LidarUsuarios;
import dcc025.genius.Usuario.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Renan
 */
public class TelaSelecao {
    private JFrame tela;
    private final int WIDTH = 1100;
    private final int HEIGHT = 520;
    private final int V_GAP = 12;
    private final int H_GAP = 8;
    private JTextField campoNome;
    private JTextField campoEmail;
    private JTextField campoSenha;
    private List<Usuario> listaUsuarios;
    private TelaInicial telaIni;
    JTable tabela;
    Font fonte;
    Font fonte2;
    Font fonte3;
    public void desenha(){
        fonte = new Font("Arial", 4, 17);
        fonte2 = new Font("Arial", 5, 20);
        fonte3 = new Font("Arial", 5, 32);
        tela = new JFrame("Selecionar Modo de jogo");
        tela.setPreferredSize(new Dimension (WIDTH, HEIGHT));
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.addWindowListener(new LidarFechamentoDeTela());
        tela.setVisible(true);
        FlowLayout layout= new FlowLayout();
        layout.setAlignment(FlowLayout.CENTER);
        tela.setLayout(layout);
        
        desenhaBotoes();
        tela.getContentPane().setBackground(new Color(140, 200, 220, 80));
        tela.pack();
    }
    public void jogoteste(Usuario testado)
    {
        
     
     CompeticaoSolo a = new CompeticaoSolo(testado);
     a.iniciar(); 
    } 
    public void jogoTeste2(Usuario testado,int tipo){
     Competicao comp;
        switch(tipo){
         case 1:
             comp = new CompeticaoSolo(testado);
             break;
         case 2:
             comp = new CompeticaoDuo(testado);
             break;
         default:
             comp = new CompeticaoSolo(testado);
             break;
        } 
     comp.iniciar();
    }
    private void desenhaBotoes(){
        JButton solo = new JButton("Solo(Local)");
        JButton duo = new JButton("Duo(Local)");
        JButton multiJogador = new JButton("Multijogador");
        solo.setFont(fonte2);
        duo.setFont(fonte2);
        multiJogador.setFont(fonte2);
        solo.setBackground(new Color(160, 165, 220));
        solo.setPreferredSize(new Dimension(WIDTH/6,100));
        duo.setPreferredSize(new Dimension(WIDTH/6,100));
        multiJogador.setPreferredSize(new Dimension(WIDTH/6,100));
        duo.setBackground(new Color(160, 165, 220));
        multiJogador.setBackground(new Color(160, 165, 220));
        JPanel painelBotoes = new JPanel();
        FlowLayout fLayout = new FlowLayout(FlowLayout.CENTER, 100, 100);
        painelBotoes.setLayout(fLayout);
        painelBotoes.setBackground(new Color(140, 200, 220, 0));
        painelBotoes.add(solo);
        int erro=0;
        Usuario joga=null;
        while (erro!=0)
     {
         erro=0;
     try{
      joga =new Usuario ("nome","Enzo.teste@gmail.com","123TesteA.");
     }
     catch(EmailFormatoException | EmailUnicoException | SenhaException e)
     {
         System.out.println("erro");
         erro=-1;
     }
     }
        solo.addActionListener(new Botaosolo(this, Usuario.atual));
        duo.addActionListener(new BotaoJogar(this,Usuario.atual,2));
        painelBotoes.add(duo);
        painelBotoes.add(multiJogador);
        //painelBotoes.setPreferredSize(new Dimension(WIDTH / 2, HEIGHT / 2));
        TitledBorder bordaTexto= BorderFactory.createTitledBorder("Opções de jogo");
        bordaTexto.setTitleFont(fonte3);
        bordaTexto.setTitleJustification(2);
        painelBotoes.setBorder(BorderFactory.createCompoundBorder(bordaTexto, BorderFactory.createEmptyBorder(20, 20, 60, 20)));
        
        tela.add(painelBotoes);
    }
    public void ocultar(){
        tela.setVisible(false);
    }
    public void mostrar(boolean b){
        tela.setVisible(b);
    }
    private class LidarFechamentoDeTela extends LidarUsuarios{

        public LidarFechamentoDeTela() {
            super();
        }

        @Override
        public void windowOpened(WindowEvent e) {
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
