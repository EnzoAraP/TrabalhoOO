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
    public static boolean removeDaLista(String email){
        return emails.remove(email);
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
        System.out.println("aaaa");
        String emailSeparado2[] = emailSeparado[1].split("\\.");
        System.out.println(emailSeparado2[0]+" "+emailSeparado2[1]);
        if(emailSeparado2.length!=2 && emailSeparado2.length!=3)
            throw new EmailFormatoException();
        this.emailCompleto=email;
        emails.add(email);
    }

    public String getEmail() {
        return emailCompleto;
    }

    public static void setListaInicial(Set<String> emails) {
        Email.emails = emails;
    }
     
    @Override
    public String toString() {
        return emailCompleto;
    }
    
    
}

