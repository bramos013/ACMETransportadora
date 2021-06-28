package codigo;

public class ClientePJ extends Cliente {

    private String cnpj;

    private String nomeFantasia;

    //Construtor ClientePJ
    public ClientePJ(String nome, String email, String endereco, String cnpj, String nomeFantasia) {
        super(nome, email, endereco);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }


    public String getCnpj() {
        return cnpj;
    }

    //toString ClientePJ
    @Override
    public String toString() {
        return
                "\nDados da Empresa: " +
                        "\nNome Fantasia: " + nomeFantasia +
                        "\nCNPJ: " + cnpj +
                        super.toString();

    }
}
