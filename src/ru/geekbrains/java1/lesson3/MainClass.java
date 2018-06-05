package ru.geekbrains.java1.lesson3;

import java.util.Random;
import java.util.Scanner;

public class MainClass {

    static Scanner scan = new Scanner (System.in); //создал объект класса Scanner
    static Random random = new Random(); //создал объект класса Random

    public static void main(String[] args) {
        byte a = 1;
        while (true) {
            guessTheNumber();
            System.out.println("\nПовторить игру ещё раз?\nЕсли 'Да' - введите '1'. 'Нет' - введите '0':");
            while (true) {
                if (scan.hasNextByte()) {
                    a = scan.nextByte();
                    break;
                }
                else {
                    scan.nextLine();
                    System.out.println("Необходимо ввести число.\nЕсли 'Да' - введите '1'. 'Нет' - введите '0':\"");
                }
            }
            if (a == 1) System.out.println("Отлично! Играем новый раунд!");
            else {
                System.out.println("Игра окончена.");
                break;
            }
        }
        scan.close();
    }

    public static void guessTheNumber () {
        int number = random.nextInt(10);
        int userNumber = -1;
        System.out.println("Угадайте число от 0 до 9.\nУ вас три попытки!");
        for (int i = 1; i <= 3; i++) {
            System.out.println("Попытка №" + i + ". Введите число и нажмите [Enter]:");
            userNumber = scan.nextInt();
            scan.nextLine();
            if (userNumber == number) {
                switch (i){
                    case 1:
                        System.out.println("Вы угадали с " + i + "-го раза!!! Вы - ПРОВИДЕЦ!!!");
                        break;
                    case 2:
                        System.out.println("Вы угадали с " + i + "-го раза! Недурно.");
                        break;
                    case 3:
                        System.out.println("Вы угадали с " + i + "-го раза! Я то думал Вы проиграете...");
                }
                break;
            } else if (userNumber < number) System.out.println("Моё число больше...");
            else System.out.println("Моё число меньше...");
        }
        if (userNumber != number) System.out.println("Вы НЕ УГАДАЛИ...\nМоё число было: " + number);
    }
}
