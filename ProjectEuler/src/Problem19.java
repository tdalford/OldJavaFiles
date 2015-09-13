
public class Problem19 {
	// figure out how the days change switching months
	//variable for year
	//variable for day of first Sunday
	//count as Sundays on firsts of months and add up
	//got it first try!
	public static void main(String[] args) {
		int sundays = 0;
		int daysofmonth = 0;
		int dayofmonth = 6;
		for (int year = 1901; year<2001; year++) {
			for (int month = 1; month < 13; month++) {
				if (month == 4 || month == 6 || month == 9 || month == 11) {
			daysofmonth = 30;
				}
				else if(month == 2) {
					if (year % 4 == 0) {
						daysofmonth = 29;
					}
					else {
						daysofmonth = 28;
					}
				}
				else {
					daysofmonth = 31;
				}
				if (dayofmonth == 1) {
					sundays++;
				}
				while (dayofmonth <= (daysofmonth-7)) {
					dayofmonth+=7;					
				}
				
				dayofmonth = 7-(daysofmonth - dayofmonth);
				
				
			}
		}
		System.out.println(sundays);
	}
}
