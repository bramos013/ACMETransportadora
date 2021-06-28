package tela.Controles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage palco;

    private static Scene cadastroAeroportoScene;
    private static Scene cadastroCargaScene;
    private static Scene cadastroPfScene;
    private static Scene cadastroPjScene;
    private static Scene consultasAtendenteScene;
    private static Scene consultasGerenteScene;
    private static Scene loginScene;
    private static Scene menuAtendenteScene;
    private static Scene menuGerenteScene;
    private static Scene statusCargaScene;

    @Override
    public void start(Stage palcoPrimario) throws Exception{
        palco = palcoPrimario;
        palcoPrimario.setTitle("ACME Transportadora");

        //Atribuir as telas fxml à variáveis
        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("../login.fxml"));
        loginScene = new Scene(fxmlLogin,600,569);

        Parent fxmlCadastroAeroporto  = FXMLLoader.load(getClass().getResource("../cadastroAeroporto.fxml"));
        cadastroAeroportoScene = new Scene(fxmlCadastroAeroporto,600,569);

        Parent fxmlCadastroCarga  = FXMLLoader.load(getClass().getResource("../cadastroCarga.fxml"));
        cadastroCargaScene = new Scene(fxmlCadastroCarga,600,569);

        Parent fxmlCadastroPf  = FXMLLoader.load(getClass().getResource("../cadastroPF.fxml"));
        cadastroPfScene = new Scene(fxmlCadastroPf,600,569);

        Parent fxmlCadastroPj  = FXMLLoader.load(getClass().getResource("../cadastroPJ.fxml"));
        cadastroPjScene = new Scene(fxmlCadastroPj,600,569);

        Parent fxmlConsultasAtendente  = FXMLLoader.load(getClass().getResource("../consultasAtendente.fxml"));
        consultasAtendenteScene = new Scene(fxmlConsultasAtendente,600,569);

        Parent fxmlStatusCarga = FXMLLoader.load(getClass().getResource("../statusCarga.fxml"));
        statusCargaScene = new Scene(fxmlStatusCarga,600,569);

        Parent fxmlConsultasGerente  = FXMLLoader.load(getClass().getResource("../consultasGerente.fxml"));
        consultasGerenteScene = new Scene(fxmlConsultasGerente,600,569);

        Parent fxmlMenuAtendente  = FXMLLoader.load(getClass().getResource("../menuAtendente.fxml"));
        menuAtendenteScene = new Scene(fxmlMenuAtendente,600,569);

        Parent fxmlMenuGerente  = FXMLLoader.load(getClass().getResource("../menuGerente.fxml"));
        menuGerenteScene = new Scene(fxmlMenuGerente,600,569);

        //Não permitir alterar tmanho da tela
        palcoPrimario.setResizable(false);

        palcoPrimario.setScene(loginScene);
        palcoPrimario.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    //mudar de painel
    public static void mudarScene(String nomeScene){
        switch (nomeScene){
            case "login":
                palco.setScene(loginScene);
                break;

            case "cadastroAeroporto":
                palco.setScene(cadastroAeroportoScene);
                break;

            case "cadastroCarga":
                palco.setScene(cadastroCargaScene);
                break;

            case "cadastroPF":
                palco.setScene(cadastroPfScene);
                break;

            case "cadastroPJ":
                palco.setScene(cadastroPjScene);
                break;

            case "consultasAtendente":
                palco.setScene(consultasAtendenteScene);
                break;

            case "consultasGerente":
                palco.setScene(consultasGerenteScene);
                break;

            case "menuAtendente":
                palco.setScene(menuAtendenteScene);
                break;

            case "menuGerente":
                palco.setScene(menuGerenteScene);
                break;
            case "statusCarga":
                palco.setScene(statusCargaScene);
                break;
        }
    }




}

