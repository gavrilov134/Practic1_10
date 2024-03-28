

package com.mycompany.practic1_10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Practic1_10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Practical task 1.10, Student Evgeny Gavrilov, RIBO-01-22, Variant 3");
        System.out.print("Enter the path to the source file: ");
        String inputFileName = scanner.next();

        try (FileInputStream inputFile = new FileInputStream(inputFileName)) {

            byte[] gamma = new byte[2];
            System.out.print("Enter two bytes for gamma (For example, ABCD): ");
            System.in.read(gamma);

            String outputFileName = inputFileName.replace(".txt", "_modified.txt");
            try (FileOutputStream outputFile = new FileOutputStream(outputFileName)) {

                int i = 0;
                int byteRead;
                while ((byteRead = inputFile.read()) != -1) {
                    byte modifiedByte = (byte) (byteRead ^ gamma[i % 2]);
                    outputFile.write(modifiedByte);
                    i++;
                }

                System.out.println("The file has been successfully modified. The result is saved in " + outputFileName);

            } catch (IOException e) {
                System.err.println("Error writing to output file.");
            }

        } catch (IOException e) {
            System.err.println("Error reading input file.");
        }

        scanner.close();
    }
}