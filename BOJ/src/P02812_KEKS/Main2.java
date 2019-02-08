package P02812_KEKS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main2 {

	static int N, K, A[], D[], top;
	static String str;

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/2812.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());

		str = br.readLine();
		A = new int[N + 1];
		D = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(str.substring(i - 1, i));
			while (K > 0 && top > 0 && D[top - 1] < A[i]) {
				top--;
				K--;
			}
			D[top++] = A[i];
		}
		top-=K;
		for (int i=0;i<top;i++)
			System.out.print(D[i]);

	}

}