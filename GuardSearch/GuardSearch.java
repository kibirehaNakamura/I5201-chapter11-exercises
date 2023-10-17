public class GuardSearch {
	public static void main(String[] args) {
		int[] arrayScode = { 102, 800, 201, 101, 283, 430, 181, 550, -1 };
		String[] arraySname = { "事務机B型", "応接机", "会議用机", "事務机A型", "折り畳み机", "木製机", "脇机", "学生机", "" };
		KeyIn ki = new KeyIn();
		
		int code = ki.readInt("商品コード");
		arrayScode[arrayScode.length - 1] = code;
		
		int idx;
		for(idx = 0; code != arrayScode[idx]; idx++) ;
		
		if(idx < (arrayScode.length - 1)) {
			System.out.println(arraySname[idx]);
		} else {
			System.out.println("登録されていない商品コードです");
		}
	}
}