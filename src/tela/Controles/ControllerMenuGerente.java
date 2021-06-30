package tela.Controles;

import codigo.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ControllerMenuGerente {
    @FXML
    private ToggleGroup OptionGerente;
    public MenuItem btnSair;
    public RadioButton rbCadastroCliente;
    public RadioButton rbConsulta;
    public RadioButton rbCadastroCarga;
    public RadioButton rbAlterarSituacaoCarga;
    public RadioButton rbCadastroAeroporto;
    public Button btnVoltar;
    public Button btnConfirmar;
    public Button btnSimular;
    public Button btnGravaTxt;
    public TextArea txtArea;
    public String txt="";

    //fechar app
    public void clickFechar(javafx.event.ActionEvent event){
        System.exit(0);
    }

    //voltar tela de login
    public void clickVoltar(javafx.event.ActionEvent event){
        Main.mudarScene("login");
    }

    //Mudar painel
    public void clickConfirmar(javafx.event.ActionEvent event){
        RadioButton opSelecionada = (RadioButton) OptionGerente.getSelectedToggle();
        String opUsuario = opSelecionada.getText();

        switch (opUsuario){
            case "Cadastrar Cliente PF":
                Main.mudarScene("cadastroPF");
                break;

            case "Cadastrar Cliente PJ":
                Main.mudarScene("cadastroPJ");
                break;

            case "Realizar Consulta (Gerente)":
                Main.mudarScene("consultasGerente");
                break;

            case "Cadastrar Carga":
                Main.mudarScene("cadastroCarga");
                break;

            case "Alterar Situaçao da Carga":
                Main.mudarScene("statusCarga");
                break;

            case "Cadastrar Aeroporto":
                Main.mudarScene("cadastroAeroporto");
                break;

        }


    }

    public void clickSimular(javafx.event.ActionEvent event){
        //Permitir simular apenas 1x
        btnSimular.setDisable(true);
        //Pop up de Alerta
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Atenção");
        alert.setHeaderText("Só é possivel realizar uma única simulação");
        alert.setContentText("Para simular novamente, feche o programa...");
        alert.show();

        simulacao();
    }

    public void simulacao(){
        System.out.println("Cadastrando aeroporto Guarulhos");
        txt = txt + "Cadastrando aeroporto Guarulhos\n";
        Aeroporto gru = new Aeroporto("GRU", "Guarulhos", "Brasil", -23.4, -46.4);
        Dados.listaAeroportos.add(gru);

        System.out.println("Cadastrando aeroporto Salgado Filho");
        txt = txt + "Cadastrando aeroporto Salgado Filho\n";
        Aeroporto poa = new Aeroporto("POA", "Salgado Filho", "Brasil", -29.9, -51);
        Dados.listaAeroportos.add(poa);

        System.out.println("Cadastrando aeroporto Heathrow");
        txt = txt + "Cadastrando aeroporto Heathrow\n";
        Aeroporto lhr = new Aeroporto("LHR", "Heathrow", "Inglaterra", 51.4, -0.4);
        Dados.listaAeroportos.add(lhr);

        System.out.println("Cadastrando cliente Maria...");
        txt = txt + "Cadastrando cliente Maria\n";
        ClientePF maria = new ClientePF("Maria", "maria@hotmail.com", "3186 Garrison Union Apt. 362 - Sumter, WY ", "123.456.789-01");
        Dados.listaClientes.add(maria);
        Dados.listaClientesPF.add(maria);

        System.out.println("Cadastrando cliente ACME Corporation");
        txt = txt + "Cadastrando cliente ACME Corporation\n";
        ClientePJ acme = new ClientePJ("ACME Corp", "acme_corp@yahoo.com", "874 Toy Green Suite 335 - Fayetteville, WI", "12.345.678/0001-01", "ACME Corporation");
        Dados.listaClientes.add(acme);
        Dados.listaClientesPJ.add(acme);

        System.out.println("Cadastrando Carga de Maria: Origem--> Salgado Filho | Destino--> Guarulhos");
        txt = txt + "Cadastrando Carga de Maria: Origem--> Salgado Filho | Destino--> Guarulhos\n";
        CargaNacional cargaMaria = new CargaNacional(111, 0.2, 0.2, 0.2, 1, poa, gru, maria, 50);
        Dados.listaCargas.add(cargaMaria);

        System.out.println("Calculando Frete de Maria...");
        txt = txt + "Calculando Frete de Maria...\n";
        cargaMaria.calculaFrete(cargaMaria.getCliente());

        System.out.println("Cadastrando Carga de Acme Corp: Origem--> Heathrow | Destino--> Salgado Filho");
        txt = txt + "Cadastrando Carga de Acme Corp: Origem--> Heathrow | Destino--> Salgado Filho\n";
        CargaInternacional cargaAcme = new CargaInternacional(555, 1, 1, 1, 10, lhr, poa, acme, lhr.getPais(), 100);
        Dados.listaCargas.add(cargaAcme);

        System.out.println("Calculando Frete de Acme...");
        txt = txt + "Calculando Frete de Acme...\n";
        cargaAcme.calculaFrete(cargaAcme.getCliente());

        System.out.println("Enviando Carga de Maria...");
        txt = txt + "Enviando Carga de Maria...\n";
        cargaMaria.enviar();

        System.out.println("-----LISTA DE AEROPORTOS-----");
        txt = txt + "\n-----LISTA DE AEROPORTOS-----\n";
        if(Dados.listaAeroportos.size()==0){
            System.out.println("\nNenhum Aeroporto cadastrado!");
            txt = txt + "\nNenhum Aeroporto cadastrado!";

        }else{
            for(int i = 0; i < Dados.listaAeroportos.size(); i++){
                txt = txt + Dados.listaAeroportos.get(i).toString();
                System.out.println(Dados.listaAeroportos.get(i).toString());
            }
        }

        System.out.println("\n-----LISTA DE CLIENTES-----");
        txt = txt + "\n-----LISTA DE CLIENTES-----\n";
        if(Dados.listaClientes.size()==0){
            System.out.println("Nenhum Cliente cadastrado!");
            txt = txt + "\nNenhum Cliente cadastrado!";

        }else{
            for(int i = 0; i < Dados.listaClientes.size(); i++){
                txt = txt + Dados.listaClientes.get(i).toString();
                System.out.println(Dados.listaClientes.get(i).toString());
            }
        }

        System.out.println("\n-----LISTA DE CARGAS-----");
        txt = txt + "\n-----LISTA DE CARGAS-----\n";
        if(Dados.listaCargas.size()==0){
            System.out.println("Nenhuma Carga cadastrada!");
            txt = txt + "\nNenhuma Carga cadastrada!";

        }else{
            for(int i = 0; i < Dados.listaCargas.size(); i++){
                txt = txt + "\nCarga " + (i + 1) + ":" + Dados.listaCargas.get(i).toString();
                System.out.println("\nCarga " + (i + 1) + ":" + Dados.listaCargas.get(i).toString());
            }
        }

        System.out.println("\nFim da Simulação");
        txt = txt + "\nFim da Simulação";

        txtArea.setText(txt);
    }

    public void clickCarregaDadosEmArquivo(){
        try{
            System.out.println("\nInforme um arquivo .txt existente!\nArquivo utilizado: Arquivo.txt");
            String path = "Arquivo.txt";

            System.out.println("\nArmazenando dados no arquivo informado...");
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))){
                //Escrever no arquivo
                bw.write(txt);
                //Quebrar linha
                bw.newLine();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Armazenamento de dados foi executada com sucesso!");
                alert.setContentText("Consulte o arquivo 'Arquivo.txt' para vizualizar os dados");
                alert.show();
            }
            catch (IOException e){
                System.err.println("Erro no armazenamento..." + e.getMessage());
            }

        }
        catch (NullPointerException e){
            System.err.println("Erro! " + e.getMessage());
        }
        finally {
            System.out.println("Operação finalizada...");
        }
    }

}
