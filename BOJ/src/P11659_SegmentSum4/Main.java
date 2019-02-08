package P11659_SegmentSum4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, M, A[], tree[];

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/11659.txt");
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());

		A = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			A[i] = Integer.valueOf(st.nextToken());

		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int tree_size = (1 << (h + 1));
		tree = new int[tree_size];
		init(1, 1, N);

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.valueOf(st.nextToken());
			int right = Integer.valueOf(st.nextToken());
			bw.write(query(1, 1, N, left, right)+"\n");
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

	static int query(int node, int start, int end, int left, int right) {
		if (right < start || left > end)
			return 0;
		if (left <= start && end <= right)
			return tree[node];
		int mid = (start + end) / 2;
		int s1 = query(2 * node, start, mid, left, right);
		int s2 = query(2 * node + 1, mid + 1, end, left, right);
		return s1 + s2;
	}

}
