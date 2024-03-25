package org.example;

import org.example.service.Service;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Добровольский Я.Б. РИБО-02-22 \n");
        System.out.print("Введите путь к исходному файлу: ");
        String inputFile = scanner.nextLine();

        System.out.print("Введите байты гаммы (в шестннадцатеричном формате, без пробелов): ");
        String gamma = scanner.nextLine();

        Service fileModifierService = new Service();
        fileModifierService.modifyFile(inputFile, gamma);
    }
}
