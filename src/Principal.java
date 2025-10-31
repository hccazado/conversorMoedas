import com.conversormoedas.model.ConversorMoeda;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    static List<ConversorMoeda> conversoes = new LinkedList<>();
    public static void main(String[] args){
        int opcao = 0;
        String moedaOrigem;
        String moedaDestino;
        ConversorMoeda conversor;
        double valor;

        Scanner scanner = new Scanner(System.in);
        while (opcao != 99) {
            System.out.println("--------Conversor de Moedas--------");
            System.out.println("1 - Converter Dolar -> Real");
            System.out.println("2 - Converter Real -> Dolar");
            System.out.println("3 - Converter Franco Suiço -> Real");
            System.out.println("4 - Converter Real -> Franco Suiço");
            System.out.println("5 - Converter Euro -> Real");
            System.out.println("6 - Converter Real -> Euro");
            System.out.println("7 - Converter Peso Chileno -> Real");
            System.out.println("8 - Converter Real -> Peso Chileno");
            System.out.println("9 - Converter Peso Mexicano -> Real");
            System.out.println("10 - Converter Real -> Peso Mexicano");
            System.out.println("99 - Sair");
            System.out.println("-----------------------------------");
            System.out.print("Digite uma opção: ");
            opcao = scanner.nextInt();

            switch(opcao){
                case 1:
                    System.out.println("Conversão Dolar -> Real");
                    System.out.print("Valor a converter: ");
                    valor = scanner.nextDouble();
                    moedaOrigem = "USD";
                    moedaDestino = "BRL";
                    conversor = new ConversorMoeda(moedaOrigem, moedaDestino);
                    System.out.println("O valor convertido é: $"+conversor.converterMoeda(valor));
                    conversoes.add(conversor);
                    break;
                case 2:
                    System.out.println("Conversão Real -> Dolar");
                    System.out.print("Quantidade de reais: ");
                    valor = scanner.nextDouble();
                    moedaOrigem = "BRL";
                    moedaDestino = "USD";
                    conversor = new ConversorMoeda(moedaOrigem, moedaDestino);
                    System.out.println("O valor convertido é: $"+conversor.converterMoeda(valor));
                    conversoes.add(conversor);
                    break;
                case 3:
                    System.out.println("Conversão Franco Suiço -> Real");
                    System.out.print("Quantidade de francos: ");
                    valor = scanner.nextDouble();
                    moedaOrigem = "CHF";
                    moedaDestino = "BRL";
                    conversor = new ConversorMoeda(moedaOrigem, moedaDestino);
                    System.out.println("O valor convertido é: $"+conversor.converterMoeda(valor));
                    conversoes.add(conversor);
                    break;
                case 4:
                    System.out.println("Conversão Real -> Franco Suiço");
                    System.out.print("Quantidade de reais: ");
                    valor = scanner.nextDouble();
                    moedaOrigem = "BRL";
                    moedaDestino = "CHF";
                    conversor = new ConversorMoeda(moedaOrigem, moedaDestino);
                    System.out.println("O valor convertido é: $"+conversor.converterMoeda(valor));
                    conversoes.add(conversor);
                    break;
                case 5:
                    System.out.println("Conversão Euro -> Real");
                    System.out.print("Quantidade de euros: ");
                    valor = scanner.nextDouble();
                    moedaOrigem = "EUR";
                    moedaDestino = "BRL";
                    conversor = new ConversorMoeda(moedaOrigem, moedaDestino);
                    System.out.println("O valor convertido é: $"+conversor.converterMoeda(valor));
                    conversoes.add(conversor);
                    break;
                case 6:
                    System.out.println("Conversão Real -> Euro");
                    System.out.print("Quantidade de reais: ");
                    valor = scanner.nextDouble();
                    moedaOrigem = "BRL";
                    moedaDestino = "EUR";
                    conversor = new ConversorMoeda(moedaOrigem, moedaDestino);
                    System.out.println("O valor convertido é: $"+conversor.converterMoeda(valor));
                    conversoes.add(conversor);
                    break;
                case 7:
                    System.out.println("Conversão Peso Chileno -> Real");
                    System.out.print("Quantidade de pesos: ");
                    valor = scanner.nextDouble();
                    moedaOrigem = "CLP";
                    moedaDestino = "BRL";
                    conversor = new ConversorMoeda(moedaOrigem, moedaDestino);
                    System.out.println("O valor convertido é: $"+conversor.converterMoeda(valor));
                    conversoes.add(conversor);
                    break;
                case 8:
                    System.out.println("Conversão Real -> Peso Chileno");
                    System.out.print("Quantidade de reais: ");
                    valor = scanner.nextDouble();
                    moedaOrigem = "BRL";
                    moedaDestino = "CLP";
                    conversor = new ConversorMoeda(moedaOrigem, moedaDestino);
                    System.out.println("O valor convertido é: $"+conversor.converterMoeda(valor));
                    conversoes.add(conversor);
                    break;
                case 9:
                    System.out.println("Conversão Peso Mexicano -> Real");
                    System.out.print("Quantidade de pesos: ");
                    valor = scanner.nextDouble();
                    moedaOrigem = "MXN";
                    moedaDestino = "BRL";
                    conversor = new ConversorMoeda(moedaOrigem, moedaDestino);
                    System.out.println("O valor convertido é: $"+conversor.converterMoeda(valor));
                    conversoes.add(conversor);
                    break;
                case 10:
                    System.out.println("Conversão Real -> Peso Mexicano");
                    System.out.print("Quantidade de reais: ");
                    valor = scanner.nextDouble();
                    moedaOrigem = "BRL";
                    moedaDestino = "MXN";
                    conversor = new ConversorMoeda(moedaOrigem, moedaDestino);
                    System.out.println("O valor convertido é: $"+conversor.converterMoeda(valor));
                    conversoes.add(conversor);
                    break;
                case 99:
                    System.out.println("Finalizando o programa!");
                    salvarArquivo();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }
    }

    public static void salvarArquivo(){
        /**
         Metodo responsanvel por salvar historico das consultas no arquivo conversoes.json
         */
        //verificando se a lista é vazia
        if (conversoes == null || conversoes.isEmpty()) {
            System.out.println("Nenhuma conversão para salvar.");
            return;
        }
        //iniciando instancia do GsonBuilder.
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        //utilizado try-with para garantir close do arquivo.
        try (FileWriter fw = new FileWriter("conversoes.json")) {
            fw.write(gson.toJson(conversoes));
            System.out.println("O programa finalizou corretamente!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}