package tela.Controles;

import codigo.Aeroporto;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ControllerCadastroAeroporto {
    public MenuItem btnSair;
    public TextField txtCodigoIATA;
    public TextField txtNomeAeroporto;
    public TextField txtPais;
    public TextField txtLatitude;
    public TextField txtLongitude;
    public Button btnLimpar;
    public Button btnCadastrar;
    public Button btnVoltar;
    public TextArea txtArea;

    //fechar app
    public void clickFechar(javafx.event.ActionEvent event){
        System.exit(0);
    }

    //Limpar Formulário Cadastro
    public void clickLimpar(ActionEvent event){
        limparDados();
        txtArea.clear();
    }

    public void limparDados(){
        txtCodigoIATA.clear();
        txtNomeAeroporto.clear();
        txtPais.clear();
        txtLatitude.clear();
        txtLongitude.clear();
    }

    //voltar tela de login
    public void clickVoltar(javafx.event.ActionEvent event){
        Main.mudarScene("login");
    }

    public void clickCadastroAeroporto() {
        try{
            //limpar txtArea
            txtArea.clear();

            String codigoIATA = txtCodigoIATA.getText().toUpperCase();
            String nome = txtNomeAeroporto.getText();
            String pais = txtPais.getText().toUpperCase();
            double latitude = Double.parseDouble(txtLatitude.getText());
            double longitude = Double.parseDouble(txtLongitude.getText());

            if(codigoIATA.isEmpty()||nome.isEmpty()||pais.isEmpty()){
                System.out.println("Todos os campos devem ser preenchidos para fazer o cadastro.");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Todos os campos devem ser preenchidos para fazer o cadastro.");
                alert.show();
                return;

            }else{
                for(Aeroporto aeroportos : Dados.listaAeroportos){
                    if(aeroportos.getcodigoIATA().equalsIgnoreCase(codigoIATA)){
                        System.out.println("ERRO! Código já existente\nImpossível fazer o cadastro...");

                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setHeaderText("Código IATA já cadastrado!");
                        alert.setContentText("Informe um código IATA diferente...");
                        alert.show();
                        return;
                    }
                }
                Aeroporto novoAeroporto = new Aeroporto(codigoIATA, nome, pais, latitude, longitude);
                Dados.listaAeroportos.add(novoAeroporto);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Cadastrado");
                alert.setHeaderText("Aeroporto cadastrado com sucesso!");
                alert.show();
                txtArea.setText("Cadastro efetuado com sucesso!\n" + novoAeroporto.toString());
                System.out.println("Cadastro efetuado com sucesso!" + novoAeroporto.toString());
                return;
            }

        }catch (RuntimeException e){
            System.err.println("Você deve preencher corretamente todos os campos para fazer o cadastro.");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Você deve preencher corretamente todos os campos para fazer o cadastro.");
            alert.setContentText("Latitude e Longitude devem ser números para realizar a operação... ");
            alert.show();
        }finally {
            limparDados();
        }

    }
}
