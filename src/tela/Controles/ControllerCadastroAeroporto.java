package tela.Controles;

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
    public TextArea txtArea;

    //fechar app
    public void clickFechar(javafx.event.ActionEvent event){
        System.exit(0);
    }

}
