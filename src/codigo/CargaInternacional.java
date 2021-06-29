package codigo;

public class CargaInternacional extends Carga {

    //Atributos CargaInternacional
    private double taxaAlfandega;

    private String paisOrigem;


    //Construtor CargaInternacional
    public CargaInternacional(int codigo, double altura, double largura, double profundidade, double peso, Aeroporto aeroportoOrigem, Aeroporto aeroportoDestino, Cliente cliente, String paisOrigem, double taxaAlfandega) {

        super(codigo, altura, largura, profundidade, peso, aeroportoOrigem, aeroportoDestino, cliente);

        this.paisOrigem = paisOrigem;
        this.taxaAlfandega = taxaAlfandega;
    }

    private double calculoDistancia(){
        double latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, distancia, diferencaLatitude, diferencaLongitude, distanciaGraus;

        latitudeOrigem = aeroportoOrigem.getLatitude();
        longitudeOrigem = aeroportoOrigem.getLongitude();
        latitudeDestino = aeroportoDestino.getLatitude();
        longitudeDestino = aeroportoDestino.getLongitude();
        //Pega latitudes e longitudes(graus decimais)

        if(latitudeOrigem > latitudeDestino){
            diferencaLatitude = latitudeOrigem - latitudeDestino;
        }
        else{
            diferencaLatitude = latitudeDestino - latitudeOrigem;
        }
        //Compara as latitudes e pega a diferença entre elas

        if(longitudeOrigem > longitudeDestino){
            diferencaLongitude = longitudeOrigem - longitudeDestino;
        }
        else{
            diferencaLongitude = longitudeDestino - longitudeOrigem;
        }
        //Compara as longitudes e pega a diferença entre elas

        distanciaGraus = Math.sqrt(Math.pow(diferencaLatitude, 2) + Math.pow(diferencaLongitude, 2));
        //Usa pitagoras pra descobrir a distancia entre os dois pontos em graus

        distancia = (distanciaGraus * 40075000)/360;
        //usa regra de 3 para calcular a distancia em metros, sabendo que uma volta na terra tem 40075km

        distancia = distancia / 1000;
        //converte pra km

        distancia = distancia / 100;
        //faz a divisão por 100 que pede no pdf

        return distancia;
    }

    //Calculo Frete PJ
    public boolean calculoFrete(ClientePJ cliente) {
        //Valor Base = (Altura X Largura X Profundidade X Peso X 10)
        double valorBase = (super.getAltura()*super.getLargura()*super.getProfundidade()*super.getPeso()*10);

        //	Valor por distância = (Distância entre aeroportos (em quilômetros)) / 100
        double valorDistancia;//teste

        valorDistancia = calculoDistancia();
        //calculoDistancia

        //Valor do frete = (Valor base X Valor por distância) + Taxa adicional(Alfandega)
        double valorFrete = (valorBase * valorDistancia) + taxaAlfandega;

        //Se Cliente for PJ, ganha 3% de desconto
        valorFrete = valorFrete * 0.97;

        valorFrete= Math.round(valorFrete);
        //Atributo valorFrete recebe o dado valorFrete
        super.setValorFrete(valorFrete);
        return true;
    }

    //Calculo Frete PF
    public boolean calculoFrete(ClientePF cliente){
        //Valor Base = (Altura X Largura X Profundidade X Peso X 10)
        double valorBase = (super.getAltura() * super.getLargura() * super.getProfundidade() * super.getPeso() * 10);

        //	Valor por distância = (Distância entre aeroportos (em quilômetros)) / 100
        double valorDistancia=100;//teste

        valorDistancia = calculoDistancia();
        //calculoDistancia

        //Valor do frete = (Valor base X Valor por distância) + Taxa adicional(Alfandega)
        double valorFrete = (valorBase * valorDistancia) + taxaAlfandega;

        valorFrete= Math.round(valorFrete);
        //Atributo valorFrete recebe o dado valorFrete
        super.setValorFrete(valorFrete);
        return true;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    //toString CargaInternacional
    //toString de Carga(super classe) + país de origem da CargaInternacional
    @Override
    public String toString() {
        return super.toString() +
                "\nPaís de Origem: " + paisOrigem +
                "\nTipo de Carga: Internacional" +
                "\n------------------------------------------" +
                "\n------------------------------------------";
    }



}

