package com.ejercicio.traza2.model;

import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Manufacturado extends Articulo {
    @Builder.Default
    private Set<Imagen> imagenes = new HashSet<>();
    @Builder.Default
    private Set<DetalleManufacturado> detalles = new HashSet<>();

    public Manufacturado(Long id, String nombre, Categoria cat, UnidadMedida um) {
        super(id, nombre, cat, um);
        this.imagenes = new HashSet<>();
        this.detalles = new HashSet<>();
    }

    public void addImagen(Imagen i) { imagenes.add(i); }
    public void addDetalle(DetalleManufacturado d) { detalles.add(d); }
}
