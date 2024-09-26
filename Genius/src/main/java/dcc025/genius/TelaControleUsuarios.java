/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Renan
 */
public class TelaControleUsuarios extends TelaListaUsuarios {

    public TelaControleUsuarios() {
        super();
        nomePagina="Controle de Usuários";
    }

    @Override
    protected void desenhaEstruturaPropria() {
         JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        painel.setPreferredSize(new Dimension(WIDTH / 4, HEIGHT));
        JPanel form = new JPanel();
        form.setBackground(new Color(140, 200, 220, 80));
        form.setLayout(new BorderLayout(10, 20));
        TitledBorder bordaForm = BorderFactory.createTitledBorder("Cadastrar");
        bordaForm.setTitleFont(fonte3);
        bordaForm.setTitlePosition(3);
        bordaForm.setTitleJustification(2);
        form.setBorder(bordaForm);
        form.setSize(WIDTH / 3, (8 * HEIGHT) / 10);
        JButton adicionar = new JButton("Adicionar");
        JButton remover = new JButton("Remover");
        adicionar.setFont(fonte2);
        remover.setFont(fonte2);
        adicionar.addActionListener(new acao_registro_login(new TelaRegistro(false,this),this));
        remover.addActionListener(new AcaoRemocaoUsuario(this));
        adicionar.setBackground(new Color(140, 240, 170));
        remover.setBackground(new Color(230, 100, 100));
        JPanel painelBotoes = new JPanel();
        FlowLayout fLayout = new FlowLayout(FlowLayout.CENTER, 20, 20);
        painelBotoes.setLayout(fLayout);
        painelBotoes.setBackground(new Color(140, 200, 220, 0));
        painelBotoes.add(adicionar);
        painelBotoes.add(remover);
        painelBotoes.setMinimumSize(new Dimension(WIDTH / 3, HEIGHT / 3));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 20, 60, 20));
        form.add(painelBotoes);
        painel.add(form, BorderLayout.WEST);
        tela.getContentPane().add(painel);
    }

    void remover() {
        int selectedRow = tabela.getSelectedRow();

        if (selectedRow != -1) {
            TabelaModificada model = (TabelaModificada) tabela.getModel();
            if (JOptionPane.showConfirmDialog(tela, "TEM CETEZA QUE DESEJA REMOVER ESSE USUÁRIO?", "REMOVER USUÁRIO", 0) == 0) {
                Usuario usuarioRemovido = (Usuario)model.getValueAt(selectedRow, 0);
                usuarios.remove(usuarioRemovido);
                Email.removeDaLista(usuarioRemovido.getEmailTexto());
                model.removeRow(selectedRow);
            }


        } else {
            JOptionPane.showMessageDialog(tela, "Nenhum usuário selecionado! ");
        }
    }

    void mostrar(boolean b) {
       tela.setVisible(true);
    }

    void atualizaModel(Usuario pessoa) {
           TabelaModificada model = (TabelaModificada)tabela.getModel();
            Object[] dados = {pessoa, pessoa.getEmail(), pessoa.getRecorde(),(boolean)(pessoa.numeroCompeticoesAtivas()!=0)};
            System.out.println(dados[0]);
            model.addRow(dados);
    }
    
}
