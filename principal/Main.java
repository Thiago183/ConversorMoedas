package com.conversor.principal;

import com.conversor.calculos.Conversao;
import com.conversor.conexoes.Conector;



import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Conector con = new Conector();
        Conversao conv = new Conversao();
        Scanner scan = new Scanner(System.in);
        int option = 10;
        double valor;
        double result;

        String menu = """
                *****************************
                1 - Real para Dolar
                2 - Dolar para real
                3 - Real para Yenes
                4 - Yenes para real
                5 - Euro para Dolar
                6 - Dolar para Euro
                0 - Para sair
                *****************************
                """;



        while(option != 0) {

            try {

                System.out.println(menu);

                option = scan.nextInt();


                switch (option) {

                    case 1:
                        System.out.println("Digite o valor que deseja converter para Dolar");
                        valor = scan.nextDouble();
                        result = conv.converterValores(valor, con.pegarValorJson("BRL", "USD"));
                        System.out.println("O valor :" + valor + " ,Convertido para Dolar : " + result);
                        option = 0;

                        break;
                    case 2:
                        System.out.println("Digite o valor que deseja converter para Real");
                        valor = scan.nextDouble();
                        result = conv.converterValores(valor, con.pegarValorJson("USD", "BRL"));
                        System.out.println("O valor :" + valor + " ,Convertido para Reais : " + result);
                        option = 0;
                        break;
                    case 3:
                        System.out.println("Digite o valor que deseja converter para Yene");
                        valor = scan.nextDouble();
                        result = conv.converterValores(valor, con.pegarValorJson("BRL", "JPY"));
                        System.out.println("O valor :" + valor + " ,Convertido para Yenes : " + result);
                        option = 0;
                        break;
                    case 4:
                        System.out.println("Digite o valor que deseja converter para Real");
                        valor = scan.nextDouble();
                        result = conv.converterValores(valor, con.pegarValorJson("BRL", "JPY"));
                        System.out.println("O valor :" + valor + " ,Convertido para Reais : " + result);
                        option = 0;
                        break;
                    case 0:
                        System.out.println("Encerrando aplicação.");
                        break;
                    default:
                        System.out.println("Opçao invalida!!");

                }


            }catch (IllegalArgumentException |  InputMismatchException  e ){
                System.out.println("Somente aceitos numeros,digite novamente");
                scan.nextLine();

            }


        }
        scan.close();



    }

}
