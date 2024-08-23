import java.util.Scanner;

public class Soma {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in); // Cria uma instância do Scanner dentro do método main
        
        System.out.println("Digite um número:");
        int np = ler.nextInt();
        
        System.out.println("Digite outro número:");
        int ns = ler.nextInt();
        
        System.out.println("A soma é: " + (np + ns));
        
        ler.close(); // Fecha o Scanner
    }
}
