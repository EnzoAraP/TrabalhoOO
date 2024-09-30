/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Arquives;

import dcc025.genius.Usuario.Usuario;
import java.util.List;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import dcc025.genius.CompeticaoeCampeonato.CampeonatoChaves;
import dcc025.genius.CompeticaoeCampeonato.CampeonatoPontos;
import dcc025.genius.CompeticaoeCampeonato.CompeticaoMulti;
import dcc025.genius.Usuario.Administrador;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Renan
 */
public class UsuarioPersistence {
    private static final String DIRETORIO = "dados";
    private static final String CAMINHO = DIRETORIO + File.separator+"usuarios.json";
    private static final String CAMINHO_ESTATICO = DIRETORIO + File.separator+"estaticos.json";
     private Gson criarGson() {
        return new GsonBuilder()
                .registerTypeAdapter(CompeticaoMulti.class, new CompeticaoMultiAdapter())
                .create();
    }
    public void salvar(List<Usuario> usuarios) {
    Gson gson = criarGson();
    List<JsonObject> jsonUsuarios = new ArrayList<>();

    for (Usuario usuario : usuarios) {
        JsonObject jsonObject = (JsonObject) gson.toJsonTree(usuario);

        // Adiciona o campo de tipo manualmente
        if (usuario instanceof Administrador) {
            jsonObject.addProperty("tipo", "Administrador");
        } else {
            jsonObject.addProperty("tipo", "Usuario");
        }

        jsonUsuarios.add(jsonObject);
    }

    String usuariosJson = gson.toJson(jsonUsuarios);

    File diretorio = new File(DIRETORIO);
    if (!diretorio.exists()) {
        diretorio.mkdirs();
    }
    Arquivo.salvar(CAMINHO, usuariosJson);
}

   
  public List<Usuario> puxarTodos() {
    Gson gson = criarGson();
    String usuariosJson = Arquivo.ler(CAMINHO);

    List<Usuario> usuarios = new ArrayList<>();
    if (!usuariosJson.equals("")) {
        // Parse o JSON como uma lista de JsonObjects
        Type tipoLista = new TypeToken<List<JsonObject>>() {}.getType();
        List<JsonObject> jsonUsuarios = gson.fromJson(usuariosJson, tipoLista);

        // Itera sobre os JsonObjects e desserializa de acordo com o campo "tipo"
        for (JsonObject jsonObject : jsonUsuarios) {
            String tipo = jsonObject.get("tipo").getAsString();

            Usuario usuario;
            if ("Administrador".equals(tipo)) {
                usuario = gson.fromJson(jsonObject, Administrador.class);
            } else {
                usuario = gson.fromJson(jsonObject, Usuario.class);
            }

            usuarios.add(usuario);
        }
    }

    return usuarios;
}
   public void salvarCamposStatic() throws IOException {
       Gson gson = new Gson();
        Map<String, Integer> camposEstaticos = new HashMap<>();
        camposEstaticos.put("numUsuariosTotal", Usuario.getNumUsuariosCriados());
        camposEstaticos.put("numCompeticoesMulti",CompeticaoMulti.getNumCompeticoesMulti() );
        String jsonEstatico = gson.toJson(camposEstaticos);
        File diretorio = new File(DIRETORIO);
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }
        Arquivo.salvar(CAMINHO_ESTATICO,jsonEstatico );
    }

    // Método para carregar campos estáticos
    public void carregarCamposStatic() throws IOException {
        String jsonEstatico = Arquivo.ler(CAMINHO_ESTATICO);
        Gson gson = new Gson();
        if (!jsonEstatico.isEmpty()) {
            Map<String, Integer> camposStatic = gson.fromJson(jsonEstatico, new TypeToken<Map<String, Integer>>() {}.getType());
            if (camposStatic.containsKey("numUsuariosTotal")) {
                Usuario.setNumUsuariosTotal(camposStatic.get("numUsuariosTotal"));
            }
            if (camposStatic.containsKey("numCompeticoesMulti")) {
                CompeticaoMulti.setNumCompeticoesMulti(camposStatic.get("numCompeticoesMulti"));
            }
        }
    }
   
}
