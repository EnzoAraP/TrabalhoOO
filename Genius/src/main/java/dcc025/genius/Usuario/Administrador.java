/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Usuario;


import dcc025.genius.Exceptions.*;
/**
 *
 * @author Renan
 */
public class Administrador extends Usuario {
    
    public Administrador(String nome, String email, String senha) throws EmailUnicoException, EmailFormatoException, SenhaException {
        super(nome, email, senha);
    }
    
}
