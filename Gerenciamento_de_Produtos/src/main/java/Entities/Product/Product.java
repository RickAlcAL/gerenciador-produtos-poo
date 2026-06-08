package Entities.Product;

public class Product {
    //Atributos encapsulados
    private String nameProduct;
    private double priceProduct;
    //Atributo que será usado como "anzol"
    protected String priceTag;
    //Construtor para inicialização
    public Product () {

    }
    //Construtor central que receberá todas as informações do usuario
    public Product (String nameProduct, double priceProduct, String priceTag) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.priceTag = priceTag;
    }
    //Construtor que recebe somente nome e preço do usuario
    public Product(String nomeUser, double precoUser) {
        this.nameProduct = nomeUser;
        this.priceProduct = precoUser;
    }

    //Getters e ‘Setters’
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public String getPriceTag() {
        return priceTag;
    }

    //Aqui tenho um metodo geral que uso para mensagem entre está classe suas SubClassese ou classe filhas
    //Aqui embaixo retorna uma mensagem com o nome do produto e seu preço
    public String priceTag () {
        return "Name product: " + nameProduct + " | Price product: $" + priceProduct;
    }
}
