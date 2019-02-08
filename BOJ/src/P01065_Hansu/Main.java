package P01065_Hansu;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	static int N, ans;

	public static void main(String[] args) throws Exception {

		long start = System.currentTimeMillis();

		System.setIn(new FileInputStream("C:/BOJ/1065.txt"));
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			ans += hansu(i);
		}

		System.out.println(ans);

		long end = System.currentTimeMillis();
		System.out.println("수행시간 : " + (end - start));

	}

	static int hansu(int n) {
		if (n < 100 || n / 100 - n % 100 / 10 == n % 100 / 10 - n % 10)
			return 1;
		return 0;
	}
}