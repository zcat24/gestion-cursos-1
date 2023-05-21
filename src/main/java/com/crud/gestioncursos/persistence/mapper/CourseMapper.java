package com.crud.gestioncursos.persistence.mapper;

import com.crud.gestioncursos.domain.Course;
import com.crud.gestioncursos.persistence.entity.Curso;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface CourseMapper {

    @Mappings({
            @Mapping(source = "idCurso", target = "courseId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precio", target = "price"),
            @Mapping(source = "cantidadCupos", target = "capacityCourse"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category"),

    })
    Course toCourse(Curso curso);
    List<Course> toCourses(List<Curso> cursos);

    @InheritInverseConfiguration
    @Mapping(target = "alfanumerico", ignore = true)
    Curso toCurso(Course course);
}
