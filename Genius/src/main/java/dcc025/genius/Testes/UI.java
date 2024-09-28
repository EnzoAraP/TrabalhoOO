package dcc025.genius.Testes;


import dcc025.genius.Buttons.BotaoJogo;
import java.awt.*;
import javax.swing.*;
import dcc025.genius.Buttons.*;

public class UI {//(Separei essas partes em private por que o Gleiph fez o mesmo no arquivo dele então achei melhor(Enzo);
        private JFrame tela;
        private JFrame telaconta;
        public JFrame telainicial;
        private final int WIDTH = 500;
        private final int HEIGHT = 300;
        private JList<Integer> listaswingint;
        private JList<String> listaswingstring;
        
    public void Board() {//Separei aqui apenas a tela para chamar as outras funçóes(Enzo);
        tela = new JFrame("Genius");
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(WIDTH,HEIGHT);
        Jogo();
        Leaderboard();
        Opcoes();
        tela.setVisible(true);
    }
    public void Telainicial(){//teste tela inicial
        telainicial =new JFrame("Tela inicial");
        telainicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telainicial.setSize(WIDTH,HEIGHT);
        Botoestela();
        telainicial.setVisible(true);
    }
    public void Botoestela()//Panel para por os botoes da tela inicial
    {
            JPanel panel = new JPanel ();
            panel.setLayout(new GridLayout(4,1));
            panel.setPreferredSize(new Dimension(WIDTH/3, HEIGHT/2));
            JButton Jogar = new JButton("Jogar");
            JButton Conta = new JButton("Conta");
            panel.add(Jogar);
            panel.add(new JButton("Leaderboard"));
            panel.add(Conta);
            Conta.addActionListener(new BotaoConta(this));
            Jogar.addActionListener (new BotaoJogo(this));
            telainicial.getContentPane().add(panel,BorderLayout.CENTER);
                    
    }
    public void Jogo(){     //Adiciona apenas o proprio Genius(Enzo)
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2));
        String caminhoAmarelo = "/colors/amarelo.png";
        String caminhoVermelho = "/colors/vermelho.png";
         String caminhoVerde = "/colors/verde.png";
          String caminhoAzul = "/colors/azul.png";
        ImageIcon iconeAM = new ImageIcon(UI.class.getResource(caminhoAmarelo)); 
        ImageIcon iconeVM = new ImageIcon(UI.class.getResource(caminhoVermelho)); 
        ImageIcon iconeVR = new ImageIcon(UI.class.getResource(caminhoVerde)); 
        ImageIcon iconeAZ = new ImageIcon(UI.class.getResource(caminhoAzul));
        panel.add(new JButton("Verde",iconeVR));
        panel.add(new JButton("Amarelo",iconeAM));
        panel.add(new JButton("Vermelho",iconeVM));
        panel.add(new JButton("Azul",iconeAZ));       
        tela.getContentPane().add(panel);
    }
    public void TelaConta(){//Tela da conta -> Possui o botão de Login e Registrar, os quais vao abrir Panels;
        telaconta = new JFrame("TelaConta");
        telaconta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           telaconta.setSize(WIDTH,HEIGHT);
           telaconta.setLayout(new GridLayout(2,1));
        JButton Login = new JButton("Login");
        JButton Register = new JButton ("Registrar");
        telaconta.add(Login);
        telaconta.add(Register);
        telaconta.setVisible(true);
    }
    public void Leaderboard(){ //Adiciona o Leaderboard(Enzo)
    JPanel panel = new JPanel();
           
          panel.setPreferredSize(new Dimension(WIDTH/3, HEIGHT/2));
          panel.setLayout(new GridLayout(1,2));
          DefaultListModel<Integer> pontuacao = new DefaultListModel<>();// Não conseguir ver direito daonde veio essa função,  List comum não funciona; queria fazer um map para por nome/pontuação na lista(Enzo);
          {//adiciona testes
          pontuacao.addElement(0);
          pontuacao.addElement(1);
          pontuacao.addElement(2);
          pontuacao.addElement(3);
    }
          DefaultListModel<String> pontuador = new DefaultListModel<>();
          {//adiciona testes
          pontuador.addElement("Primeiro");
          pontuador.addElement("Segundo");
          pontuador.addElement("Terceiro");
          }
          listaswingstring = new JList<>(pontuador);
          listaswingint = new JList<>(pontuacao);
           panel.add(new JScrollPane(listaswingstring));
           panel.add(new JScrollPane(listaswingint));
           tela.getContentPane().add(panel,BorderLayout.EAST);
    }
    public void Opcoes(){ //Inicio de tentativas de por os botoes de Logar e afins(Enzo);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT/5));
        panel.add(new JButton("Login"));
         panel.add(new JButton("Register"));
        panel.add(new JButton("Logout"));
            tela.getContentPane().add(panel,BorderLayout.SOUTH);
         
    }
    
}
