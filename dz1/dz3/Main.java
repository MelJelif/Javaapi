package dz1.dz3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите первое число: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Введите операцию (+, -, *, /): ");
        String operator = scanner.next();
        
        System.out.print("Введите второе число: ");
        double num2 = scanner.nextDouble();
        
        double result = 0;
        
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
                
            case "-":
                result = num1 - num2;
                break;
                
            case "*":
                result = num1 * num2;
                break;
                
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Ошибка: деление на ноль");
                    return;
                }
                break;
                
            default:
                System.out.println("Ошибка: неверная операция");
                return;
        }
        
        System.out.println(num1 + " " + operator +" "+ num2 + " = " + result);
    }
}
