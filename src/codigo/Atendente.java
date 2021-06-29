package codigo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Atendente {

    private Scanner read = new Scanner(System.in);

    List<Carga> listaDeCargas = new ArrayList<>();

    List<ClientePF> listaDeClientesPF = new ArrayList<>();

    List<ClientePJ> listaDeClientesPJ = new ArrayList<>();

    List<Aeroporto> listaDeAeroportos = new ArrayList<>();

    public static Boolean verificaEmail(String email){
        //Cria variaveis e converte a String em um Array de Char
        int arroba, ponto, fimComPonto, medidorDeArrobas;
        arroba = 0;
        ponto = 0;
        fimComPonto = 0;
        medidorDeArrobas = 0;
        char[] emailChar = email.toCharArray();

        //verifica se e uma string vazia
        if(email.equals("")){
            return false;
        }

        //Verifica se o ultimo digito e um ponto
        if(emailChar[emailChar.length - 1] == '.'){
            return false;
        }
        else{
            //Marca que o ultimo digito nao e um ponto
            fimComPonto = 1;

            //inicia o for para verificar o resto do email para ver se e valido
            for(int i = 0; i < emailChar.length; i++){
                //variavel booleana para verificar se e caractere especial ou letra
                Boolean flag = Character.isLetterOrDigit(emailChar[i]);

                //variavel booleana para verificar se e numero
                Boolean bool = Character.isDigit(emailChar[i]);

                //faz verificacoes por meio de if e else para confirmar que tem apenas um arroba, que nao tem ponto logo depois do arroba,
                //que nao tem caractere especial depois do arroba alem do ponto, assim como pra verificar se nao tem digitos depois do arroba
                if(i == 0 && emailChar[i] == '@'){
                    return false;
                }
                else if(i == (emailChar.length - 1) && emailChar[i] == '.'){
                    return false;
                }
                else if(emailChar[i] == '@'){
                    arroba = 1;
                    medidorDeArrobas = i;
                }
                else if(arroba == 1 && emailChar[i] == '@' && i != medidorDeArrobas){
                    return false;
                }
                else if(arroba == 1 && emailChar[i] == '.' && emailChar[i - 1] == '@'){
                    return false;
                }
                else if(arroba == 1 && emailChar[i] == '~'){
                    return false;
                }
                else if(arroba == 1 && ((!flag && emailChar[i] != '.') || bool)){
                    return false;
                }
                else if(arroba == 1 && emailChar[i] == '.'){
                    ponto = 1;
                }
            }
        }

        //Se nao ficou com 1 em algum destes quer dizer que o email e invalido
        if(arroba == 0 || ponto == 0 || fimComPonto == 0){
            return false;
        }
        else{
            return true;
        }
    }

    /*public Boolean verificaInteiro(String inteiro){
        //faz um laco de repeticao para percorrer a string
        for(int i = 0; i < inteiro.length(); i++){
            //verifica em cada ponto da string se e um numero ou qualquer outro caractere, se nao for numero retorna falso
            if(!Character.isDigit(inteiro.charAt(i))){
                return false;
            }
        }

        //se em nenhum momento retornou falso, retorna true
        return true;
    }

     */

    //Verifica se o CNPJ já existe no Sistema - ok
    private boolean validaCPF(String CPF){
        boolean novoCPF = true;
        for(ClientePF lista : listaDeClientesPF){
            if(lista.getCpf().equals(CPF)){
                System.out.println("CPF Existente");
                return novoCPF = false;
            }
        }
        return novoCPF;
    }

    //Verifica se o CNPJ já existe no Sistema - ok
    private boolean validaCNPJ(String CNPJ){
        boolean novoCNPJ = true;
        for(ClientePJ lista : listaDeClientesPJ){
            if(lista.getCnpj().equals(CNPJ)){
                System.out.println("CNPJ Existente");
                return novoCNPJ = false;
            }
        }
        return novoCNPJ;
    }

    //Verifica se o cpf é válido
    private boolean verificaCPF(String cpf){
        //Verifica se ta vazio
        if(cpf.equals("")){
            return false;
        }

        //verifica se tem digitos suficiente
        if(cpf.length() < 14){
            return false;
        }

        //inicia um laco de repeticao para percorrer toda a string
        for(int i = 0; i < cpf.length(); i++){
            switch(i){
                //verifica se o i e igual a 4 para ver se e o primeiro ponto do cpf
                case 3:
                    if(cpf.charAt(i) != '.'){
                        System.out.println("sem primeiro ponto");
                        return false;
                    }
                    break;

                //verifica se o i e igual a 8 para ver se e o segundo ponto do cpf
                case 7:
                    if(cpf.charAt(i) != '.'){
                        System.out.println("sem segundo ponto");
                        return false;
                    }
                    break;

                //verifica se o i e igual a 12 para ver se e o traco do cpf
                case 11:
                    if(cpf.charAt(i) != '-'){
                        System.out.println("sem traco");
                        return false;
                    }
                    break;

                default:
                    //verifica se i e menor do que 14, que e o tamanho maximo de um cpf
                    if(i < 14){
                        //se for menor do que catorze ele verifica se e um numero, ja que n vai entrar aqui quando entrar nos outros case,
                        //se nao for ele retorna falso
                        if(!Character.isDigit(cpf.charAt(i))){
                            System.out.println("Viu que em " + i + " tem algo q n e numero");
                            return false;
                        }
                    }
                    else if(cpf.charAt(i) != ' '){
                        //caso seja maior do que 14 ele verifica se o digito e um espaco em branco, se nao for retorna falso
                        System.out.println("Achou digito depois dos 14 caractere");
                        return false;
                    }
                    break;
            }
        }

        //se chegar ate aqui retorna verdadeiro
        return validaCPF(cpf);
    }

    //Verifica se o cnpj é válido
    private boolean verificaCNPJ(String cnpj){
        //faz mais ou menos o mesmo que o cpf, so que com a quantidade de digitos de um cnpj sendo ou nao so numeros
        if(cnpj.equals("")){
            return false;
        }


        if(cnpj.length() < 18){
            return false;
        }

        for(int i = 0; i < cnpj.length(); i++){
            switch(i){
                case 2:
                    if(cnpj.charAt(i) != '.'){
                        return false;
                    }
                    break;
                case 6:
                    if(cnpj.charAt(i) != '.'){
                        return false;
                    }
                    break;
                case 10:
                    if(cnpj.charAt(i) != '/'){
                        return false;
                    }
                    break;
                case 15:
                    if(cnpj.charAt(i) != '-'){
                        return false;
                    }
                    break;
                default:
                    if(i < 18){
                        if(!Character.isDigit(cnpj.charAt(i))){
                            return false;
                        }
                    }
                    else if(cnpj.charAt(i) != ' '){
                        return false;
                    }
                    break;
            }
        }

        return validaCNPJ(cnpj);
    }

    public void cadastroCliente() {
        String tipoCliente = "";
        String nome = "";
        String email = "";
        String endereco = "";
        String cpf = "";
        String cnpj = "";
        String nomeFantasia = "";

        while(!(tipoCliente.equals("1") || tipoCliente.equals("2"))){
            System.out.println("1 - Cliente Pessoa Fisica");
            System.out.println("2 - Cliente Pessoa Juridica");
            System.out.println("Qual o tipo de Cliente? ");
            tipoCliente = read.next();
            if(!(tipoCliente.equals("1") || tipoCliente.equals("2"))){
                for(int i = 0; i < 2000; i++){
                    System.out.println("");
                }
                System.out.println("Entrada invalida, tente novamente");
            }
        }

        System.out.println("Digite o nome: ");
        nome = read.next();
        read.nextLine();
        System.out.println("Digite o endereco: ");
        endereco = read.next();

        while(!verificaEmail(email)){
            System.out.println("Digite um email: ");
            email = read.next();
            if(!verificaEmail(email)){
                for(int i = 0; i < 2000; i++){
                    System.out.println("");
                }
                System.out.println("Entrada invalida, tente novamente");
            }
        }

        switch(tipoCliente){
            case "1":
                boolean continua=true;
                while(continua){

                    System.out.println("Exemplo: 012.345.678-90\n");
                    System.out.println("Digite o seu CPF no padrão do exemplo acima\n");
                    cpf = read.next();

                    if(verificaCPF(cpf)){
                        listaDeClientesPF.add(new ClientePF(nome, email, endereco, cpf));
                        continua=false;
                    }else{
                        System.out.println("Entrada invalida, tente novamente");
                    }

                }


                break;

            case "2":
                continua = true;
                while(continua){
                    System.out.println("01.234.567/8901-23\n");
                    System.out.println("Digite o seu CNPJ no padrão do exemplo acima\n");
                    cnpj = read.next();

                    if(verificaCNPJ(cnpj)){
                        System.out.println("Digite o nome fantasia da empresa: ");
                        nomeFantasia = read.next();

                        listaDeClientesPJ.add(new ClientePJ(nome, email, endereco, cnpj, nomeFantasia));
                        continua=false;
                    }else{
                        System.out.println("Entrada invalida, tente novamente");
                    }
                }

                break;
        }
    }

    public void cadastroCarga() {

        //codigo, altura, largura, profundidade, peso, origem, destino, cliente

        int codigo = listaDeCargas.size();
        double altura = 0;
        double largura = 0;
        double profundidade = 0;
        double peso = 0;
        Aeroporto origem  = null;
        Aeroporto destino = null;
        Cliente cliente = null;
        String tipoCarga = "";
        String continua = "";
        double taxaISQN = 0;
        double taxaAlfandega = 0;


        //Escolher o tipo da carga
        while(!(tipoCarga.equals("1") || tipoCarga.equals("2"))){
            System.out.println("1 - Carga Nacional");
            System.out.println("2 - Carga Internacional");
            System.out.println("Qual o tipo de Carga? ");
            tipoCarga = read.next();
            if(!(tipoCarga.equals("1") || tipoCarga.equals("2"))){
                for(int i = 0; i < 20; i++){
                    System.out.println("");
                }
                System.out.println("Entrada invalida, tente novamente");
            }
        }

        //Informar os dados da carga
        System.out.println("Informe os seguintes dados da Carga: ");

        System.out.println("Altura: ");
        altura = read.nextDouble();
        System.out.println("Largura: ");
        largura = read.nextDouble();
        System.out.println("Profundidade: ");
        profundidade = read.nextDouble();
        System.out.println("Peso: ");
        peso = read.nextDouble();

        //Seleciona o aeroporto Destino
        while(continua.equals("")){
            System.out.println("Selecione o Destino da Carga: ");
            destino = selecionaAeroporto();
            if(!destino.getPais().toUpperCase().equals("BRASIL")){
                System.out.println("Pais invalido, tente novamente");
            }else{
                continua = "x";
            }
        }

        continua = "";
        //Seleciona Aeroporto Origem
        switch(tipoCarga) {
            case "1":
                while (continua.equals("")) {
                    System.out.println("Selecione a Origem da Carga: ");
                    origem = selecionaAeroporto();
                    if (!origem.getPais().toUpperCase().equals("BRASIL")) {
                        System.out.println("Pais invalido, tente novamente");
                    } else {
                        continua = "x";
                    }
                }
                break;
            case "2":
                while (continua.equals("")) {
                    System.out.println("Selecione a Origem da Carga: ");
                    origem = selecionaAeroporto();
                    if (origem.getPais().toUpperCase().equals("BRASIL")) {
                        System.out.println("Pais inválido, tente novamente");
                    } else {
                        continua = "x";
                    }
                }
                break;
            default:
                System.out.println("Nao entrei no Pais Origem");
                break;

        }

        //Seleciona o tipo de cliente PF ou PJ
        String tipoCliente = "";
        while(!(tipoCliente.equals("1") || tipoCliente.equals("2"))){
            System.out.println("1 - Cliente Pessoa Fisica");
            System.out.println("2 - Cliente Pessoa Juridica");
            System.out.println("Qual o tipo de Cliente? ");
            tipoCliente = read.next();
            if(!(tipoCliente.equals("1") || tipoCliente.equals("2"))){
                for(int i = 0; i < 20; i++){
                    System.out.println("");
                }
                System.out.println("Entrada invalida, tente novamente");
            }
        }

        //Verificação do cliente
        switch(tipoCliente){
            case "1":
                boolean vdd=true;
                while(vdd){
                    consultaClientes();
                    System.out.println("Insira CPF do cliente: ");
                    String cpf=read.next();
                    if(validaCPF(cpf)){
                        System.out.println("Cliente não cadastrado no sistema");
                        System.out.println("Informe outro CPF...");
                    }else{
                        System.out.println("CPF Cadastrado!");
                        for(ClientePF pf:listaDeClientesPF){
                            if(pf.getCpf().equals(cpf)){
                                cliente=pf;
                            }

                            vdd=false;
                        }
                    }
                }
                break;


            case "2":
                boolean vddd=true;
                while(vddd){
                    consultaClientes();
                    System.out.println("Insira CNPJ do cliente: ");
                    String cnpj=read.next();
                    if(validaCNPJ(cnpj)){
                        System.out.println("Cliente não cadastrado no sistema");
                        System.out.println("Informe outro CNPJ...");
                    }else{
                        System.out.println("CNPJ Cadastrado!");

                        for(ClientePJ pj:listaDeClientesPJ){
                            if(pj.getCnpj().equals(cnpj)){
                                cliente=pj;
                            }
                            vddd=false;
                        }
                    }
                }
                break;
        }

        //Criar a carga e fazer o calculo do frete
        //Acrescentar dados do aerporto e do cliente vinculado

        if(tipoCarga.equals("1")){//Nacional
            System.out.println("Informe a taxa ISQN: ");
            taxaISQN=read.nextDouble();

            CargaNacional novaCargaNacional=new CargaNacional(codigo, altura, largura, profundidade, peso, origem, destino, cliente, taxaISQN);
            if(tipoCliente.equals("1")){ //PF
                novaCargaNacional.calculoFrete((ClientePF) cliente);

            }else if(tipoCliente.equals("2")){ //PJ
                novaCargaNacional.calculoFrete((ClientePJ) cliente);
            }

            listaDeCargas.add(novaCargaNacional);
            System.out.println("\n---DADOS DA CARGA---\n");
            System.out.println(novaCargaNacional.toString());
            System.out.println("\n---DADOS DO CLIENTE---\n");
            System.out.println(cliente.toString());
        }else{
            System.out.println("Informe a taxa de Alfândega: ");
            taxaAlfandega=read.nextDouble();

            CargaInternacional novaCargaInternacional=new CargaInternacional(codigo, altura,largura,profundidade, peso, origem, destino, cliente, origem.getPais(), taxaAlfandega);
            if(tipoCliente.equals("1")){ //PF
                novaCargaInternacional.calculoFrete((ClientePF) cliente);

            }else if(tipoCliente.equals("2")){//PJ
                novaCargaInternacional.calculoFrete((ClientePJ) cliente);
            }
            listaDeCargas.add(novaCargaInternacional);
            System.out.println("\n---DADOS DA CARGA---\n");
            System.out.println(novaCargaInternacional.toString());

            System.out.println("\n---DADOS DO CLIENTE---\n");
            System.out.println(cliente.toString());
        }

        }

    public String alteraSituacao(int codigo) {
        int count = 0;
        for(int i = 0 ; i < listaDeCargas.size(); i++){
            if(listaDeCargas.get(i).getCodigo() == codigo){
                count++;
            }
        }
        if(count == 0){
            System.out.println("Carga não encontrada!");
            return null;
        }

        for(int i = 0; i < listaDeCargas.size(); i++){
            if(listaDeCargas.get(i).getSituacao().toUpperCase().equals("CANCELADA") || listaDeCargas.get(i).getSituacao().toUpperCase().equals("ENTREGUE")){
                System.out.println("Erro: Status não pode ser alterado!");
                return null;
            }
        }

        int op=0;
        while(op!=1 && op!=2){
            System.out.println("Informe a nova situação da carga: \n[1] Cancelada\n[2] Entregue");
            op=read.nextInt();
        }

        for(int i = 0 ; i < listaDeCargas.size(); i++){
            if(listaDeCargas.get(i).getCodigo() == codigo){
                if(op==1){
                    System.out.println("Alterando para 'Cancelada'");
                    listaDeCargas.get(i).setSituacao("Cancelada");

                }else if(op==2){
                    System.out.println("Alterando para 'Entregue'");
                    listaDeCargas.get(i).setSituacao("Entregue");
                }
            }
        }
        System.out.println("Status alterado com sucesso!");
        return null;

    }

    public Aeroporto selecionaAeroporto(){
        Aeroporto aeroportoSelecionado = null;
        String codigoIATA = "";
        String continua = "x";

        consultaAeroportos();

        while(continua.equals("x")){
            int j = 0;
            System.out.println("Informe o código IATA do Aeroporto Desejado");
            codigoIATA = read.next().toUpperCase();
            for(int i = 0; i < listaDeAeroportos.size() ; i++){
                if(listaDeAeroportos.get(i).getcodigoIATA().equals(codigoIATA)){
                    continua="";
                    aeroportoSelecionado = listaDeAeroportos.get(i);
                    j++;
                }
            }
            if(j == 0){
                System.out.println("Código IATA Invalido");
            }
        }
        return aeroportoSelecionado;

    }

    public String consultaAeroportos() {
        if(listaDeAeroportos.size()==0){
            System.out.println("Nenhum aeroporto cadastrado!");
            return null;
        }
        for(int i = 0; i < listaDeAeroportos.size(); i++){
            System.out.println("\nAeroporto " + (i + 1) + ":\n" + listaDeAeroportos.get(i).toString());
        }
        return null;
    }

    public String consultaCargas() {
        if(listaDeCargas.size()==0){
            System.out.println("Nenhuma Carga cadastrada!");
            return null;
        }        
        for(int i = 0; i < listaDeCargas.size(); i++){ 
                System.out.println("\nCarga " + (i + 1) + ":" + listaDeCargas.get(i).toString());
            } 
        return null;
    }

    //Inicializar os cadastros automáticos

    public void inicializaMenu() {
        //inicializa();

        //MENU
        int opEntrada=9;
        boolean menuPrincipal=true;

        while(menuPrincipal){
            System.out.println("\n------MENU ACME TRANSPORTADORA-----");
            System.out.println("Você é um :\n[1] ATENDENTE\n[2] GERENTE\n[0] SAIR");
            System.out.println("Sua opção: ");
            opEntrada=read.nextInt();

            switch (opEntrada){

                case 1:
                    menuAtendente();
                    break;

                case 2:
                    menuGerente();
                    break;

                case 0:
                    System.out.println("\nEncerrando...");
                    menuPrincipal=false;
                    break;

                default:
                    System.out.println("\nOpção inválida!");
                    break;
            }
        }

    }

    public void menuAtendente(){
        int opAtendente=9;
        boolean menuAtendente=true;

        while(menuAtendente){
            System.out.println("\n-----ATENDENTE-----");
            System.out.println("[1] CADASTRAR CLIENTE\n[2] CADASTRAR CARGA\n[3] ALTERAR SITUAÇÃO DE CARGA\n[4] CONSULTAR CARGAS CADASTRADAS\n[0] VOLTAR");
            System.out.println("Escolha uma alternativa válida: ");
            opAtendente= read.nextInt();

            switch (opAtendente) {
                case 1:
                    cadastroCliente();
                    break;

                case 2:
                    cadastroCarga();
                    break;

                case 3:
                    System.out.println("Informe o código da carga: ");
                    int codigoCarga= read.nextInt();

                    alteraSituacao(codigoCarga);
                    break;

                case 4:
                    consultaCargas();
                    break;

                case 0:
                    menuAtendente=false;
                    break;

                default:
                    System.out.println("\nOpção inválida! ");
                    break;

            }
        }


    }

    public void menuGerente(){
        int opGerente=9;
        boolean menuGerente=true;
        int cont=0;

        while(menuGerente){
            System.out.println("\n-----GERENTE-----");
            System.out.println("[1] CADASTRAR CLIENTE\n[2] CADASTRAR CARGA\n[3] ALTERAR SITUAÇÃO DE CARGA\n[4] CONSULTAR CARGAS CADASTRADAS\n[5] CADASTRAR AEROPORTO\n[6] CONSULTAR AEROPORTOS\n[7] CONSULTAR CLIENTES CADASTRADOS\n[8] SIMULAÇÃO\n[0] VOLTAR");
            System.out.println("Escolha uma alternativa válida: ");
            opGerente= read.nextInt();


            switch (opGerente) {
                case 1:
                    cadastroCliente();
                    break;

                case 2:
                    cadastroCarga();
                    break;

                case 3:
                    System.out.println("Informe o código da carga: ");
                    int codigoCarga= read.nextInt();

                    alteraSituacao(codigoCarga);
                    break;

                case 4:
                    consultaCargas();
                    break;

                case 5:
                    cadastroAeroporto();
                    break;

                case 6:
                    consultaAeroportos();
                    break;

                case 7:
                    consultaClientes();
                    break;

                case 8:
                    if(cont==0){
                        simulacao();
                        cont++;
                    }else{
                        System.out.println("Simulação já executada!");
                    }
                    break;

                case 0:
                    menuGerente=false;
                    break;

                default:
                    System.out.println("\nOpção inválida! ");
                    break;

            }
        }
    }

    //ok
    public void cadastroAeroporto() {
        String codigoIATA="";
        String nome="";
        String pais="";
        double latitude=0;
        double longitude=0;

        System.out.println("----CADASTRAR AEROPORTO----");
        System.out.println("Informe o código IATA do aeroporto: ");
        codigoIATA=read.next().toUpperCase();

        for(Aeroporto aeroportos : listaDeAeroportos){
            if(aeroportos.getcodigoIATA().equals(codigoIATA)){
                System.out.println("ERRO! Código já existente\nImpossível fazer o cadastro...");
                return;
            }
        }

        System.out.println("Informe os seguintes dados: ");
        System.out.println("Nome do aeroporto: ");
        read.nextLine();
        nome=read.nextLine();

        System.out.println("País: ");
        pais=read.nextLine();
        //read.nextLine();

        System.out.println("Latitude: ");
        latitude=read.nextDouble();
        System.out.println("Longitude: ");
        longitude=read.nextDouble();

        System.out.println("Cadastro efetuado com sucesso!");
        listaDeAeroportos.add(new Aeroporto(codigoIATA, nome, pais, latitude, longitude));
        return;
    }

    //ok
    public String consultaClientes() {
        if(listaDeClientesPJ.size()==0){
            System.out.println("Não há clientes PJ cadastrados");
        }

        if(listaDeClientesPF.size()==0){
            System.out.println("Não há clientes PF cadastrados");
        }

        for(int i = 0; i < listaDeClientesPF.size(); i++){
            System.out.println("Cliente Pessoa Fisica " + (i + 1) + ":" + listaDeClientesPF.get(i).toString());
        }

        for(int i = 0; i < listaDeClientesPJ.size(); i++){
            System.out.println("Cliente Pessoa Juridica " + (i + 1) + ":" + listaDeClientesPJ.get(i).toString());
        }
        return null;
    }

    //ok
    public String simulacao(){
        System.out.println("Cadastrando aeroporto Guarulhos");
        Aeroporto gru = new Aeroporto("GRU", "Guarulhos", "Brasil", -23.4, -46.4);
        listaDeAeroportos.add(gru);

        System.out.println("Cadastrando aeroporto Salgado Filho");
        Aeroporto poa = new Aeroporto("POA", "Salgado Filho", "Brasil", -29.9, -51);
        listaDeAeroportos.add(poa);

        System.out.println("Cadastrando aeroporto Heathrow");
        Aeroporto lhr = new Aeroporto("LHR", "Heathrow", "Inglaterra", 51.4, -0.4);
        listaDeAeroportos.add(lhr);

        System.out.println("Cadastrando cliente Maria...");
        ClientePF maria = new ClientePF("Maria", "maria@hotmail.com", "3186 Garrison Union Apt. 362 - Sumter, WY ", "123.456.789-01");
        listaDeClientesPF.add(maria);

        System.out.println("Cadastrando cliente ACME Corp...");
        ClientePJ acme = new ClientePJ("ACME Corp", "acme_corp@yahoo.com", "874 Toy Green Suite 335 - Fayetteville, WI", "12.345.678/0001-01", "ACME Corporation");
        listaDeClientesPJ.add(acme);

        System.out.println("Cadastrando Carga de Maria: Origem--> Salgado Filho | Destino--> Guarulhos");
        CargaNacional cargaMaria = new CargaNacional(111, 0.2, 0.2, 0.2, 1, listaDeAeroportos.get(1), listaDeAeroportos.get(0), listaDeClientesPF.get(0), 500);
        listaDeCargas.add(cargaMaria);

        System.out.println("Calculando Frete de Maria...");
        cargaMaria.calculoFrete(maria);

        System.out.println("Cadastrando Carga de Acme Corp: Origem--> Heathrow | Destino--> Salgado Filho");
        CargaInternacional cargaAcme = new CargaInternacional(555, 1, 1, 1, 10, listaDeAeroportos.get(2), listaDeAeroportos.get(1), listaDeClientesPJ.get(0), listaDeAeroportos.get(2).getPais(), 1000);
        listaDeCargas.add(cargaAcme);

        System.out.println("Calculando Frete de Acme...");
        cargaAcme.calculoFrete(acme);

        System.out.println("Enviando Carga de Maria...");
        listaDeCargas.get(0).enviar();


        System.out.println("-----LISTA DE AEROPORTOS-----");
        consultaAeroportos();

        System.out.println("-----LISTA DE CLIENTES-----");
        consultaClientes();

        System.out.println("-----LISTA DE CARGAS-----");
        consultaCargas();

        return "Fim da Simulação";
    }


}
