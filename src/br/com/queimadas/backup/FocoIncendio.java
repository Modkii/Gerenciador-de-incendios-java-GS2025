package br.com.queimadas.model;

import java.time.LocalDateTime;

public class FocoIncendio extends EntidadeBase {
    private Localizacao localizacao;
    private StatusFoco status;
    private LocalDateTime dataDeteccao;
    private Equipe equipeDesignada;

    public FocoIncendio(String id, Localizacao localizacao) {
        super(id);
        this.localizacao = localizacao;
        this.status = StatusFoco.ATIVO;
        this.dataDeteccao = LocalDateTime.now();
    }

    public void controlarFoco() {
        this.status = StatusFoco.CONTROLADO;
    }

    public void extinguirFoco() {
        this.status = StatusFoco.EXTINTO;
    }

    public void designarEquipe(Equipe equipe) {
        this.equipeDesignada = equipe;
        equipe.iniciarMissao();
    }

    public StatusFoco getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "FocoIncendio {" +
                super.toString() +
                ", Localizacao=" + localizacao +
                ", Status=" + status +
                ", DataDeteccao=" + dataDeteccao +
                ", EquipeDesignada=" + (equipeDesignada != null ? equipeDesignada.getNome() : "Nenhuma") +
                '}';
    }
}
