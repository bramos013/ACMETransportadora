package tela.Controles;

import codigo.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ControllerConsultasGerente {
    @FXML
    private ToggleGroup consultas;
    public MenuItem btnSair;
    public RadioButton rbCargas;
    public RadioButton rbClientes;
    public RadioButton rbAeroportos;
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

    public void clickConfirmar(javafx.event.ActionEvent event){
        //limpar tela
        txtArea.clear();

        RadioButton opSelecionada = (RadioButton) consultas.getSelectedToggle();

        if(opSelecionada.getText().equals("Clientes")){
            consultaClientes();

        }else if(opSelecionada.getText().equals("Cargas")){
            consultaCargas();

        }else if(opSelecionada.getText().equals("Aeroportos")){
            consultaAeroportos();
        }
    }

    public void consultaCargas() {
        String txt ="";
        if(Dados.listaCargas.size()==0){
            System.out.println("Nenhuma Carga cadastrada!");
            txtArea.setText("Nenhuma Carga cadastrada!");

        }else{
            for(int i = 0; i < Dados.listaCargas.size(); i++){
                txt = txt + "\nCarga " + (i + 1) + ":" + Dados.listaCargas.get(i).toString();
            }
            System.out.println(txt);
            txtArea.setText(txt);
        }

    }

    public void consultaClientes() {
        String txt ="";
        if(Dados.listaClientes.size()==0){
            System.out.println("Nenhum Cliente cadastrado!");
            txtArea.setText("Nenhum Cliente cadastrado!");

        }else{
            for(int i = 0; i < Dados.listaClientes.size(); i++){
                txt = txt + Dados.listaClientes.get(i).toString();
            }
            System.out.println(txt);
            txtArea.setText(txt);
        }

    }

    public void consultaAeroportos() {
        String txt ="";
        if(Dados.listaAeroportos.size()==0){
            System.out.println("Nenhum Aeroporto cadastrado!");
            txtArea.setText("Nenhum Aeroporto cadastrado!");

        }else{
            for(int i = 0; i < Dados.listaAeroportos.size(); i++){
                txt = txt + Dados.listaAeroportos.get(i).toString();
            }
            System.out.println(txt);
            txtArea.setText(txt);
        }

    }

}
