/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius;

import java.util.List;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
/**
 *
 * @author Renan
 */
public class UsuarioPersistence {
    private static final String DIRETORIO = "dados";
    private static final String CAMINHO = DIRETORIO + File.separator+"usuarios.json";
    
    public void salvar(List<Usuario> usuarios){
        Gson gson = new Gson();
        String usuariosJson = gson.toJson(usuarios);
        
        File diretorio = new File(DIRETORIO);
        if(!diretorio.exists())
            diretorio.mkdirs();
        Arquivo.salvar(CAMINHO, usuariosJson);
    }
    
    public List<Usuario> puxarTodos()
    {
        Gson gs= new Gson();
        String usuariosJson= Arquivo.ler(CAMINHO);
        
        List<Usuario> usuarios = new ArrayList<>();
        if(!usuariosJson.equals("")) {

            Type tipoLista = new TypeToken<List<Usuario>>() {
            }.getType();
        usuarios = gs.fromJson(usuariosJson, tipoLista);

        }
        if (usuarios == null)
                usuarios = new ArrayList<>();
        
        return usuarios;
    }
    
}
