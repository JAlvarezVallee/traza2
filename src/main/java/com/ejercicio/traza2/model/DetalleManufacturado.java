package com.ejercicio.traza2.model;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class DetalleManufacturado {
    private Long id;
    private double cantidad;
    private Insumo insumo;
}
