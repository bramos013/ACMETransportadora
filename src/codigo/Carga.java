package codigo;

public class Carga {

    //Atributos de Carga
    private int codigo;

    private double altura;

    private double largura;

    private double profundidade;

    private double peso;

    private double valorFrete=100;

    private String situacao = "Pendente";

    protected Aeroporto aeroportoOrigem;

    protected Aeroporto aeroportoDestino;

    private Cliente cliente;


    //Construtor de Carga
    public Carga(int codigo, double altura, double largura, double profundidade, double peso, Aeroporto aeroportoOrigem, Aeroporto aeroportoDestino, Cliente cliente) {
        this.codigo = codigo;
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
        this.peso = peso;
        this.aeroportoOrigem = aeroportoOrigem;
        this.aeroportoDestino = aeroportoDestino;
        this.cliente = cliente;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public double getAltura() {
        return altura;
    }

    public double getLargura() {
        return largura;
    }

    public double getProfundidade() {
        return profundidade;
    }

    public double getPeso() {
        return peso;
    }

    public String getSituacao() {
        return situacao;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public boolean enviar(){
        //Variaveis para fazer a comparação
        String brasil="BRASIL";
        String br="BR";

        //Verifica se o pais de destino é nacional
        if(aeroportoDestino.getPais().toUpperCase().equals(brasil) || aeroportoDestino.getPais().toUpperCase().equals(br)){
            situacao="Enviado";
            return true;
        }else{
            return false;
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setSituacao(String situacao) {
        this.situacao=situacao;
    }

    public String toString() {
        return
                "\nDados da Carga" +
                "\n" + cliente +
                "\nAeroporto de Origem: " + aeroportoOrigem.getNome() +
                "\nAeroporto de Destino: " + aeroportoDestino.getNome() +
                "\nAltura: " + altura +
                "\nLargura: " + largura +
                "\nPeso: " + peso +
                "\nProfundidade: " + profundidade +
                "\nSituação: " + situacao +
                "\nCódigo: " + codigo;

    }

}

