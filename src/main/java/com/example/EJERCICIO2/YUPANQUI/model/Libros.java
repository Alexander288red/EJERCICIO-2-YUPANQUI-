/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EJERCICIO2.YUPANQUI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int anioPublicacion; // Corregido para usar 'anioPublicacion'
    private String autor;

    // Constructor vacío (opcional, pero recomendado para JPA)
    public Libros() {
    }

    // Constructor con parámetros (opcional, para facilidad de uso)
    public Libros(String nombre, int anioPublicacion, String autor) {
        this.nombre = nombre;
        this.anioPublicacion = anioPublicacion; // Corregido para usar 'anioPublicacion'
        this.autor = autor;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioPublicacion() { // Corregido para usar 'anioPublicacion'
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) { // Corregido para usar 'anioPublicacion'
        this.anioPublicacion = anioPublicacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Sobrescribir el método toString (opcional)
    @Override
    public String toString() {
        return "Libros{id=" + id + ", nombre='" + nombre + "', anioPublicacion=" + anioPublicacion + ", autor='" + autor + "'}";
    }

    // Sobrescribir el método equals (opcional)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libros libros = (Libros) o;
        return id != null && id.equals(libros.id);
    }

    // Sobrescribir el método hashCode (opcional)
    @Override
    public int hashCode() {
        return 31 + (id != null ? id.hashCode() : 0);
    }
}