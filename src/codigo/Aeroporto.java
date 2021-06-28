package codigo;

public class Aeroporto {

    private String codigoIATA;

    private String nome;

    private String pais;

    private double latitude;

    private double longitude;

    public Aeroporto(String codigoIATA, String nome, String pais, double latitude, double longitude) {
        this.codigoIATA = codigoIATA;
        this.nome = nome;
        this.pais = pais;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public String getcodigoIATA(){
        return codigoIATA;
    }

    public String getNome(){
        return nome;
    }

    public String getPais(){
        return pais;
    }

    public double getLatitude(){
        return latitude;
    }

    public double getLongitude(){
        return longitude;
    }

    public String toString(){
        String Aeroporto = "";
        Aeroporto = Aeroporto + "Aeroporto de " + nome + "\n";
        Aeroporto = Aeroporto + "Codigo IATA: " + codigoIATA + "\n";
        Aeroporto = Aeroporto + "Pais: " + pais + "\n";
        Aeroporto = Aeroporto + "Latitude: " + latitude + " e Longitude: " + longitude;
        return Aeroporto;
    }
}
