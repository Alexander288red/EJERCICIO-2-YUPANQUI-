/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EJERCICIO2.YUPANQUI.controller;

import com.example.EJERCICIO2.YUPANQUI.Repository.LibrosRepository;
import com.example.EJERCICIO2.YUPANQUI.model.Libros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LibrosController {

    @Autowired
    private LibrosRepository librosRepository;

    // Mostrar lista de libros
    @GetMapping("/listarLibros")
    public String listarLibros(Model model) {
        List<Libros> libros = librosRepository.findAll();
        model.addAttribute("libros", libros);
        return "listar_libros"; // Vista para listar los libros
    }

    // Mostrar formulario para editar un libro
    @GetMapping("/editarLibro/{id}")
    public String editarLibro(@PathVariable("id") Long id, Model model) {
        Libros libro = librosRepository.findById(id).orElse(null);
        if (libro != null) {
            model.addAttribute("libro", libro);
            return "formulario_libros"; // Vista para editar libro
        }
        return "redirect:/listarLibros"; // Redirigir si el libro no existe
    }

    // Mostrar formulario para agregar un nuevo libro
    @GetMapping("/agregarLibro")
    public String agregarLibro(Model model) {
        model.addAttribute("libro", new Libros()); // Crear un objeto vacío de libro
        return "formulario_libros"; // Vista para agregar libro
    }

    // Procesar el formulario para crear o actualizar un libro
    @PostMapping("/guardarLibro")
    public String guardarLibro(@ModelAttribute Libros libro) {
        librosRepository.save(libro); // Guardar o actualizar el libro
        return "redirect:/listarLibros"; // Redirigir a la lista de libros
    }

    // Eliminar un libro
    @GetMapping("/eliminarLibro/{id}")
    public String eliminarLibro(@PathVariable("id") Long id) {
        if (librosRepository.existsById(id)) { // Verificar si el libro existe antes de eliminar
            librosRepository.deleteById(id); // Eliminar el libro
        }
        return "redirect:/listarLibros"; // Redirigir a la lista de libros
    }
}