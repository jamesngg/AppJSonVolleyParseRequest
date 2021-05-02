package br.com.local.appjsonvolleyparserequest;

public class Herois {
    private Integer id;
    private String nome;
    private String nomereal;
    private String idade;

    public Herois() {
    }

    public Herois(Integer id, String nome, String nomereal, String idade) {
        this.id = id;
        this.nome = nome;
        this.nomereal = nomereal;
        this.idade = idade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomereal() {
        return nomereal;
    }

    public void setNomereal(String nomereal) {
        this.nomereal = nomereal;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}
