import java.util.Random;
import java.util.ArrayList;
public class Password {

	public static void main(String[] args) {
		EasyWriter outFile = new EasyWriter("passwords.txt");
		for (int i = 0; i < 10; i++)
		{
		String password = "";
		Random rn = new Random();
		// number, capital letter, lowercase letter, symbol

		// number, 48-57
		char numb = (char) (rn.nextInt(10) + 48);
		password = password + numb;

		// capital letter, 65-90
		char cap = (char) (rn.nextInt(26) + 65);
		password = password + cap;

		// lowercase letter, 97-122
		char low = (char) (rn.nextInt(26) + 97);
		password = password + low;

		// symbol, 33-64
		char symb = (char) (rn.nextInt(32) + 33);
		password = password + symb;

		// add random characters, 33-126
		int moreChars = rn.nextInt(10) + 4;
		for (int j = 0; j < moreChars; j++) {
			char rand = (char) (rn.nextInt(94) + 33);
			password = password + rand;
		}
		password = SortAlgs.scramble(password);
		ArrayList<Integer> encrypted = new ArrayList<Integer>();
		System.out.println(password);
		System.out.println();
		outFile.println(password);
		outFile.println(); 
		int[] values = {3, 2, 8, 1, 7,3};
		EncryptAlpha encrypter = new EncryptAlpha(values);
		encrypted = encrypter.encrypt(password);
		String encryptedNum = "";
		for (int j = 0; j < encrypted.size(); j++)
		{
			encryptedNum += encrypted.get(j);
		}
		System.out.println(encryptedNum);
		outFile.println(encryptedNum);
		outFile.println();
		System.out.println();
		}
		outFile.close(); // optional

	}
	

}
