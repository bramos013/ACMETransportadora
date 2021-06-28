package codigo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    //Atributos Cliente
    private String nome;

    private String email;

    private String endereco;

    private List<Carga> listaDeCargas = new ArrayList<>();

    //Construtor Cliente
    public Cliente(String nome, String email, String endereco) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }


    //Adiciona Carga criada na lista de cargas
    public void adicionaCarga(Carga carga){
        listaDeCargas.add(carga);
    }

    //toString Cliente
    public String toString() {
        if(listaDeCargas.size()>0){
            return
                    "\nNome: " + nome +
                            "\nEmail: " + email +
                            "\nEndereço: " + endereco +
                            "\nLista de Cargas: " + listaDeCargas;
        }else{
            return
                    "\nNome: " + nome +
                            "\nEmail: " + email +
                            "\nEndereço: " + endereco +
                            "\n";
        }

    }

}
