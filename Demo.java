import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Demo {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		//得到一个信息摘要器
		MessageDigest digest = MessageDigest.getInstance("md5");
		System.out.println(digest.toString());
		String password = "123456";
		//byte[] result = digest.digest(password.getBytes());
		byte[] result = password.getBytes();
		StringBuffer buffer = new StringBuffer();
		//把每一个byte与0xff做一个与运算
		for(byte b : result) {
			//与运算
			int number = b & 0xff;
			String str = Integer.toHexString(number);
			//System.out.println(str);
			if (str.length() == 1) {
				buffer.append("0");
			}
			buffer.append(str);
		}
		System.out.println(buffer.toString());
	}
}
