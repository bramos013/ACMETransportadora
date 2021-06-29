package tela.Controles;

import codigo.Atendente;
import codigo.ClientePJ;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ControllerCadastroPJ {
    public MenuItem btnSair;
    public TextField txtNome;
    public TextField txtEndereco;
    public TextField txtEmail;
    public TextField txtCnpj;
    public TextField txtNomeFantasia;
    public Button btnLimpar;
    public Button btnCadastrar;
    public TextArea txtArea;

    //Cadastrar Cliente Juridico
    public void cadastrarClientePJ(ActionEvent event) {
        String nome = txtNome.getText();            
        String endereco = txtEndereco.getText();                    
        String email = txtEmail.getText();            
        String cnpj = txtCnpj.getText();
        String nomeFantasia = txtNomeFantasia.getText();

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

        ClientePJ novoClientePJ = new ClientePJ(nome,email,endereco,cnpj,nomeFantasia);
        txtArea.setText(toStringPJ());
        System.out.println(novoClientePJ.toString());
        Dados.listaClientes.add(novoClientePJ);
        Dados.listaClientesPJ.add(novoClientePJ);
        limparDados();
    }

    //fechar app
    public void clickFechar(ActionEvent event){
        System.exit(0);
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
            txtCnpj.clear();
            txtNomeFantasia.clear();
        }
    
    //voltar tela de login
    public void clickVoltar(ActionEvent event){
            Main.mudarScene("login");
        }

    //Mostrar os dados
    public String toStringPJ() {
        return
            "Cliente Cadastrado "+
            "\nNome: " + txtNome.getText() +
            "\nEndereço: " + txtEndereco.getText() +
            "\nEmail: " + txtEmail.getText() +
            "\nCNPJ: " + txtCnpj.getText()+
            "\nNome Fantasia: " + txtNomeFantasia.getText();
    }
}
