public class LinearSearch {
	public static void main(String[] args) {
		int[] arrayScode = { 102, 800, 201, 101, 283, 430, 181, 550 };
		String[] arraySname = { "事務机B型", "応接机", "会議用机", "事務机A型", "折り畳み机", "木製机", "脇机", "学生机" };
		KeyIn ki = new KeyIn();
		
		int code = ki.readInt("商品コード");
		
		int idx;
		for(idx = 0; (idx < arrayScode.length) && (code != arrayScode[idx]); idx++) ;
		
		if(idx < arrayScode.length) {
			System.out.println(arraySname[idx]);
		} else {
			System.out.println("登録されていない商品コードです");
		}
	}
}