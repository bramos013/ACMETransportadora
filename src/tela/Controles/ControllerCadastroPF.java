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
    public String clienteCadastrado;
    

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
            
        if(!Atendente.verificaEmail(email)){
            for(int i = 0; i < 2000; i++){
                System.out.println("");
            }
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Atenção");
            alert.setHeaderText("E-mail invalido");
            alert.setContentText("Informar um e-mail no padrão email@teste.com! ");
            alert.show();
        }

        ClientePF novoClientePF = new ClientePF(nome,email,endereco,cpf);
        txtArea.setText(novoClientePF.toString());
        Dados.listaClientes.add(novoClientePF);
        Dados.listaClientesPF.add(novoClientePF);
        limparDados();
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

