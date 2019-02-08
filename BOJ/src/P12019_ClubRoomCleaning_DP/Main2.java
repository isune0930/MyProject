package P12019_ClubRoomCleaning_DP;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kyungjun.an
 */
public class Main2 {

	public static int N;
	public static int M;

	public static int a[] = new int[103];
	public static int d[][][] = new int[103][13][20 * 103];
	public static int p[][][] = new int[103][13][20 * 103];

	public static int INF = 987654321;

	public static ArrayList<Integer> trace = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		long start = System.currentTimeMillis();

		System.setIn(new FileInputStream("C:/BOJ/12019.txt"));
		Scanner sc = new Scanner(System.in);

		trace.clear();

		N = sc.nextInt();
		M = sc.nextInt();

		int sumS = 0;
		for (int i = 1; i <= N; ++i) {
			a[i] = sc.nextInt();
			sumS += a[i];
		}

		for (int i = 0; i <= N; ++i) {
			for (int j = 0; j <= M; ++j) {
				for (int k = 0; k <= sumS; ++k) {
					d[i][j][k] = INF;
				}
			}
		}

		d[0][0][0] = 0;
		for (int i = 1; i <= N; ++i) {
			for (int j = 0; j <= M; ++j) {
				if (i < j) {
					continue;
				}

				if (j >= 1) {
					for (int m = 0; m <= sumS; ++m) {
						if (d[i - 1][j - 1][m] + m * a[i] <= d[i][j][0]) {
							d[i][j][0] = d[i - 1][j - 1][m] + m * a[i];
							p[i][j][0] = m + a[i];
						}
					}
				}

				for (int k = 1; k <= sumS; ++k) {
					if (k - a[i] >= 0) {
						d[i][j][k] = Math.min(d[i][j][k], d[i - 1][j][k - a[i]]
								+ (k - a[i]) * a[i]);
					}
				}
			}
		}

		int curS = 0, curN = N, curM = M;
		int ans = INF;
		for (int k = 0; k <= sumS; ++k) {
			if (d[N][M][k] <= ans) {
				ans = d[N][M][k];
				curS = k;
			}
		}

		while (curN >= 1) {
			if (curS == 0) {
				curS = p[curN][curM][curS] - a[curN];
				--curM;
				trace.add(curN);
			} else {
				curS = curS - a[curN];
			}
			--curN;
		}

		System.out.println(ans);
		for (int i = (int) trace.size() - 1; i >= 0; --i) {
			System.out.print(trace.get(i) + " ");
		}
		System.out.println("");

		long end = System.currentTimeMillis();
		System.out.println(end - start + " ms");
	}

}