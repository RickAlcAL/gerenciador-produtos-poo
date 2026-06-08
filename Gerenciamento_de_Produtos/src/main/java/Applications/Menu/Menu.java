package Applications.Menu;

import Entities.Enums.Avisos;
import Entities.ImportProduct.ImportedProduct;
import Entities.Product.Product;
import Entities.UsedProduct.UsedProduct;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu  {
    //Declarando uma lista para armazenamendo de banco de dados ficticio
    List<Product> listaDeProdutos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    //Formato da date para ser formatada
    SimpleDateFormat formatadorBR = new SimpleDateFormat("dd/MM/yyyy");

    public void menuUsuario () {
        char respUser;
        System.out.println("Enter the number of products:");
        int opcaoUser = sc.nextInt();
        sc.nextLine();

        //Usando enum para voltar um resultado a reação do usuario
        System.out.println(Avisos.AGUARDE.getMsgFinal());

        for (int i = 0; i < opcaoUser; i ++){
            System.out.println("Commom, used or imported (c/u/i) ?");
            respUser = sc.next().charAt(0);
            sc.nextLine();

            if (respUser == 'c'){
                System.out.println("Name:");
                String nomeUser = sc.nextLine();
                System.out.println("Price:");
                double precoUser = sc.nextDouble();
                sc.nextLine();
                //Usando e inicializando atribuição direta no construtor sem set
                listaDeProdutos.add(new Product(nomeUser, precoUser));
                //Enum utilizado para confirmação de etapa
                System.out.println(Avisos.CONCEDIDO.getMsgFinal());

            } else if (respUser == 'u') {
                System.out.println("Name:");
                String nomeUser = sc.nextLine();
                System.out.println("Price:");
                double precoUser = sc.nextDouble();
                sc.nextLine();

                System.out.println("Manufacture date (DD/MM/YYYY)");
                String dataUsuario = sc.nextLine();

                try {
                    /*OBSERVAÇÃO após usar o trycartch se não usar a data assim: 00/00/0000 o sistema quebra*/
                    //Convertendo a data do usuario dentro de um trycartch
                    Date dataConvertida = formatadorBR.parse(dataUsuario);
                    listaDeProdutos.add(new UsedProduct(nomeUser, precoUser, dataConvertida));
                    // CORREÇÃO: Adicionado System.out.println
                    System.out.println(Avisos.CONCEDIDO.getMsgFinal());
                } catch (Exception e){
                    //Usando ENUM para voltar um resultado pre programado
                    System.out.println(Avisos.ERRO.getMsgFinal());
                }

            } else if (respUser == 'i') {
                System.out.println("Name:");
                String nomeUser = sc.nextLine();
                System.out.println("Price:");
                double precoUser = sc.nextDouble();
                sc.nextLine();
                System.out.println("Customsfee:");
                double taxaImportacao = sc.nextDouble();
                sc.nextLine();

                listaDeProdutos.add(new ImportedProduct(nomeUser, precoUser, taxaImportacao));
                // Opcional: Adicionar o aviso concedido para o importado se quiser
                System.out.println(Avisos.CONCEDIDO.getMsgFinal());

            } else {
                System.out.println(Avisos.ERRO.getMsgFinal());
                i--; // Evita perder a rodada caso digite errado
            }
        }

        System.out.println("\nPRICE TAGS");
        for (Product prod: listaDeProdutos){
            System.out.println(prod.priceTag());
        }
    }
}