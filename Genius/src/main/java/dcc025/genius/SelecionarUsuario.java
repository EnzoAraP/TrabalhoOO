/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Renan
 */
public class SelecionarUsuario implements ListSelectionListener{
 
    private TelaListaUsuarios tela;
    public SelecionarUsuario(TelaListaUsuarios tela){
        this.tela=tela;
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
       tela.atualizarUsuarioSelecionado();
    }
    
}

