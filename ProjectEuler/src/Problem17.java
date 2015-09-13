
public class Problem17 {
	public static void main(String[] args) {
	//one- 3
	//two 3
	//three 5
	//four 4
	//five 4
	//six 3
	//seven  5
	//eight 5
	//nine 4

	//—36—

	//ten 3

	//eleven 6
	//twelve 6
	//thir- 8
	//four- 8
	//fif- 7
	//six- 7
	//seven- 9
	//eigh- 8
	//nine- 8

	//—67—  106 total

	//twenty 36+10(6) = 96
	//thir- 39 + 10(6)
	//for- 86
	//fif- 86
	//six- 86
	//seven- 106	
	//eigh- 96
	//nine- 96

	//—854 first hundred—

	//one hundred and 13 (except for first 100) so add 99(13) + 10
	//two-  13 same
	//three- 15 99(15) + 12
	//four- 14 (11, 14)
	//five- 14 
	//six- 13 
	//seven- 15 
	//eight- 15 
	//nine- 14 

	//one thousand 11
	int singles = 10*854;
	int hund = 10+99*13;
	int twund = hund;
	int thrund = 12+99*15;
	int frund = 11+99*14;
	int firund = frund;
	int sirund = hund;
	int serund = thrund;
	int eirund = thrund;
	int nirund = frund;
	int thou = 11;
	System.out.println(singles+hund+twund+thrund+frund+firund+sirund+serund+eirund+nirund+thou);

}

}
