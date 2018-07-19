//This Solution is for http://geeks.redmart.com/2015/01/07/skiing-in-singapore-a-coding-diversion/
import java.util.ArrayList;
import java.util.Scanner;

public class Skii {

	private static Scanner sc;
	static int N;
	static int M;
	static int max = 0;
	static int maxSteep = 0;
	static int start = 0;

	public static void longestPathfromAVertice(int i, int j, int lengthData[][], int data[][], int pre) {
		if (i < 0 || i >= N || j < 0 || j >= M) {
			return;
		}
		lengthData[i][j] = pre + 1;
		if (i + 1 < N && data[i][j] > data[i + 1][j]) {
			longestPathfromAVertice(i + 1, j, lengthData, data, lengthData[i][j]);
		}
		if (i - 1 >= 0 && data[i][j] > data[i - 1][j]) {
			longestPathfromAVertice(i - 1, j, lengthData, data, lengthData[i][j]);
		}
		if (j + 1 < M && data[i][j] > data[i][j + 1]) {
			longestPathfromAVertice(i, j + 1, lengthData, data, lengthData[i][j]);
		}
		if (j - 1 >= 0 && data[i][j] > data[i][j - 1]) {
			longestPathfromAVertice(i, j - 1, lengthData, data, lengthData[i][j]);
		}
		if (max < lengthData[i][j]) {
			max = lengthData[i][j];

			maxSteep = start - data[i][j];

		} else if (max == lengthData[i][j]) {
			int a = start - data[i][j];
			if (maxSteep < a) {
				maxSteep = a;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("sample_input.txt"));

		sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		int data[][] = new int[N][M];
		int lengthData[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int high = sc.nextInt();
				data[i][j] = high;
				lengthData[i][j] = 1;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				start = data[i][j];
				longestPathfromAVertice(i, j, lengthData, data, 0);

			}
		}

		System.out.println("TotalScore = " + max + " steep " + maxSteep);
		sc.close();
	}
}
