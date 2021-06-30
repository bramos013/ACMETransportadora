package tela.Controles;

import codigo.*;
import javafx.scene.control.*;

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
        try{
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

            //Verificar se todos os campos foram preenchidos
            if(txtAltura.getText().isEmpty()||txtLargura.getText().isEmpty()||txtProfundidade.getText().isEmpty()||txtPeso.getText().isEmpty()||txtAeroDestino.getText().isEmpty()||txtAeroOrigem.getText().isEmpty()||txtDadoCliente.getText().isEmpty()) {
                System.err.println("Todos os campos devem ser preenchidos para fazer o cadastro.");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Todos os campos devem ser preenchidos para fazer o cadastro.");
                alert.show();
                return;
            }

            //Pegar os codigos IATA e verificar se os codigos IATA estão cadastrados
            for(Aeroporto aero : Dados.listaAeroportos){
                if(aero.getcodigoIATA().equalsIgnoreCase(codIataDestino)){
                    aeroportoDestino = aero;
                }

                if(aero.getcodigoIATA().equalsIgnoreCase(codIataOrigem)){
                    aeroportoOrigem = aero;
                }
            }
            if(aeroportoDestino == null || aeroportoOrigem == null){
                System.err.println("Código IATA inválido");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Código IATA inválido.");
                alert.setContentText("Informe apenas códigos IATA já cadastrados no sistema.");
                alert.show();
                return;
            }

            //Diferenciar as taxas de acordo com localidade
            if(aeroportoOrigem.getPais().equalsIgnoreCase("BRASIL")){
                //Taxa ISQN
                taxa = 50.0;
            }else{
                //Taxa alfandega
                taxa = 100.0;
            }

            //Verificar se cliente é PF/PJ e se está cadastrado
            for(ClientePF clientes : Dados.listaClientesPF){
                if(clientes.getCpf().equals(txtDadoCliente.getText())){
                    cliente = clientes;
                }
            }
            for(ClientePJ clientes : Dados.listaClientesPJ){
                if(clientes.getCnpj().equals(txtDadoCliente.getText())){
                    cliente = clientes;
                }
            }
            if(cliente == null){
                System.err.println("Cliente não cadastrado!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Cliente não cadastrado!");
                alert.setContentText("Informe CPF/CNPJ de clientes já cadastrados no sistema.");
                alert.show();
                return;
            }


            //Cria a carga e add na lista
            if(aeroportoOrigem.getPais().equalsIgnoreCase("BRASIL")){
                CargaNacional carga = new CargaNacional(codigo,altura,largura,profundidade,peso,aeroportoOrigem,aeroportoDestino,cliente,taxa);
                Dados.listaCargas.add(carga);
                //Calcular frete
                carga.setValorFrete(carga.calculaFrete(cliente));
                //Mostra no text area a carga cadastrada
                txtArea.setText(carga.toString());
            }else{
                CargaInternacional carga = new CargaInternacional(codigo,altura,largura,profundidade,peso,aeroportoOrigem,aeroportoDestino,cliente,aeroportoOrigem.getPais(),taxa);
                Dados.listaCargas.add(carga);
                //Calcular frete
                carga.setValorFrete(carga.calculaFrete(cliente));
                //Mostra no text area a carga cadastrada
                txtArea.setText(carga.toString());
            }

        }catch (RuntimeException e){
                System.err.println("Os campos Altura, Largura, Profundidade e Peso devem ser preenchidos com valores numéricos");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Você deve preencher corretamente todos os campos para fazer o cadastro.");
                alert.setContentText("Preencha os campos Altura, Largura, Profundidade e Peso com valores numéricos");
                alert.show();


        }finally {
            limparDados();
        }
    }


}
