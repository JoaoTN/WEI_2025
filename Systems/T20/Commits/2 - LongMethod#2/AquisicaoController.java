package sgab.controller;

import jakarta.servlet.http.HttpServletRequest;
import sgab.model.dto.Aquisicao;
import sgab.model.dto.Fornecedor;
import sgab.model.dto.Obra;
import sgab.model.dto.Pessoa;
import sgab.model.dto.Autor;
import sgab.model.dto.Assunto;
import sgab.model.dto.util.AquisicaoStatus;
import sgab.model.service.GestaoAquisicao;
import sgab.model.service.GestaoFornecedoresService;
import sgab.model.service.GestaoObras;
import sgab.model.service.GestaoPessoasService;
import sgab.model.service.GestaoAutor;
import sgab.model.service.GestaoAssuntoService;
import java.util.List;
import java.util.LinkedList;
import sgab.model.dto.Biblioteca;
import sgab.model.dto.Exemplar;
import sgab.model.exception.NegocioException;
import sgab.model.exception.PersistenciaException;
import sgab.model.service.GestaoAcervo;
import sgab.model.service.GestaoBibliotecaService;

public class AquisicaoController {
    public static String pedir(HttpServletRequest request) {
        String jsp = "";
        try {
            Long aquisicaoId = Long.parseLong(request.getParameter("aquisicaoId"));
            request.getSession().setAttribute("idAquisicaoAtual", aquisicaoId);
            
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            Aquisicao aquisicao = gestaoAquisicao.pesquisarAquisicao(aquisicaoId);
            request.getSession().setAttribute("obraAlvo", aquisicao.getObra());
            
            if(aquisicao != null){
                jsp = "/core/aquisicoes/pedir-passo3.jsp";
            } else {
                String erro = "Ocorreu erro ao Pedir Aquisicao!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String mostraAquisicao(HttpServletRequest request) {
        String jsp = "";
        try {
            Long aquisicaoId = Long.parseLong(request.getParameter("aquisicaoId"));
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            Aquisicao aquisicao = gestaoAquisicao.pesquisarAquisicao(aquisicaoId);
            Obra obra = aquisicao.getObra();
            Long quantidade = aquisicao.getQuantidade();
            String justificativa = aquisicao.getJustificativaQuantidade();
            
            if (obra != null) {
                request.setAttribute("obra", obra);
                request.setAttribute("quantidade", quantidade);
                request.setAttribute("justificativa", justificativa);
                jsp = "/core/aquisicoes/visualizar-obra.jsp";
            } else {
                String erro = "Ocorreu erro ao Visualizar Obra!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String listarTodos(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            List<Aquisicao> listAquisicoes = gestaoAquisicao.listarAquisicoes();
            if(listAquisicoes != null){
                request.setAttribute("listAquisicoes", listAquisicoes);
                jsp = "/core/aquisicoes/pedidos-aquisicoes.jsp";
            } else {
                String erro = "Nao existe registro de Aquisicoes!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String listarAtivos(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            List<Aquisicao> listAquisicoesAtivas = gestaoAquisicao.aquisicoesAtivas();
            if(listAquisicoesAtivas != null){
                request.setAttribute("listAquisicoesAtivas", listAquisicoesAtivas);
                jsp = "/core/aquisicoes/pedidos-ativos.jsp";
            } else {
                String erro = "Nao existe registro de Aquisicoes Ativas!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String listarPendentes(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            List<Aquisicao> listAquisicoesPendentes = gestaoAquisicao.aquisicoesPendente();
            GestaoObras gestaoObras = new GestaoObras();
            
            for(Aquisicao aquisicao : listAquisicoesPendentes){
                List<Obra> listaObras = gestaoObras.pesquisarObraNome(aquisicao.getObra().getTitulo());
                for(Obra obra : listaObras){
            
                }
            }
            if(listAquisicoesPendentes != null){
                request.setAttribute("listAquisicoesPendentes", listAquisicoesPendentes);
                jsp = "/core/aquisicoes/pedidos-pendentes.jsp";
            } else {
                String erro = "Nao existe registro de Aquisicoes Pendentes!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String listarFinalizados(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            List<Aquisicao> listAquisicoesFinalizadas = gestaoAquisicao.aquisicoesFinalizada();
            if(listAquisicoesFinalizadas != null){
                request.setAttribute("listAquisicoesFinalizadas", listAquisicoesFinalizadas);
                jsp = "/core/aquisicoes/pedidos-finalizados.jsp";
            } else {
                String erro = "Nao existe registro de Aquisicoes Finalizadas!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String gravarPendente(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoObras gestaoObra = new GestaoObras();
            GestaoBibliotecaService gestaoBiblioteca = new GestaoBibliotecaService();
            GestaoPessoasService gestaoPessoas = new GestaoPessoasService();
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            GestaoAutor gestaoAutor = new GestaoAutor();
            GestaoAssuntoService gestaoAssuntos = new GestaoAssuntoService();
            
            String etapa = request.getParameter("etapa");
            
            switch(etapa){
                case "primeiro":
                    jsp = handlePrimeiroEtapa(request, gestaoObra, gestaoBiblioteca);
                    break;
                case "segundo":
                    jsp = handleSegundoEtapa(request, gestaoAquisicao);
                    break;
                case "segundo-criarObra":
                    jsp = handleSegundoCriarObra(request, gestaoAutor, gestaoAssuntos, gestaoAquisicao);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    private static String handlePrimeiroEtapa(HttpServletRequest request, GestaoObras gestaoObra, GestaoBibliotecaService gestaoBiblioteca) {
        String jsp = "";
        String nomeObra = request.getParameter("nomeObra");
        List<Obra> obraAlvo = gestaoObra.pesquisarObraNome(nomeObra);

        String nomeBiblioteca = request.getParameter("biblioteca");
        nomeBiblioteca = nomeBiblioteca.split("::")[0];
        Biblioteca bibliotecaAlvo = gestaoBiblioteca.pesquisarProNome(nomeBiblioteca);

        request.getSession().setAttribute("bibliotecaAlvo", bibliotecaAlvo);
        
        Pessoa pessoaAlvo = (Pessoa) request.getSession().getAttribute("usuario");
        request.getSession().setAttribute("pessoaDona", pessoaAlvo);
        
        Long quantidade = null;
        String quantidadeString = request.getParameter("quantidade");
        if(!quantidadeString.isEmpty())
            quantidade = Long.parseLong(quantidadeString);
        
        String justificativa = request.getParameter("justificativa");
        if(!justificativa.isEmpty()){
            justificativa = "";
        }
        
        request.getSession().setAttribute("quantidadeAlvo", quantidade);
        request.getSession().setAttribute("justificativaAlvo", justificativa);
        
        if(obraAlvo.isEmpty()){
            request.setAttribute("nomeObra", nomeObra);
            jsp = "/core/aquisicoes/criarAquisicaoLeitor.jsp";
        }
        else{
            request.setAttribute("obras", obraAlvo);
            jsp="/core/aquisicoes/pedir-passo2.jsp";
        }
        return jsp;
    }

    private static String handleSegundoEtapa(HttpServletRequest request, GestaoAquisicao gestaoAquisicao) {
        Pessoa pessoa = (Pessoa) request.getSession().getAttribute("pessoaDona");
        Biblioteca biblioteca = (Biblioteca) request.getSession().getAttribute("bibliotecaAlvo");
        Obra obra = (Obra) request.getSession().getAttribute("obraAlvo");
        Aquisicao aquisicao = new Aquisicao(biblioteca, pessoa, null, null, AquisicaoStatus.PENDENTE, obra);

        Long quantidade1 = (Long) request.getSession().getAttribute("quantidadeAlvo");
        String justificativa1 = (String) request.getSession().getAttribute("justificativaAlvo");

        if(quantidade1 != null && justificativa1 != ""){
            aquisicao.setQuantidade(quantidade1);
            aquisicao.setJustificativaQuantidade(justificativa1);
        }

        gestaoAquisicao.cadastrarAquisicao(aquisicao);
        return "/core/aquisicoes/operacao-sucesso.jsp";
    }

    private static String handleSegundoCriarObra(HttpServletRequest request, GestaoAutor gestaoAutor, GestaoAssuntoService gestaoAssuntos, GestaoAquisicao gestaoAquisicao) {
        Pessoa pessoa1 = (Pessoa) request.getSession().getAttribute("pessoaDona");
        Biblioteca biblioteca1 = (Biblioteca) request.getSession().getAttribute("bibliotecaAlvo");

        String tituloObra = request.getParameter("titulo");
        String categoriaObra = request.getParameter("categoria");
        String notaObra = request.getParameter("nota");

        List<Autor> autores = new LinkedList<>();
        String[] nomeAutores = request.getParameter("autores").split("::");
        if(!(nomeAutores.length == 1 && nomeAutores[0].equals(""))){
            for(String autor: nomeAutores){
                Autor alvo = gestaoAutor.pesquisarNome(autor);
                autores.add(alvo);
            }
        }
        List<Assunto> assuntos = new LinkedList<>();
        String[] nomeAssuntos = request.getParameter("assuntos").split("::");
        if(!(nomeAssuntos.length == 1 && nomeAssuntos[0].equals(""))){
            for(String assunto : nomeAssuntos){
                Assunto alvo = gestaoAssuntos.pesquisarAssunto(assunto);
                assuntos.add(alvo);
            }
        }

        String temp = request.getParameter("ano");
        Integer anoObra = null;
        if(!temp.equals(""))
            anoObra = Integer.parseInt(temp);

        String editoraObra = request.getParameter("editora");
        String cidadeEditoraObra = request.getParameter("cidEditora");

        temp = request.getParameter("edicao");
        Integer edicaoObra = null;
        if(!temp.equals(""))
            edicaoObra = Integer.parseInt(temp);

        temp = request.getParameter("volume");
        Integer volumeObra = null;
        if(!temp.equals(""))
            volumeObra = Integer.parseInt(temp);

        Obra obra1 = new Obra(categoriaObra, tituloObra, autores, assuntos, notaObra, anoObra, editoraObra, cidadeEditoraObra, edicaoObra, volumeObra);

        Aquisicao aquisicao1 = new Aquisicao(biblioteca1, pessoa1, null, null, AquisicaoStatus.PENDENTE, obra1);
        aquisicao1.setObraExiste(false);

        Long quantidade2 = (Long) request.getSession().getAttribute("quantidadeAlvo");
        String justificativa2 = (String) request.getSession().getAttribute("justificativaAlvo");

        if(quantidade2 != null && justificativa2 != ""){
            aquisicao1.setQuantidade(quantidade2);
            aquisicao1.setJustificativaQuantidade(justificativa2);
        }

        gestaoAquisicao.cadastrarAquisicao(aquisicao1);
        return "/core/aquisicoes/operacao-sucesso.jsp";
    }

    public static String gravarAquisicaoBibliotecario(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoPessoasService gestaoPessoa = new GestaoPessoasService();
            GestaoObras gestaoObra = new GestaoObras();
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            GestaoFornecedoresService gestaoFornecedor = new GestaoFornecedoresService();
            GestaoBibliotecaService gestaoBibliotecaService = new GestaoBibliotecaService();
            
            String etapa = request.getParameter("etapa");
            
            switch(etapa){
                case "primeiro":
                    String nomeObra = request.getParameter("nomeObra");
                    List<Obra> obrasAlvo = gestaoObra.pesquisarObraNome(nomeObra);
                    if(obrasAlvo.isEmpty()){
                        jsp = "/core/aquisicoes/pedir-passo2-none.jsp";
                    }
                    else{
                        String bibliotecaNome = request.getParameter("biblioteca");
                        bibliotecaNome = bibliotecaNome.split("::")[0];
                        Biblioteca bibliotecaAlvo = gestaoBibliotecaService.pesquisarProNome(bibliotecaNome);
                        
                        request.setAttribute("obras", obrasAlvo);
                        request.getSession().setAttribute("pessoaDona", null);
                        request.getSession().setAttribute("idAquisicaoAtual", null);
                        request.getSession().setAttribute("bibliotecaAlvo", bibliotecaAlvo);
                        jsp= "/core/aquisicoes/pedir-passo2.jsp";
                    }
                    break;
                case "segundo":
                    Long idObra = Long.parseLong(request.getParameter("obraId"));
                    Obra obraAlvo = gestaoObra.pesquisarObraID(idObra);
                    request.getSession().setAttribute("obraAlvo", obraAlvo);
                    
                    Pessoa pessoaAlvo = (Pessoa) request.getSession().getAttribute("pessoaDona");
                    
                    if(pessoaAlvo != null){
                        jsp = gravarPendente(request);
                        break;
                    }
                    
                    jsp= "/core/aquisicoes/pedir-passo3.jsp";
                    break;
                    
                case "terceiro":
                    Long id = (Long) request.getSession().getAttribute("idAquisicaoAtual");
                    if(id==null){
                        Obra obraAlvo1 = (Obra) request.getSession().getAttribute("obraAlvo");
                        Long quantidade = Long.parseLong(request.getParameter("quantidade"));
                        
                        String nomeFornecedor = request.getParameter("fornecedor");
                        
                        Fornecedor fornecedorAlvo = gestaoFornecedor.pesquisarPorNome(nomeFornecedor);
                        
                        Pessoa pessoaAlvo1 = (Pessoa) request.getSession().getAttribute("usuario");
                        
                        Biblioteca biblioteca = (Biblioteca) request.getSession().getAttribute("bibliotecaAlvo");
                        //todo usar biblioteca do bibliotecário

                        
                        Aquisicao novaAquisicao = new Aquisicao(biblioteca, pessoaAlvo1, quantidade, fornecedorAlvo, AquisicaoStatus.ATIVO, obraAlvo1);
                        gestaoAquisicao.cadastrarAquisicao(novaAquisicao);
                        jsp = listarAtivos(request);
                    }
                    else{
                        Aquisicao aquisicao = gestaoAquisicao.pesquisarAquisicao(id);
                        
                        String fornecedorNome = request.getParameter("fornecedor");
                        Fornecedor fornecedor = gestaoFornecedor.pesquisarPorNome(fornecedorNome);
                        
                        if(fornecedor == null){
                            String erro = "O Fornecedor indicado não foi encontrado.";
                            request.setAttribute("erro", erro);
                            jsp = "/core/erro.jsp";
                        }
                        else{
                            Long quantidade = Long.parseLong(request.getParameter("quantidade"));

                            aquisicao.setFornecedor(fornecedor);
                            aquisicao.setQuantidade(quantidade);
                            aquisicao.setStatus(AquisicaoStatus.ATIVO);
                            jsp = listarPendentes(request);
                            try{
                                gestaoAquisicao.alterarAquisicao(aquisicao);
                                jsp = listarPendentes(request);
                            } catch(PersistenciaException ex){
                                String erro = "Nao foi possivel efetuar o pedido dessa aquisição!";
                                request.setAttribute("erro", erro);
                                jsp = "/core/erro.jsp";
                            }
                        }
                    }
                    break;
            }
        } catch (NegocioException ne){
            for(String erro : ne.getMessages()){
                System.out.println("ERRO:" + erro);
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String gravarFinalizado(HttpServletRequest request) {
        String jsp = "";
        try {
            GestaoAcervo gestaoAcervo = new GestaoAcervo();
            
            Long aquisicaoId = Long.parseLong(request.getParameter("aquisicaoId"));
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            Aquisicao aquisicao = gestaoAquisicao.pesquisarAquisicao(aquisicaoId);
            aquisicao.setStatus(AquisicaoStatus.FINALIZADA);
            
            Long quantidade = aquisicao.getQuantidade();
            Biblioteca bibliotecaAlvo = aquisicao.getBiblioteca();
            Obra obraAlvo = aquisicao.getObra();
            
            for(int i = 0; i < quantidade; i++){
                Exemplar exemplarTemp = new Exemplar(obraAlvo, bibliotecaAlvo);
                gestaoAcervo.cadastrarExemplar(exemplarTemp);
            }
            
            try{
                gestaoAquisicao.alterarAquisicao(aquisicao);
                jsp = listarAtivos(request);
            } catch(PersistenciaException ex){
                String erro = "Nao foi possivel efetuar o finalização dessa aquisição!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static String recusar(HttpServletRequest request) {
        String jsp = "";
        try {
            String motivoRecusa = request.getParameter("motivoRecusa");
            // to do Enviar email para Pessoa da Aquisição
            
            Long aquisicaoId = Long.parseLong(request.getParameter("aquisicaoId"));
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            Aquisicao aquisicao = gestaoAquisicao.pesquisarAquisicao(aquisicaoId);
            try{
                gestaoAquisicao.excluirAquisicao(aquisicao);
                jsp = listarPendentes(request);
            } catch(PersistenciaException ex){
                String erro = "Ocorreu erro ao Recusar Aquisicao!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String removerPendente(HttpServletRequest request) {
        String jsp = "";
        try {
            Long aquisicaoId = (Long) request.getSession().getAttribute("aquisicaoAlvo");
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            Aquisicao aquisicao = gestaoAquisicao.pesquisarAquisicao(aquisicaoId);
            ObraController.gravarInsercao(request);
            aquisicao.setObraExiste(true);
            
            GestaoAutor gestaoAutor = new GestaoAutor();
            GestaoObras gestaoObras = new GestaoObras();
            GestaoAssuntoService gestaoAssuntos = new GestaoAssuntoService();
            
            String tituloObra = request.getParameter("titulo");
            String categoriaObra = request.getParameter("categoria");
            String notaObra = request.getParameter("nota");
            
            List<Autor> autores = new LinkedList<>();
            String[] nomeAutores = request.getParameter("autores").split("::");
            for(String autor: nomeAutores){
                Autor alvo = gestaoAutor.pesquisarNome(autor);
                autores.add(alvo);
            }
            
            List<Assunto> assuntos = new LinkedList<>();
            String[] nomeAssuntos = request.getParameter("assuntos").split("::");
            for(String assunto : nomeAssuntos){
                Assunto alvo = gestaoAssuntos.pesquisarAssunto(assunto);
                assuntos.add(alvo);
            }
            
            Integer anoObra = Integer.parseInt(request.getParameter("ano"));
            String editoraObra = request.getParameter("editora");
            String cidadeEditoraObra = request.getParameter("cidEditora");
            Integer edicaoObra = Integer.parseInt(request.getParameter("edicao"));
            Integer volumeObra = Integer.parseInt(request.getParameter("volume"));

            Obra obra = new Obra(categoriaObra, tituloObra, autores, assuntos, notaObra, anoObra, editoraObra, cidadeEditoraObra, edicaoObra, volumeObra);
            aquisicao.setObra(obra);
            jsp = listarPendentes(request);
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
    public static String cadastrarObra(HttpServletRequest request) {
        String jsp = "";
        try{
            Long aquisicaoId = Long.parseLong(request.getParameter("aquisicaoId"));
            GestaoAquisicao gestaoAquisicao = new GestaoAquisicao();
            Aquisicao aquisicao = gestaoAquisicao.pesquisarAquisicao(aquisicaoId);
            
            Obra obraAlvo = aquisicao.getObra();
            request.getSession().setAttribute("aquisicaoAlvo", aquisicaoId);
            request.setAttribute("obra", obraAlvo);
            jsp = "/core/aquisicoes/cadastrar-obra-pedido.jsp";
        } catch(Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
