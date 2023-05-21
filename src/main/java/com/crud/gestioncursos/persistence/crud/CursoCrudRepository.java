package com.crud.gestioncursos.persistence.crud;

import com.crud.gestioncursos.persistence.entity.Curso;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CursoCrudRepository extends CrudRepository<Curso, Integer> {


    List<Curso> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Curso>> findByCantidadCuposLessThanAndEstado(int cantidadCupos, boolean estado);
}
