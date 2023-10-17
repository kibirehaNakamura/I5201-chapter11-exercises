public class SectionSearch {
	public static void main(String[] args) {
		int[] arrayWeight = { 50, 75, 100, 150, 200, 250, 500, 750, 1000, 2000, 3000, 4000 };
		int[] arrayRate = { 120, 140, 160, 200, 240, 270, 390, 580, 700, 950, 1150, 1350 };
		KeyIn ki = new KeyIn();
		
		int weight = ki.readInt("重量");
		if(weight > 4000) {
			System.out.println("取り扱いできません");
		} else if(weight < 0) {
			System.out.println("反重力物質は取り扱いできません");
		} else {
			int i;
			for(i = 0; i < arrayWeight.length; i++) {
				if(weight <= arrayWeight[i]) break;
			}
			
			System.out.println(arrayRate[i] + "円");
		}
	}
}