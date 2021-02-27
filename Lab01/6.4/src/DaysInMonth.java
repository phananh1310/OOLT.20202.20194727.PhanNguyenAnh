// year has more than 4 digits and force to input digits
import java.util.Scanner;
import java.util.ArrayList;
public class DaysInMonth {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input day and year: ");
		boolean k=false, year=false, month=false;
		String strMonth, strYear;
		int YEAR=1000,MONTH=1;
		ArrayList<String> arrayList = new ArrayList<String>(48);
		arrayList.add("1");
		arrayList.add("2");
		arrayList.add("3");
		arrayList.add("4");
		arrayList.add("5");
		arrayList.add("6");
		arrayList.add("7");
		arrayList.add("8");
		arrayList.add("9");
		arrayList.add("10");
		arrayList.add("11");
		arrayList.add("12");
		arrayList.add("January");
		arrayList.add("February");
		arrayList.add("March");
		arrayList.add("April");
		arrayList.add("May");
		arrayList.add("June");
		arrayList.add("July");
		arrayList.add("August");
		arrayList.add("September");
		arrayList.add("October");
		arrayList.add("November");
		arrayList.add("December");
		arrayList.add("Jan");
		arrayList.add("Feb");
		arrayList.add("Mar");
		arrayList.add("Apr");
		arrayList.add("May");
		arrayList.add("Jun");
		arrayList.add("Jul");
		arrayList.add("Aug");
		arrayList.add("Sep");
		arrayList.add("Oct");
		arrayList.add("Nov");
		arrayList.add("Dec");
		arrayList.add("Jan.");
		arrayList.add("Feb.");
		arrayList.add("Mar.");
		arrayList.add("Apr.");
		arrayList.add("May.");
		arrayList.add("Jun.");
		arrayList.add("Jul.");
		arrayList.add("Aug.");
		arrayList.add("Sep.");
		arrayList.add("Oct.");
		arrayList.add("Nov.");
		arrayList.add("Dec.");
		int[] CommonYear = {31,28,31,30,31,30,31,31,30,31,30,31};
		while (!k) {
			while(!month) {
				System.out.printf("Input month: ");
				strMonth = keyboard.nextLine();
				if (arrayList.contains(strMonth)) {
					month=true;
					MONTH = (arrayList.indexOf(strMonth)+1)%12;
					
				}
				}
			while (!year) {
				System.out.printf("Input year: ");
				strYear = keyboard.nextLine();
				YEAR = Integer.parseInt(strYear);
				if (YEAR>=1000)
					year=true;
			}
			k = year||month;
		}
		
		System.out.printf("# of days: ");
		if (((((YEAR % 4 == 0) && (YEAR % 100 != 0)) || (YEAR % 400 == 0)))&&MONTH==2)
		{
				System.out.println(CommonYear[MONTH-1]+1);	
		}
		else
		{
			System.out.println(CommonYear[MONTH-1]);	
		}
		
		}
		
		
	}

