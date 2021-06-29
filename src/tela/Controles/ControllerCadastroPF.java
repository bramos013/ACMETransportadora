package tela.Controles;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ControllerCadastroPF {
    public MenuItem btnSair;
    public TextField txtNome;
    public TextField txtEndereco;
    public TextField txtEmail;
    public TextField txtCpf;
    public Button btnLimpar;
    public Button btnCadastrar;
    public TextArea txtArea;
    public String clienteCadastrado;

    //fechar app
    public void clickFechar(ActionEvent event){
        System.exit(0);
    }
    
    //Cadastrar Cliente Fisico
    public void cadastrarClientePF(ActionEvent event) {
        String nome = txtNome.getText();
            System.out.println("Nome: " + nome);        
        String endereco = txtEndereco.getText();        
            System.out.println("Endereço: " + endereco);
        String email = txtEmail.getText();
            System.out.println("E-mail: " + email);        
        String cpf = txtCpf.getText();        
            System.out.println("CPF: " + cpf);

        txtArea.setText(toStringPF());
    }
    
    //Limpar Formulário Cadastro
    public void clickLimpar(ActionEvent event){
        txtNome.clear();
        txtEndereco.clear();
        txtEmail.clear();
        txtCpf.clear();        
        txtArea.clear();
    }

    //Voltar Menu
    public void clickVoltar(ActionEvent event){
    }

    //Mostrar os dados
    public String toStringPF() {
        return
        "Cliente Cadastrado "+
        "\nNome: " + txtNome.getText() +
        "\nEndereço: " + txtEndereco.getText() +
        "\nEmail: " + txtEmail.getText() +
        "\nCPF: " + txtCpf.getText();
    }   
}

