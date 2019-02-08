package P01015_SequenceSort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	static int N, A[], B[];

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/1015.txt");
		// InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(fr);
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < i; j++) {
				if (A[j] > A[i])
					B[j]++;
				else
					B[i]++;
			}
		}

		for (int i = 0; i < N; i++)
			System.out.print(B[i] + " ");

	}
}
