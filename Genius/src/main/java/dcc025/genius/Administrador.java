/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius;

/**
 *
 * @author Renan
 */
public class Administrador extends Usuario {
    
    public Administrador(String nome, String email, String senha) throws EmailUnicoException, EmailFormatoException {
        super(nome, email, senha);
    }
    
}
