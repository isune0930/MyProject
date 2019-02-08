package P03046_R2;

import java.util.Scanner;

public class Main {

	static int R1, S;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		R1 = sc.nextInt();
		S = sc.nextInt();

		System.out.println(2 * S - R1);

	}

}