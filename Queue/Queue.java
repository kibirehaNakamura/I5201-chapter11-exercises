/**
 * キューの処理(内容の表示、enqueue、dequeue)を行うクラスです。
 * テキストの【プログラムの一部分】を参考に作成しました。
 *
 */
public class Queue {
	/**
	 * キー入力を受け付けるためのKeyInインスタンスを生成します。
	 * 
	 */
	static KeyIn ki = new KeyIn();
	
	/**
	 * プログラムのエントリーポイントです。
	 * 
	 */
	public static void main(String[] args) {
		int[] arrayQueue = createNewQueue();
		int front = 0;	// キューの先頭位置のポインタ
		int rear = 0;	// キューの末尾の次の位置のポインタ
		
		Loop:
		while(true) {
			int kind = selectMenu();
			switch(kind) {
			case 0:	// 表示
				showQueue(arrayQueue, front, rear);
				break;
				
			case 1:	// 格納
				rear = enqueue(arrayQueue, front, rear);
				break;
				
			case 2:	// 取出
				front = dequeue(arrayQueue, front, rear);
				break;
				
			case -1:
				System.out.println("----プログラム終了----");
				break Loop;
				
			default:	// 指定外
				System.out.println("種別の入力エラーです");
				break;
			}
		}
	}
	
	/**
	 * 作成する配列の要素数を聞き、配列を作成するメソッドです。
	 * 
	 * @return 入力された値(2以上)の個数の要素を持つ配列
	 */
	private static int[] createNewQueue() {
		System.out.println("(指定した数 - 1)個のキューバッファが用意されます");
		int element;	// 配列要素数
		while((element = ki.readInt("配列要素数")) < 2) ;	// 2以上が入力されるまでループ
		int[] arrayQueue = new int[element];
		System.out.println((element - 1) + "個の要素を格納できます");
		
		return arrayQueue;
	}
	
	/**
	 * 操作メニューを表示し、範囲内の入力された値を返すメソッドです。
	 * 
	 * @return 入力された、-1から2までの整数
	 */
	private static int selectMenu() {
		int kind;
		do {
			kind = ki.readInt("種別(0:表示/1:格納/2:取出/-1:終了)");
		} while(kind < -1 || 2 < kind);
		
		return kind;
	}
	
	/**
	 * キューの配列、先頭と末尾の次のポインタを受け取り、キューの内容を表示するメソッドです。
	 * 
	 * @param arrayQueue キューの配列
	 * @param front      先頭のポインタ
	 * @param rear       末尾の次のポインタ
	 */
	private static void showQueue(int[] arrayQueue, int front, int rear) {
		if(front == rear) {
			queueEmpty();
		} else {
			for(int i = front, count = 0; i != rear; i++, count++) {
				System.out.println("[" + count + "] " + arrayQueue[i]);
				if(i >= (arrayQueue.length - 1)) {
					i = -1;
				}
			}
		}
	}
	
	/**
	 * キューの配列、先頭と末尾の次のポインタを受け取り、入力された要素をキューに格納するメソッドです。
	 * 
	 * @param arrayQueue キューの配列
	 * @param front      先頭のポインタ
	 * @param rear       末尾の次のポインタ
	 * @return 要素格納後の、末尾の次のポインタ
	 */
	private static int enqueue(int[] arrayQueue, int front, int rear) {
		if((rear + 1) == front || ((rear + 1 - arrayQueue.length) == front)) {
			queueFull();
		} else {
			arrayQueue[rear] = ki.readInt("データ(整数)");
			rear += 1;
			if(rear >= arrayQueue.length) {
				rear = 0;
			}
		}
		
		return rear;
	}
	/**
	 * キューの配列、先頭と末尾の次のポインタを受け取り、キューの先頭の要素を取り出して表示するメソッドです。
	 * 
	 * @param arrayQueue キューの配列
	 * @param front      先頭のポインタ
	 * @param rear       末尾の次のポインタ
	 * @return 要素取り出し後の、先頭のポインタ
	 */
	private static int dequeue(int[] arrayQueue, int front, int rear) {
		if(front == rear) {
			queueEmpty();
		} else {
			System.out.println(arrayQueue[front]);
			front += 1;
			if(front >= arrayQueue.length) {
				front = 0;
			}
		}
		
		return front;
	}
	
	/**
	 * 「キューが一杯です」と表示するメソッドです。
	 *
	 */
	private static void queueFull() {
		System.out.println("キューが一杯です");
	}
	
	/**
	 * 「データが格納されていません」と表示するメソッドです。
	 * 
	 */
	private static void queueEmpty() {
		System.out.println("データが格納されていません");
	}
}