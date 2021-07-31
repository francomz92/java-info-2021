package com.mapeoClases.ejercicioSiete.entity;

import javax.persistence.*;

@Entity
public class UnitOfMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String unitOfMeasure;
    @OneToOne
    private Ingredient ingredient;
}
