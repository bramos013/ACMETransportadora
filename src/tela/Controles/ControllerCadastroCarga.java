package tela.Controles;

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
    public TextArea txtArea;

    //fechar app
    public void clickFechar(javafx.event.ActionEvent event){
        System.exit(0);
    }
}
