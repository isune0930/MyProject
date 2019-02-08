package P01572_Median;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in), 10240);
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		long ans = 0;
		IDT md = new IDT(250000);
		for (int i = 1; i < k; i++) {
			md.add(a[i], 1);
		}
		for (int i = k; i <= n; i++) {
			md.add(a[i], 1);
			ans += md.kth((k + 1) / 2);
			md.add(a[i - k + 1], -1);
		}
		System.out.println(ans);
	}

	static class IDT {
		int[] data;
		int base = 1;

		IDT(int n) {
			while (base < n) {
				base *= 2;
			}
			data = new int[base * 2];
		}

		public void add(int place, int value) {
			place += base;
			while (place >= 1) {
				data[place] += value;
				place /= 2;
			}
		}

		public long kth(int k) {
			int now = 1;
			while (now < base) {
				if (data[now * 2] < k) {
					k -= data[now * 2];
					now = now * 2 + 1;
				} else
					now = now * 2;
			}
			return now - base;
		}
	}
}