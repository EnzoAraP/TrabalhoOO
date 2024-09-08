package dcc025.genius;

import java.awt.*;
import javax.swing.*;

public class UI {//(Separei essas partes em private por que o Gleiph fez o mesmo no arquivo dele então achei melhor(Enzo);
        private JFrame tela;
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
    public void Jogo(){     //Adiciona apenas o proprio Genius(Enzo)
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2));
      //  String caminhoAmarelo = "src/main/Resources/colors/amarelo.png";
        //ImageIcon icone = new ImageIcon(UI.class.getResource(caminho)); (Eu não estou conseguindo nem a pau pegar a imagem pelos arquivos de dentro do scr, devo ter que perguntar pro gleiph(Enzo);
        panel.add(new JButton("Verde"));
        panel.add(new JButton("Amarelo"));
        panel.add(new JButton("Vermelho"));
        panel.add(new JButton("Azul"));       
        tela.getContentPane().add(panel);
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
