import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	private final int QUANTITY_ARRAYS;
	private final int SIZE_ARRAY;
	private final int ELEMENT_ROW;
	private final int ELEMENT_COLUMN;
	private final int NUM_P;
	private int [] elLine;

	private Main() throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		QUANTITY_ARRAYS = sc.nextInt();
		SIZE_ARRAY = sc.nextInt();
		ELEMENT_ROW = sc.nextInt() - 1;
		ELEMENT_COLUMN = sc.nextInt() - 1;
		NUM_P = sc.nextInt();
		createElLine(sc);
		sc.close();
	}

	private void createElLine(Scanner sc) {
		elLine = new int[SIZE_ARRAY];
		sc.nextLine();
		sc.nextLine();
		for (int i = 0; i < SIZE_ARRAY; i++) {
			if (i==ELEMENT_ROW) {
				for (int j = 0; j < SIZE_ARRAY; j++) {
					elLine[j] = sc.nextInt();
				}
				sc.nextLine();
				continue;
			}
			sc.nextLine();
		}
		
		for (int n = 1; n < QUANTITY_ARRAYS; n++) {
			int [] sum = new int [SIZE_ARRAY];
			for (int i = 0; i < SIZE_ARRAY; i++) {
				for (int j = 0; j < SIZE_ARRAY; j++) {
					sum[j]+=sc.nextInt()*elLine[i];
					if (i==SIZE_ARRAY-1 && sum[j]>=NUM_P) {
						sum[j]%=NUM_P;
					}
				}
			}
			elLine = sum;
		}
	}

	public static void main(String[] args) throws IOException {

		Main obj = new Main();
		obj.printAnswer();

	}

	private void printAnswer() throws IOException {
		FileWriter writer = new FileWriter("output.txt");
		writer.write(elLine[ELEMENT_COLUMN] + "");
		writer.close();
	}

}
