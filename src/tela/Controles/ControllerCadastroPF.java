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
            //System.out.println("Nome: " + nome);
        String endereco = txtEndereco.getText();        
            //System.out.println("Endereço: " + endereco);
        String email = txtEmail.getText();
            //System.out.println("E-mail: " + email);
        String cpf = txtCpf.getText();        
            //System.out.println("CPF: " + cpf);
        if(!Atendente.verificaEmail(email)){
            for(int i = 0; i < 2000; i++){
                System.out.println("");
            }
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Atenção");
            alert.setHeaderText("E-mail invalido");
            alert.setContentText("Informar um e-mail no padrão email@teste.com! ");
            alert.show();
            System.out.println("Entrada invalida, tente novamente");
        }

        System.out.println("CPF: " + cpf);


        ClientePF novoClientePF = new ClientePF(nome,email,endereco,cpf);
        txtArea.setText(toStringPF());
        System.out.println(novoClientePF.toString());
        Dados.listaClientes.add(novoClientePF);
        Dados.listaClientesPF.add(novoClientePF);
        limparDados();
    }

    //Limpar Formulário Cadastro
    public void clickLimpar(ActionEvent event){
        limparDados();
        txtArea.clear();
    }

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

