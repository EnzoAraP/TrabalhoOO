/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Exceptions;

/**
 *
 * @author Renan
 */
public class EmailUnicoException extends Exception {
    public EmailUnicoException(){
        super("Email deve ser único");
    }
}