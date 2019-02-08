package P04673_SelfNumber;

import java.util.Arrays;

public class Main {

	static boolean sn[] = new boolean[10036];

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		Arrays.fill(sn, true);
		for (int i = 1; i <= 10000; i++) {
			sn[dn(i)] = false;
			if (sn[i])
				System.out.println(i);
		}

		long end = System.currentTimeMillis();
		System.out.println("수행시간 : " + (end - start));

	}

	static int dn(int i) {
		int res = i;
		if (i >= 10000) {
			res += i / 10000;
			i %= 10000;
		}
		if (i >= 1000) {
			res += i / 1000;
			i %= 1000;
		}
		if (i >= 100) {
			res += i / 100;
			i %= 100;
		}
		if (i >= 10) {
			res += i / 10;
			i %= 10;
		}
		return res += i;
	}

}
