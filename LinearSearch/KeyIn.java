import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class KeyIn {
	String buf = null;
	
	public String readString() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in, Charset.forName(System.getProperty("native.encoding"))));
			buf = br.readLine();
		} catch(IOException e) {
			System.out.println(e);
			System.exit(1);
		}
		return buf;
	}
	
	
	public String readString(String msg) {
		System.out.print(msg + ">");
		return readString();
	}
	
	
	public int readInt() {
		int inputIntValue;
		while(true) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in, Charset.forName(System.getProperty("native.encoding"))));
				buf = br.readLine();
				inputIntValue = Integer.parseInt(buf);
				break;
			} catch(IOException e) {
				System.out.println(e);
				System.exit(1);
			} catch(NumberFormatException e) {
				System.out.println("整数値を入力してください : " + buf);
				System.out.print("再入力>");
			}
		}
		return inputIntValue;
	}
	
	
	public int readInt(String msg) {
		System.out.print(msg + ">");
		return readInt();
	}
}