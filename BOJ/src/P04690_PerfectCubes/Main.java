package P04690_PerfectCubes;

public class Main {

	public static void main(String[] args) {

		for (int a = 1; a <= 100; a++)
			for (int b = 2; b < a; b++)
				for (int c = b + 1; f(a) > f(b) + f(c); c++)
					for (int d = c + 1; f(a) >= f(b) + f(c) + f(d); d++)
						if (f(a) == f(b) + f(c) + f(d))							
							System.out.println("Cube = " + a + ", Triple = ("+ b + "," + c + "," + d + ")");

	}

	static int f(int x) {
		return x * x * x;
	}

}