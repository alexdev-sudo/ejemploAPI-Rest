package org.comiteolimpico.apiatletas.Service;

public interface Igestor<T> {
    void agregar(T obj);
        T buscar(String nombre);

    }

