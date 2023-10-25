public class ScoreInput {
	public static void main(String[] args) {
		KeyIn ki = new KeyIn();
		
		/* データ入力件数の入力 */
		int dataNum;
		while(true) {
			dataNum = ki.readInt("入力するデータの件数(1-100)");
			if(1 <= dataNum && dataNum <= 100) break;
			System.out.println("1から100までの数値を入力してください");
		}
		
		/* 入力データ数分の配列を生成してデータの入力 */
		int[] arrayNum = new int[dataNum];
		String[] arrayName = new String[dataNum];
		int[] arrayScore = new int[dataNum];
		for(int i = 0; i < dataNum; i++) {
			while(true) {
				arrayNum[i] = ki.readInt((i + 1) + "人目の学籍番号(7桁以内)");
				if(0 < arrayNum[i] && arrayNum[i] < 10000000) break;
				System.out.println("学籍番号は7桁以内で入力してください");
			}
			while(true) {
				arrayName[i] = ki.readString((i + 1) + "人目の名前(16文字以内)");
				if(0 < arrayName[i].length() && arrayName[i].length() <= 16) break;
				System.out.println("名前は1文字以上16文字以内で入力してください");
			}
			while(true) {
				arrayScore[i] = ki.readInt((i + 1) + "人目の点数(0-100)");
				if(0 <= arrayScore[i] && arrayScore[i] <= 100) break;
				System.out.println("点数は0から100の間の数値を入力してください");
			}
		}
		
		/* 選択ソートで学籍番号の昇順にソート */
		for(int i = 0; i < (dataNum - 1); i++) {
			for(int j = (i + 1); j < dataNum; j++) {
				if(arrayNum[i] > arrayNum[j]) {
					int tempInt = arrayNum[i];
					arrayNum[i] = arrayNum[j];
					arrayNum[j] = tempInt;
					String tempStr = arrayName[i];
					arrayName[i] = arrayName[j];
					arrayName[j] = tempStr;
					tempInt = arrayScore[i];
					arrayScore[i] = arrayScore[j];
					arrayScore[j] = tempInt;
				}
			}
		}
		
		/* ファイル名を指定してオープン */
		FileOut fo = new FileOut();
		boolean flag = fo.open(ki.readString("出力ファイル名"));
		if(flag == false) {
			System.out.println("ファイルオープンエラー");
			System.out.println("プログラムを終了します");
			System.exit(1);
		}
		
		/* データを整形して書き込み */
		for(int i = 0; i < dataNum; i++) {
			String writeLetter = arrayNum[i] + "," + arrayName[i] + "," + arrayScore[i];
			flag = fo.writeln(writeLetter);
			if(flag == false) {
				System.out.println("データ書き込みエラー");
				System.out.println("プログラムを終了します");
				fo.close();
				System.exit(1);
			}
		}
		
		/* ファイルをクローズ */
		flag = fo.close();
		if(flag == false) {
			System.out.println("ファイルクローズエラー");
			System.out.println("プログラムを終了します");
			System.exit(1);
		}
		
		System.out.println(dataNum + "件のデータを出力しました");
		System.out.println("プログラムを終了します");
	}
}