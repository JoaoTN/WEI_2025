/*
MIT License

Copyright (c) 2018 Daniel da Silva Calado, Izaquiel Cavalcante da Silva, 
                   Kaio Cesar Bezerra da Silva e Wemerson Diogenes da Silva

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package br.edu.ifpe.petpalacy.model.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import br.edu.ifpe.petpalacy.model.entidades.Horarios;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.hibernate.mapping.ManyToOne;

/**
 *
 * @author Wemerson Diogenes da Silva <wemersondiogenes16@gmail.com>
 */
@Entity
public class Servico implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne
    private Empresa empresa;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Horarios> listaDeHorarios;
    @OneToOne
    private ServicoInfo servicoInfo;

    public Servico() {
        listaDeHorarios = new ArrayList<>();
        servicoInfo = new ServicoInfo();
    }

    public Servico(String nome, Integer duracao, BigDecimal valor, Empresa empresa, List<Horarios> listaDeHorarios) {
        this();
        servicoInfo.setNome(nome);
        servicoInfo.setDuracao(duracao);
        servicoInfo.setValor(valor);
        this.empresa = empresa;
        this.listaDeHorarios = listaDeHorarios;
    }

    public void inserirHorario(Horarios hora) {
        listaDeHorarios.add(hora);
    }

    public void deletarHorario(Horarios hora) {
        listaDeHorarios.remove(hora);
    }

    public Integer getIdServico() {
        return id;
    }

    public void setIdServico(Integer id) {
        this.id = id;
    }

    public ServicoInfo getServicoInfo() {
        return servicoInfo;
    }

    public void setServicoInfo(ServicoInfo servicoInfo) {
        this.servicoInfo = servicoInfo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Horarios> getListaDeHorarios() {
        return listaDeHorarios;
    }

    public void setListaDeHorarios(List<Horarios> listaDeHorarios) {
        this.listaDeHorarios = listaDeHorarios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        // Implementação do equals omitida para brevidade
    }

    @Override
    public String toString() {
        // Implementação do toString omitida para brevidade
    }
}
