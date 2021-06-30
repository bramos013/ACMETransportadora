package tela.Controles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ControllerStatusCarga {
    @FXML
    private ToggleGroup statusCarga;
    public RadioButton rbCancelada;
    public RadioButton rbEntregue;
    public Button btnStatusVoltar;
    public Button btnStatusConfirmar;
    public TextField txtCodigoStatus;

    //Busca a Carga e Chama o alterarSituacao
    public void alterarStatusCarga(ActionEvent event){
        try{
            int codigoStatus = Integer.parseInt(txtCodigoStatus.getText());
            String opcao = "";
            RadioButton op = (RadioButton) statusCarga.getSelectedToggle();
            if(op.getText().equals("Cancelada")){
                opcao = "Cancelada";
                alteraSituacao(codigoStatus,opcao);
            }else if(op.getText().equals("Entregue")){
                alteraSituacao(codigoStatus,opcao);
            }
        }catch (RuntimeException e){
            System.err.println("Código deve composto apenas por números");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("O código deve ser composto apenas por números");
            alert.setContentText("Coloque o código corretamente para realizar a operação... ");
            alert.show();
        }finally {
            txtCodigoStatus.clear();
        }

    }
    
    //Altera a situação da carga
    public void alteraSituacao(int codigo, String status) {
        int count = 0;
        for(int i = 0 ; i < Dados.listaCargas.size(); i++){
            if(Dados.listaCargas.get(i).getCodigo() == codigo){
                count++;
            }
        }
        if(count == 0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Carga não encontrada");
            alert.setContentText("Informe um novo código para realizar a operação... ");
            alert.show();
            return;
        }
    
        for(int i = 0; i < Dados.listaCargas.size(); i++){
            if(Dados.listaCargas.get(i).getCodigo() == codigo){
                if(Dados.listaCargas.get(i).getSituacao().equalsIgnoreCase("Cancelada") || Dados.listaCargas.get(i).getSituacao().equalsIgnoreCase("Entregue")) {                    
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("Cargas com status CANCELADA ou ENTREGUE não podem ser alteradas!");
                    alert.setContentText("Informe um novo código para realizar a operação... ");
                    alert.show();
                    return;

                }else{
                    if(status.equalsIgnoreCase("Cancelada")){
                        Dados.listaCargas.get(i).setSituacao("Cancelada");
                    }else if(status.equalsIgnoreCase("Entregue")){
                        Dados.listaCargas.get(i).setSituacao("Entregue");
                    }
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Atualizado");
                    alert.setHeaderText("Status alterado com sucesso!");
                    alert.show();
                    return;
                }
            }
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
