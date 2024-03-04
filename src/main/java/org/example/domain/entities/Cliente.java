package org.example.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long totalVentas;
    private String estado;

    public Cliente() {
        this.name = "Unknown";
        this.totalVentas = 0L;
        this.estado = "activo";
    }

    public Cliente(String name, Long totalVentas, String estado){
        this.name = name;
        this.totalVentas = totalVentas;
        this.estado= estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(Long totalVentas) {
        this.totalVentas = totalVentas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalVentas=" + totalVentas +
                ", estado='" + estado + '\'' +
                '}';
    }
}
