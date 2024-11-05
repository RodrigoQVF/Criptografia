import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        int[] linhagemA = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
        
        // Input
        System.out.println("Insira a palavra: (4 letras):"); // Palavra para ser convertida
        String s = scan.nextLine();
        scan.close();
        int Fvetor = s.length();
        
        if(Fvetor >= 5){
            System.out.println("palavra maior que 4 letras");
            return;
        }

        // Conversão para números
        int[] VetorC = new int[Fvetor];
        for (int i = 0; i < Fvetor; i++) {
            for (int j = 0; j < 26; j++) {
                if (s.charAt(i) == alfabeto.charAt(j)) {
                    VetorC[i] = linhagemA[j];
                }
            }
        }

        System.out.println(" ");
        System.out.println("convertida em números");
        for (int num : VetorC) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Matriz codificadora
        int[][] C = {
            {1, 1, 1, 1},
            {1, 2, 1, 2},
            {1, 1, 1, 0},
            {1, 4, 2, 3}
        };

        // Multiplicação de matriz
        int[] cript2 = multiplyMatrix(C, VetorC);

        System.out.println("Vetor criptografado com a matriz codificadora");
        for (int i : cript2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Decodificação
        int[][] inverseMatrix = {
            {-1, 2, 1, -1},
            {-2, 1, 1, 0},
            {3, -3, -1, 1},
            {1, 0, -1, 0}
        };

        int [] P = multiplyMatrix(inverseMatrix, cript2); //multiplica matriz inversa com o vetor criptografado para descriptografar
        int[] x = roundArray(P); // vetor convertido em número arrendodado.


        System.out.println(" ");
        System.out.println("Descriptografada");

        StringBuilder Vetorx = new StringBuilder();
        for (int i = 0; i < x.length; i++) { //Conversão dos números para letras
            for (int j = 0; j < 26; j++) {
                if (x[i] == linhagemA[j]) {
                    Vetorx.append(alfabeto.charAt(j));
                }
            }
        }
        System.out.println(Vetorx.toString()); //Descriptografia do vetor.
    }

    // Método para multiplicar matriz e vetor
    public static int[] multiplyMatrix(int[][] matrix, int[] vector) {
        int[] result = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            result[i] = 0;
            for (int j = 0; j < vector.length; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }
        return result;
    }


    // Método para arredondar o array de inteiros
    public static int[] roundArray(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = (int) Math.round(array[i]);
        }
        return result;
    }
}


