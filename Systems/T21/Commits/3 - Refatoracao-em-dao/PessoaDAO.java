package br.sistema.crud.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.sistema.crud.jdbc.ConexaoUtil;
import br.sistema.crud.jdbc.dto.EnderecoDTO;
import br.sistema.crud.jdbc.dto.PessoaDTO;
import br.sistema.crud.jdbc.dto.UfDTO;
import br.sistema.crud.jdbc.exception.PersistenciaExcpetion;

public class PessoaDAO {
    private static final String TB_PESSOA = "pessoa";
    private static final String TB_ENDERECO = "endereco";

    public void inserir(Pessoa pessoa) {
        inserirPessoa(pessoa);
        inserirEndereco(pessoa.getEndereco());
    }

    private void inserirPessoa(Pessoa pessoa) {
        // Lógica para inserir pessoa na tabela TB_PESSOA
    }

    private void inserirEndereco(Endereco endereco) {
        // Lógica para inserir endereço na tabela TB_ENDERECO
    }

    public void atualizar(Pessoa pessoa) {
        atualizarPessoa(pessoa);
        atualizarEndereco(pessoa.getEndereco());
    }

    private void atualizarPessoa(Pessoa pessoa) {
        // Lógica para atualizar pessoa na tabela TB_PESSOA
    }

    private void atualizarEndereco(Endereco endereco) {
        // Lógica para atualizar endereço na tabela TB_ENDERECO
    }

    public void deletar(Pessoa pessoa) {
        deletarEndereco(pessoa.getEndereco());
        deletarPessoa(pessoa);
    }

    private void deletarEndereco(Endereco endereco) {
        // Lógica para deletar endereço da tabela TB_ENDERECO
    }

    private void deletarPessoa(Pessoa pessoa) {
        // Lógica para deletar pessoa da tabela TB_PESSOA
    }

    public List<Pessoa> listarTodos() {
        List<Pessoa> pessoas = buscarTodasPessoas();
        for (Pessoa pessoa : pessoas) {
            Endereco endereco = buscaEnderecoPorId(pessoa.getEndereco().getId());
            pessoa.setEndereco(endereco);
        }
        return pessoas;
    }

    private List<Pessoa> buscarTodasPessoas() {
        // Lógica para buscar todas as pessoas da tabela TB_PESSOA
    }

    private Endereco buscaEnderecoPorId(int id) {
        // Lógica para buscar endereço por ID na tabela TB_ENDERECO
    }

    public List<Pessoa> filtraPessoa(String filtro) {
        List<Pessoa> pessoas = filtrarPessoas(filtro);
        for (Pessoa pessoa : pessoas) {
            UF uf = buscaUFPorId(pessoa.getEndereco().getUf().getId());
            pessoa.getEndereco().setUf(uf);
        }
        return pessoas;
    }

    private List<Pessoa> filtrarPessoas(String filtro) {
        // Lógica para filtrar pessoas da tabela TB_PESSOA com base no filtro
    }

    private UF buscaUFPorId(int id) {
        // Lógica para buscar UF por ID na tabela de UF
    }
}
