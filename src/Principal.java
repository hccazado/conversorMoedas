import com.conversormoedas.model.ConversorMoeda;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args){
        int opcao = 0;
        String moedaOrigem;
        String moedaDestino;
        ConversorMoeda conversor;
        double valor;
        Scanner scanner = new Scanner(System.in);
        while (opcao != 99) {
            System.out.println("--------Conversor de Moedas--------");
            System.out.println("1 - Converter Dolar - Real");
            System.out.println("2 - Converter Real - Dolar");
            System.out.println("3 - Converter Franco Suiço - Real");
            System.out.println("4 - Converter Real - Franco Suiço");
            System.out.println("5 - Converter Real - Euro");
            System.out.println("6 - Converter Euro - Real");
            System.out.println("7 - Converter Real - Peso Chileno");
            System.out.println("8 - Converter Peso Chileno - Real");
            System.out.println("9 - Converter Real - Peso Mexicano");
            System.out.println("10 - Converter Peso Mexicano - Real");
            System.out.println("99 - Sair");
            System.out.println("-----------------------------------");
            System.out.print("Digite uma opção: ");
            opcao = scanner.nextInt();

            switch(opcao){
                case 1:
                    System.out.println("Conversão Dolar/Real");
                    System.out.print("Quantidade de dolares: ");
                    valor = scanner.nextDouble();
                    moedaOrigem = "USD";
                    moedaDestino = "BRL";
                    conversor = new ConversorMoeda(moedaOrigem, moedaDestino);
                    System.out.println("O valor convertido é: "+conversor.converterMoeda(valor));
                    break;
                case 2:
                    System.out.println("Conversão Real/Dolar");
                    System.out.print("Quantidade de reais: ");
                    valor = scanner.nextDouble();
                    moedaOrigem = "BRL";
                    moedaDestino = "USD";
                    conversor = new ConversorMoeda(moedaOrigem, moedaDestino);
                    System.out.println("O valor convertido é: "+conversor.converterMoeda(valor));
                    break;
                case 3:
                    System.out.println("Conversão Real/Franco Suiço");
                    System.out.print("Quantidade de reais: ");
                    valor = scanner.nextDouble();
                    moedaOrigem = "BRL";
                    moedaDestino = "CHF";
                    conversor = new ConversorMoeda(moedaOrigem, moedaDestino);
                    System.out.println("O valor convertido é: "+conversor.converterMoeda(valor));
                    break;
                case 4:
                    System.out.println("Conversão Franco Suiço/Real");
                    System.out.print("Quantidade de francos: ");
                    valor = scanner.nextDouble();
                    moedaOrigem = "CHF";
                    moedaDestino = "BRL";
                    conversor = new ConversorMoeda(moedaOrigem, moedaDestino);
                    System.out.println("O valor convertido é: "+conversor.converterMoeda(valor));
                    break;
                case 5:
                    System.out.println("Conversão Real/Euro");
                    System.out.print("Quantidade de reais: ");
                    valor = scanner.nextDouble();
                    moedaOrigem = "BRL";
                    moedaDestino = "EUR";
                    conversor = new ConversorMoeda(moedaOrigem, moedaDestino);
                    System.out.println("O valor convertido é: "+conversor.converterMoeda(valor));
                    break;
                case 6:
                    System.out.println("Conversão Euro/Real");
                    System.out.print("Quantidade de euros: ");
                    valor = scanner.nextDouble();
                    moedaOrigem = "EUR";
                    moedaDestino = "BRL";
                    conversor = new ConversorMoeda(moedaOrigem, moedaDestino);
                    System.out.println("O valor convertido é: "+conversor.converterMoeda(valor));
                    break;
                case 7:
                    System.out.println("Conversão Real/Peso Chileno");
                    System.out.print("Quantidade de reais: ");
                    valor = scanner.nextDouble();
                    moedaOrigem = "BRL";
                    moedaDestino = "CLP";
                    conversor = new ConversorMoeda(moedaOrigem, moedaDestino);
                    System.out.println("O valor convertido é: "+conversor.converterMoeda(valor));
                    break;
                case 8:
                    System.out.println("Conversão Peso Chileno/Real");
                    System.out.print("Quantidade de pesos: ");
                    valor = scanner.nextDouble();
                    moedaOrigem = "CLP";
                    moedaDestino = "BRL";
                    conversor = new ConversorMoeda(moedaOrigem, moedaDestino);
                    System.out.println("O valor convertido é: "+conversor.converterMoeda(valor));
                    break;
                case 9:
                    System.out.println("Conversão Real/Peso Mexicano");
                    System.out.print("Quantidade de reais: ");
                    valor = scanner.nextDouble();
                    moedaOrigem = "BRL";
                    moedaDestino = "MXN";
                    conversor = new ConversorMoeda(moedaOrigem, moedaDestino);
                    System.out.println("O valor convertido é: "+conversor.converterMoeda(valor));
                    break;
                case 10:
                    System.out.println("Conversão Peso Mexicano/Real");
                    System.out.print("Quantidade de pesos: ");
                    valor = scanner.nextDouble();
                    moedaOrigem = "MXN";
                    moedaDestino = "BRL";
                    conversor = new ConversorMoeda(moedaOrigem, moedaDestino);
                    System.out.println("O valor convertido é: "+conversor.converterMoeda(valor));
                    break;
                case 99:
                    System.out.println("Finalizando o programa!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }
    }
}