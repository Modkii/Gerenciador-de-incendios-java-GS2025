package br.com.queimadas.model;

public abstract class EntidadeBase {
    protected String id;

    public EntidadeBase(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id;
    }
}
