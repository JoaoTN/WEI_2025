package br.edu.ifpe.petpalacy.model.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Agendamento implements Serializable {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Servico servico;
    
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}) 
    private Cliente cliente;
    
    private String data;
    private String hora;
    
    @Enumerated(EnumType.ORDINAL)
    private StatusAgen statusAgen;

    public Agendamento() {
    }

    public Agendamento(Servico servico, Cliente cliente, String data, String hora, StatusAgen statusAgen) {
        this.servico = servico;
        this.cliente = cliente;
        this.data = data;
        this.hora = hora;
        this.statusAgen = statusAgen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public StatusAgen getStatusAgen() {
        return statusAgen;
    }

    public void setStatusAgen(StatusAgen statusAgen) {
        this.statusAgen = statusAgen;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agendamento other = (Agendamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Agendamento{" + "id=" + id + ", servico=" + servico + ", cliente=" + cliente + ", data=" + data + ", hora=" + hora + ", statusAgen=" + statusAgen + '}';
    }
}
