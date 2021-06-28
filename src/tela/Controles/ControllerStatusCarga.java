package tela.Controles;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class ControllerStatusCarga {
    public RadioButton rbCancelada;
    public RadioButton rbEntregue;
    public Button btnStatusVoltar;
    public Button btnStatusConfirmar;

    //fechar app
    public void clickFechar(javafx.event.ActionEvent event){
        System.exit(0);
    }

    //voltar tela de login
    public void clickVoltar(javafx.event.ActionEvent event){
        Main.mudarScene("login");
    }
}
