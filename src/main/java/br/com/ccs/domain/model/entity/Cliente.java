package br.com.ccs.domain.model.entity;

public class Cliente {

    private String nome;
    private String telefoneContato;

    public Cliente() {
    }

    public Cliente(String nome, String telefoneContato) {
        this.nome = nome;
        this.telefoneContato = telefoneContato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }
}
