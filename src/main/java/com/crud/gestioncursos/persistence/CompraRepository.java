package com.crud.gestioncursos.persistence;

import com.crud.gestioncursos.domain.Purchase;
import com.crud.gestioncursos.domain.repository.PurchaseRepository;
import com.crud.gestioncursos.persistence.crud.CompraCrudRepository;
import com.crud.gestioncursos.persistence.entity.Compra;
import com.crud.gestioncursos.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;
    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        Optional<List<Compra>> compras = compraCrudRepository
                .findByIdEstudiante(clientId);
        return compras.map(compras1 -> mapper.toPurchases(compras1));
    }

    @Override
    public Purchase save(Purchase purchase) {

        Compra compra = mapper.toCompra(purchase);
        compra.getComprasCurso()
                .forEach(comprasCurso -> comprasCurso.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
