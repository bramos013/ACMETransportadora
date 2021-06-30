package tela.Controles;

import codigo.Atendente;
import codigo.ClientePF;
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
    

    //fechar app
    public void clickFechar(ActionEvent event){
        System.exit(0);
    }
    
    //Cadastrar Cliente Fisico
    public void cadastrarClientePF(ActionEvent event) {
        String nome = txtNome.getText();            
        String endereco = txtEndereco.getText();                    
        String email = txtEmail.getText();            
        String cpf = txtCpf.getText();        

        if(nome.equals("")||endereco.equals("")||email.equals("")||cpf.equals("")){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Atenção");
            alert.setHeaderText("Entrada inválida!");
            alert.setContentText("Você deve preencher todos os campos para realizar o cadastro.");
            alert.show();
            limparDados();
            return;

        }else if(!Atendente.verificaEmail(email)){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Atenção");
            alert.setHeaderText("E-mail invalido");
            alert.setContentText("Informar um e-mail no padrão email@teste.com! ");
            alert.show();
            limparDados();
            return;

        }else{
            ClientePF novoClientePF = new ClientePF(nome,email,endereco,cpf);
            txtArea.setText(novoClientePF.toString());
            Dados.listaClientes.add(novoClientePF);
            Dados.listaClientesPF.add(novoClientePF);
            limparDados();
            return;
        }
    }

    //Limpar Formulário Cadastro
    public void clickLimpar(ActionEvent event){
        limparDados();
        txtArea.clear();
    }

    //Limpar Dados Informado pelo usuário
    public void limparDados(){
        txtNome.clear();
        txtEndereco.clear();
        txtEmail.clear();
        txtCpf.clear();
    }

    //voltar tela de login
    public void clickVoltar(javafx.event.ActionEvent event){
        Main.mudarScene("login");
    }

}

