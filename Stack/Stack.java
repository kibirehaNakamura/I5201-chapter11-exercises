/**
 * スタックの処理(内容の表示、push、pop)を行うクラスです。
 * テキストの【プログラムの一部分】を参考に作成しました。
 * 
 */
public class Stack {
	/**
	 * キー入力を受け付けるためのKeyInインスタンスを生成します。
	 * 
	 */
	static KeyIn ki = new KeyIn();
	
	/**
	 * 定数を宣言します。
	 * 
	 */
	static final int STACK_EMPTY = -1;	// スタックが空である状態の定数
	
	
	/**
	 * プログラムのエントリーポイントです。
	 * 
	 */
	public static void main(String[] args) {
		int element;	// スタックサイズ
		
		while((element = ki.readInt("スタック要素数")) < 1) ;	// 1以上の値が入力されるまで聞き続ける
		
		int[] arrayStack = new int[element];	// スタック保存領域
		int sp = STACK_EMPTY;	// スタックポインタ
		
		Loop:
		while(true) {
			int kind = select();
			switch(kind) {
			case 0:	// 表示
				showStack(arrayStack, sp);
				break;
				
			case 1:	// push
				sp = pushStack(arrayStack, sp);
				break;
				
			case 2:	// pop
				sp = popStack(arrayStack, sp);
				break;
				
			case -1:	// 終了
				System.out.println("----プログラム終了----");
				break Loop;
				
			default:	// 指定外
				System.out.println("種別の入力エラーです");
				break;
			}
		}
	}
	
	/**
	 * 操作メニューを表示し、入力された値を返すメソッドです。
	 * 
	 * @return 入力された-1から2までの整数
	 */
	private static int select() {
		int kind;
		do {
			kind = ki.readInt("種別(0:表示/1:push/2:pop/-1:終了)");
		} while(kind < -1 || 2 < kind);
		
		return kind;
	}
	
	/**
	 * スタックの配列とスタックポインタを受け取り、スタックの内容を表示するメソッドです。
	 * 
	 * @param arrayStack スタック配列
	 * @param sp         スタックポインタ
	 */
	private static void showStack(int[] arrayStack, int sp) {
		if(sp == STACK_EMPTY) {
			stackEmpty();
		} else {
			for(int i = sp; i > -1; i--) {
				System.out.println("[" + i + "] " + arrayStack[i]);
			}
		}
	}
	
	/**
	 * スタックの配列とスタックポインタを受け取り、入力されたデータをpushし、push後のスタックポインタの値を返すメソッドです。
	 * 
	 * @param arrayStack スタック配列
	 * @param sp         スタックポインタ
	 * @return push後のスタックポインタの値
	 */
	private static int pushStack(int[] arrayStack, int sp) {
		if(sp == arrayStack.length - 1) {
			stackFull();
		} else {
			sp += 1;
			arrayStack[sp] = ki.readInt("データ(整数)");
		}
		
		return sp;
	}
	
	/**
	 * スタックの配列とスタックポインタを受け取り、データをpopしながらpopしたデータを表示し、pop後のスタックポインタの値を返すメソッドです。
	 * 
	 * @param arrayStack スタック配列
	 * @param sp         スタックポインタ
	 * @return pop後のスタックポインタの値
	 */
	private static int popStack(int[] arrayStack, int sp) {
		if(sp == STACK_EMPTY) {
			stackEmpty();
		} else {
			System.out.println(arrayStack[sp]);
			sp -= 1;
		}
		
		return sp;
	}
	/**
	 * 「スタックが空です」と表示するメソッドです。
	 * 
	 */
	private static void stackEmpty() {
		System.out.println("スタックが空です");
	}
	
	/**
	 * 「スタックが一杯です」と表示するメソッドです。
	 * 
	 */
	private static void stackFull() {
		System.out.println("スタックが一杯です");
	}
}