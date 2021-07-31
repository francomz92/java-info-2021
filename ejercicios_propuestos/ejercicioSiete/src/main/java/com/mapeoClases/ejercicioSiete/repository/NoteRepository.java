package com.mapeoClases.ejercicioSiete.repository;

import com.mapeoClases.ejercicioSiete.entity.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
}
