 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.CompeticaoeCampeonato;

import dcc025.genius.CompeticaoeCampeonato.Competicao;
import dcc025.genius.Telas.Game;
import dcc025.genius.Telas.*;
import dcc025.genius.Usuario.Usuario;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Renan
 */
public class CompeticaoSolo  extends Competicao{

    private int melhor;
    private Usuario jogador;
    private int dificuldade;
    private Game novojogo;
    private int pontuacao;

    private TelaDificuldade tldificuldade;
    private JLabel pontuacaoLabel;
    private JLabel pontuacaoMelhorLabel;
    private JLabel ponuacaoBestLabel;
    public CompeticaoSolo(Usuario jogador,int dificuldade,TelaDificuldade tldificuldade) {
        this.jogador = jogador;
        this.dificuldade=dificuldade;
        this.tldificuldade=tldificuldade;
        pontuacao=-1;
        int solo=1;
    }
    @Override
    public void iniciar() {
        
        novojogo=Game.rodar(this,dificuldade,tldificuldade);
        JPanel painelPont = new JPanel();
        // Configuração da interface
        painelPont.setBorder(BorderFactory.createTitledBorder(BorderFactory.createDashedBorder(Color.DARK_GRAY), "Pontuações", 2, 1, new Font("Arial",5,32), Color.blue));
        painelPont.setSize(400, 300);
        painelPont.setLayout(new GridLayout(3, 1)); // Layout de grade para mostrar as pontuações

        pontuacaoLabel = new JLabel();
  pontuacaoLabel = new JLabel("Pontuacao do jogador: 0 pts", JLabel.CENTER);
  pontuacaoMelhorLabel = new JLabel("Melhor pontuacao da rodada: 0 pts", JLabel.CENTER);
            pontuacaoLabel.setFont(new Font("Arial",2,18));
            pontuacaoMelhorLabel.setFont(new Font("Arial",2,18));
            painelPont.add(pontuacaoLabel); // Adiciona o JLabel para cada jogador
            painelPont.add(pontuacaoMelhorLabel);
            ponuacaoBestLabel = new JLabel("Sua melhor pontuacao:"+jogador.getRecorde()+" pts");
         ponuacaoBestLabel.setFont(new Font("Arial",2,18));
            painelPont.add(ponuacaoBestLabel);
            ;
        novojogo.getTela().setLayout(new GridLayout(3,3));
        novojogo.getTela().setPreferredSize(new Dimension(900,900));
        novojogo.getTela().getContentPane().add(painelPont);   
        novojogo.startGame();
    }

    @Override
    public boolean finalizado() {
       
        mudarTurno();
        pontuacao=0;
                pontuacaoLabel.setText("  Pontuacao do jogador: "+pontuacao+"pts");
        return true;
    }

    @Override
    public void mudarTurno() {
        System.out.println("Troca de turno");
        int pontuacao=novojogo.pontuacao();
        System.out.println("pontuacao: "+pontuacao);
        System.out.println("melhor:"+melhor);
        if(pontuacao>melhor)
        {
            jogador.setRecorde(pontuacao);
            System.out.println("Sua nova melhor pontuacao mudou ! agora vale "+pontuacao);
            melhor =pontuacao;
             atualizamelhor( melhor);
             if(pontuacao>jogador.getRecorde())
             {
                 jogador.setRecorde(pontuacao);
             }
        }
       
        pontuacao=0;
        novojogo.startGame();
        //Ver qual foi a pontuacao do jogo e verificar os recordes
    }
   

     @Override
    public void atualizaPontuacao() {
        pontuacao++;
        pontuacaoLabel.setText("  Pontuacao do jogador: "+pontuacao+"pts");
    }
    public void atualizamelhor(int novomelhor)
    {
        System.out.println("entrou atualizamelhor :"+novomelhor);
        pontuacaoMelhorLabel.setText("Melhor pontuacao da rodada:"+novomelhor+" pts");
         ponuacaoBestLabel.setText("Sua melhor pontuacao:"+jogador.getRecorde()+" pts");
    }
}
