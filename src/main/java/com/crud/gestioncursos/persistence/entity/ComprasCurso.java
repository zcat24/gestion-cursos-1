package com.crud.gestioncursos.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "compras_cursos")
public class ComprasCurso {

    @EmbeddedId //Este anotacion se coloca cuando la clave primaria es compuesta y esta dada por otra clase.
    private ComprasCursoPK id;

    private Integer cantidad;

    private Double total;

    private Boolean estado;

    @ManyToOne
    @MapsId("idCompra")
    @JoinColumn(name = "id_compra", referencedColumnName = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_curso", insertable = false, updatable = false)
    private  Curso curso;

    public ComprasCursoPK getId() {
        return id;
    }

    public void setId(ComprasCursoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
