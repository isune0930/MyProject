package P02812_KEKS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {

	static int N, K;
	static String str;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		str = br.readLine();

		ArrayDeque<Character> dq = new ArrayDeque<>();
		dq.push(str.charAt(0));
		for (int i = 1; i < N; i++) {
			while (K > 0 && !dq.isEmpty() && dq.getFirst() < str.charAt(i)) {
				K--;
				dq.pop();
			}
			dq.push(str.charAt(i));
		}
		while (K > 0) {
			K--;
			dq.pop();
		}
		StringBuffer sb = new StringBuffer();
		while (dq.size() > 0) {
			sb.append(dq.pollLast());
		}
		System.out.println(sb.toString());

	}

}