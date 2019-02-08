package P04690_PerfectCubes;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main2 {

	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		for (int a = 1; a <= 100; a++)
			for (int b = 2; b < a; b++)
				for (int c = b + 1; f(a) > f(b) + f(c); c++)
					for (int d = c + 1; f(a) >= f(b) + f(c) + f(d); d++)
						if (f(a) == f(b) + f(c) + f(d))
							bw.write("Cube = " + a + ", Triple = (" + b + ","
									+ c + "," + d + ")" + "\n");

		bw.flush();

	}

	static int f(int x) {
		return x * x * x;
	}

}