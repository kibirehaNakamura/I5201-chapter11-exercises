public class ScoreSearch {
	public static void main(String[] args) {
		FileIn fi = new FileIn();
		KeyIn ki = new KeyIn();
		
		/* 入力ファイル名の指定とオープン */
		String fileName = ki.readString("成績ファイル名");
		boolean flag = fi.open(fileName);
		if(flag == false) {
			System.out.println("ファイルオープンエラー");
			System.out.println("プログラムを終了します");
			System.exit(1);
		}
		
		/* レコード件数のカウント */
		int recordNum = 0;
		String record = "";
		while(record != null) {
			record = fi.readLine();
			if(record != null) {
				recordNum += 1;
			}
		}
		
		/* 一旦クローズ */
		flag = fi.close();
		if(flag == false) {
			System.out.println("ファイルクローズエラー");
			System.out.println("プログラムを終了します");
			System.exit(1);
		}
		
		/* レコードが0件ならあきらめとく */
		if(recordNum <= 0) {
			System.out.println("レコードが1件も存在しません");
			System.out.println("プログラムを終了します");
			System.exit(0);
		}
		
		/* 配列の生成 */
		String[] arrayNum = new String[recordNum];	// 検索の都合上文字列型の方がいいので文字列型にしている
		String[] arrayName = new String[recordNum];
		int[] arrayScore = new int[recordNum];
		
		/* 再オープン */
		flag = fi.open(fileName);
		if(flag == false) {
			System.out.println("ファイルオープンエラー");
			System.out.println("プログラムを終了します");
			System.exit(1);
		}
		
		/* レコードを読み取りながら配列におさめる */
		for(int i = 0; i < recordNum; i++) {
			try {
				record = fi.readLine();
				String[] recordSplit = record.split(",");
				Integer.parseInt(recordSplit[0]);	// 学籍番号に数字以外が入っていないかの確認 動作上は必要ない
				arrayNum[i] = recordSplit[0];
				while(arrayNum[i].length() < 7) {	// 学籍番号が7桁未満の時に頭に0を追加して7桁にする
					arrayNum[i] = "0" + arrayNum[i];
				}
				arrayName[i] = recordSplit[1];
				arrayScore[i] = Integer.parseInt(recordSplit[2]);
			} catch(NumberFormatException e) {	// Integer.parseInt()が通らなかったとき
				System.out.println("レコードに誤りがあります : " + record);
				System.out.println("数字のみが入る場所に数字以外が入っています");
				System.out.println("このレコードを読み込まないで続行します");
				arrayNum[i] = "-1";
				arrayName[i] = "";
				arrayScore[i] = -1;
				continue;
			} catch(ArrayIndexOutOfBoundsException e) {	// splitしたレコードの配列外を参照してしまったとき
				System.out.println("レコードに誤りがあります : " + record);
				System.out.println("レコードの区切りの数が足りません");
				System.out.println("このレコードを読み込まないで続行します");
				arrayNum[i] = "-1";
				arrayName[i] = "";
				arrayScore[i] = -1;
				continue;
			} catch(Exception e) {	// その他ぜんぶ
				System.out.println("予期せぬエラー : " + e);
				System.out.println("プログラムを終了します");
				fi.close();
				System.exit(1);
			}
		}
		
		/* 配列に入れたらクローズしちゃっていいでしょ */
		flag = fi.close();
		if(flag == false) {
			System.out.println("ファイルクローズエラー");
			System.out.println("プログラムを終了します");
			System.exit(1);
		}
		
		/* 検索処理 */
		while(true) {
			String searchNum = ki.readString("検索学籍番号(入力しないでEnterで終了)");
			if(searchNum == null) {
				System.out.println("ｶﾞｯ");
				continue;
			}
			if(searchNum.isEmpty()) break;
			int i;
			for(i = 0; i < recordNum; i++) {
				if(searchNum.equals(arrayNum[i])) break;
			}
			if(i < recordNum) {
				System.out.println("学籍番号 : " + arrayNum[i]);
				System.out.println("氏名　　 : " + arrayName[i]);
				System.out.println("点数　　 : " + arrayScore[i]);
			} else {
				System.out.println("指定した学籍番号のデータは見つかりませんでした");
			}
		}
		
		System.out.println("---- プログラム終了 ----");
	}
}