/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Telas;

import dcc025.genius.Telas.TelaInicial;
import dcc025.genius.Exceptions.*;
import dcc025.genius.Buttons.*;
import dcc025.genius.CompeticaoeCampeonato.Competicao;
import dcc025.genius.CompeticaoeCampeonato.CompeticaoDuo;
import dcc025.genius.CompeticaoeCampeonato.CompeticaoMulti;
import dcc025.genius.CompeticaoeCampeonato.CompeticaoSolo;
import dcc025.genius.Usuario.LidarUsuarios;
import dcc025.genius.Usuario.Usuario;
import java.awt.BorderLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Renan
 */
public class TelaSelecao implements Tela {
    private JFrame tela;
    private final int WIDTH = 1100;
    private final int HEIGHT = 720;
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
    
    
    
    @Override
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
        Usuario.atual.painelSelecao(this);
        desenhaBotoes();
        tela.getContentPane().setBackground(new Color(140, 200, 220, 80));
        tela.pack();
    }
    public void settlini(TelaInicial telaInic)
    {
        this.telaIni=telaInic;
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
        JButton sair = new JButton("Sair");
        sair.addActionListener(new BotaoSair(this,telaIni));
        sair.setBackground(new Color(230, 100, 100));
        solo.addActionListener(new Botaosolo( new TelaDificuldade(this,1),this));
        duo.addActionListener(new BotaoJogar(new TelaDificuldade(this,2),this));
        painelBotoes.add(duo);
        painelBotoes.add(multiJogador);
        multiJogador.addActionListener(new BotaoJogarMulti(this,Usuario.atual));

        //painelBotoes.setPreferredSize(new Dimension(WIDTH / 2, HEIGHT / 2));
        TitledBorder bordaTexto= BorderFactory.createTitledBorder("Opções de jogo");
        bordaTexto.setTitleFont(fonte3);
        bordaTexto.setTitleJustification(2);
        painelBotoes.setBorder(BorderFactory.createCompoundBorder(bordaTexto, BorderFactory.createEmptyBorder(20, 20, 60, 20)));
        JPanel panelSair = new JPanel();
        panelSair.setLayout(fLayout);
        panelSair.setBackground(new Color(140, 200, 220, 0));
        panelSair.add(sair);
        
        tela.setPreferredSize(new Dimension (WIDTH, (HEIGHT*12)/10));
        tela.add(painelBotoes);
        tela.add(panelSair);
    }
    public void desenhaBotoesEspeciais(){
        JButton especialCompeticoes = new JButton("Competições multijogador");
        JButton especialGerenciamentoUsuarios = new JButton("Gerenciamento de Usuários");
        especialCompeticoes.setFont(fonte2);
        especialGerenciamentoUsuarios.setFont(fonte2);
        especialCompeticoes.setPreferredSize(new Dimension(2*WIDTH/7,100));
        especialGerenciamentoUsuarios.setPreferredSize(new Dimension(2*WIDTH/7,100));
        especialGerenciamentoUsuarios.setBackground(new Color(180, 185, 189));
        especialCompeticoes.setBackground(new Color(180, 185, 189));
        especialCompeticoes.addActionListener(new AcaoTelaCompeticao(this) );
        especialGerenciamentoUsuarios.addActionListener(new AcaoGerenciamentoUsuarios(this));
        JPanel painelAdm = new JPanel();
        FlowLayout fLayout = new FlowLayout(FlowLayout.CENTER, 120, 30);
        painelAdm.setLayout(fLayout);
        painelAdm.setBackground(new Color(140, 200, 220, 0));
        painelAdm.add(especialGerenciamentoUsuarios);
        painelAdm.add(especialCompeticoes);
        painelAdm.setPreferredSize(new Dimension(WIDTH,HEIGHT/4));
        tela.getContentPane().add(painelAdm,BorderLayout.NORTH);
        
    }
    public void abrirGerenciamentoUsuarios(){
        TelaControleUsuarios novaTela = new TelaControleUsuarios(this);
        novaTela.desenha();
    }

    public void competicoesMulti() {
        System.out.println("EEEEEE"); 
        if(Usuario.atual.emCompeticao()){
            System.out.println("EEEEEE35"); 
            CompeticaoMulti c= Usuario.atual.getCompeticaoAtiva(0);
            System.out.println(c==null);
            c.iniciar();
        }
        else{
            JOptionPane.showMessageDialog(tela
                    , "Você não tem competições multijogador ativas no momento.É necessário que um administrador o adicione em uma para que você possa jogar"
                    , "Ausência de competições", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void deslogar()
    {
        Usuario.atual=null;
    }
    public void ocultar(){
        tela.setVisible(false);
    }
    @Override
    public void mostrar(boolean mostrar){
        tela.setVisible(mostrar);
    }
    public JFrame getTela()
    {
        return tela;
    }
    @Override
    public JFrame getFrame()
    {
        return tela;
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
