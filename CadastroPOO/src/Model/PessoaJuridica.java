package model;

public class PessoaJuridica extends Pessoa {
    private String cnpj;

    // Construtor padrão
    public PessoaJuridica() {}

    // Construtor completo
    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome); // Chama o construtor da superclasse (Pessoa)
        this.cnpj = cnpj;
    }

    // Getters e Setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    // Exibir 
    @Override
    public void exibir() {
        super.exibir(); // Chama o método exibir da superclasse
        System.out.println("CNPJ: " + cnpj);
    }
}
