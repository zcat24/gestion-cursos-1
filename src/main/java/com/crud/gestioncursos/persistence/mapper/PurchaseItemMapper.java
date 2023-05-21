package com.crud.gestioncursos.persistence.mapper;

import com.crud.gestioncursos.domain.Purchase;
import com.crud.gestioncursos.domain.PurchaseItem;
import com.crud.gestioncursos.persistence.entity.ComprasCurso;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {CourseMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idCurso", target = "courseId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active"),
    })
    PurchaseItem toPurchaseItem(ComprasCurso curso);


    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "curso", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true),
    })
    ComprasCurso toComprasCurso(PurchaseItem item);


}
