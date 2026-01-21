package javainterviewquestions;

import java.util.Scanner;

public class ValueToAsciiCode {

	public static void main(String[] args) {
		try (Scanner reader = new Scanner(System.in)) {

			System.out.print("Please enter an ASCII code (e.g., 65): ");
			int code = reader.nextInt();

			// Explicit type casting converts the number to its character
			char character =  (char) code;

			System.out.println("THE CHARACTER FOR ASCII CODE " + code + " IS: " + character);

		} catch (Exception e) {
			System.out.println("Please enter a valid whole number.");
		}
	}
}