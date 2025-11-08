package org.comiteolimpico.apiatletas.Service;

import org.comiteolimpico.apiatletas.Model.Atleta;

import java.util.ArrayList;
import java.util.List;

public class Gestor_Atletas implements  Igestor<Atleta>{

    private List<Atleta> atletas = new ArrayList<>();
    @Override
    public void agregar (Atleta a){
        atletas.add(a);
    }

    @Override
public Atleta buscar (String nombre) {
    return atletas.stream().filter(a -> a.getNombre().equalsIgnoreCase(nombre))
            .findFirst().orElse(null);
    }
public List<Atleta> getAtletas() {
        return atletas;
}
}