package Entities.ImportProduct;

import Entities.Product.Product;

public class ImportedProduct extends Product {
    //Atributos encapsulados
    private double customsFee;
    protected double totalPrice;
    //Construtor para inicialização
    public ImportedProduct () {

    }
    //Construtor real que recebe todos os dados de uma vez
    public ImportedProduct(String nameProduct, double priceProduct, String priceTag, double customsFee, double totalPrice) {
        super(nameProduct, priceProduct, priceTag);
        this.customsFee = customsFee;
        this.totalPrice = totalPrice;
    }
    //Construtor para receber apenas nome preço e a taxa do usuario
    public ImportedProduct(String nomeUser, double precoUser, double taxaImportacao) {
        super(nomeUser,precoUser);
        this.customsFee = taxaImportacao;
    }
    //Getters e setters
    public double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(double customsFee) {
        this.customsFee = customsFee;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    //Calculo do preço final usando a taxa com o preço do produto
    public double totalPriceFee (double priceProduct) {
        return priceProduct += customsFee;
    }

    //Aqui temos um metodo sendo apontado com Override para que seja mostrado ao usuario o que eu quero que seja aparente
    //Logo com está explicação demostra que eu falo para o java o que eu quero que exatamento apareça
    //Abaixo e um metodo que existe dentro da Class Product
    @Override
    public String priceTag () {
        double precoTotal = getPriceProduct() + customsFee;
        return getNameProduct() + " $ " + precoTotal + " (Customs fee: $ " + customsFee + ")";
    }
}
