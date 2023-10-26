public class Euclid {
	public static void main(String[] args) {
		KeyIn ki = new KeyIn();
		int a = 0;
		while(a < 1 || 40000 < a) {
			a = ki.readInt("a(1-40000)");
		}
		int b = 0;
		while(b < 1 || 40000 < b) {
			b = ki.readInt("b(1-40000)");
		}
		
		int gcd = a;	// 最大公約数
		int div = b;	// 除数
		int rem;	// 剰余
		
		while(0 < div) {	// 最大公約数GCDを求める
			rem = gcd % div;
			gcd = div;
			div = rem;
		}
		
		int lcm = (a * b) / gcd;	// 最小公倍数
		
		System.out.println("最大公約数GCD = " + gcd);
		System.out.println("最小公倍数LCM = " + lcm);
	}
}