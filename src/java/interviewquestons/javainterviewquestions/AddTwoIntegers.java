package javainterviewquestions;

import java.util.Scanner;

public class AddTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner reader = new Scanner(System.in)) {

			System.out.println("Please enter the first number: ");
			int num1 = reader.nextInt();

			System.out.println("Please enter the second number: ");
			int num2 = reader.nextInt();

			int total = num1 + num2;

			System.out.println("The total of entered 2 integer values is: " + total);

		}

		catch (Exception e) {

			System.out.println("Error: Please enter valid integer number: ");
		}
	}
}
