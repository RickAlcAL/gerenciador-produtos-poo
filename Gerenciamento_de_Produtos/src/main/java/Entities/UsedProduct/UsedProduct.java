package Entities.UsedProduct;

import Entities.Product.Product;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
    //Atributo encapsulado
    private Date manufactureDate;
    //Construtor para incialização
    public UsedProduct () {

    }
    //Construtor geral que recebe todas as informações
    public UsedProduct(String nameProduct, double priceProduct, String priceTag, Date manufactureDate) {
        super(nameProduct, priceProduct, priceTag);
        this.manufactureDate = manufactureDate;
    }
    //Construtor secundario que está recebendo nome,preço e data do usuario
    public UsedProduct(String nomeUser, double precoUser, Date dataUsuario) {
        super(nomeUser, precoUser);
        this.manufactureDate = dataUsuario;
    }
    //Getters e Setters padrões
    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    //Aqui novamente utilizando o metodo da classe Product para intanciar uma mensagem para o usuario sem precisar novamente utilizar no menu
    //Aqui aparece a data formatada com SImpleDateFormat retornando com super e logo na frente o nome do metodo novamente
    //Super significa SuperClass ou classpai, ela está buscando as informações de Product
    @Override
    public String priceTag () {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        // Adicionado os parênteses () depois de priceTag
        return super.priceTag() + " (Manufacture date: " + sdf.format(manufactureDate) + ")";
    }
}
