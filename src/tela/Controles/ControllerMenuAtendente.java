package tela.Controles;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ControllerMenuAtendente {
    @FXML
    private ToggleGroup OptionAtendente;
    public MenuItem btnSair;
    public RadioButton rbCadastroCliente;
    public RadioButton rbConsulta;
    public RadioButton rbCadastroCarga;
    public RadioButton rbStatusCarga;
    public Button btnVoltar;
    public Button btnConfirmar;
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
        RadioButton opSelecionada = (RadioButton) OptionAtendente.getSelectedToggle();
        String opUsuario = opSelecionada.getText();

        switch (opUsuario){
            case "Cadastrar Cliente PF":
                Main.mudarScene("cadastroPF");
                break;

            case "Cadastrar Cliente PJ":
                Main.mudarScene("cadastroPJ");
                break;

            case "Realizar Consulta (Atendente)":
                Main.mudarScene("consultasAtendente");
                break;

            case "Cadastrar Carga":
                Main.mudarScene("cadastroCarga");
                break;

            case "Alterar Situaçao da Carga":
                Main.mudarScene("statusCarga");
                break;
        }

    }
}
