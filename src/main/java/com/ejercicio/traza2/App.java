package com.ejercicio.traza2;

import com.ejercicio.traza2.model.*;
import com.ejercicio.traza2.repo.ManufacturadoRepository;

public class App {
    public static void main(String[] args) {
        // Categorías
        Categoria pizzas = Categoria.builder().id(1L).nombre("Pizzas").build();
        Categoria lomos = Categoria.builder().id(2L).nombre("Lomos").build();
        Categoria insumos = Categoria.builder().id(3L).nombre("Insumos").build();
        Categoria sandwich = Categoria.builder().id(4L).nombre("Sandwich").build();

        // Unidades
        UnidadMedida kg = UnidadMedida.builder().id(1L).nombre("Kilogramos").build();
        UnidadMedida lt = UnidadMedida.builder().id(2L).nombre("Litros").build();
        UnidadMedida gr = UnidadMedida.builder().id(3L).nombre("Gramos").build();

        // Insumos
        Insumo sal = new Insumo(1L, "Sal", insumos, gr, true);
        Insumo aceite = new Insumo(2L, "Aceite", insumos, lt, true);
        Insumo carne = new Insumo(3L, "Carne", insumos, kg, true);
        Insumo harina = new Insumo(4L, "Harina", insumos, kg, true);

        // Imágenes
        Imagen img1 = Imagen.builder().id(1L).nombreArchivo("hawaina1.png").build();
        Imagen img2 = Imagen.builder().id(2L).nombreArchivo("hawaina2.png").build();
        Imagen img3 = Imagen.builder().id(3L).nombreArchivo("hawaina3.png").build();
        Imagen img4 = Imagen.builder().id(4L).nombreArchivo("lomo1.png").build();
        Imagen img5 = Imagen.builder().id(5L).nombreArchivo("lomo2.png").build();
        Imagen img6 = Imagen.builder().id(6L).nombreArchivo("lomo3.png").build();

        // Detalles
        DetalleManufacturado dPizza1 = DetalleManufacturado.builder().id(1L).cantidad(1).insumo(sal).build();
        DetalleManufacturado dPizza2 = DetalleManufacturado.builder().id(2L).cantidad(2).insumo(harina).build();
        DetalleManufacturado dPizza3 = DetalleManufacturado.builder().id(3L).cantidad(1).insumo(aceite).build();
        DetalleManufacturado dLomo1 = DetalleManufacturado.builder().id(4L).cantidad(1).insumo(sal).build();
        DetalleManufacturado dLomo2 = DetalleManufacturado.builder().id(5L).cantidad(1).insumo(aceite).build();
        DetalleManufacturado dLomo3 = DetalleManufacturado.builder().id(6L).cantidad(1).insumo(carne).build();

        // Manufacturados
        Manufacturado pizzaHawaina = new Manufacturado(1L, "Pizza Hawaina", pizzas, gr);
        pizzaHawaina.addImagen(img1);
        pizzaHawaina.addImagen(img2);
        pizzaHawaina.addImagen(img3);
        pizzaHawaina.addDetalle(dPizza1);
        pizzaHawaina.addDetalle(dPizza2);
        pizzaHawaina.addDetalle(dPizza3);

        Manufacturado lomoCompleto = new Manufacturado(2L, "Lomo Completo", lomos, gr);
        lomoCompleto.addImagen(img4);
        lomoCompleto.addImagen(img5);
        lomoCompleto.addImagen(img6);
        lomoCompleto.addDetalle(dLomo1);
        lomoCompleto.addDetalle(dLomo2);
        lomoCompleto.addDetalle(dLomo3);

        // Repo
        ManufacturadoRepository repo = new ManufacturadoRepository();
        repo.save(pizzaHawaina);
        repo.save(lomoCompleto);

        // Resultados
        System.out.println("\n-- Categorías --");
        System.out.println(pizzas);
        System.out.println(lomos);
        System.out.println(insumos);
        System.out.println(sandwich);

        System.out.println("\n-- Insumos --");
        System.out.println(sal); System.out.println(aceite); System.out.println(carne); System.out.println(harina);

        System.out.println("\n-- Manufacturados --");
        repo.findAll().forEach(System.out::println);

        System.out.println("\n-- Buscar Manufacturado por ID=1 --");
        repo.findById(1L).ifPresent(System.out::println);

        System.out.println("\n-- Actualizar Manufacturado ID=2 --");
        Manufacturado lomoEditado = new Manufacturado(2L, "Lomo Completo Especial", lomos, gr);
        repo.update(2L, lomoEditado).ifPresent(System.out::println);

        System.out.println("\n-- Eliminar Manufacturado ID=1 --");
        repo.delete(1L).ifPresent(m -> System.out.println("Eliminado: " + m.getNombre()));

        System.out.println("\n-- Listado Final --");
        repo.findAll().forEach(System.out::println);
    }
}
