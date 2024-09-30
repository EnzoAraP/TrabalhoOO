/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Usuario;


import dcc025.genius.Exceptions.*;
import dcc025.genius.Telas.TelaSelecao;
/**
 *
 * @author Renan
 */
public class Administrador extends Usuario {
    
    public Administrador(String nome, String email, String senha) throws EmailUnicoException, EmailFormatoException, SenhaException {
        super(nome, email, senha);
    }

    @Override
    public boolean removivel() {
        if(Usuario.atual.getEmailTexto().equals("adm@adm.adm") || Usuario.atual.equals(this))
            return true;
        return false;
    }
    @Override
    public String getCargo(){
        return "Administrador";
    }
    @Override
    public void painelSelecao(TelaSelecao tela){
        tela.desenhaBotoesEspeciais();
    }
    @Override
    public String getClassType(){
        return "Administrador";
    }
}
