

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dcc025.genius.Buttons;
import dcc025.genius.Telas.TelaControleCompeticao;
import dcc025.genius.Telas.TelaSelecao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 *
 * @author Renan
 */
public class AcaoTelaCompeticao implements ActionListener{
    TelaSelecao tela;
    public AcaoTelaCompeticao(TelaSelecao tela) {
       this.tela=tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] opcoes={"Campeonato de Pontos","Confronto"};
       int escolha = JOptionPane.showOptionDialog(tela.getFrame(), "Qual será o tipo de competição que deseja gerenciar na tela de controle?", "Tipo de competição", 0, 0,null  , opcoes, 0);
       if(escolha!=-1){
           tela.mostrar(false);
           TelaControleCompeticao telaControl = new TelaControleCompeticao(this.tela,escolha);
           telaControl.desenha();
       }
    }
    
    
}