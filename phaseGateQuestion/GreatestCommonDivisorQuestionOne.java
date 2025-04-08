package AllPhaseGateFolder.lastPhaseGate;

import java.util.Scanner;

class Fact{
	public static int getCommonDivisor(int number, int numberTwo){

int counter =0;
int roll = 0;

	while (number != 0){
	for (int count = 1; count <= number; count++){

		if (number % count == 0){
		roll++;
	}
   }
	return roll;
}

public static void main(String[] args){

Scanner reader = new Scanner(System.in);

int numberOne = reader.nextInt();
int numberTwo = reader.nextInt();

int result = getCommonDivisor(numberOne, numberTwo);
System.out.print("Greatest Divisor Is: " + result);
   }
}