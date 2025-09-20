package com.ejercicio.traza2.model;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Categoria {
    @EqualsAndHashCode.Include @ToString.Include
    private Long id;
    @EqualsAndHashCode.Include @ToString.Include
    private String nombre;
}

