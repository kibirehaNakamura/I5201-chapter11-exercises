public class InsertSort {
	public static void main(String[] args) {
		int[] arrayScode = { 102, 800, 201, 101, 283, 430, 181, 550 };
		String[] arraySname = { "事務机B型", "応接机", "会議用机", "事務机A型", "折り畳み机", "木製机", "脇机", "学生机" };
		
		for(int i = 1; i < arrayScode.length; i++) {
			for(int j = i; j > 0; j--) {
				if(arrayScode[j - 1] > arrayScode[j]) {
					int tempCode = arrayScode[j];
					arrayScode[j] = arrayScode[j - 1];
					arrayScode[j - 1] = tempCode;
					String tempName = arraySname[j];
					arraySname[j] = arraySname[j - 1];
					arraySname[j - 1] = tempName;
				} else {
					break;
				}
			}
		}
		
		for(int i = 0; i < arrayScode.length; i++) {
			System.out.println(arrayScode[i] + "\t" + arraySname[i]);
		}
	}
}