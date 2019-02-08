package P01263_TimeManagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Main {

	static int N, T[], S[], ans;

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/1263.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		T = new int[N + 1];
		S = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			S[i] = Integer.parseInt(st.nextToken());
		}

		quickSort(T, S, 1, N);
		ans = S[N];
		for (int i = N; i >= 1; i--) {
			ans = Math.min(ans, S[i]);
			ans -= T[i];
		}

		if (ans >= 0)
			System.out.println(ans);
		else
			System.out.println(-1);

	}

	static int partition(int T[], int S[], int left, int right) {
		int i = left, j = right;
		int tmp;
		int pivot = S[(left + right) / 2];
		while (i <= j) {
			while (S[i] < pivot)
				i++;
			while (S[j] > pivot)
				j--;
			if (i <= j) {
				tmp = S[i];
				S[i] = S[j];
				S[j] = tmp;
				tmp = T[i];
				T[i] = T[j];
				T[j] = tmp;
				i++;
				j--;
			}
		}
		;
		return i;
	}

	static void quickSort(int T[], int S[], int left, int right) {
		int index = partition(T, S, left, right);
		if (left < index - 1)
			quickSort(T, S, left, index - 1);
		if (index < right)
			quickSort(T, S, index, right);
	}

}