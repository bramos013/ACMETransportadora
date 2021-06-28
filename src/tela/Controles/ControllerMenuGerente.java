package tela.Controles;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ControllerMenuGerente {
    @FXML
    private ToggleGroup OptionGerente;
    public MenuItem btnSair;
    public RadioButton rbCadastroCliente;
    public RadioButton rbConsulta;
    public RadioButton rbCadastroCarga;
    public RadioButton rbAlterarSituacaoCarga;
    public RadioButton rbCadastroAeroporto;
    public Button btnVoltar;
    public Button btnConfirmar;
    public Button btnSimular;
    public TextArea txtArea;

    //fechar app
    public void clickFechar(javafx.event.ActionEvent event){
        System.exit(0);
    }

    //voltar tela de login
    public void clickVoltar(javafx.event.ActionEvent event){
        Main.mudarScene("login");
    }

    //Mudar painel
    public void clickConfirmar(javafx.event.ActionEvent event){
        RadioButton opSelecionada = (RadioButton) OptionGerente.getSelectedToggle();
        String opUsuario = opSelecionada.getText();

        switch (opUsuario){
            case "Cadastrar Cliente PF":
                Main.mudarScene("cadastroPF");
                break;

            case "Cadastrar Cliente PJ":
                Main.mudarScene("cadastroPJ");
                break;

            case "Realizar Consulta (Gerente)":
                Main.mudarScene("consultasGerente");
                break;

            case "Cadastrar Carga":
                Main.mudarScene("cadastroCarga");
                break;

            case "Alterar Situaçao da Carga":
                Main.mudarScene("statusCarga");
                break;

            case "Cadastrar Aeroporto":
                Main.mudarScene("cadastroAeroporto");
                break;

        }


    }

    public void clickSimular(javafx.event.ActionEvent event){



    }


}
