package javainterviewquestions;

import java.util.Scanner;

public class MultiplyTwoFloatNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner reader = new Scanner(System.in)) {

			System.out.println("Please enter the first floating Number: ");
			float num1 = reader.nextFloat();

			System.out.println("Please enter the second float Number: ");
			float num2 = reader.nextFloat();

			float total = num1 * num2;
			System.out.println("The total after multiplying the two floating numbers is: " + total);

		} catch (Exception e) {

			System.out.println("Please enter the correct float value: ");
		}

	}

}
