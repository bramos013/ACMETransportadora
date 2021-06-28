package tela.Controles;

import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

public class ControllerConsultasAtendente {
    public MenuItem btnSair;
    public RadioButton rbCargas;
    public RadioButton rbClientes;
    public RadioButton rbAeroportos;
    public Button btnVoltar;
    public TextArea txtArea;

    //fechar app
    public void clickFechar(javafx.event.ActionEvent event){
        System.exit(0);
    }

    //voltar tela de login
    public void clickVoltar(javafx.event.ActionEvent event){
        Main.mudarScene("login");
    }
}
