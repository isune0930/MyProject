package P02042_SegmentSum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static long A[], tree[];

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/2042.txt");
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());

		A = new long[N + 1];
		for (int i = 1; i <= N; i++)
			A[i] = Integer.valueOf(br.readLine());

		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int tree_size = 1 << (h + 1);
		tree = new long[tree_size];
		init(1, 1, N);

		int ts = M + K;
		while (ts-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			if (a == 1)
				update(1, 1, N, b, c);
			else
				bw.write(query(1, 1, N, b, c) + "\n");
		}
		bw.flush();

	}

	static void init(int node, int start, int end) {
		if (start == end)
			tree[node] = A[start];
		else {
			int mid = (start + end) / 2;
			init(2 * node, start, mid);
			init(2 * node + 1, mid + 1, end);
			tree[node] = tree[2 * node] + tree[2 * node + 1];
		}
	}

	static long query(int node, int start, int end, int left, int right) {
		if (right < start || left > end)
			return 0;
		if (left <= start && end <= right)
			return tree[node];
		int mid = (start + end) / 2;
		long s1 = query(2 * node, start, mid, left, right);
		long s2 = query(2 * node + 1, mid + 1, end, left, right);
		return s1 + s2;
	}

	static void update(int node, int start, int end, int index, int value) {
		if (index < start || end < index)
			return;
		if (start == end) {
			tree[node] = value;
			return;
		}
		int mid = (start + end) / 2;
		update(2 * node, start, mid, index, value);
		update(2 * node + 1, mid + 1, end, index, value);
		tree[node] = tree[2 * node] + tree[2 * node + 1];
	}
	
}