
package tablemodel;

import control.Cliente;
import view.ClienteView;
import javax.swing.JOptionPane;

/**
 *
 * @author FERNANDO ROGI
 */
public class ClienteWriteTM {
    
        public static void writeTM(){
            Cliente cliente = criarCliente();

            if(cliente.getDadosCliente().getSexo() == null) {
                JOptionPane.showMessageDialog(null, "Sexo não informado");
                cliente.getDadosCliente().setSexo("NÃO INFORMADO");
            }

            ClienteView.Modelo.addFuncionario(cliente);
        }

        private static Cliente criarCliente() {
            Cliente cliente = new Cliente(null);
            
            cliente.getDadosCliente().setNome(Cliente.v[0]);
            cliente.getDadosCliente().setCpf(Cliente.v[1]);
            cliente.getDadosCliente().setFone(Cliente.v[2]);
            cliente.getDadosCliente().setIdade(Cliente.v[3]);
            cliente.getDadosCliente().setCidade(Cliente.v[4]);
            cliente.getDadosCliente().setSexo(obterSexo(Cliente.v[5]));
            cliente.getDadosCliente().setFonec(Cliente.v[6]);
            cliente.getDadosCliente().setEmail(Cliente.v[7]);
            cliente.getDadosCliente().setCep(Cliente.v[8]);
            cliente.getDadosCliente().setEstado(Cliente.v[9]);
            cliente.getDadosCliente().setBairro(Cliente.v[10]);
            cliente.getDadosCliente().setNumero(Cliente.v[11]);
            cliente.getDadosCliente().setRua(Cliente.v[12]);
        
            return cliente;
        }

    private static String obterSexo(String valor) {
        if("Masculino".equals(valor)) {
            return "Masculino";
        }else if("Feminino".equals(valor)) {
            return "Feminino";
        }else {
            return null;
        }
    }
}
