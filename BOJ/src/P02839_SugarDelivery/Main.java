package P02839_SugarDelivery;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	static int N, X, Y, ans;

	public static void main(String[] args) throws Exception {

		long start = System.currentTimeMillis();

		System.setIn(new FileInputStream("C:/BOJ/2839.txt"));
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		X = N / 5;

		if (N % 5 == 0)
			ans = X;
		else {
			ans = -1;
			for (int i = X; i >= 0; i--) {
				if ((N - (i * 5)) % 3 == 0) {
					Y = (N - (i * 5)) / 3;
					ans = i + Y;
					break;
				}
			}
		}

		System.out.println(ans);

		long end = System.currentTimeMillis();
		System.out.println("수행시간 : " + (end - start));
	}

}