package dcc025.genius;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import dcc025.genius.Botaosolo;
import dcc025.genius.CompeticaoSolo;
import dcc025.genius.EmailFormatoException;
import dcc025.genius.EmailUnicoException;
import dcc025.genius.TelaRegistro;
import dcc025.genius.Usuario;
import dcc025.genius.acao_registro_login;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
public class TelaInicial {
    private JFrame tela;
    private final int WIDTH = 1100;
    private final int HEIGHT = 520;
    private final int V_GAP = 12;
    private final int H_GAP = 8;
    Font fonte;
    Font fonte2;
    Font fonte3;
    public void desenha(){
        fonte = new Font("Arial", 4, 17);
        fonte2 = new Font("Arial", 5, 20);
        fonte3 = new Font("Arial", 5, 32);
        tela = new JFrame("Selecionar Modo de jogo");
        tela.addWindowListener(new LidarUsuarios(this));
        tela.setPreferredSize(new Dimension (WIDTH, HEIGHT));
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    private void desenhaBotoes(){
        JButton login = new JButton("Fazer Login");
        JButton registro = new JButton("Registrar-se");
        JButton regras = new JButton("Regras");
        login.setFont(fonte2);
        registro.setFont(fonte2);
        regras.setFont(fonte2);
        login.setBackground(new Color(160, 165, 220));
        login.setPreferredSize(new Dimension(WIDTH/6,100));
        registro.setPreferredSize(new Dimension(WIDTH/6,100));
        regras.setPreferredSize(new Dimension(WIDTH/6,100));
        registro.setBackground(new Color(160, 165, 220));
        regras.setBackground(new Color(160, 165, 220));
        JPanel painelBotoes = new JPanel();
        FlowLayout fLayout = new FlowLayout(FlowLayout.CENTER, 100, 100);
        painelBotoes.setLayout(fLayout);
        painelBotoes.setBackground(new Color(140, 200, 220, 0));
        login.addActionListener(new acao_registro_login(new TelaRegistro(true,this),this));
        registro.addActionListener(new acao_registro_login(new TelaRegistro(false,this),this));
        painelBotoes.add(login);
        
        painelBotoes.add(registro);
        painelBotoes.add(regras);
        //painelBotoes.setPreferredSize(new Dimension(WIDTH / 2, HEIGHT / 2));
        TitledBorder bordaTexto= BorderFactory.createTitledBorder("Tela Inicial");
        bordaTexto.setTitleFont(fonte3);
        bordaTexto.setTitleJustification(2);
        painelBotoes.setBorder(BorderFactory.createCompoundBorder(bordaTexto, BorderFactory.createEmptyBorder(20, 20, 60, 20)));
        
        tela.add(painelBotoes);
    }
    public void ocultar(){
        tela.setVisible(false);
    }

    public void mostrar(boolean mostrar) {
      tela.setVisible(mostrar);
    }
}

