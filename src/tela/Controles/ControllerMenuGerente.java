package tela.Controles;

import codigo.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    public TextArea txtArea;

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

        simulacao();
    }

    public void simulacao(){
        String txt="";

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

        System.out.println("Enviando Carga de Acme...");
        txt = txt + "Enviando Carga de Acme...\n";
        cargaAcme.enviar();

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

        System.out.println("Fim da Simulação");
        txt = txt + "Fim da Simulação";

        txtArea.setText(txt);
    }



}
