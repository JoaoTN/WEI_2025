package br.sistema.crud.jdbc.dto;

public class EnderecoDTO {

    private Integer idEndereco;
    private String logradouro;
    private String bairro;
    private String cidade;
    private Long numero;
    private Integer cep;
    private UfDTO ufDTO;

    // Construtor vazio
    public EnderecoDTO() {
    }

    // Getters e setters para os atributos
    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public UfDTO getUfDTO() {
        return ufDTO;
    }

    public void setUfDTO(UfDTO ufDTO) {
        this.ufDTO = ufDTO;
    }
}
