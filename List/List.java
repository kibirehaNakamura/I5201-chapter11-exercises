/**
 * リスト構造で保存されたデータの検索、表示、追加、更新、削除を行えるクラスです。
 * 検索はテキストの疑似言語を元に、それ以外の項目は自分で作成しました。
 * 
 */
public class List {
	/**
	 * 定数とグローバル変数を宣言します。
	 * 
	 */
	static final int END_OF_LIST = -1;
	static int[] arrayNum = { 20, 40, 10, 0, 30, 0, 0, 0 };
	static int[] arrayScore = { 22, 44, 11, 0, 33, 0, 0, 0 };
	static int[] arrayNext = { 4, -1, 0, 5, 1, 6, 7, -1 };
	static int lip = 2;	// リストの先頭を示すポインタ
	static int eip = 3;	// 空きリストの先頭を示すポインタ
	/**
	 * キー入力を処理するKeyInインスタンスを生成します。
	 * 
	 */
	static KeyIn ki = new KeyIn();
	
	/**
	 * プログラムのエントリーポイントです。
	 * 
	 */
	public static void main(String[] args) {
		int kind;
		while(0 <= (kind = ki.readInt("操作(0:検索/1:表示/2:追加/3:更新/4:削除/-1:終了)"))) {
			switch(kind) {
			case 0:	// 検索(ListSearchの流用)
				SearchList();
				break;
				
			case 1:	// 表示
				ShowList();
				break;
				
			case 2:	// 追加
				AddList();
				break;
				
			case 3:	// 更新
				UpdateList();
				break;
				
			case 4:	// 削除
				DeleteList();
				break;
				
			default:
				break;
			}
		}
		System.out.println("---- プログラム終了 ----");
	}
	
	/**
	 * 番号からリスト内の要素を検索するメソッドです。
	 * 
	 */
	private static void SearchList() {
		if(lip == END_OF_LIST) {
			System.out.println("データが格納されていません");
		} else {
			int num;
			while(0 < (num = ki.readInt("検索番号(0:終了)"))) {
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
	
	/**
	 * リスト内の要素を全て表示するメソッドです。
	 * 
	 */
	private static void ShowList() {
		if(lip == END_OF_LIST) {
			System.out.println("データが格納されていません");
		} else {
			int next = lip;
			int count = 1;
			while(next != END_OF_LIST) {
				System.out.println("[" + count + "]" + arrayNum[next] + "番 : " + arrayScore[next] + "点");
				next = arrayNext[next];
				count += 1;
			}
		}
	}
	
	/**
	 * リストの任意の位置に要素を追加するメソッドです。
	 * 
	 */
	private static void AddList() {
		if(eip == END_OF_LIST) {
			System.out.println("データが一杯です");
		} else {
			int add = 0;
			while(add < 1 || arrayNum.length < add) {
				add = ki.readInt("データを追加する場所(1(先頭)～" + arrayNum.length + "(末尾))");
			}
			int idx = lip;
			int count = 1;
			int prev = -1;
			while(count < add && idx != END_OF_LIST) {
				prev = idx;
				idx = arrayNext[idx];
				count += 1;
			}
			int emptyData = eip;	// 空きリストの先頭の配列番号を取得
			eip = arrayNext[emptyData];	// 空きリストの先頭を更新
			arrayNum[emptyData] = ki.readInt("追加データの番号(整数)");
			arrayScore[emptyData] = ki.readInt("追加データの得点(整数)");
			arrayNext[emptyData] = idx;
			if(prev == -1) {
				lip = emptyData;
			} else {
				arrayNext[prev] = emptyData;
			}
			System.out.println("データを" + count + "番目に追加しました");
		}
	}
	/**
	 * リスト内の任意の位置の要素を更新するメソッドです。
	 * 
	 */
	private static void UpdateList() {
		if(lip == END_OF_LIST) {
			System.out.println("データが格納されていません");
		} else {
			int update = 0;
			while(update < 1 || arrayNum.length < update) {
				update = ki.readInt("更新するデータの場所(1(先頭)～" + arrayNum.length + "(末尾))");
			}
			int idx = lip;
			int count = 1;
			while(count < update && idx != END_OF_LIST) {
				idx = arrayNext[idx];
				count += 1;
			}
			if(idx == END_OF_LIST) {
				System.out.println("指定された場所のデータが存在しません");
			} else {
				System.out.println(count + "番目のデータ(" + arrayNum[idx] + "番:" + arrayScore[idx] + "点)を更新します");
				arrayNum[idx] = ki.readInt("更新データの番号(整数)");
				arrayScore[idx] = ki.readInt("更新データの得点(整数)");
				System.out.println("データを更新しました");
			}
		}
	}
	
	/**
	 * リスト内の任意の位置の要素を削除するメソッドです。
	 * 
	 */
	private static void DeleteList() {
		if(lip == END_OF_LIST) {
			System.out.println("データが格納されていません");
		} else {
			int del = 0;
			while(del < 1 || arrayNum.length < del) {
				del = ki.readInt("削除するデータの場所(1(先頭)～" + arrayNum.length + "(末尾))");
			}
			int idx = lip;
			int count = 1;
			int prev = -1;
			while(count < del && idx != END_OF_LIST) {
				prev = idx;
				idx = arrayNext[idx];
				count += 1;
			}
			if(idx == END_OF_LIST) {
				System.out.println("指定された場所のデータが存在しません");
			} else {
				yesnoLoop:
				while(true) {
					char yesno = ki.readString(count + "番目のデータ(" + arrayNum[idx] + "番:" + arrayScore[idx] + "点)を削除します(y/n)").charAt(0);
					switch(yesno) {
					case 'y':	// breakしないで次のcaseの処理を行う
					case 'Y':
						if(prev == -1) {
							lip = arrayNext[idx];
						} else {
							arrayNext[prev] = arrayNext[idx];
						}
						arrayNext[idx] = eip;
						eip = idx;
						System.out.println("削除しました");
						break yesnoLoop;
						
					case 'n':	// breakしないで次のcaseの処理を行う
					case 'N':
						System.out.println("キャンセルしました");
						break yesnoLoop;
						
					default:
						break;
					}
				}
			}
		}
	}
}