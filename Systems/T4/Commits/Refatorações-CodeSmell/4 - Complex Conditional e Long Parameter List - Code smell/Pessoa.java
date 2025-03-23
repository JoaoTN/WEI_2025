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
import br.edu.ufersa.controlConsult.model.jpaDAO.PessoaJpaController;
import br.edu.ufersa.controlConsult.model.jpaDAO.PessoaJpaController.tipoPesquisaEnum;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.NonexistentEntityException;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.PreexistingEntityException;
import br.edu.ufersa.controlConsult.model.validacao.Cpf_Util;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.transaction.NotSupportedException;

/**
 *
 * @author leone
 */
@Entity
@Table(name = "pessoa")
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT m FROM Pessoa m")
    , @NamedQuery(name = "Pessoa.findById", query = "SELECT m FROM Pessoa m WHERE m.id = :id")
    , @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE lower(p.nome) LIKE lower(:nome)")
    , @NamedQuery(name = "Pessoa.findMedicosByNome", query = "SELECT m FROM Pessoa m WHERE lower(m.nome) LIKE lower(:nome) AND m.medico!=null")
    , @NamedQuery(name = "Pessoa.findPacientesByNome", query = "SELECT p FROM Pessoa p WHERE lower(p.nome) LIKE lower(:nome) AND p.paciente!=null")
    , @NamedQuery(name = "Pessoa.findByCPF", query = "SELECT m FROM Pessoa m WHERE m.cpf = :cpf")
    , @NamedQuery(name = "Pessoa.medico", query = "SELECT m FROM Pessoa m WHERE m.medico!=null")
    , @NamedQuery(name = "Pessoa.paciente", query = "SELECT p FROM Pessoa p WHERE p.paciente!=null")})
public class Pessoa implements Serializable, ICRUD {

    public static enum TipoPessoaEnum {
        AMBOS, PACIENTE, MEDICO;
    }

    public static List<Pessoa> findAll() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        PessoaJpaController instance = new PessoaJpaController(emf);
        return instance.findPessoaEntities();
    }

    public static List<Pessoa> findMedicosByNome(String nome) {
        EntityManagerFactory emf = JpaFactory.getInstance();
        PessoaJpaController instance = new PessoaJpaController(emf);
        return instance.findByNome(tipoPesquisaEnum.MEDICO, nome);
    }

    public static List<Pessoa> findPacientesByNome(String nome) {
        EntityManagerFactory emf = JpaFactory.getInstance();
        PessoaJpaController instance = new PessoaJpaController(emf);
        return instance.findByNome(tipoPesquisaEnum.PACIENTE, nome);
    }

    /**
     * Pesquisa no banco de dados a primeira entidade Médico com o CPF.
     *
     * @param cpf Cadastro de Pessoa Física.
     * @return O médico com portar o cpf.
     */
    public static Pessoa findByCPF(String cpf) throws NoResultException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        PessoaJpaController instance = new PessoaJpaController(emf);
        return instance.findByCPF(cpf);
    }

    public static List<Pessoa> findByNome(String nome) throws NoResultException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        PessoaJpaController instance = new PessoaJpaController(emf);
        return instance.findByNome(tipoPesquisaEnum.ALL, nome);
    }

    public static List<Pessoa> findMedicos() throws NoResultException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        PessoaJpaController instance = new PessoaJpaController(emf);
        return instance.findMedicos();
    }

    public static List<Pessoa> findPacientes() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        PessoaJpaController instance = new PessoaJpaController(emf);
        return instance.findPacientes();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome", length = 150)
    private String nome;
    @Column(name = "data_de_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataDeNascimento;
    @Column(name = "sexo")
    private Character sexo;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "bairro", length = 50)
    private String bairro;
    @Column(name = "num_casa")
    private Integer numCasa;
    @Column(name = "logradouro", length = 50)
    private String logradouro;
    @Column(name = "cep", length = 15)
    private String cep;
    @Column(name = "telefone", length = 15)
    private String telefone;
    @Basic(optional = false)
    @Column(name = "cpf", unique = true, length = 20)
    private String cpf;
    @Column(name = "rg", unique = true, length = 20)
    private String rg;
    @Column(name = "estado", length = 50)
    private String estado;
    @Column(name = "cidade", length = 50)
    private String cidade;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "medico")
    private Medico medico;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "paciente")
    private Paciente paciente;

    /**
     * O tipo de pessoa que o formulário da janela irá processar.
     */
    protected Pessoa() {
    }

    /**
     * Construtor completo
     *
     * @throws IllegalArgumentException se algum atributo for inválido.
     */

    
    public Pessoa( Builder builder ) {
        this.id = builder.id;
        this.nome = builder.nome;
        this.dataDeNascimento = builder.dataDeNascimento;
        this.sexo = builder.sexo;
        this.email = builder.email;
        this.bairro = builder.bairro;
        this.numCasa = builder.numCasa;
        this.logradouro = builder.logradouro;
        this.cep = builder.cep;
        this.telefone = builder.telefone;
        this.cpf = builder.cpf;
        this.rg = builder.rg;
        this.estado = builder.estado;
        this.cidade = builder.cidade;
        this.medico = builder.medico;
        this.paciente = builder.paciente;

    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
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
    
    public static class Builder {
        private Integer id;
        private String nome;
        private Date dataDeNascimento;
        private Character sexo;
        private String email;
        private String bairro;
        private Integer numCasa;
        private String logradouro;
        private String cep;
        private String telefone;
        private String cpf;
        private String rg;
        private String estado;
        private String cidade;
        private Medico medico;
        private Paciente paciente;

        public Builder(String nome) {
            this.nome = nome;
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder dataDeNascimento(Date dataDeNascimento) {
            this.dataDeNascimento = dataDeNascimento;
            return this;
        }

        public Builder sexo(Character sexo) {
            this.sexo = sexo;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder bairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public Builder numCasa(Integer numCasa) {
            this.numCasa = numCasa;
            return this;
        }

        public Builder logradouro(String logradouro) {
            this.logradouro = logradouro;
            return this;
        }

        public Builder cep(String cep) {
            this.cep = cep;
            return this;
        }

        public Builder telefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder rg(String rg) {
            this.rg = rg;
            return this;
        }

        public Builder estado(String estado) {
            this.estado = estado;
            return this;
        }

        public Builder cidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public Builder medico(Medico medico) {
            this.medico = medico;
            return this;
        }

        public Builder paciente(Paciente paciente) {
            this.paciente = paciente;
            return this;
        }

        public Pessoa build() {
            return new Pessoa(this);
        }
    }


    @Override
    public void create() throws PreexistingEntityException, Exception {
        if (Pessoa.findByCPF(this.getCpf()) != null) {
            throw new PreexistingEntityException("CPF já registrado.");
        }
        EntityManagerFactory emf = JpaFactory.getInstance();
        PessoaJpaController instance = new PessoaJpaController(emf);
        try {
            instance.create(this);
        } catch (Exception ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void read() throws NotSupportedException {
        throw new NotSupportedException("Not supported operation.");
//        EntityManagerFactory emf = JpaFactory.getInstance();
//        PessoaJpaController instance = new PessoaJpaController(emf);
//        try {
//            instance.read(this);
//        } catch (EntityNotFoundException ex) {
//            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
//            throw ex;
//        }
    }

    @Override
    public void update() throws PreexistingEntityException, Exception {
        EntityManagerFactory emf = JpaFactory.getInstance();
        Pessoa duplicate = Pessoa.findByCPF(this.getCpf());
        if (duplicate != null) {
            if (!duplicate.getId().equals(this.getId())) {
                throw new PreexistingEntityException("CPF já está registrado para outra pessoa.");
            }
        }
        PessoaJpaController instance = new PessoaJpaController(emf);
        try {
            instance.edit(this);
        } catch (Exception ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public void delete() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        PessoaJpaController instance = new PessoaJpaController(emf);
        try {
            instance.destroy(this.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
