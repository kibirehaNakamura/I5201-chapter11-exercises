public class SelectionSort {
	public static void main(String[] args) {
		int[] arrayScode = { 102, 800, 201, 101, 283, 430, 181, 550 };
		String[] arraySname = { "事務机B型", "応接机", "会議用机", "事務机A型", "折り畳み机", "木製机", "脇机", "学生机" };
		
		for(int i = 0; i < (arrayScode.length - 1); i++) {
			for(int j = i + 1; j < arrayScode.length; j++) {
				if(arrayScode[i] > arrayScode[j]) {
					int tempCode = arrayScode[i];
					arrayScode[i] = arrayScode[j];
					arrayScode[j] = tempCode;
					String tempName = arraySname[i];
					arraySname[i] = arraySname[j];
					arraySname[j] = tempName;
				}
			}
		}
		
		for(int i = 0; i < arrayScode.length; i++) {
			System.out.println(arrayScode[i] + "\t" + arraySname[i]);
		}
	}
}