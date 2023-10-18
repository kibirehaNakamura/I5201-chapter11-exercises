public class Stack {
	public static void main(String[] args) {
		final int STACK_EMPTY = -1;
		KeyIn ki = new KeyIn();
		
		int element;	// スタックサイズ
		while((element = ki.readInt("スタック要素数")) < 1) ;	// 1以上の値が入力されるまで聞き続ける
		
		int[] arrayStack = new int[element];	// スタック保存領域
		int sp = STACK_EMPTY;	// スタックポインタ
		int kind;	// 処理種別
		
		while(0 <= (kind = ki.readInt("種別(0:表示/1:push/2:pop/-1:終了)"))) {
			switch(kind) {
			case 0:
				if(sp == STACK_EMPTY) {
					System.out.println("スタックされていません");
				} else {
					for(int i = sp; i > -1; i--) {
						System.out.println("[" + i + "] " + arrayStack[i]);
					}
				}
				break;
				
			case 1:
				if(sp == arrayStack.length - 1) {
					System.out.println("スタックが一杯です");
				} else {
					sp += 1;
					arrayStack[sp] = ki.readInt("データ(整数)");
				}
				break;
				
			case 2:
				if(sp == STACK_EMPTY) {
					System.out.println("スタックされていません");
				} else {
					System.out.println(arrayStack[sp]);
					sp -= 1;
				}
				break;
				
			default:
				System.out.println("種別の入力エラーです");
				break;
			}
		}
		System.out.println("----プログラム終了----");
	}
}