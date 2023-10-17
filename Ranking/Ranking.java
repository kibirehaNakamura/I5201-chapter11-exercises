public class Ranking {
	public static void main(String[] args) {
		int[] arrayMark = { 90, 75, 100, 60, 95, 70, 85, 80, 90, 80 };
		int[] arrayRank = {  1,  1,   1,  1,  1,  1,  1,  1,  1,  1 };
		
		/* 順位付けループ */
		for(int i = 0; i < arrayMark.length; i++) {
			for(int j = 0; j < arrayMark.length; j++) {
				if(arrayMark[i] < arrayMark[j]) {
					arrayRank[i] += 1;
				}
			}
		}
		
		/* 順位付け後の配列の内容の表示 */
		for(int i = 0; i < arrayMark.length; i++) {
			System.out.println((i + 1) + "人目\t" + arrayMark[i] + "点\t" + arrayRank[i] + "位");
		}
	}
}