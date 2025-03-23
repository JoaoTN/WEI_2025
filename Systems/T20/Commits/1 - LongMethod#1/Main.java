package sgab.controller;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sgab.model.dto.Biblioteca;
import sgab.model.dto.Exemplar;
import sgab.model.dto.util.ExemplarStatus;
import sgab.model.dto.Obra;
import sgab.model.service.GestaoAcervo;
import sgab.model.service.GestaoBibliotecaService;
import sgab.model.service.GestaoObras;

@WebServlet(name = "Main", urlPatterns = {"/main"})
public class Main extends HttpServlet {   
    private String jsp = "";
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter("acao");
        jsp = executarAcao(acao, request);
        //Redirecionando pagina
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }

    private String executarAcao(String acao, HttpServletRequest request) {
        switch (acao) {
            case "Logar":
                return LoginController.logar(request);
                break;
            case "AssuntoListar":
                return AssuntoController.listar(request);
                break;
            case "AssuntoAlterar":
                return AssuntoController.alterar(request);
                break;
            case "AssuntoGravarAlteracao":
                return AssuntoController.gravarAlteracao(request);
                break;
            case "AssuntoGravarInsercao":
                return AssuntoController.gravarInsercao(request);
                break;
            case "AssuntoExcluir":
                return AssuntoController.excluir(request);
                break;
            case "ObraListar":
                return ObraController.listar(request);
                break;
            case "ObraPesquisar":
                return ObraController.pesquisar(request);
                break;
            case "ObraGravarInsercao":
                return ObraController.gravarInsercao(request);
                break;
            case "ObraAlterar":
                return ObraController.alterar(request);
                break;
            case "ObraGravarAlteracao":
                return ObraController.gravarAlteracao(request);
                break;
            case "ObraExcluir":
                return ObraController.excluir(request);
                break;
            case "PessoaPesquisar":
                return PessoaController.pesquisarLogin(request);
                break;
            case "PessoaListar":
                return PessoaController.listar(request);
                break;
            case "PessoaAlterar":
                return PessoaController.alterar(request);
                break;
            case "PessoaGravarAlteracao":
                return PessoaController.gravarAlteracao(request);
                break;
            case "PessoaGravarInsercao":
                return PessoaController.gravarInsercao(request);
                break;
            case "PessoaExcluir":
                return PessoaController.excluir(request);
            case "UnidadeOrganizacionalListar":
                return UnidadeOrganizacionalController.listar(request);
                break;
            case "UnidadeOrganizacionalAlterar":
                return UnidadeOrganizacionalController.alterar(request);
                break;
            case "UnidadeOrganizacionalGravarAlteracao":
                return UnidadeOrganizacionalController.gravarAlteracao(request);
                break;
            case "UnidadeOrganizacionalGravarInsercao":
                return UnidadeOrganizacionalController.gravarInsercao(request);
                break;
            case "UnidadeOrganizacionalExcluir":
                return UnidadeOrganizacionalController.excluir(request);
                break;
            case "AdministradorGravarInsercao":
                return AdministradorController.gravarInsercaoAdministrador(request);
                break;
            case "AdministradorGravarAlteracao":
                return AdministradorController.alterarAdministrador(request);
                break;
            case "AdministradorPesquisar":
                return AdministradorController.pesquisarAdministradorLogin(request);
                break;
            case "AdministradorListar":
                return AdministradorController.listarAdministradores(request);
                break;
            case "AdministradorAlterar":
                return AdministradorController.alterarAdministrador(request);
                break;
            case "GestorGravarInsercao":
                return AdministradorController.gravarInsercaoGestor(request);
                break;
            case "GestorGravarAlteracao":
                return AdministradorController.alterarGestor(request);
                break;
            case "GestorPesquisar":
                return AdministradorController.pesquisarGestorLogin(request);
                break;
            case "GestorListar":
                return AdministradorController.listarGestores(request);
                break;
            case "GestorAlterar":
                return AdministradorController.alterarGestor(request);
                break;
            case "AutorCadastrar":
                return AutorController.insercao(request);
                break;
            case "AutorAlterar":
                return AutorController.alterar(request);
                break;
            case "AutorPesquisar":
                return AutorController.pesquisar(request);
                break;
            case "AutorExcluir":
                return AutorController.excluir(request);
                break;
            case "FornecedorListar":
                return FornecedorController.listar(request);
                break;
            case "FornecedorAlterar":
                return FornecedorController.alterar(request);
                break;
            case "FornecedorGravarAlteracao":
                return FornecedorController.gravarAlteracao(request);
                break;
            case "FornecedorGravarInsercao":
                return FornecedorController.gravarInsercao(request);
                break;
            case "FornecedorExcluir":
                return FornecedorController.excluir(request);
                break;
            case "BibliotecaListar":
                return BibliotecaController.listar(request);
                break;
            case "BibliotecaAlterar":
                return BibliotecaController.alterar(request);
                break;
            case "BibliotecaGravarAlteracao":
                return BibliotecaController.gravarAlteracao(request);
                break;
            case "BibliotecaGravarInsercao":
                return BibliotecaController.gravarInsercao(request);
                break;
            case "BibliotecaExcluir":
                return BibliotecaController.excluir(request);
                break;
            case "IniciaCadastroAquisicao":
                return "/core/aquisicoes/pedir-passo1-leitor.jsp";
                break;
            case "AquisicaoCriar":
                return AquisicaoController.gravarAquisicaoBibliotecario(request);
                break;
            case "AquisicaoPendente":
                jsp= AquisicaoController.gravarPendente(request);
                break;
            case "ListarAquisicoes":
                return AquisicaoController.listarPendentes(request);
                break;
            case "AceitarAquisicao":
                return AquisicaoController.pedir(request);
                break;
            case "RecusarAquisicao":
                return AquisicaoController.recusar(request);
                break;
            case "ListarAquisicoesAtivos":
                return AquisicaoController.listarAtivos(request);
                break;
            case "FinalizarAquisicao":
                return AquisicaoController.gravarFinalizado(request);
                break;
            case "ListarAquisicoesFinalizadas":
                return AquisicaoController.listarFinalizados(request);
                break;
            case "AquisicaoPedidoCriarObra":
                return AquisicaoController.gravarPendente(request);
                break;
            case "ConfereAquisicao":
                return AquisicaoController.mostraAquisicao(request);
                break;
            case "CadastrarObraAquisicao":
                return AquisicaoController.cadastrarObra(request);
                break;
            case "GravarObraAquisicao":
                return AquisicaoController.removerPendente(request);
                break;
            case "LeitorCadastrar":
                return LeitorController.cadastrar(request);
                break;
            case "AtendentePesquisar":
                return GestorController.pesquisarAtendenteLogin(request);
                break;
            case "AtendenteListar":
                return GestorController.listarAtendentes(request);
                break;
            case "AtendenteAlterar":
                return GestorController.alterarAtendente(request);
                break;
            case "AtendenteGravarAlteracao":
                return GestorController.gravarAlteracaoAtendente(request);
                break;
            case "AtendenteGravarInsercao":
                return GestorController.gravarInsercaoAtendente(request);
                break;
            case "BibliotecarioPesquisar":
                return GestorController.pesquisarAtendenteLogin(request);
                break;
            case "BibliotecarioListar":
                return GestorController.listarBibliotecarios(request);
                break;
            case "BibliotecarioAlterar":
                return GestorController.alterarBibliotecario(request);
                break;
            case "BibliotecarioGravarAlteracao":
                return GestorController.gravarAlteracaoBibliotecario(request);
                break;
            case "BibliotecarioGravarInsercao":
                return GestorController.gravarInsercaoBiblioteca(request);
                break;
            case "ListarAcervo":
                return AcervoController.escolherBiblioteca(request);
                break;
            case "RestaurarExemplar":
                return AcervoController.enviarReparo(request);
                break;
            case "RetornoRestauracao":
                return AcervoController.receberReparo(request);
                break;
            case "DesativaExemplar":
                return AcervoController.desativarExemplar(request);
                break;
            case "TransformaExemplarConsulta":
                return AcervoController.registrarLivroConsulta(request);
                break;
            case "TransferirExemplar":
                return AcervoController.registrarTransferencia(request);
                break;
            case "UsuarioListar":
                return UsuarioController.listar(request);
                break;
            case "UsuarioExcluir":
                return UsuarioController.excluir(request);
                break;
            case "UsuarioInserir":
                return UsuarioController.gravarInsercao(request);
                break;
            case "IniciarReservar":
                return ReservaController.listarExemplares(request);
                break;
            case "ListarReservar":
                return ReservaController.listarReservas(request);
                break;
            case "ReservarExemplar":
                return ReservaController.reservar(request);
                break;
            case "ReservarPesquisarExemplar":
                return ReservaController.pesquisarListaExemplares(request);
                break;
            case "ReservarPesquisar":
                return ReservaController.pesquisarListaReservas(request);
                break;
            case "FinalizarReserva":
                return ReservaController.finalizar(request);
                break;
            case "EmprestarReserva":
                return ReservaController.emprestar(request);
                break;
            case "GravaDevolucao":
                return DevolucaoController.GravaDevolucao(request);
                break;
            case "ListarRestaurar":
                return AcervoController.listarRestaurar(request);
                break;
            case "ListarConsulta":
                return AcervoController.listarConsulta(request);
                break;
            case "ListarTransferencia":
                return AcervoController.listarTransferencia(request);
                break;
            case "MostraExemplar":
                return AcervoController.mostraExemplar(request);
                break;
            case "ListarAcervoBiblioteca":
                return AcervoController.listarAcervoBiblioteca(request);
                break;
            case "AceitaExemplar":
                return AcervoController.aceitarExemplar(request);
                break;
            case "EmprestimoListar":
                return EmprestimoController.listar(request);
                break;
            case "EmprestimoSolicitar":
                return EmprestimoController.gravarEmprestimo(request);
                break;
        }
    }
}

