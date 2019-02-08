package P02357_MinimumAndMaximum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, M, A[];
	static MinMax[] tree;
	final static int MAX = 1000000000;

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/2357.txt");
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());

		A = new int[N + 1];
		for (int i = 1; i <= N; i++)
			A[i] = Integer.valueOf(br.readLine());

		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int tree_size = 1 << (h + 1);
		tree = new MinMax[tree_size];
		init(1, 1, N);

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			bw.write(minquery(1, 1, N, a, b) + " " + maxquery(1, 1, N, a, b)
					+ "\n");
		}
		bw.flush();

	}

	static void init(int node, int start, int end) {
		if (start == end)
			tree[node] = new MinMax(A[start], A[start]);
		else {
			int mid = (start + end) / 2;
			init(2 * node, start, mid);
			init(2 * node + 1, mid + 1, end);
			int min = Math.min(tree[2 * node].min, tree[2 * node + 1].min);
			int max = Math.max(tree[2 * node].max, tree[2 * node + 1].max);
			tree[node] = new MinMax(min, max);
		}
	}

	static int minquery(int node, int start, int end, int left, int right) {
		if (right < start || end < left)
			return MAX;
		if (left <= start && end <= right)
			return tree[node].min;
		int mid = (start + end) / 2;
		int min1 = minquery(2 * node, start, mid, left, right);
		int min2 = minquery(2 * node + 1, mid + 1, end, left, right);
		return Math.min(min1, min2);
	}

	static int maxquery(int node, int start, int end, int left, int right) {
		if (right < start || end < left)
			return 0;
		if (left <= start && end <= right)
			return tree[node].max;
		int mid = (start + end) / 2;
		int max1 = maxquery(2 * node, start, mid, left, right);
		int max2 = maxquery(2 * node + 1, mid + 1, end, left, right);
		return Math.max(max1, max2);
	}

}

class MinMax {
	public MinMax(int min, int max) {
		this.min = min;
		this.max = max;
	}

	int min, max;
}