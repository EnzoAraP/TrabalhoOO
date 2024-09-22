/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Renan
 */
public class TelaRegistro {
    private JFrame tela;
    private final int WIDTH = 1350;
    private final int HEIGHT = 650;
    private final int V_GAP = 12;
    private final int H_GAP = 8;
    private JTextField campoNome;
    private JTextField campoEmail;
    private JTextField campoSenha;
    private JList<Usuario> jListUsuarios;
    private List<Usuario> listaUsuarios;
    JTable tabela;
    Font fonte;
    Font fonte2;
    Font fonte3;
    

    public void desenha() {
        
        fonte = new Font("Arial", 4, 17);
        fonte2 = new Font("Arial", 5, 20);
        fonte3 = new Font("Arial", 5, 32);
        tela = new JFrame("Registro");
        tela.addWindowListener(new LidarUsuarios(this));
        tela.setPreferredSize(new Dimension (WIDTH, HEIGHT+100));
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);
        DefaultListModel<Usuario> model = new DefaultListModel<>();
        jListUsuarios= new JList<>(model);
        FlowLayout layout= new FlowLayout();
        layout.setAlignment(FlowLayout.CENTER);
        tela.setLayout(layout);
        
        desenhaFormCadastro();
        tela.getContentPane().setBackground(new Color(140, 200, 220, 80));
        tela.pack();
    }
    
    private void desenhaFormCadastro() {

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        painel.setPreferredSize(new Dimension(WIDTH / 3, HEIGHT));
        JPanel form = new JPanel();
        form.setBackground(new Color(140, 200, 220, 80));
        form.setLayout(new BorderLayout(10, 20));
        TitledBorder bordaForm = BorderFactory.createTitledBorder("Registro");
        bordaForm.setTitleFont(fonte3);
        bordaForm.setTitlePosition(3);
        bordaForm.setTitleJustification(2);
        form.setBorder(bordaForm);
        form.setSize(WIDTH / 3, (8 * HEIGHT) / 10);
        JPanel painelCampos = new JPanel();
        painelCampos.setBackground(new Color(120, 180, 190, 90));
        painelCampos.setPreferredSize(new Dimension(WIDTH / 3, 5 * HEIGHT / 8));
        painelCampos.setLayout(new GridLayout(6, 0, 12, 8));
        campoNome = new JTextField(30);
        campoEmail = new JTextField(15);
        campoSenha = new JTextField(15);

        JLabel[] labels = {new JLabel("Nome"), new JLabel("E-mail"), new JLabel("Senha")};

        for (int i = 0; i < 3; i++) {
            labels[i].setLayout(new BorderLayout(0, 0));
            labels[i].setFont(fonte2);
            if (i != 0) {
                labels[i].setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
            }
            painelCampos.add(labels[i]);
        }

        painelCampos.add(campoNome, 1);

        painelCampos.add(campoEmail, 3);

        painelCampos.add(campoSenha, 5);
        painelCampos.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(125, 145, 130), 1, true), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        campoNome.setFont(fonte);
        campoEmail.setFont(fonte);
        campoSenha.setFont(fonte);
        JButton registrar = new JButton("Registrar");
        JButton cancelar = new JButton("Cancelar");
        registrar.addActionListener(new AcaoRegistro(this));
        registrar.setFont(fonte2);
        cancelar.setFont(fonte2);
        //adicionar.addActionListener(new Adicionar(this));
        //editar.addActionListener(new Editar(this));
        //remover.addActionListener(new Remover(this));
        registrar.setBackground(new Color(140, 240, 170));
        cancelar.setBackground(new Color(230, 100, 100));
        JPanel painelBotoes = new JPanel();
        FlowLayout fLayout = new FlowLayout(FlowLayout.CENTER, 20, 20);
        painelBotoes.setLayout(fLayout);
        painelBotoes.setBackground(new Color(140, 200, 220, 0));
        painelBotoes.add(registrar);
        painelBotoes.add(cancelar);
        painelBotoes.setMinimumSize(new Dimension(WIDTH / 3, HEIGHT / 3));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 20, 60, 20));
        form.add(painelCampos, BorderLayout.NORTH);
        form.add(painelBotoes);
        painel.add(form, BorderLayout.WEST);
        tela.getContentPane().add(painel);

    }
    public void carregaUsuariosCadastrados(List<Usuario> listaUsuarios){
        this.listaUsuarios = listaUsuarios;
        if(listaUsuarios==null)
            listaUsuarios= new ArrayList<>();
        
    }
    public List<Usuario> getListaUsuarios(){
        return this.listaUsuarios;
    }
    public void registrarUsuario(){
        Email email = null;
        Usuario pessoa = null;
        DefaultListModel<Usuario> model = (DefaultListModel<Usuario>)jListUsuarios.getModel();
        try {
            email = new Email(campoEmail.getText());
        } catch (EmailUnicoException ex) {
            JOptionPane.showMessageDialog(tela, "Esse email já está cadastrado");
        } catch (EmailFormatoException ex) {
            JOptionPane.showMessageDialog(tela, "O email passado é inválido");
        }
        try {
            pessoa = new Usuario(campoNome.getText(), email, campoSenha.getText());
            model.addElement(pessoa);
            listaUsuarios.add(pessoa);

        } catch (Exception ex) {
            
        }
    }
}
