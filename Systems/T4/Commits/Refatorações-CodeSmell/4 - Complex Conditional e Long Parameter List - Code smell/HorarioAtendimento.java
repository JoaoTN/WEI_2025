/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

import br.edu.ufersa.controlConsult.model.interfaces.ICRUD;
import br.edu.ufersa.controlConsult.model.jpaDAO.HorarioAtendimentoJpaController;
import br.edu.ufersa.controlConsult.model.jpaDAO.JpaFactory;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author cassiano
 */
@Entity
@Table(name = "horario_atendimento")
@NamedQueries({
    @NamedQuery(name = "HorarioAtendimento.findByWeek", query = "SELECT m FROM HorarioAtendimento m WHERE m.diaSemana = :diaSemana")})
public class HorarioAtendimento implements Serializable, ICRUD {

    public static List<HorarioAtendimento> findAll() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        HorarioAtendimentoJpaController instance = new HorarioAtendimentoJpaController(emf);
        List<HorarioAtendimento> res_horarios = instance.findHorarioAtendimentoEntities();
        return res_horarios;
    }

    /**
     * Pesquisa pelo dia da semana.
     */
    public static List<HorarioAtendimento> findByDay(DiaSemanaEnum dia) {
        List<HorarioAtendimento> horarios = findAll();
        List<HorarioAtendimento> horarios_res = new ArrayList<>();
        for (HorarioAtendimento h : horarios) {
            if (h.getDiaSemana().equals(dia)) {
                horarios_res.add(h);
            }
        }
        return horarios_res;
    }

    /**
     * Verifica se há algum conflito de horários.
     */
    public boolean isConflito(HorarioAtendimento h) {
        if (this.getDiaSemana().equals(h.getDiaSemana())) {
            if (h.getFim().after(this.getInicio())
                    && this.getFim().after(h.getInicio())) {
                return true;
            }
        }
        return false;
    }

    public enum DiaSemanaEnum {
        SEGUNDA("Segunda-feira"), TERCA("Terça-feira"), QUARTA("Quarta-feira"),
        QUINTA("Quinta-feira"), SEXTA("Sexta-feira"), SABADO("Sábado"), DOMINGO("Domingo");
        String nome;

        private DiaSemanaEnum(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return this.nome;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "inicio")
    @Temporal(TemporalType.TIME)
    private Date inicio;
    @Basic(optional = false)
    @Column(name = "fim")
    @Temporal(TemporalType.TIME)
    private Date fim;
    @ManyToMany(mappedBy = "listaHorario", fetch = FetchType.EAGER)
    private List<Medico> medicoList;
    @Enumerated(EnumType.STRING)
    private DiaSemanaEnum diaSemana;

    private int estado; //TODO
    private Date ultimaRealizacao; // TODO

    public HorarioAtendimento() {
    }

    public HorarioAtendimento(Time inicio, Time fim,
            int estado, DiaSemanaEnum diaSemana) {
        this.setId(id);
        this.setInicio(inicio);
        this.setFim(fim);
        this.setEstado(estado);
        this.setUltimaRealizacao(ultimaRealizacao);
        this.setDiaSemana(diaSemana);
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setUltimaRealizacao(Date ultimaRealizacao) {
        this.ultimaRealizacao = ultimaRealizacao;
    }

    public Date getUltimaRealizacao() {
        return ultimaRealizacao;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inicio: ").append(this.getInicio()).append("\n");
        sb.append("Fim: ").append(this.getFim()).append("\n");
        sb.append("Estado: ").append(this.getEstado()).append("\n");
        sb.append("Ultima realização: ").append(this.getUltimaRealizacao()).append("\n");
        sb.append("Dia da semana: ").append(this.getDiaSemana()).append("\n");
        return sb.toString();
    }

    public HorarioAtendimento(Integer id) {
        this.id = id;
    }

    public HorarioAtendimento(Integer id, Date inicio, Date fim) {
        this.id = id;
        this.setInicio(inicio);
        this.setFim(fim);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public Date getFim() {
        return fim;
    }

    public DiaSemanaEnum getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemanaEnum diaSemana) {
        this.diaSemana = diaSemana;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof HorarioAtendimento)) {
            return false;
        }
        HorarioAtendimento other = (HorarioAtendimento) object;
        return Objects.equals(this.id, other.id);
    }

    public static List<HorarioAtendimento> findByMedicoId(Integer id) {
        //        Session session = horarioAtendimentoCRUD.sf.openSession();
        //        Query query = session.createSQLQuery("select * from horario_atendimento AS h where h.medico_id = ?").addEntity(HorarioAtendimento.class);
        //        query.setInteger(0, id);
        //        List<HorarioAtendimento> list = (List<HorarioAtendimento>) query.list();
        //        session.close();
        //        return list;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        HorarioAtendimentoJpaController instance = new HorarioAtendimentoJpaController(emf);
        instance.create(this);
    }

    @Override
    public void read() throws NonexistentEntityException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        HorarioAtendimentoJpaController instance = new HorarioAtendimentoJpaController(emf);
        try {
            instance.read(this);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(HorarioAtendimento.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void update() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        HorarioAtendimentoJpaController instance = new HorarioAtendimentoJpaController(emf);
        try {
            instance.edit(this);
        } catch (Exception ex) {
            Logger.getLogger(HorarioAtendimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        HorarioAtendimentoJpaController instance = new HorarioAtendimentoJpaController(emf);
        try {
            instance.destroy(this.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(HorarioAtendimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
