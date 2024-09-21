/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius;


import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Renan
 */
public class Email {
    private static Set<String> emails = new HashSet<>();
    private String emailCompleto;
    public Email(String email)throws EmailUnicoException, EmailFormatoException {
        if(emails.contains(email))
            throw new EmailUnicoException();
        parteFormatoEmail(email);
    }
    public void setEmail(String email) throws EmailUnicoException, EmailFormatoException{
        emails.remove(emailCompleto);
        if(emails.contains(email)){
            emails.add(emailCompleto);
            throw new EmailUnicoException();
        }
        parteFormatoEmail(email);
    }
    private void parteFormatoEmail(String email) throws EmailFormatoException{
        String emailSeparado[] = email.split("@");
        if(emailSeparado.length != 2)
            throw new EmailFormatoException();
        String emailSeparado2[] = emailSeparado[1].split("\\.");
        if(emailSeparado2.length!=2 || emailSeparado2.length!=3)
            throw new EmailFormatoException();
        this.emailCompleto=email;
        emails.add(email);
    }

    public String getEmail() {
        return emailCompleto;
    }

    @Override
    public String toString() {
        return emailCompleto;
    }
    
    
}

