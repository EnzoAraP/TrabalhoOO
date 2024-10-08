/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.CompeticaoeCampeonato;

import dcc025.genius.CompeticaoeCampeonato.Competicao;
import dcc025.genius.Telas.*;
import dcc025.genius.Usuario.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Renan
 */
public class CompeticaoDuo implements Competicao {

    private int melhor;
    private Usuario jogador;
    private int turno;
    private Game novojogo;
    private boolean fim;
    private int pontuacoes[];
    private int atual;
    private int vencedor;
    private JLabel pontuacaoLabel[];
    private int dificuldade;
    private TelaDificuldade tldificuldade;
    
    public CompeticaoDuo(Usuario jogador, int dificuldade,TelaDificuldade tldificuldade) {
        this.jogador = jogador;
        fim = false;
        pontuacoes = new int[2];
        pontuacoes[0]=pontuacoes[1]=-1;
        atual=0;
        this.tldificuldade=tldificuldade;
        vencedor=0;
        this.dificuldade=dificuldade;
        melhor=jogador.getRecorde();
    }

    @Override
    public void iniciar() {
        
        novojogo = Game.rodar(this, dificuldade,tldificuldade);
        JPanel painelPont = new JPanel();
        // Configuração da interface
        painelPont.setBorder(BorderFactory.createTitledBorder(BorderFactory.createDashedBorder(Color.DARK_GRAY), "Pontuações", 2, 1, new Font("Arial",5,32), Color.blue));
        painelPont.setSize(300, 200);
        painelPont.setLayout(new GridLayout(2, 1)); // Layout de grade para mostrar as pontuações

        pontuacaoLabel = new JLabel[2];

        // Adiciona uma linha para cada jogador
        for (int i = 0; i < 2; i++) {
            pontuacaoLabel[i] = new JLabel("Jogador " + (i + 1) + ": 0 pontos", JLabel.CENTER);
            pontuacaoLabel[i].setFont(new Font("Arial",2,18));
            painelPont.add(pontuacaoLabel[i]); // Adiciona o JLabel para cada jogador
        }
        novojogo.getTela().setLayout(new GridLayout(3,2));
        novojogo.getTela().setPreferredSize(new Dimension(600,600));
        novojogo.getTela().getContentPane().add(painelPont);
        novojogo.startGame();
       
    }

    @Override
    public boolean finalizado() {
        boolean retorno;
        if (fim) {
            retorno=true;
        }
        else{
            retorno =false;
        }
        
        mudarTurno();
        return retorno;
    }

    @Override
    public void mudarTurno() {
        
        System.out.println("Troca de turno");
        pontuacoes[atual]= novojogo.pontuacao();
        JOptionPane.showMessageDialog(novojogo.getTela(), "Pontuação do jogador "+(atual+1)+" : "+pontuacoes[atual]);
        if(fim){
           if(pontuacoes[1]>pontuacoes[0]) 
               vencedor=1;
           if(pontuacoes[1]!=pontuacoes[0])
             JOptionPane.showMessageDialog(novojogo.getTela(), "Vencedor: jogador "+(vencedor+1));
           else
             JOptionPane.showMessageDialog(novojogo.getTela(), "E o jogo termina empate. ");  
        }
        System.out.println("pontuacao: " + pontuacoes[atual]);
        System.out.println("melhor:" + melhor);
        if (pontuacoes[atual] > melhor) {
            jogador.setRecorde(pontuacoes[atual]);
            System.out.println("Sua nova melhor pontuacao mudou ! agora vale " + pontuacoes[atual]);
            melhor = pontuacoes[atual];
        }
        if(atual==0)
            atual=1;
        else
            atual=0;
        if(!fim){
          fim=true;  
          novojogo.startGame();
        }
        else{
            tldificuldade.mostrar(true);
            novojogo.getTela().dispose();
        }
    }

    @Override
    public void atualizaPontuacao() {
        pontuacoes[atual]++;
        pontuacaoLabel[atual].setText("Jogador " + (atual + 1) + " : "+pontuacoes[atual]+"  pontos");
    }

}
