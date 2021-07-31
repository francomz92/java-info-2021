package com.mapeoClases.ejercicioSiete.entity;

import javax.persistence.*;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String prepTime;
    private String cookTime;
    private String serving;
    private  Ingredient ingredient;
    private Note note;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    private Category category;
}
