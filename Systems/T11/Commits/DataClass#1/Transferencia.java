package app.condominio.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "transferencias")
@PrimaryKeyJoinColumn(name = "idmovimento")
public class Transferencia extends Movimento {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcontadestino")
    private Conta contaDestino;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idmovimentoinverso")
    private Movimento movimentoInverso;

    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public Movimento getMovimentoInverso() {
        return movimentoInverso;
    }

    public void setMovimentoInverso(Movimento movimentoInverso) {
        this.movimentoInverso = movimentoInverso;
    }
}
