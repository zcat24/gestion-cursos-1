package com.crud.gestioncursos.persistence;

import com.crud.gestioncursos.domain.Course;
import com.crud.gestioncursos.domain.repository.CourseRepository;
import com.crud.gestioncursos.persistence.crud.CursoCrudRepository;
import com.crud.gestioncursos.persistence.entity.Curso;
import com.crud.gestioncursos.persistence.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CursoRepository  implements CourseRepository {

    @Autowired
    private CursoCrudRepository cursoCrudRepository;
    @Autowired
    private CourseMapper mapper;

    @Override
    public List<Course> getAll() {

        List<Curso> cursos = (List<Curso>) cursoCrudRepository.findAll();
        return mapper.toCourses(cursos) ;
    }

    @Override
    public Optional<List<Course>> getByCategory(int categoryId) {

        List<Curso> cursos = cursoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toCourses(cursos));
    }

    @Override
    public Optional<List<Course>> getScarseCourse(int quantity) {

        Optional<List<Curso>> cursos = cursoCrudRepository.findByCantidadCuposLessThanAndEstado(quantity, true);
        return cursos.map(cursos1 -> mapper.toCourses(cursos1));
    }

    @Override
    public Optional<Course> getCourse(int courseId) {

        return cursoCrudRepository.findById(courseId).map(curso -> mapper.toCourse(curso));
    }

    @Override
    public Course save(Course course) {
        Curso curso = mapper.toCurso(course);
        return mapper.toCourse(cursoCrudRepository.save(curso));
    }

    @Override
    public void delete(int courseId) {

        cursoCrudRepository.deleteById(courseId);
    }
}
