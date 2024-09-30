/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Telas;

import dcc025.genius.OtherListeners.SelecionarUsuario;
import dcc025.genius.OtherListeners.TabelaModificada;
import dcc025.genius.Telas.TelaRegistro;
import dcc025.genius.Usuario.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
public abstract class TelaListaUsuarios implements Tela {
     JFrame tela;
    protected final int WIDTH = 1650;
    protected final int HEIGHT = 650;
    private final int V_GAP = 12;
    private final int H_GAP = 8;
    private JTextField campoNome;
    private JTextField campoCpf;
    private JTextField campoIdade;
    private JTextField campoDataNascimento;
    private JList<Usuario> jListUsuarios;
    protected JTable tabela;
    protected Font fonte;
    protected Font fonte2;
    protected Font fonte3;
    private Usuario usuarioSelecionado;
    protected List<Usuario> usuarios;
    protected String nomePagina;
    protected TelaSelecao telaAnterior;

    public TelaListaUsuarios(TelaSelecao telaAnterior) {
        nomePagina="";
        usuarios=TelaRegistro.getListaUsuarios();
        this.telaAnterior = telaAnterior;
        
    }
    
    
     @Override
    public void desenha() {
        
        fonte = new Font("Times New Roman", 4, 17);
        fonte2 = new Font("Times New Roman", 5, 20);
        fonte3 = new Font("Times New Roman", 5, 32);
        tela = new JFrame(nomePagina);
        tela.setPreferredSize(new Dimension (WIDTH, HEIGHT+100));
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setVisible(true);
        tela.addWindowListener(new saidaRetorno());
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
        model.addColumn("Cargo");
        model.addColumn("Recorde");
        model.addColumn("Em competição");
       
      
        
        tabela.getColumnModel().getColumn(0)
                .setPreferredWidth(150);
        tabela.getColumnModel().getColumn(1)
                .setPreferredWidth(150);
        tabela.getColumnModel().getColumn(2)
                .setPreferredWidth(60);
        tabela.getColumnModel().getColumn(3)
                .setPreferredWidth(25);
        tabela.getColumnModel().getColumn(4)
                .setPreferredWidth(70);
       JScrollPane painelScroll = new JScrollPane(tabela);
        painelScroll.getViewport().setBackground(new Color(180,220,215)); 
        lista.add((painelScroll), BorderLayout.CENTER);
        
        tela.getContentPane().add(lista);
        for(Usuario usuario:usuarios){
            
            Object[] dados = {usuario, usuario.getEmail(),usuario.getCargo(), usuario.getRecorde(),usuario.getEstadoCompeticao()};
            System.out.println(dados[0]);
            model.addRow(dados);
        } 
    }
     @Override
    public void mostrar(boolean mostrar) {
       tela.setVisible(mostrar);
    }
    public void atualizarUsuarioSelecionado() {
        int selectedRow = tabela.getSelectionModel().getMinSelectionIndex();

        if(selectedRow != -1){

            TabelaModificada model = (TabelaModificada) tabela.getModel();
            usuarioSelecionado = (Usuario) model.getValueAt(selectedRow, 0);
        }
    }
    public abstract void adicionar();
    public abstract void remover();

    @Override
    public JFrame getFrame() {
        return tela;
    }
    
    private class saidaRetorno implements WindowListener{

        @Override
        public void windowOpened(WindowEvent e) {
            
        }

        @Override
        public void windowClosing(WindowEvent e) {
           telaAnterior.mostrar(true);
        }

        @Override
        public void windowClosed(WindowEvent e) {
          telaAnterior.mostrar(true);
        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }
        
    }
}
