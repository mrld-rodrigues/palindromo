package com.mycompany.polidromo;
import java.util.Scanner;

/**
  * @author Amiraldo Rodrigues
 */

public class Polidromo {   //Criando uma classe e uma função para testar se é palidromo ou não


    public static boolean teste_polidromo(String palavra){

        for(int i = 0; i < palavra.length(); i++){ //Vai varrer toda a string

            if (palavra.charAt(i) != palavra.charAt(palavra.length() - i - 1)){ // Verifica os termos equidistantes são iguais
                return false;                                                   // até a falha de igualdade, palídromo. .
            }
        }
        return true; // Se é palídromo. Retorna false
    }

    public static String _intro() { // função para imprimir o texto
        return """
                Atividade assícrona UFCD-0816
                Exercício 1

                PALÍDROMO Um palíndromo é uma palavra,
                frase ou qualquer outra sequência de unidades
                que tenha a propriedade de poder ser lida tanto
                da direita para a esquerda como da
                esquerda para a direita.

                Vamos a isso!

                """;
    }

    static String reversePala(String palavra, int i){ // Função para inverter a string utilizando recursovidade
        if(i == 0){                           // Estamos estudando isso em Python e preciso praticar.
            return palavra.charAt(0) + "";
        }
        char letras = palavra.charAt(i); // aqui posiciona o cursor para leitura no ultimo char \0 Da acordo com a funcão length().
        return letras + reversePala(palavra, i-1); // E aqui retorna a varredura vesersa por causa do i - 1, dessa maneira
    }                                                  // o cursor avançará para o char a seguir do \0.


    public static void main(String[] args) {

        //Declaração das variavies
        Scanner teclado = new Scanner(System.in);
        String text = _intro();
        String palavra;
        String sair = "SaiR";


        System.out.println(text);

        System.out.print("Digite a palavra ou frase que gostaria de testar\n"
                + "o PALÍDROMO ou digite 'SaiR' para encerrar o programa: ");
        palavra = teclado.next();   //Capturando a String digitada


        while (!palavra.equals(sair)){   //Testando se a String capturada, sempre será false.

            if (teste_polidromo(palavra)){ // Aqui é onde chamamos a função para verificar se é ou não palídromo

                System.out.print("\n\nA palavra/frase é um Palídromo!!\n\n");
                String reversa = reversePala(palavra, palavra.length()-1); // Atribuirá a variável reversa a palavra ao contrário
                System.out.printf("A palavra reversa é "+ reversa);
                System.out.println("\n");
            }else{

                System.out.print("\n\nA palavra/frase não é Palídromo!!\n\n");
                String reversa = reversePala(palavra, palavra.length()-1);
                System.out.printf("A palavra reversa é "+ reversa);
                System.out.println("\n");
            }
            System.out.print("Digite a palavra ou frase que gostaria de testar\n"
                    + "o PALÍDROMO ou digite 'SaiR' para encerrar o programa: ");
            palavra = teclado.next();
        }
        System.out.println("\n\n\tEncerrando o progrmama...");    //Encerra o progrmama se a condição do while for true
    }
}