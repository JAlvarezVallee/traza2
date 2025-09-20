package com.ejercicio.traza2.model;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Insumo extends Articulo {
    private boolean esParaElaborar;

    public Insumo(Long id, String nombre, Categoria cat, UnidadMedida um, boolean esParaElaborar) {
        super(id, nombre, cat, um);
        this.esParaElaborar = esParaElaborar;
    }
}

