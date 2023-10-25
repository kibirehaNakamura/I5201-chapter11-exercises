public class BinarySearchTree {
	public static void main(String[] args) {
		final int END_OF_TREE = -1;
		int[] arrayNum   = {  5,  2,  7,  9,  1,  3,  0,  0 };
		int[] arrayScore = { 50, 20, 70, 90, 10, 30,  0,  0 };
		int[] arrayLeft  = {  1,  4, -1, -1, -1, -1, -1, -1 };
		int[] arrayRight = {  2,  5,  3, -1, -1, -1, -1, -1 };
		int pt = 0;
		KeyIn ki = new KeyIn();
		
		int num;
		while(0 < (num = ki.readInt("学籍番号(0:終了)"))) {
			int idx = pt;
			while(idx != END_OF_TREE && arrayNum[idx] != num) {
				if(arrayNum[idx] < num) {
					idx = arrayRight[idx];
				} else {
					idx = arrayLeft[idx];
				}
			}
			if(idx == END_OF_TREE) {
				System.out.println("見つかりませんでした");
			} else {
				System.out.println("点数 = " + arrayScore[idx]);
			}
		}
		System.out.println("---- プログラム終了 ----");
	}
}