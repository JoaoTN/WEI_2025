package model;


import control.Cliente;
import dao.ClienteDAO;
import view.ClienteView;
import static view.ClienteView.Modelo;
import java.util.ArrayList;

public class ClienteWrite {
   public static ArrayList<Cliente> cadastros = new ArrayList<>();
   public static Cliente cadastro = new Cliente(null);
         
   public static void salvar(){
      atualizarDadosCliente();
      atualizarModelo();
   }
            

   private static void atualizarDadosCliente() {
      Cliente cliente = ClienteWrite.cadastros.get(ClienteView.index);
      String[] dadosCliente = Cliente.v;
      
      cliente.getDadosCliente().setNome(dadosCliente[0]);
      cliente.getDadosCliente().setCpf(dadosCliente[1]);
      cliente.getDadosCliente().setFone(dadosCliente[2]);
      cliente.getDadosCliente().setIdade(dadosCliente[3]);
      cliente.getDadosCliente().setCidade(dadosCliente[4]);
      cliente.getDadosCliente().setSexo(dadosCliente[5]);
      cliente.getDadosCliente().setFonec(dadosCliente[6]);
      cliente.getDadosCliente().setEmail(dadosCliente[7]);
      cliente.getDadosCliente().setCep(dadosCliente[8]);
      cliente.getDadosCliente().setEstado(dadosCliente[9]);
      cliente.getDadosCliente().setBairro(dadosCliente[10]);
      cliente.getDadosCliente().setNumero(dadosCliente[11]);
      cliente.getDadosCliente().setRua(dadosCliente[12]);
      Cliente.id = cliente.getDadosCliente().getCpf();
}

   private static void atualizarModelo() {
      Cliente cliente = ClienteWrite.cadastros.get(ClienteView.index);
      ClienteView.Modelo.setValueAt(cliente, ClienteView.index);
}
}