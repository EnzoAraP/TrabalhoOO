/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Usuario;


import dcc025.genius.Telas.TelaInicial;
import dcc025.genius.Telas.TelaRegistro;
import dcc025.genius.Arquives.UsuarioPersistence;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Renan
 */
public class LidarUsuarios implements WindowListener {

    private TelaInicial telaI;
    private UsuarioPersistence usrPrs;
    public LidarUsuarios(TelaInicial telaI) {
        this.telaI = telaI;
        usrPrs = new UsuarioPersistence();
    }
    public LidarUsuarios(){
        telaI=null;
        usrPrs = new UsuarioPersistence();
    }
    @Override
    public void windowOpened(WindowEvent e) {
        
        List<Usuario> usuarios =usrPrs.puxarTodos();
        Set<String> emails = new HashSet<>();
        for(Usuario user : usuarios)
            emails.add(user.getEmailTexto());
        Email.setListaInicial(emails);
        TelaRegistro.carregaUsuariosCadastrados(usuarios);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        List<Usuario> usuarios=TelaRegistro.getListaUsuarios();
        for(Usuario user : usuarios){
            System.out.println(user.getNome()+" "+user.getRecorde());
        }
        usrPrs.salvar(TelaRegistro.getListaUsuarios());
    }

    @Override
    public void windowClosed(WindowEvent e) {
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
