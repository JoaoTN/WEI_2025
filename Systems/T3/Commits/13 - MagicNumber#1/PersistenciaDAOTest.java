/*MIT License

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
package br.edu.ifpe.petpalacy.model.dao;

import br.edu.ifpe.petpalacy.model.dao.PersistenciaDAO;
import br.edu.ifpe.petpalacy.model.entidades.Cliente;
import br.edu.ifpe.petpalacy.model.entidades.Endereco;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */
public class PersistenciaDAOTest {
     private static int codigoPersiste = 0;

    private static final String CLIENTE_NOME = "ObjetoPersisteDAO";
    private static final String CLIENTE_CPF = "33333333333";
    private static final String CLIENTE_TELEFONE = "33333333333";
    private static final String CLIENTE_EMAIL = "persistedao@ifpe.com";
    private static final String CLIENTE_SENHA = "persistedao12345";
    private static final String ENDERECO_LOGRADOURO = "Av Pedro Falcao";
    private static final int ENDERECO_NUMERO = 50;
    private static final String ENDERECO_BAIRRO = "Sao Jose";
    private static final String ENDERECO_CIDADE = "Garanhuns";
    
    @BeforeClass
    public static void deveSalvarObjetoTest() {
    Cliente cliente = new Cliente();
    cliente.setNome(CLIENTE_NOME);
    cliente.setCpf(CLIENTE_CPF);
    cliente.setTelefone(CLIENTE_TELEFONE);
    cliente.setEmail(CLIENTE_EMAIL);
    cliente.setSenha(CLIENTE_SENHA);
    
    Endereco end = new Endereco();
    end.setLogradouro(ENDERECO_LOGRADOURO);
    end.setNumero(ENDERECO_NUMERO);
    end.setBairro(ENDERECO_BAIRRO);
    end.setCidade(ENDERECO_CIDADE);
    
    cliente.setEndereco(end);
    PersistenciaDAO.getInstance().salvar(cliente);
    
    String sql = "SELECT c FROM Cliente c"; 
    List<Cliente> clientes = (List<Cliente>) PersistenciaDAO.getInstance().listar(sql);
    for(Cliente lista : clientes) {
        if(CLIENTE_NOME.equals(lista.getNome())) {
            codigoPersiste = lista.getIdCliente();
        }
    }
    
    String sqlSalv = "SELECT c FROM Cliente c WHERE c.id =" + codigoPersiste;
    Cliente cli = (Cliente) PersistenciaDAO.getInstance().listar(sqlSalv).get(0);
    assertEquals(CLIENTE_NOME, cli.getNome());
}

    
    @Test
    //@Ignore
    public void deveListarObjtosTest() {
        String sql = "SELECT c FROM Cliente c"; 
        List<Cliente> clientes = (List<Cliente>) PersistenciaDAO.getInstance().listar(sql);
        boolean listou = clientes.size()>0;
        assertEquals(true, listou);
    }
    
    @Test
    //@Ignore
    public void deveEditarObjetoTest() {
        Cliente cliente = null;
        
        String sql = "SELECT c FROM Cliente c";
        List<Cliente> clientes = (List<Cliente>) PersistenciaDAO.getInstance().listar(sql);
        for(Cliente lista : clientes) {
            if("ObjetoPersisteDAO".equals(lista.getNome())) {
                cliente = lista;
                cliente.setNome("ObjetoPersisteDAOEdit");
                cliente.setCpf("22222222222");
                cliente.setTelefone("333333333");
                cliente.setEmail("edit@ifpe.com");
                cliente.setSenha("edit121212");

                Endereco endereco = new Endereco();
                endereco.setLogradouro("AV Frei Caneca 112");
                endereco.setBairro("Heliopolis");
                endereco.setCidade("Garanhuns");

                cliente.setEndereco(endereco);
                break;
            }
        }
        
        PersistenciaDAO.getInstance().editar(cliente);
        
        String sqlEdit = "SELECT c FROM Cliente c WHERE c.id ="+codigoPersiste;
        Cliente cli = (Cliente) PersistenciaDAO.getInstance().listar(sqlEdit).get(0);
        assertEquals("ObjetoPersisteDAOEdit", cli.getNome());
    }
    
    @Test
    //@Ignore
    public void deveAutenticarObjetoTest() {
        String sql = "SELECT a FROM Cliente a", email = "edit@ifpe.com", senha = "edit121212";
        Cliente cliente  = (Cliente) PersistenciaDAO.getInstance().autenticar(sql, email, senha);
        
        assertEquals("edit@ifpe.com", cliente.getEmail());
    }
    
    @AfterClass
    //@Ignore
    public static void deveDeletarObjetoTest() {
        String sql = "SELECT c FROM Cliente c WHERE c.id ="+codigoPersiste;
        Cliente cliente = (Cliente) PersistenciaDAO.getInstance().listar(sql).get(0);
        PersistenciaDAO.getInstance().deletar(cliente);
    }
    
}
