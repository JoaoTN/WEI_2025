package br.sistema.crud.jdbc.bo;

import br.sistema.crud.jdbc.dao.LoginDAO;
import br.sistema.crud.jdbc.dto.LoginDTO;
import br.sistema.crud.jdbc.exception.NegocioException;

public class LoginBO {

    private static final String MENSAGEM_LOGIN_OBRIGATORIO = "Login obrigatório";

    public boolean logar(LoginDTO loginDTO) throws NegocioException {
        validarLogin(loginDTO);

        try {
            LoginDAO loginDAO = new LoginDAO();
            return loginDAO.logar(loginDTO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new NegocioException(e.getMessage(), e);
        }
    }

    private void validarLogin(LoginDTO loginDTO) throws NegocioException {
        if (loginDTO.getNome() == null || loginDTO.getNome().isEmpty()) {
            throw new NegocioException(MENSAGEM_LOGIN_OBRIGATORIO);
        } else if (loginDTO.getSenha() == null || loginDTO.getSenha().isEmpty()) {
            throw new NegocioException(MENSAGEM_LOGIN_OBRIGATORIO);
        }
    }
}
