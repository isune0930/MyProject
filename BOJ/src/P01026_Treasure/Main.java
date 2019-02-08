package P01026_Treasure;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N, A[], B[], ans;

	public static void main(String[] args) throws Exception {

		long start = System.currentTimeMillis();

		System.setIn(new FileInputStream("C:/BOJ/1026.txt"));
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		A = new int[N];
		B = new int[N];

		for (int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		for (int i = 0; i < N; i++)
			B[i] = sc.nextInt();

		Arrays.sort(A);
		Arrays.sort(B);

		for (int i = 0; i < N; i++) {
			ans += A[i] * B[N - 1 - i];
		}

		System.out.println(ans);

		long end = System.currentTimeMillis();
		System.out.println(end - start + " ms");

	}

}