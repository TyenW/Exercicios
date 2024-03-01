import java.util.Scanner;
public class Somar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o primeiro número inteiro: ");
        int n1 = scanner.nextInt();
        System.out.print("Digite o segundo número inteiro: ");
        int n2 = scanner.nextInt();
        int r = n1 + n2;
        System.out.println("A soma de " + n1 + " e " + n2 + " é: " + r);
	}
}