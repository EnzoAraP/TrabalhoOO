/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius.Arquives;
import com.google.gson.*;
import dcc025.genius.CompeticaoeCampeonato.CampeonatoChaves;
import dcc025.genius.CompeticaoeCampeonato.CampeonatoPontos;
import dcc025.genius.CompeticaoeCampeonato.CompeticaoMulti;
import java.lang.reflect.Type;

public class CompeticaoMultiAdapter implements JsonSerializer<CompeticaoMulti>, JsonDeserializer<CompeticaoMulti> {

    @Override
    public JsonElement serialize(CompeticaoMulti src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = context.serialize(src).getAsJsonObject();
        
        // Adiciona o campo classType durante a serialização
        if (src instanceof CampeonatoPontos) {
            jsonObject.addProperty("classType", "CampeonatoPontos");
        } else if (src instanceof CampeonatoChaves) {
            jsonObject.addProperty("classType", "CampeonatoChaves");
        }
        
        return jsonObject;
    }

    @Override
    public CompeticaoMulti deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        // Verificar se o campo classType existe e não é nulo
        if (jsonObject.has("classType") && !jsonObject.get("classType").isJsonNull()) {
            String classType = jsonObject.get("classType").getAsString();

            // Verifica o valor de classType e desserializa para a classe correta
            if (classType.equals("CampeonatoPontos")) {
                return context.deserialize(jsonObject, CampeonatoPontos.class);
            } else if (classType.equals("CampeonatoChaves")) {
                return context.deserialize(jsonObject, CampeonatoChaves.class);
            } else {
                throw new JsonParseException("Tipo de classe desconhecido: " + classType);
            }
        } else {
            throw new JsonParseException("Campo 'classType' ausente ou nulo no JSON.");
        }
    }
}

