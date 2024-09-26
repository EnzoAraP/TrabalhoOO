/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Renan
 */
public abstract class TelaListaUsuarios {
     JFrame tela;
    protected final int WIDTH = 1350;
    protected final int HEIGHT = 650;
    private final int V_GAP = 12;
    private final int H_GAP = 8;
    private JTextField campoNome;
    private JTextField campoCpf;
    private JTextField campoIdade;
    private JTextField campoDataNascimento;
    private JList<Usuario> jListUsuarios;
    JTable tabela;
    protected Font fonte;
    protected Font fonte2;
    protected Font fonte3;
    private Usuario usuarioSelecionado;
    protected List<Usuario> usuarios;
    protected String nomePagina;

    public TelaListaUsuarios() {
        nomePagina="";
         usuarios=TelaRegistro.getListaUsuarios();
        
        
    }
    
    
    public void desenha() {
        
        fonte = new Font("Times New Roman", 4, 17);
        fonte2 = new Font("Times New Roman", 5, 20);
        fonte3 = new Font("Times New Roman", 5, 32);
        tela = new JFrame(nomePagina);
        tela.setPreferredSize(new Dimension (WIDTH, HEIGHT+100));
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);
        usuarioSelecionado=null;
        FlowLayout layout= new FlowLayout();
        layout.setAlignment(FlowLayout.CENTER);
        tela.setLayout(layout);
        desenhaListaUsuarios();
        desenhaEstruturaPropria();
        tela.getContentPane().setBackground(new Color(140, 200, 220, 80));
        tela.pack();
    }
    protected abstract void desenhaEstruturaPropria(); 
    private void desenhaListaUsuarios() {
        JPanel lista = new JPanel();
        TitledBorder bordaTabela = BorderFactory.createTitledBorder("Lista de Usuários");
        bordaTabela.setTitleFont(fonte3);
        bordaTabela.setTitlePosition(3);
        bordaTabela.setTitleJustification(2);
        lista.setBorder(bordaTabela);
        lista.setPreferredSize(new Dimension(6 * WIDTH / 12, HEIGHT));
        lista.setBackground(new Color(140, 200, 220, 80));
        lista.setLayout(new BorderLayout());
        TabelaModificada model = new TabelaModificada();
        tabela = new JTable(model);
        
         
        
         
        tabela.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected && !hasFocus) {
                    c.setBackground(row % 2 == 0 ? new Color(100, 200, 240, 70) : new Color(140, 160, 180, 70));
                } else {
                    c.setBackground(row % 2 == 0 ? new Color(80, 180, 220, 100) : new Color(130, 150, 160, 100));
                }
                return c;
            }
        });
        tabela.setRowHeight(30);
        
        tabela.setFont(new Font("Times New Roman", 1, 15));
        tabela.setAlignmentX(20);
        tabela.setDragEnabled(false);
        tabela.getSelectionModel().addListSelectionListener(new SelecionarUsuario(this));
        
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.getTableHeader().setFont(fonte2);
        tabela.getTableHeader().setBackground(new Color(190,220,175,50));
        
        model.addColumn("Nome");
        model.addColumn("Email");
        model.addColumn("Recorde");
        model.addColumn("Em competição");
       
      
        
        tabela.getColumnModel().getColumn(0)
                .setPreferredWidth(220);
        tabela.getColumnModel().getColumn(0)
                .setPreferredWidth(220);
        tabela.getColumnModel().getColumn(1)
                .setPreferredWidth(70);
        tabela.getColumnModel().getColumn(2)
                .setPreferredWidth(30);
        tabela.getColumnModel().getColumn(3)
                .setPreferredWidth(120);
       JScrollPane painelScroll = new JScrollPane(tabela);
        painelScroll.getViewport().setBackground(new Color(180,220,215)); 
        lista.add((painelScroll), BorderLayout.CENTER);
        
        tela.getContentPane().add(lista);
        for(Usuario usuario:usuarios){
            
            Object[] dados = {usuario, usuario.getEmail(), usuario.getRecorde(),(boolean)(usuario.numeroCompeticoesAtivas()==0)};
            System.out.println(dados[0]);
            model.addRow(dados);
        } 
    }

    void atualizarUsuarioSelecionado() {
        int selectedRow = tabela.getSelectionModel().getMinSelectionIndex();

        if(selectedRow != -1){

            TabelaModificada model = (TabelaModificada) tabela.getModel();
            usuarioSelecionado = (Usuario) model.getValueAt(selectedRow, 0);
        }
    }
}
