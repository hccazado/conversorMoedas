package com.conversormoedas.model;

import com.conversormoedas.exception.ExceptionValorInvalido;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMoeda {
    //Declaração de variaveis. Aplicado encapsulamento.
    @SerializedName("base_code")
    private final String moedaOrigem;
    @SerializedName("target_code")
    private final String moedaDestino;
    @SerializedName("conversion_rate")
    private final double taxaConversao;
    private double valor;
    private double valorConvertido;

    //CHAVE DA API EXCHANGERATE
    String apiKey = "";
    //---------------------------------------

    public ConversorMoeda(String moedaOrigem, String moedaDestino) {
        //construtor padrao (requerendo par de moedas)
        this.moedaOrigem = moedaOrigem;
        this.moedaDestino = moedaDestino;
        //obtendo valor da taxa de conversão a partir da execução do metodo pegaTaxa
        this.taxaConversao = pegaTaxa();
    }

    public ConversorMoeda(String moedaOrigem, String moedaDestino, double valor) {
        //construtor padrao (requerendo par de moedas) e valor p/ conversão
        this.moedaOrigem = moedaOrigem;
        this.moedaDestino = moedaDestino;
        this.valor = valor;
        //obtendo valor da taxa de conversão a partir da execução do metodo pegaTaxa
        this.taxaConversao = pegaTaxa();
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double converterMoeda (double valor){
        /**
          Metodo responsanvel por calcular a conversão do par de moedas selecionado
         */
        if(valor <= 0){
            //retornando erro de execução para valores menor ou igual a zero
            throw new ExceptionValorInvalido("Deve informar valor maior que zero!");
        }
        this.valor = valor;
        valorConvertido = valor*taxaConversao;
        return valorConvertido;
    }

    public Double pegaTaxa(){
        /**
         * Metodo responsavel por consultar a taxa de conversão para o par moedas selecionado pelo cliente.
         */
        String baseUrl = "https://v6.exchangerate-api.com/v6/";
        //gerando string da url formada com chave api e codigos das moedas de origem e destino
        String url = "%s%s/pair/%s/%s".formatted(baseUrl, apiKey, moedaOrigem, moedaDestino);
        try {
            //instancia de cliente http
            HttpClient client = HttpClient.newHttpClient();
            //instancia da requisição que será executada no metodo de resposta
            HttpRequest requisicao = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            //execução da requisição e obtenção da resposta
            HttpResponse response = client.send(requisicao, HttpResponse.BodyHandlers.ofString());
            //convertendo corpo da resposta (string) em Json com metodo da biblioteca Gson
            JsonElement elementoJson = JsonParser.parseString((String) response.body());
            //gerando um objeto json (p/ acesso chave-valor)a partir do elemento json
            JsonObject objetoJson = elementoJson.getAsJsonObject();
            //obtendo e retornando o valor da taxa de conversão do par de moedas selecionado
            return objetoJson.get("conversion_rate").getAsDouble();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
