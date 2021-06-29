package tela.Controles;

import codigo.Aeroporto;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
        //limpar txtArea
        txtArea.clear();

        String codigoIATA = txtCodigoIATA.getText().toUpperCase();
        String nome = txtNomeAeroporto.getText();
        String pais = txtPais.getText().toUpperCase();
        double latitude = Double.parseDouble(txtLatitude.getText());
        double longitude = Double.parseDouble(txtLongitude.getText());

        for(Aeroporto aeroportos : Dados.listaAeroportos){
            if(aeroportos.getcodigoIATA().equalsIgnoreCase(codigoIATA)){
                System.out.println("ERRO! Código já existente\nImpossível fazer o cadastro...");
                txtArea.setText("ERRO! Código já existente\nImpossível fazer o cadastro...");
                return;
            }
        }
        Aeroporto novoAeroporto = new Aeroporto(codigoIATA, nome, pais, latitude, longitude);
        Dados.listaAeroportos.add(novoAeroporto);

        txtArea.setText("Cadastro efetuado com sucesso!\n" + novoAeroporto.toString());
        System.out.println("Cadastro efetuado com sucesso!" + novoAeroporto.toString());
        limparDados();
    }
}
