
package model;

import control.Funcionario;
import java.util.ArrayList;
import view.FuncionarioView;
import static view.FuncionarioView.Modelo;


public class FuncionarioWrite {
    
         public static ArrayList<Funcionario> cadastros = new ArrayList<>();
         public static Funcionario cadastro = new Funcionario(null);

             public static void salvar() {      
               atualizarDadosFuncionario();
               atualizarModelo();
            }
            
            public static void atualizarDadosFuncionario(){      
               Funcionario funcionario = FuncionarioWrite.cadastros.get(FuncionarioView.index);
               String[] dadosFuncionario = Funcionario.v;
      
               funcionario.getDadosFuncionario().setNome(dadosFuncionario[0]);
               funcionario.getDadosFuncionario().setCpf(dadosFuncionario[1]);
               funcionario.getDadosFuncionario().setEmail(dadosFuncionario[2]);
               funcionario.getDadosFuncionario().setFone(dadosFuncionario[3]);
               funcionario.getDadosFuncionario().setIdade(dadosFuncionario[4]);
               funcionario.getDadosFuncionario().setSalario(dadosFuncionario[5]);
               funcionario.getDadosFuncionario().setFonec(dadosFuncionario[6]);
               funcionario.getDadosFuncionario().setNumero(dadosFuncionario[7]);
               funcionario.getDadosFuncionario().setData(dadosFuncionario[8]);
               funcionario.getDadosFuncionario().setDepartamento(dadosFuncionario[9]);
               funcionario.getDadosFuncionario().setFuncao(dadosFuncionario[10]);
               funcionario.getDadosFuncionario().setObservacao(dadosFuncionario[11]);
               funcionario.getDadosFuncionario().setSexo(dadosFuncionario[12]);
               Funcionario.id = funcionario.getDadosFuncionario().getCpf();
 }

     private static void atualizarModelo() {
        Funcionario funcionario = FuncionarioWrite.cadastros.get(FuncionarioView.index);
        Modelo.setValueAt(funcionario, FuncionarioView.index);
    }
    
}
