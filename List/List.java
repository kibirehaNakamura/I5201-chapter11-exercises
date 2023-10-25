public class List {
	public static void main(String[] args) {
		final int END_OF_LIST = -1;
		int[] arrayNum = { 20, 40, 10, 0, 30, 0, 0, 0 };
		int[] arrayScore = { 22, 44, 11, 0, 33, 0, 0, 0 };
		int[] arrayNext = { 4, -1, 0, 5, 1, 6, 7, -1 };
		int lip = 2;	// リストの先頭を示すポインタ
		int eip = 3;	// 空きリストの先頭を示すポインタ
		
		KeyIn ki = new KeyIn();
		int kind;
		while(0 <= (kind = ki.readInt("操作(0:検索/1:表示/2:追加/3:更新/4:削除/-1:終了)"))) {
			switch(kind) {
			case 0:	// 検索(ListSearchの流用)(データない時はその旨表示した方がよさそうなので後で直す)
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
				break;
				
			case 1:	// 表示
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
				break;
				
			case 2:	// 追加
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
				break;
				
			case 3:	// 更新
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
				break;
				
			case 4:	// 削除
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
				break;
				
			default:
				break;
			}
		}
		System.out.println("---- プログラム終了 ----");
	}
}