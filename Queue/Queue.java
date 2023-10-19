public class Queue {
	public static void main(String[] args) {
		KeyIn ki = new KeyIn();
		
		System.out.println("(指定した数 - 1)個のキューバッファが用意されます");
		int element;
		/* ここテキストだと「element < 1」だけどそれだと一つも要素が入れられないバッファが作られる可能性ありません？ */
		while((element = ki.readInt("配列要素数")) < 2) ;
		int[] arrayQueue = new int[element];
		System.out.println((element - 1) + "個の要素を格納できます");
		
		int kind;
		int front = 0;
		int rear = 0;
		while(0 <= (kind = ki.readInt("種別(0:表示/1:格納/2:取出/-1:終了)"))) {
			switch(kind) {
			case 0:
				if(front == rear) {
					System.out.println("データが格納されていません");
				} else {	// 別にリングバッファ状に処理するか否かで処理分ける必要なくない？
					for(int i = front, count = 0; i != rear; i++, count++) {
						System.out.println("[" + count + "] " + arrayQueue[i]);
						if(i >= (arrayQueue.length - 1)) {
							i = -1;
						}
					}
				}
				break;
				
			case 1:
				if((rear + 1) == front || ((rear + 1 - arrayQueue.length) == front)) {
					System.out.println("キューが一杯です");
				} else {
					arrayQueue[rear] = ki.readInt("データ(整数)");
					rear += 1;
					if(rear >= arrayQueue.length) {
						rear = 0;
					}
				}
				break;
				
			case 2:
				if(front == rear) {
					System.out.println("データが格納されていません");
				} else {
					System.out.println(arrayQueue[front]);
					front += 1;
					if(front >= arrayQueue.length) {
						front = 0;
					}
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