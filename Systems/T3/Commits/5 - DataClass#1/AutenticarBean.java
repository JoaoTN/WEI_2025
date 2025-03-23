public class AutenticarBean implements Serializable {
    private String email;
    private String senha;
    private Cliente clienteLogin = null;
    private Empresa empresaLogin = null;

    public AutenticarBean() {
        clienteLogin = new Cliente();
        empresaLogin = new Empresa();
    }

    

    public boolean autenticarUsuario() {
       
    }

    public void limparCredenciais() {
       
    }

    
}
