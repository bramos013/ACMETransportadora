package tela.Controles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ControllerLogin {
    @FXML
    private ToggleGroup login;
    public MenuItem btnSair;
    public RadioButton rbAtendente;
    public RadioButton rbGerente;
    public Button btnEntrar;
    public TextArea txtArea;

    //fechar app
    public void clickFechar(ActionEvent event){
        System.exit(0);
    }

    //entrar em um menu
    public void clickEntrar(ActionEvent event){
        RadioButton opSelecionada = (RadioButton) login.getSelectedToggle();

        if(opSelecionada.getText().equals("Atendente")){
            Main.mudarScene("menuAtendente");
            rbGerente.setDisable(true);

        }else if(opSelecionada.getText().equals("Gerente")){
            Main.mudarScene("menuGerente");
            rbAtendente.setDisable(true);
        }

    }



}


