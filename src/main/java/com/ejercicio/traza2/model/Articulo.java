package com.ejercicio.traza2.model;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public abstract class Articulo {
    @EqualsAndHashCode.Include @ToString.Include
    private Long id;
    @EqualsAndHashCode.Include @ToString.Include
    private String nombre;
    private Categoria categoria;
    private UnidadMedida unidadMedida;
}
