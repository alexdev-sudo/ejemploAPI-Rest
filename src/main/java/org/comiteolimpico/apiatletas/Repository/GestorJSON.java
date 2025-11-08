package org.comiteolimpico.apiatletas.Repository;

import org.comiteolimpico.apiatletas.Model.Atleta;
import com.google.gson.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//
public class GestorJSON {
    private static final String ARCHIVO = "atletas.json";
    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .setPrettyPrinting()
            .create();



    public void guardar(List<Atleta> atletas1) {
        try (Writer writer = new FileWriter(ARCHIVO)) {
        gson.toJson(atletas1, writer);
        } catch(IOException e) {
            System.out.println("Error al guardar el archivo" +e.getMessage());
        }
    }
    public List<Atleta> cargar() {
    try(FileReader reader = new FileReader(ARCHIVO)){

        Atleta[] atleta1 = gson.fromJson(reader, Atleta[].class);
        if (atleta1 != null){
           return List.of(atleta1);

        }

    } catch (IOException e) {
        System.out.println("Archivo JSON vacio, iniciando con lista vacia");
    }
    return new ArrayList<>();
    }

    public class LocalDateAdapter  implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
        @Override
        public JsonElement serialize(LocalDate date,Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(date.toString());
        }
        @Override
        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            return LocalDate.parse(json.getAsString());
        }

    }
}
