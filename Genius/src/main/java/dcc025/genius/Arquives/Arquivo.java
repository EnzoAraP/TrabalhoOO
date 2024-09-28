/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Arquives;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renan
 */
public class Arquivo {
    public static boolean salvar(String caminho,String dadosArquivar){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho, false))) {
            writer.write(dadosArquivar);
        } catch (IOException e) {
            System.out.println("Erro ao armazenar arquivos");
            return false;
        }
      return true;  
    }
    public static String ler(String caminho){
            FileReader leitorArquivo=null;
            StringBuilder dados= new StringBuilder();
            BufferedReader leitorLimpo=null;
        try {
            leitorArquivo = new FileReader(caminho);
            leitorLimpo = new BufferedReader(leitorArquivo);
            String linha;
            while((linha = leitorLimpo.readLine()) != null)
                dados.append(linha).append("\n");
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
            return "";
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        return dados.toString();
    }
}
