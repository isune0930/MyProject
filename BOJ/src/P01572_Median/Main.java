package P01572_Median;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K, A[], seg[], ans;

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/1572.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		A = new int[N];
		seg = new int[1024 * 512];
		for (int i = 0; i < N; i++)
			A[i] = Integer.valueOf(br.readLine());
		for (int i = 0; i < K - 1; i++)
			update(A[i], 1, 1, 0, 65535);
		for (int i = K - 1; i < N; i++) {
			update(A[i], 1, 1, 0, 65535);
			ans += query((K + 1) / 2, 1, 0, 65535);
			update(A[i - K + 1], -1, 1, 0, 65535);
		}
		System.out.println(ans);

	}

	static int query(int val, int node, int x, int y) {
		int mid = (x + y) / 2;
		if (x == y)
			return x;
		if (seg[node * 2] >= val)
			return query(val, node * 2, x, mid);
		return query(val - seg[node * 2], node * 2 + 1, mid + 1, y);
	}

	static int update(int pos, int val, int node, int x, int y) {
		if (y < pos || pos < x)
			return seg[node];
		if (x == y)
			return seg[node] += val;
		int mid = (x + y) / 2;
		return seg[node] = update(pos, val, node * 2, x, mid)
				+ update(pos, val, node * 2 + 1, mid + 1, y);

	}

}