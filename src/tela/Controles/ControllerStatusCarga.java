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

    //Busca a Carga e Chama o alterarSituacao
    public void alterarStatusCarga(ActionEvent event){              
        int codigoStatus = Integer.parseInt(txtCodigoStatus.getText());
        String opcao = "";
        RadioButton op = (RadioButton) statusCarga.getSelectedToggle();                            
        if(op.getText().equals("Cancelada")){
            opcao = "Cancelada";                        
            alteraSituacao(codigoStatus,opcao);
        }else if(op.getText().equals("Entregue")){
            alteraSituacao(codigoStatus,opcao);
        }        
    }           
    
    //Altera a situação da carga
    public String alteraSituacao(int codigo, String status) {
        int count = 0;
        for(int i = 0 ; i < Dados.listaCargas.size(); i++){
            if(Dados.listaCargas.get(i).getCodigo() == codigo){
                count++;
            }
        }
        if(count == 0){
            System.out.println("Carga não encontrada!");
            return null;
        }
    
        for(int i = 0; i < Dados.listaCargas.size(); i++){
            if(Dados.listaCargas.get(i).getSituacao().toUpperCase().equals("CANCELADA") || Dados.listaCargas.get(i).getSituacao().toUpperCase().equals("ENTREGUE")){
                System.out.println("Erro: Status não pode ser alterado!");
                return null;
            }
        }
    
        for(int i = 0 ; i < Dados.listaCargas.size(); i++){
            if(Dados.listaCargas.get(i).getCodigo() == codigo){
                if(status=="Cancelada"){
                    System.out.println("Alterando para 'Cancelada'");
                    Dados.listaCargas.get(i).setSituacao("Cancelada");
    
                }else if(status=="Entregue"){
                    System.out.println("Alterando para 'Entregue'");
                    Dados.listaCargas.get(i).setSituacao("Entregue");
                }
            }
        }
        System.out.println("Status alterado com sucesso!");
        return null;
    
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
