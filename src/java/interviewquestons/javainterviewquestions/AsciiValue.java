package javainterviewquestions;

import java.util.Scanner;

public class AsciiValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner reader = new Scanner(System.in)) {

			System.out.println("Please enter the value: ");
			char value = reader.next().charAt(0);
			
			int asciiValue = value;

			System.out.println("THE ENTERED VALUE'S is: " + value + "ASCII CODE IS: " + asciiValue);

		} catch (Exception e) {

			System.out.println("The entered value is not correct, please enter the correct value: ");
		}

	}

}
