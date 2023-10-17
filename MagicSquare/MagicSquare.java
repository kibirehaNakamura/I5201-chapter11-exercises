import java.util.stream.IntStream;

public class MagicSquare {
	public static void main(String[] args) {
		KeyIn ki = new KeyIn();
		int order;
		
		/* 作成する魔方陣の次数の入力 */
		while(true) {
			order = ki.readInt("奇数の魔法陣");
			/* 正の奇数なら進む */
			if(((order % 2) == 1) && (order > 0)) break;
			System.out.println("正の奇数を入力してください");
		}
		
		int[][] magicSqr = new int[order][order];
		
		/* 魔方陣の作成 */
		int row = 0;
		int column = order / 2;
		magicSqr[row][column] = 1;
		for(int num = 2; num <= (order * order); num++) {
			if((num % order) == 1) {
				row += 1;
			} else if(row == 0) {
				row = order - 1;
				column += 1;
			} else if(column == (order - 1)) {
				row -= 1;
				column = 0;
			} else {
				row -= 1;
				column += 1;
			}
			magicSqr[row][column] = num;
		}
		
		/* 魔方陣の表示 */
		for(int i = 0; i < order; i++) {
			for(int j = 0; j < order; j++) {
				System.out.print(magicSqr[i][j] + "\t");
			}
			System.out.println();
		}
		
		int sum = IntStream.of(magicSqr[0]).sum();
		System.out.println("要素の和 = " + sum);
	}
}