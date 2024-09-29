/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.CompeticaoeCampeonato;

import dcc025.genius.Usuario.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renan
 */
public class CampeonatoChaves extends CompeticaoMulti {
    
    private List<Integer> vencedores;
    private int vencedor;
    public CampeonatoChaves(List<Usuario> jogadores) throws Exception {
        super(jogadores,1);
        if(jogadores.size()!=2 && jogadores.size()!=4 && jogadores.size()!=8)
            throw new Exception("Numero inválido de jogadores");
        vencedor=-1;
        vencedores=new ArrayList<>();
    }

    @Override
    public void organizar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean finalizado() {
        return vencedor!=-1;
    }

    @Override
    public void atualizaPontuacao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
