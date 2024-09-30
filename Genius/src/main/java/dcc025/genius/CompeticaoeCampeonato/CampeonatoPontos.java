/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.CompeticaoeCampeonato;

import dcc025.genius.Telas.Game;
import dcc025.genius.Usuario.Usuario;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Renan
 */
public class CampeonatoPontos extends CompeticaoMulti {

    private List<Integer> vidas;
    private int finalizados;
    private int turno;
    private boolean fim;
    private int vencedorNum;
    private transient JLabel vidasLabel;
    
    public static int maxJogadores(){
        return 4;
    }
    public CampeonatoPontos(List<Usuario> jogadores, int numVidas) throws Exception {
        super(jogadores);
        vidas = new ArrayList<>();
        if (numVidas < 1) {
            numVidas = 1;
        }
        for (int i = 0; i < numJogadores; i++) {
            vidas.add(numVidas);
        }
        this.atualizaUsuariosEmCompeticao();

    }

    @Override
    public void organizar() {
        
        vidas.set(this.indiceAtual, vidas.get(this.indiceAtual) - 1);
        String adicao = "";
        for (int i = 0; i < pontuacoes.size(); i++) {
            if (pontuacoes.get(i) != -1) {
                adicao = pontuacoes.get(i).toString();
            } else {
                adicao = "-";
            }
            pontuacoesLabel.add(new JLabel(jogadores.get(i).getEmailTexto() + " : " + adicao + " pontos ,   vidas: " + vidas.get(i)));
            pontuacoesPainel.add(pontuacoesLabel.get(i));
        }
        painelPont.setLayout(new GridLayout(3, 1));
        vidasLabel = new JLabel("Vidas : " + vidas.get(this.indiceAtual));
        pontuacoesPainel.setBorder(BorderFactory.createTitledBorder("Lista de maiores pontuuações"));
        pontuacoesPainel.setFont(new Font("Arial", 5, 18));
        vidasLabel.setFont(new Font("Arial", 2, 18));
        painelPont.add(vidasLabel);
        
    }

   
    public boolean fim(){
        if(jogadores.size()==1)
            return true;
        for(Integer vida : vidas){
            if(vida>0)
                return false;
        }
        return true;
    }
    @Override
    public boolean finalizado() {
        mudarTurno();
        return fim;

    }
    private List<Usuario> melhoresJogadores(){
        List<Usuario> melhoresJogadores = new ArrayList<>();
        melhorPontuacao=0;
        for(Integer pontuacao : pontuacoes )
            if(pontuacao>melhorPontuacao)
                melhorPontuacao=pontuacao;
        for(int i=0;i<jogadores.size();i++)
            if(pontuacoes.get(i)==melhorPontuacao)
                melhoresJogadores.add(jogadores.get(i));
        return melhoresJogadores;
    }

    @Override
    public void removerJogador(Usuario jogador) {
        this.inicializaLitaJogadores();
        int indice = jogadores.indexOf(jogador);
        super.removerJogador(jogador);
        if (indice != -1) {
            vidas.remove(indice);
        }
    }
    
    @Override
    public void mudarTurno() {
        System.out.println("Troca de turno");
        pontuacaoAtual = novoJogo.pontuacao();
        JOptionPane.showMessageDialog(telaNovoJogo, "Sua pontuação: " + pontuacaoAtual);

        if (pontuacaoAtual > pontuacoes.get(this.indiceAtual)) {
            pontuacoes.set(indiceAtual, pontuacaoAtual);
            pontuacoesLabel.get(indiceAtual).setText((jogadores.get(this.indiceAtual).getEmailTexto() + " : " + pontuacaoAtual + " pontos ,   vidas: " + vidas.get(this.indiceAtual)));
        }
        System.out.println("melhor:" + melhor);
        if (pontuacaoAtual > melhor) {
            this.jogadorAtual.setRecorde(pontuacaoAtual);
            JOptionPane.showMessageDialog(telaNovoJogo, "Sua nova melhor pontuacao mudou ! agora vale " + pontuacaoAtual, "Superação de recorde", JOptionPane.INFORMATION_MESSAGE);
            melhor = pontuacaoAtual;
        }
        pontuacaoAtual=-1;
        if (vidas.get(this.indiceAtual) > 0) {
            if (JOptionPane.showConfirmDialog(telaNovoJogo, "Deseja continuar jogando e gastar suas vidas restantes a fim de melhorar sua pontuação?",
                     "Continuar Jogando?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                novoJogo.startGame();
                telaNovoJogo = novoJogo.getFrame();
                vidas.set(indiceAtual, vidas.get(indiceAtual)-1);
                vidasLabel.setText("Vidas : " + vidas.get(this.indiceAtual));
                pontuacoesLabel.get(indiceAtual).setText((jogadores.get(this.indiceAtual).getEmailTexto() + " : " + pontuacoes.get(indiceAtual) + " pontos ,   vidas: " + vidas.get(this.indiceAtual)));
            } else {
                telaNovoJogo.dispose();
            }
        }
        else{
            if(!mensagem.equals("-")){
                JOptionPane.showMessageDialog(telaNovoJogo, mensagem, "Resultado final",JOptionPane.INFORMATION_MESSAGE);
                jogadorAtual.retirarCompeticao(this);
              telaNovoJogo.dispose();
            }
            else if(this.fim()){
              this.mensagemFimJogo();
               JOptionPane.showMessageDialog(telaNovoJogo, mensagem, "Resultado final",JOptionPane.INFORMATION_MESSAGE);
               jogadorAtual.retirarCompeticao(this);
               telaNovoJogo.dispose();
            }
            else{
               JOptionPane.showMessageDialog(telaNovoJogo, "Você não tem mais vidas restantes, espere até que o jogo acabe para saber o vencedor");
               telaNovoJogo.dispose();
            }
        }
    }

    
    @Override
    public boolean possivelJogar() {
      if(vidas.get(this.indiceAtual)>0)
          return true;
      String parciais="";
      String adicao = "";
        for (int i = 0; i < pontuacoes.size(); i++) {
            if (pontuacoes.get(i) != -1) {
                adicao = pontuacoes.get(i).toString();
            } else {
                adicao = "-";
            }
            parciais+=(jogadores.get(i).getEmailTexto() + " : " + adicao + " pontos ,   vidas: " + vidas.get(i)+"\n");
            
        }
      JOptionPane.showMessageDialog(telaNovoJogo, "Você está sem vidas no momento, aguarde até o fim dojogo para uma definição\n\tResultados Parciais: \n"+parciais);
      return false;
    }

    @Override
    protected void mensagemFimJogo() {
               List<Usuario> vencedores = this.melhoresJogadores();
              mensagem="\t\tJogo finalizado!!!!!\n ";
              if(vencedores.size()==1)
                  mensagem+=" O jogador "+vencedores.get(0).getNome()+" de email "+vencedores.get(0).getEmailTexto()+" é o campeão, com a pontuação de "+melhorPontuacao+" acertos";
              else{
                  mensagem+="\n O jogo termina em empate, sendo a melhor pontuação "+melhorPontuacao+" acertos. Os campeões empatados foram:\n";
                  for(Usuario umVencedor: vencedores){
                      mensagem+=umVencedor.getNome()+" , de email "+umVencedor.getEmailTexto()+"\n";
                  }
              }
    }
    
    @Override
    public String getClassType() {
        return "CampeonatoPontos";
    }

    @Override
    protected void fimAbruptoCompeticao(int indice) {
          
    }

}

