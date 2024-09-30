/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Telas;

import dcc025.genius.*;
import dcc025.genius.Telas.TelaRegistro;
import dcc025.genius.Buttons.AcaoRemocaoUsuario;
import dcc025.genius.Buttons.acao_registro_login;
import dcc025.genius.CompeticaoeCampeonato.CompeticaoMulti;
import dcc025.genius.Usuario.Email;
import dcc025.genius.OtherListeners.TabelaModificada;
import dcc025.genius.Usuario.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

    public TelaControleUsuarios(TelaSelecao telaAnterior) {
        super(telaAnterior);
        nomePagina = "Controle de Usuários";
    }

    @Override
    protected void desenhaEstruturaPropria() {
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        painel.setPreferredSize(new Dimension(5 * WIDTH / 12, HEIGHT));
        JPanel form = new JPanel();
        form.setBackground(new Color(140, 200, 220, 80));
        form.setLayout(new BorderLayout(10, 20));
        TitledBorder bordaForm = BorderFactory.createTitledBorder("Cadastrar");
        bordaForm.setTitleFont(fonte3);
        bordaForm.setTitlePosition(3);
        bordaForm.setTitleJustification(2);
        form.setBorder(bordaForm);
        form.setSize(WIDTH / 2, (8 * HEIGHT) / 10);
        JButton adicionarAdm = new JButton("Adicionar Administrador");
        JButton adicionar = new JButton("Adicionar Usuário Comum");
        JButton remover = new JButton("Remover");
        adicionar.setFont(fonte2);
        adicionarAdm.setFont(fonte2);
        remover.setFont(fonte2);
        adicionar.addActionListener(new acao_registro_login(new TelaRegistro(false, this, false), this));
        adicionarAdm.addActionListener(new acao_registro_login(new TelaRegistro(false, this, true), this));
        remover.addActionListener(new AcaoRemocaoUsuario(this));
        adicionarAdm.setBackground(new Color(130, 205, 120));
        adicionar.setBackground(new Color(140, 170, 240));
        remover.setBackground(new Color(230, 100, 100));
        JPanel painelBotoes = new JPanel();
        FlowLayout fLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);
        painelBotoes.setLayout(fLayout);
        painelBotoes.setBackground(new Color(140, 200, 220, 0));
        painelBotoes.add(adicionar);
        painelBotoes.add(adicionarAdm);
        painelBotoes.add(remover);
        painelBotoes.setPreferredSize(new Dimension(5 * WIDTH / 12, HEIGHT / 3));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        form.add(painelBotoes);
        painel.add(form, BorderLayout.WEST);
        tela.getContentPane().add(painel);
    }

    @Override
    public void remover() {
        int selectedRow = tabela.getSelectedRow();

        if (selectedRow != -1) {
            TabelaModificada model = (TabelaModificada) tabela.getModel();
            Usuario usuarioRemovido = (Usuario) model.getValueAt(selectedRow, 0);
            if (Usuario.atual.equals(usuarioRemovido)) {
                JOptionPane.showMessageDialog(tela, "Não pode remover a si mesmo na tela de controle de usuários", "ALERTA!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!usuarioRemovido.removivel()) {

                JOptionPane.showMessageDialog(tela, "Você não tem permissão para remover este usuário", "AÇÃO NÃO PERMITIDA!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (JOptionPane.showConfirmDialog(tela, "TEM CETEZA QUE DESEJA REMOVER ESSE USUÁRIO?", "REMOVER USUÁRIO", 0) == 0) {
                if (usuarioRemovido.emCompeticao()) {
                    List<CompeticaoMulti> compsAtvs = new ArrayList<>(usuarioRemovido.getCompeticoesAtivas());
                    Iterator<CompeticaoMulti> iterator = compsAtvs.iterator();
                    while (iterator.hasNext()) {
                        CompeticaoMulti comp = iterator.next();
                        comp.removerJogador(usuarioRemovido);
                    }
                }
                usuarios.remove(usuarioRemovido);
                Email.removeDaLista(usuarioRemovido.getEmailTexto());
                model.removeRow(selectedRow);
            }

        } else {
            JOptionPane.showMessageDialog(tela, "Nenhum usuário selecionado! ");
        }
    }

    public void atualizaModel(Usuario pessoa) {
        TabelaModificada model = (TabelaModificada) tabela.getModel();
        Object[] dados = {pessoa, pessoa.getEmail(), pessoa.getCargo(), pessoa.getRecorde(), pessoa.getEstadoCompeticao()};
        System.out.println(dados[0]);
        model.addRow(dados);
    }

    @Override
    public void adicionar() {
    }

}
