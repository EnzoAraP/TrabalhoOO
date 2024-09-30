/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Telas;

import dcc025.genius.Buttons.AcaoAdicaoUsuario;
import dcc025.genius.Buttons.AcaoCriarCompeticao;
import dcc025.genius.Buttons.AcaoRemocaoUsuario;
import dcc025.genius.Buttons.acao_registro_login;
import dcc025.genius.CompeticaoeCampeonato.CampeonatoChaves;
import dcc025.genius.CompeticaoeCampeonato.CampeonatoPontos;
import dcc025.genius.CompeticaoeCampeonato.CompeticaoMulti;
import dcc025.genius.OtherListeners.SelecionarUsuario;
import dcc025.genius.OtherListeners.TabelaModificada;
import dcc025.genius.Telas.TelaListaUsuarios;
import dcc025.genius.Usuario.Email;
import dcc025.genius.Usuario.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Renan
 */
public class TelaControleCompeticao extends TelaListaUsuarios {

    private List<JTextField> campoUsers;
    private List<Usuario> listaParcial;
    private JList<String> listaParcialTela;
    private int maxJogadores;
    private int tipo;
    private CompeticaoMulti competicao;
    private String nomeCompeticao;
    
    
    public TelaControleCompeticao(TelaSelecao telaAnterior, int tipo) {
        super(telaAnterior);
        nomePagina="Controle de Competições";
        campoUsers= new ArrayList<>();
        if(tipo==0){
          maxJogadores=CampeonatoPontos.maxJogadores();
          this.tipo=0;
          nomeCompeticao="Campeonato de Pontos";
        }
        else{
          maxJogadores=CampeonatoChaves.maxJogadores();
          this.tipo=1;
          nomeCompeticao="Confronto";
        }
        listaParcial = new ArrayList<>();
    }

    
    @Override
    protected void desenhaEstruturaPropria() {
       JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        
        JPanel controle = new JPanel();
        controle.setBackground(new Color(200, 167, 180, 143));
        controle.setLayout(new BorderLayout(10, 20));
        TitledBorder bordaForm = BorderFactory.createTitledBorder("Nova Competição("+nomeCompeticao+")");
        bordaForm.setTitleFont(fonte3);
        bordaForm.setTitlePosition(3);
        bordaForm.setTitleJustification(2);
        controle.setBorder(bordaForm);
        controle.setSize(new Dimension(WIDTH / 2, (8 * HEIGHT) / 10));
        JButton adicionar = new JButton("Adicionar Jogador");
        JButton remover = new JButton("Remover Jogador");
        JButton criar = new JButton("Criar Competição");
        adicionar.setFont(fonte2);
        remover.setFont(fonte2);
        criar.setFont(fonte2);
        adicionar.addActionListener(new AcaoAdicaoUsuario(this));
        remover.addActionListener(new AcaoRemocaoUsuario(this));
        criar.addActionListener(new AcaoCriarCompeticao(this));
        adicionar.setBackground(new Color(140, 240, 170));
        remover.setBackground(new Color(230, 100, 100));
        criar.setBackground(new Color(70, 160, 230));
        JPanel painelBotoes = new JPanel();
        FlowLayout fLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);
        painelBotoes.setLayout(fLayout);
        painelBotoes.setBackground(new Color(140, 200, 220, 0));
        painelBotoes.add(adicionar);
        painelBotoes.add(remover);
        painelBotoes.add(criar);
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 20, 60, 20));
        
        controle.add(painelBotoes,BorderLayout.NORTH);
        controle.add(this.desenhaListaParcial(),BorderLayout.CENTER);
        painel.add(controle, BorderLayout.WEST);
        tela.add(painel);
    }
    private JPanel desenhaListaParcial(){
        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder("Lista Parcial"));
        painel.setPreferredSize(new Dimension(WIDTH/4, HEIGHT/2));
        painel.setLayout(new BorderLayout());

        DefaultListModel<String> model = new DefaultListModel<>();


        listaParcialTela = new JList<>(model);
        listaParcialTela.addListSelectionListener(new SelecionarUsuario(this));

        painel.add(new JScrollPane(listaParcialTela), BorderLayout.CENTER);

        return painel;
    }

    @Override
    public void remover() {
       int selectedIndex = listaParcialTela.getSelectedIndex();

        if (selectedIndex != -1) {
            DefaultListModel model = (DefaultListModel<String>) listaParcialTela.getModel();
            if (JOptionPane.showConfirmDialog(tela, "TEM CETEZA QUE DESEJA TIRAR ESSE JOGADOR DA LISTA PARCIAL?", "RETIRAR JOGADOR", 0) == 0) {
                model.remove(selectedIndex);
                listaParcial.remove(selectedIndex);
            }
        } else {
            JOptionPane.showMessageDialog(tela, "Nenhum usuário selecionado! ");
        }
    }

    @Override
    public void adicionar() {
        int selectedRow = tabela.getSelectedRow();

        if (selectedRow != -1) {
            TabelaModificada model = (TabelaModificada) tabela.getModel();
            DefaultListModel modelLista = (DefaultListModel<String>) listaParcialTela.getModel();
            Usuario usuarioAdicionar = (Usuario)model.getValueAt(selectedRow, 0);
            if ( !usuarioAdicionar.emCompeticao() ) {
                if( !listaParcial.contains(usuarioAdicionar)){
                    if( listaParcial.size()<maxJogadores){
                        listaParcial.add(usuarioAdicionar);
                        modelLista.addElement(usuarioAdicionar.getEmailTexto());
                    }
                    else{
                        JOptionPane.showMessageDialog(tela, "A lista Parcial já atingiu o número máximo de jogadores para essa competição! ");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(tela, "O usuário já está na listaParcial!!! Portanto, não é possível adicioná-lo novamente. ");
                }
            }
            else{
                JOptionPane.showMessageDialog(tela, "O usuário já está em uma competição multijogador! Portanto, não é possível adicioná-lo em mais uma. ");
            }


        } else {
            JOptionPane.showMessageDialog(tela, "Nenhum usuário selecionado! ");
        }
    }
    
    public void criar(){
        
            try {
                List<Usuario> listaPassada= new ArrayList<>();
                for(Usuario jogador : listaParcial)
                    listaPassada.add(jogador);
                if(tipo==0){
                competicao = new CampeonatoPontos(listaPassada,3);
                }
                else{
                competicao = new CampeonatoChaves(listaPassada);   
                }
                TabelaModificada model = (TabelaModificada) tabela.getModel();
                model.fireTableRowsUpdated(0, model.getRowCount());
                JOptionPane.showMessageDialog(tela, "Competição criada com sucesso!", "Sucesso criação", JOptionPane.INFORMATION_MESSAGE);
                DefaultListModel modelLista = (DefaultListModel<String>) listaParcialTela.getModel();
                
                for(Usuario jogador : listaParcial)
                   System.out.println(jogador.getEstadoCompeticao());
                modelLista.clear();
                listaParcial.clear();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(tela, "Erro ao criar competição, numero de jogadores insuficiente!", "Erro criação", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }