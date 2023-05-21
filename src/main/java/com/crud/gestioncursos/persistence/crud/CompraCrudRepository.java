package com.crud.gestioncursos.persistence.crud;

import com.crud.gestioncursos.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {

    Optional<List<Compra>> findByIdEstudiante(String idEstudiante);
}
