public class Problem14 {
	public static void main(String[] args) {
		int terms = 1;
		int maxterms = 0;
		int most = 0;
		for (int a = 2; a<1000000; a++) {
			long testnumb = a;
			while (testnumb > 1) {
				if (testnumb % 2 == 0) {
					testnumb/=2;
				}
				else {
					testnumb = 3*testnumb + 1;
				}
				terms++;
			}
			if (terms > maxterms) {
				maxterms = terms;
				most = a;
			}
			terms = 1;
	}
		System.out.println(most);
	}
		
}
