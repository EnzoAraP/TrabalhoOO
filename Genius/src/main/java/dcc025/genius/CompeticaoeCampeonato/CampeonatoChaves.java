/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.CompeticaoeCampeonato;

import static dcc025.genius.CompeticaoeCampeonato.CompeticaoMulti.numCompeticoesMulti;
import dcc025.genius.Usuario.Usuario;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Renan
 */
public class CampeonatoChaves extends CompeticaoMulti {
    
    
    private int vencedorNum;
    private transient JTextArea mensagemPontuacoes;
    private boolean[] jogou;
    
    public static int maxJogadores(){
        return 2;
    }
    public CampeonatoChaves(List<Usuario> jogadores) throws Exception {
        super(jogadores);
        if(jogadores.size()!=2){
            numCompeticoesMulti--;
            throw new Exception("Numero inválido de jogadores");
            
        }
        jogou = new boolean[2];
        jogou[0]=jogou[1]=false;
        vencedorNum=-1;
        this.atualizaUsuariosEmCompeticao();
    }

    @Override
    public void organizar() {
        this.mensagemPontuacoes= new JTextArea();
        String adicao = "";
        if(indiceAtual==0)
            adicao="Você, "+jogadorAtual.getNome()+", é o anfitrião a estabelecer a pontuação \na ser batida por "+jogadorAtual.getNome()+"(Desafiante)";
        else
            adicao="Você, "+jogadorAtual.getNome()+", é o desafiante.\nDeve superar a pontuação de "+pontuacoes.get(0)+" \npara se tornar o campeoão.\nCaso contrário,perderá.";
        painelPont.setLayout(new GridLayout(2, 1));
        pontuacoesPainel.setBorder(BorderFactory.createTitledBorder("Pontuação"));
        pontuacoesPainel.setFont(new Font("Arial", 5, 18));
        mensagemPontuacoes.setText(adicao);
        mensagemPontuacoes.setFont(new Font("Times New Roman",4,18));
        mensagemPontuacoes.setRows(4);
        mensagemPontuacoes.setBackground(Color.DARK_GRAY);
        pontuacoesPainel.add(mensagemPontuacoes);
    }

    
    
    @Override
    public boolean finalizado() {
        mudarTurno();
        return vencedorNum!=-1;
    }

    

    @Override
    public void mudarTurno() {
         System.out.println("Troca de turno");
        pontuacaoAtual = novoJogo.pontuacao();
        jogou[indiceAtual]=true;
        pontuacoes.set(indiceAtual, pontuacaoAtual);
        if(indiceAtual==0)
            JOptionPane.showMessageDialog(telaNovoJogo, "Sua pontuação: " + pontuacaoAtual+".\nEla foi estabelecida, agora o desafiante deve tentar superá-la.\n"
                    + "Em caso negativo, você defenderá sua coroa e vencerá a partida!");
        else
        {
            JOptionPane.showMessageDialog(telaNovoJogo, "Sua pontuação: " + pontuacaoAtual+". Será que foi suficiente?");
            if(pontuacoes.get(1)>pontuacoes.get(0))
                vencedorNum=1;
            else
                vencedorNum=0;
        }
       
        System.out.println("melhor:" + melhor);
        if (pontuacaoAtual > melhor) {
            this.jogadorAtual.setRecorde(pontuacaoAtual);
            JOptionPane.showMessageDialog(telaNovoJogo, "Sua nova melhor pontuacao mudou ! agora vale " + pontuacaoAtual, "Superação de recorde", JOptionPane.INFORMATION_MESSAGE);
            melhor = pontuacaoAtual;
        }
        if(vencedorNum!=-1){
            this.mensagemFimJogo();
            JOptionPane.showMessageDialog(telaNovoJogo, mensagem, "Fim do confronto", JOptionPane.INFORMATION_MESSAGE);
            jogadorAtual.retirarCompeticao(this);
            mensagem="-";
        }
        telaNovoJogo.dispose();
        pontuacaoAtual=-1;
    }

    @Override
    public boolean possivelJogar() {
       boolean retorno=true;
        if(jogou[indiceAtual] ){
            retorno=false;
           if(indiceAtual==0)
               JOptionPane.showMessageDialog(telaNovoJogo, "Você já jogou, anfitrião e estabeleceu a pontuação de "+pontuacoes.get(0)+
                       "\nAgora é vez de "+jogadores.get(1).getNome()+" ,de email "+jogadores.get(1).getEmailTexto()+" tentar lhe superar!", "Paciência", JOptionPane.INFORMATION_MESSAGE);
           else
               JOptionPane.showMessageDialog(telaNovoJogo, "Você já jogou, desafiante. Aguarde o resultado final.", "Já jogou", JOptionPane.INFORMATION_MESSAGE);
        } 
        else if(indiceAtual==1 && !jogou[0]){
            retorno=false;
            JOptionPane.showMessageDialog(telaNovoJogo, "Você, desafiante, deve aguardar a jogada do anfitrião "+jogadores.get(0).getNome()+
                    ", de email "+jogadores.get(0).getEmailTexto()+".\nApenas após ela pode tentar sua vitória!", "Aguarde o anfitrião", JOptionPane.INFORMATION_MESSAGE);
        }
        return retorno;    
            
    }

    @Override
    protected void mensagemFimJogo() {
        if(vencedorNum!=indiceAtual)
            mensagem="\t\tVOCÊ PERDEU!\n";
        else
            mensagem="\t\tVOCÊ VENCEU!\n";
        if(vencedorNum==0){
            mensagem+="O desafiante foi incapaz de superar o anfitrião, que defende sua coroa com uma pontuação de "+pontuacoes.get(0)+"!!\n"
                    + "Parabéns ao vencedor "+jogadores.get(0).getNome()+" de email "+jogadores.get(0).getEmailTexto()+".";
        }
        else{
           mensagem+="O desafiante superou o anfitrião, alcançando a marca de "+pontuacoes.get(1)+"pontos!!!\n"
                    + "Parabéns ao vencedor "+jogadores.get(1).getNome()+" de email "+jogadores.get(1).getEmailTexto()+"."; 
        }
    }
    @Override
    public String getClassType() {
        return "CampeonatoChaves";
    }

    @Override
    public boolean fim() {
       return vencedorNum!=-1;
    }
}
