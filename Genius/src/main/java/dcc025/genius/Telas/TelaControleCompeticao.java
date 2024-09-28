/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Telas;

import dcc025.genius.Telas.TelaListaUsuarios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author Renan
 */
public class TelaControleCompeticao extends TelaListaUsuarios {

    private List<JTextField> campoUsers;
    public TelaControleCompeticao() {
        super();
        nomePagina="Controle de Competições";
         campoUsers= new ArrayList<>();
    }

    
    @Override
    protected void desenhaEstruturaPropria() {
       
    }
    
}
