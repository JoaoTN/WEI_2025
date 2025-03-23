/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

import br.edu.ufersa.controlConsult.model.exceptions.CampoInvalidoException;
import br.edu.ufersa.controlConsult.model.exceptions.CampoLimiteStringException;
import br.edu.ufersa.controlConsult.model.exceptions.CampoObrigatorioException;
import br.edu.ufersa.controlConsult.model.interfaces.ICRUD;
import br.edu.ufersa.controlConsult.model.jpaDAO.JpaFactory;
import br.edu.ufersa.controlConsult.model.jpaDAO.MedicoJpaController;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

/**
 *
 * @author cassiano
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m")
    , @NamedQuery(name = "Medico.findById", query = "SELECT m FROM Medico m WHERE m.id = :id")})
public class Medico implements ICRUD, Serializable {

    public static List<Medico> findAll() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        MedicoJpaController instance = new MedicoJpaController(emf);
        return instance.findMedicoEntities();
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "medico")
    private Pessoa pessoa;

    @Column(name = "crm", length = 15)
    private String crm;

    @Column(name = "carga_horaria")
    private Integer cargaHoraria;

    @JoinColumn(name = "especialidade", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.REFRESH)
    //Aviso de precaução: Cascade Merge deste relacionamento está com problemas.
    private Especialidade especialidade;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "medico_horario", joinColumns = {
        @JoinColumn(name = "medico", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "horario", referencedColumnName = "id")})
    private List<HorarioAtendimento> listaHorario;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "medico")
    private Set<Consulta> listaConsultas;

    public List<Questionario> getQuestionarios() {
        return questionarios;
    }

    public void setQuestionarios(List<Questionario> questionarios) {
        this.questionarios = questionarios;
    }

    @OneToMany(mappedBy = "medico", targetEntity = Questionario.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Questionario> questionarios;

    @OneToMany(mappedBy = "medico", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @OrderBy("data_entrada DESC")
    private SortedSet<Frequencia> listFrequencia;

    public Medico(String crm, Integer cargaHoraria, Especialidade especialidade)
            throws CampoObrigatorioException, CampoLimiteStringException,
            CampoInvalidoException {
        this.setCrm(crm);
        this.setCargaHoraria(cargaHoraria);
        this.setEspecialidade(especialidade);
    }

    public Medico() {
    }

    public void setListaHorario(List<HorarioAtendimento> listaHorario) {
        this.listaHorario = listaHorario;
    }

    public List<HorarioAtendimento> getListaHorario() {
        return listaHorario;
    }

   
    private static final int LIMITE_CARGA_HORARIA = 60;

    public void setCargaHoraria(Integer cargaHoraria)
            throws CampoObrigatorioException, CampoInvalidoException {
        if (cargaHoraria > 0) {
            if (cargaHoraria <= LIMITE_CARGA_HORARIA) {
                this.cargaHoraria = cargaHoraria;
            } else {
                throw new CampoInvalidoException("Carga horária excedeu o limite de" + LIMITE_CARGA_HORARIA + "horas.");
            }
        } else {
            throw new CampoObrigatorioException("Campo Carga Horária é obrigatório");
        }
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setEspecialidade(Especialidade especialidade) throws CampoObrigatorioException {
        if (especialidade != null) {
            this.especialidade = especialidade;
        } else {
            throw new CampoObrigatorioException("Campo Especialidade é obrigatório");
        }
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public SortedSet<Frequencia> getListFrequencia() {
        return listFrequencia;
    }

    public void setListFrequencia(SortedSet<Frequencia> listFrequencia) {
        this.listFrequencia = listFrequencia;
    }

    public Set<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public void setListaConsultas(Set<Consulta> listaConsultas) {
        this.listaConsultas = listaConsultas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;

        if (!verificaEqual(this.getId(), other.getId())) {
            return false;
        }

        return true;
    }

    private boolean verificaEqual(Object id1, Object id2) {
        if (id1 == null && id2 != null) {
            return false;
        }
        if (id1 != null && !id1.equals(id2)) {
            return false;
        }
        return true;
    }
        

    @Override
    public String toString() {
        return "br.edu.ufersa.controlConsult.model.Medico[ id=" + this.getId() + " ]";
    }

    public void addListaHorario(HorarioAtendimento h) {
        if (this.listaHorario == null) {
            this.listaHorario = new ArrayList<HorarioAtendimento>();
        }
        this.listaHorario.add(h);
    }

    @Override
    public void create() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        MedicoJpaController instance = new MedicoJpaController(emf);
        instance.create(this);
    }

    @Override
    public void read() throws EntityNotFoundException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        MedicoJpaController instance = new MedicoJpaController(emf);
        try {
            instance.read(this);
        } catch (EntityNotFoundException ex) {
            Logger.getLogger(Medico.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void update() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        MedicoJpaController instance = new MedicoJpaController(emf);
        try {
            instance.edit(this);
        } catch (Exception ex) {
            Logger.getLogger(Medico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        MedicoJpaController instance = new MedicoJpaController(emf);
        try {
            instance.destroy(this.getId());
        } catch (NonexistentEntityException | IllegalArgumentException ex) {
            Logger.getLogger(Medico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) throws CampoObrigatorioException {
        if (pessoa != null) {
            this.pessoa = pessoa;
        } else {
            throw new CampoObrigatorioException("Não há pessoa asssociada a esse registro.");
        }
    }

    public String getCrm() {
        return crm;
    }

    private static final int MAX_CARACTERES_CRM = 15;

    public void setCrm(String crm) throws CampoObrigatorioException, CampoLimiteStringException {
        
        if (crm != null && !crm.isEmpty()) {
            if (crm.length() <= MAX_CARACTERES_CRM) {
                this.crm = crm;
            } else {
                throw new CampoLimiteStringException("Campo CRM excedeu o limite de caracteres.");
            }
        } else {
            throw new CampoObrigatorioException("Campo CRM é obrigatório");
        }
    }

    /**
     * Verifica se existe algum horário existente com conflito com tal horário
     * analisado.
     *
     * @param h Horário a ser analisado.
     */
    public boolean isConflitoHorarios(HorarioAtendimento h) {
        boolean res = false;
        for (HorarioAtendimento horario : listaHorario) {
            if (horario.isConflito(h)) {
                res = true;
            }
        }
        return res;
    }

}
