/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.CompeticaoeCampeonato;

import static dcc025.genius.CompeticaoeCampeonato.CompeticaoMulti.numCompeticoesMulti;
import dcc025.genius.Usuario.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renan
 */
public class CampeonatoChaves extends CompeticaoMulti {
    
    private List<Integer> vencedores;
    private int vencedorNum;
    
    public static int maxJogadores(){
        return 2;
    }
    public CampeonatoChaves(List<Usuario> jogadores) throws Exception {
        super(jogadores);
        if(jogadores.size()!=2){
            numCompeticoesMulti--;
            throw new Exception("Numero inválido de jogadores");
            
        }
        vencedorNum=-1;
        vencedores=new ArrayList<>();
        this.atualizaUsuariosEmCompeticao();
    }

    @Override
    public void organizar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean finalizado() {
        return vencedorNum!=-1;
    }

    @Override
    public void atualizaPontuacao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mudarTurno() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean possivelJogar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void mensagemFimJogo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public String getClassType() {
        return "CampeonatoChaves";
    }

    @Override
    public boolean fim() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
