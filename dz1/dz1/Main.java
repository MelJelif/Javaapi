package dz1.dz1;

import java.util.Scanner;

public class Main {  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число n: ");
        int n = scanner.nextInt();

        int triangularNumber = calcTriangNum(n);
        int factorial = Factorial(n);

        System.out.println("n-ое треугольное число: " + triangularNumber);
        System.out.println("n! (факториал): " + factorial);
    }

    public static int calcTriangNum(int n){
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static int Factorial(int n){
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
