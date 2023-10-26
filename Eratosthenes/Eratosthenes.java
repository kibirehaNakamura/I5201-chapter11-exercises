public class Eratosthenes {
	public static void main(String[] args) {
		KeyIn ki = new KeyIn();
		int range;
		while(true) {
			range = ki.readInt("いくつまで？");
			if(range >= 2) break;
		}
		
		/* 初期値設定 */
		boolean[] arrayPrime = new boolean[range + 1];
		arrayPrime[2] = true;
		for(int i = 3; i < arrayPrime.length; i += 2) {
			arrayPrime[i] = true;
		}
		
		/* n(添字)の倍数をfalseに設定 */
		double end = Math.sqrt((double)range);
		for(int i = 3; i < end; i += 2) {
			if(arrayPrime[i] == true) {
				for(int j = i * 2; j < arrayPrime.length; j += i) {
					arrayPrime[j] = false;
				}
			}
		}
		
		/* 素数の表示 */
		int count = 0;
		for(int i = 2; i < arrayPrime.length; i++) {
			if(arrayPrime[i] == true) {
				if(i == 2) {
					System.out.print(i);
				} else {
					System.out.print(", " + i);
				}
				count += 1;
			}
		}
		System.out.println();
		System.out.println(count + "個");
	}
}