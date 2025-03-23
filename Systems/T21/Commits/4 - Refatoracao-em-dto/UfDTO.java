package br.sistema.crud.jdbc.dto;

public class UfDTO {
	public class UfDTO {
		private UfData ufData;

		// construtor, se necessário

		public UfData getUfData() {
			return ufData;
		}

		public void setUfData(UfData ufData) {
			this.ufData = ufData;
		}
	}
}

public class UfData {
    private Integer idUF;
    private String siglaUF;
    private String descrcao;

    public Integer getIdUF() {
        return idUF;
    }

    public void setIdUF(Integer idUF) {
        this.idUF = idUF;
    }

    public String getSiglaUF() {
        return siglaUF;
    }

    public void setSiglaUF(String siglaUF) {
        this.siglaUF = siglaUF;
    }

    public String getDescricao() {
        return descrcao;
    }

    public void setDescricao(String descricao) {
        this.descrcao = descricao;
    }
}
