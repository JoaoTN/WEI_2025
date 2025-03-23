/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

import br.edu.ufersa.controlConsult.model.interfaces.ICRUD;
import br.edu.ufersa.controlConsult.model.jpaDAO.JpaFactory;
import br.edu.ufersa.controlConsult.model.jpaDAO.UsuarioJpaController;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.NonexistentEntityException;
import br.edu.ufersa.controlConsult.model.validacao.Criptografia;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id")
    , @NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username = :username")
    , @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")
    , @NamedQuery(name = "Usuario.login", query = "SELECT u FROM Usuario u WHERE u.username = :username and u.password = :password")})
public class Usuario implements Serializable, ICRUD {

    public static List<Usuario> findAll() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        UsuarioJpaController instance = new UsuarioJpaController(emf);
        return instance.findUsuarioEntities();
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username", length = 15, unique = true)
    private String username;
    @Column(name = "password", length = 32)
    private char[] password;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(String username, char[] password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.toLowerCase();
    }

    public char[] getPassword() {
        return password;
    }

    public static Usuario pega_Banco(Usuario usuario) {
        EntityManagerFactory emf = JpaFactory.getInstance();
        UsuarioJpaController instance = new UsuarioJpaController(emf);
        return instance.pegar_Banco(usuario);
    }

    private static final int MAX_PASSWORD_LENGTH = 32;
    
    public void setPassword(char[] password_raw) throws IllegalArgumentException {
        char[] password_hash = Criptografia.criptografar(password_raw);
        int password_length = password_hash.length;
        if (password_length > MAX_PASSWORD_LENGTH) {
            throw new IllegalArgumentException("Senha maior que 32 caracteres.");
        }
        this.password = password_hash;
    }

    public Usuario login() throws IllegalAccessException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        UsuarioJpaController instance = new UsuarioJpaController(emf);
        return instance.login(this);
//        Query query = session.createSQLQuery("select * from administrador where user = ? and senha = ?").addEntity(Usuario.class);
//        query.setString(0, this.username);
//        query.setString(1, this.password);
    }

    public void registraEntrada(String medico, Date horario) {

    }

    public void registraSaida(String medico, Date horario) {

    }

    public void agendaConsulta(String paciente, Date horarioAtendimento, Date data) {

    }

    public void iniciaAtendimento(Date horarioAtendimento) {

    }

    public void proximoAtendimento(Date horarioAtendimento) {

    }

    public void finalizaAtendimento(Date horarioAtendimento) {

    }

    public void verificaAtendimento(String medico) {

    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ufersa.controlConsult.model.jpaDAO.Usuario[ id=" + id + " ]";
    }

    @Override
    public void create() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        UsuarioJpaController instance = new UsuarioJpaController(emf);
        instance.create(this);
    }

    @Override
    public void read() throws NonexistentEntityException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        UsuarioJpaController instance = new UsuarioJpaController(emf);
        try {
            instance.read(this);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void update() throws NonexistentEntityException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        UsuarioJpaController instance = new UsuarioJpaController(emf);
        try {
            instance.edit(this);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete() throws NonexistentEntityException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        UsuarioJpaController instance = new UsuarioJpaController(emf);
        try {
            instance.destroy(this.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

}
