package codigo;


public class ClientePF extends Cliente {

    private String cpf;

    //Construtor ClientePF
    public ClientePF(String nome, String email, String endereco, String cpf) {
        super(nome, email, endereco);
        this.cpf = cpf;
    }


    public String getCpf() {
        return cpf;
    }


    //toString ClientePF
    @Override
    public String toString() {
        return
                "\nDados do Cliente: " +
                        "\nCPF: " + cpf +
                        super.toString();

    }





}

