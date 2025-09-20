package com.ejercicio.traza2.model;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Imagen {
    @EqualsAndHashCode.Include @ToString.Include
    private Long id;
    @EqualsAndHashCode.Include @ToString.Include
    private String nombreArchivo;
}
