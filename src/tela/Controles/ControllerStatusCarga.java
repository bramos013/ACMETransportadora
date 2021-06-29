package tela.Controles;

import codigo.Atendente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ControllerStatusCarga {
    @FXML
    private ToggleGroup statusCarga;
    public RadioButton rbCancelada;
    public RadioButton rbEntregue;
    public Button btnStatusVoltar;
    public Button btnStatusConfirmar;
    public TextField txtCodigoStatus;
    public Atendente status;

    //Alterar Situacao Carga
    public void alterarStatusCarga(ActionEvent event){              
        int codigoStatus = Integer.parseInt(txtCodigoStatus.getText());
        RadioButton op = (RadioButton) statusCarga.getSelectedToggle();                            
        if(op.getText().equals("Cancelada")){
         String opcao = "Cancelada";               
         //status.alteraSituacao(codigoStatus, opcao);
         status.alteraSituacao(codigoStatus);
    /*
        }else if(op.getText().equals("Entregue")){
            status.alteraSituacao(codigoStatus,2);
        }
    */
        System.out.println("Código Status: " + codigoStatus+
                            "\nOpSelecionada " + opcao);
        }
    }
    //fechar app
    public void clickFechar(ActionEvent event){
        System.exit(0);
    }
    //voltar tela de login
    public void clickVoltar(ActionEvent event){
        Main.mudarScene("login");
    }

}
