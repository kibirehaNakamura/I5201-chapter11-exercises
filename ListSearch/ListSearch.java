public class ListSearch {
	public static void main(String[] args) {
		final int END_OF_LIST = -1;
		int[] arrayNum = { 20, 40, 10, 0, 30, 0, 0, 0 };
		int[] arrayScore = { 22, 44, 11, 0, 33, 0, 0, 0 };
		int[] arrayNext = { 4, -1, 0, 5, 1, 6, 7, -1 };
		int lip = 2;	// リストの先頭を示すポインタ
		int eip = 3;	// 空きリストの先頭を示すポインタ
		
		KeyIn ki = new KeyIn();
		int num;
		while(0 < (num = ki.readInt("番号(0:終了)"))) {
			int idx = lip;
			while((idx != END_OF_LIST) && (num != arrayNum[idx])) {
				idx = arrayNext[idx];
			}
			
			if(idx != END_OF_LIST) {
				System.out.println(arrayScore[idx]);
			} else {
				System.out.println("見つかりませんでした");
			}
		}
	}
}