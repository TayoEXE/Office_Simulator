package Utilities;

import java.io.*;
import java.util.Scanner;

public class InputHandler {

    private static BufferedReader _scanner = new BufferedReader(new InputStreamReader(System.in));

    public static String getAlphaNumeric(String prompt) throws IOException {
        String input = null;

        System.out.print(prompt);
        input = _scanner.readLine();
        System.out.println();

        return input;
    }

    public static void cleanUp() throws IOException {
        try {
            _scanner.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}