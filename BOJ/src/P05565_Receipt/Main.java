package P05565_Receipt;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("C:/BOJ/5565.txt");
		BufferedReader br = new BufferedReader(fr);
		int ans = Integer.valueOf(br.readLine());
		for (int i = 1; i <= 9; i++) 
			ans -= Integer.valueOf(br.readLine());
		System.out.println(ans);
	}
}