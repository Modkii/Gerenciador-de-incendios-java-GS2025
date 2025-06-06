package br.com.queimadas.model;

import java.util.ArrayList;
import java.util.List;

public class Equipe extends EntidadeBase {
    private String nome;
    private List<String> membros;
    private StatusEquipe status;

    public Equipe(String id, String nome) {
        super(id);
        this.nome = nome;
        this.membros = new ArrayList<>();
        this.status = StatusEquipe.DISPONIVEL;
    }

    public Equipe(String id, String nome, List<String> membros) {
        super(id);
        this.nome = nome;
        this.membros = membros;
        this.status = StatusEquipe.DISPONIVEL;
    }

    public void iniciarMissao() {
        this.status = StatusEquipe.EM_ACAO;
    }

    public void concluirMissao() {
        this.status = StatusEquipe.DISPONIVEL;
    }

    public String getNome() {
        return nome;
    }

    public StatusEquipe getStatus() {
        return status;
    }

    public void adicionarMembro(String membro) {
        membros.add(membro);
    }

    @Override
    public String toString() {
        return "Equipe {" +
                super.toString() +
                ", Nome='" + nome + '\'' +
                ", Membros=" + membros +
                ", Status=" + status +
                '}';
    }
}
