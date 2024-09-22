/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius;

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

    TelaRegistro telaR;
    UsuarioPersistence usrPrs;
    public LidarUsuarios(TelaRegistro telaR) {
        this.telaR = telaR;
        usrPrs = new UsuarioPersistence();
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        
        List<Usuario> usuarios =usrPrs.puxarTodos();
        Set<String> emails = new HashSet<>();
        for(Usuario user : usuarios)
            emails.add(user.getEmailTexto());
        Email.setListaInicial(emails);
        telaR.carregaUsuariosCadastrados(usuarios);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        usrPrs.salvar(telaR.getListaUsuarios());
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
