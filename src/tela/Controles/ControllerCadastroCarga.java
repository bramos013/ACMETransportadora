package tela.Controles;

import codigo.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControllerCadastroCarga {
    public MenuItem btnSair;
    public TextField txtAltura;
    public TextField txtLargura;
    public TextField txtProfundidade;
    public TextField txtPeso;
    public TextField txtAeroOrigem;
    public TextField txtAeroDestino;
    public Button btnLimpar;
    public Button btnCadastrar;
    public Button btnVoltar;
    public TextArea txtArea;
    public TextField txtDadoCliente;

    //fechar app
    public void clickFechar(javafx.event.ActionEvent event){
        System.exit(0);
    }

    public void clickLimpar(javafx.event.ActionEvent event){
        limparDados();
        txtArea.clear();
    }

    public void limparDados(){
        txtAltura.clear();
        txtLargura.clear();
        txtProfundidade.clear();
        txtPeso.clear();
        txtAeroOrigem.clear();
        txtAeroDestino.clear();
        txtDadoCliente.clear();
    }

    //voltar tela de login
    public void clickVoltar(javafx.event.ActionEvent event){
        Main.mudarScene("login");
    }

    public void clickCadastrar(javafx.event.ActionEvent event){
        //Limpar área de texto
        txtArea.clear();

        Integer codigo = Dados.listaCargas.size();
        Double altura = Double.valueOf(txtAltura.getText());
        Double largura = Double.valueOf(txtLargura.getText());
        Double peso = Double.valueOf(txtPeso.getText());
        Double profundidade = Double.valueOf(txtProfundidade.getText());
        String codIataOrigem = txtAeroOrigem.getText();
        String codIataDestino = txtAeroDestino.getText();
        Aeroporto aeroportoDestino = null;
        Aeroporto aeroportoOrigem = null;
        double taxa = 0;
        Cliente cliente = null;

        //Pegar os codigos IATA
        for(Aeroporto aero : Dados.listaAeroportos){
            if(aero.getcodigoIATA().equalsIgnoreCase(codIataDestino)){
                aeroportoDestino = aero;
            }

            if(aero.getcodigoIATA().equalsIgnoreCase(codIataOrigem)){
                aeroportoOrigem = aero;
            }
        }

        //Diferenciar as taxas de acordo com localidade
        if(aeroportoOrigem.getPais().equalsIgnoreCase("BRASIL")){
            //Taxa ISQN
            taxa = 50.0;
        }else{
            //Taxa alfandega
            taxa = 100.0;
        }

        //Verificar se cliente é PF
        for(ClientePF clientes : Dados.listaClientesPF){
            if(clientes.getCpf().equals(txtDadoCliente.getText())){
                cliente = clientes;
            }
        }

        //Verificar se cliente é PJ
        for(ClientePJ clientes : Dados.listaClientesPJ){
            if(clientes.getCnpj().equals(txtDadoCliente.getText())){
                cliente = clientes;
            }
        }


        //Cria a carga e add na lista
        if(aeroportoOrigem.getPais().equalsIgnoreCase("BRASIL")){
            CargaNacional carga = new CargaNacional(codigo,altura,largura,profundidade,peso,aeroportoOrigem,aeroportoDestino,cliente,taxa);
            Dados.listaCargas.add(carga);
            //Calcular frete
            carga.setValorFrete(carga.calculaFrete(cliente));
            //Mostra no text area a carga cadastrada
            txtArea.setText(carga.toString());
            System.out.println(carga.toString());
        }else{
            CargaInternacional carga = new CargaInternacional(codigo,altura,largura,profundidade,peso,aeroportoOrigem,aeroportoDestino,cliente,aeroportoOrigem.getPais(),taxa);
            Dados.listaCargas.add(carga);
            //Calcular frete
            carga.setValorFrete(carga.calculaFrete(cliente));
            //Mostra no text area a carga cadastrada
            txtArea.setText(carga.toString());
            System.out.println(carga.toString());
        }

        limparDados();
    }


}
