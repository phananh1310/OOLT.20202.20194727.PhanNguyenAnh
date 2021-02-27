import java.util.Scanner;
public class Stars {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.printf("n = ");
		int n = in.nextInt();
		int i=1;
		
		for (int j=n;j>0;j--) {
			for (int t=j-1;t>0;t--)
				System.out.printf(" ");
			for (int t=0;t<i;t++)
				System.out.printf("*");
			System.out.println();
			i+=2;
		}
		
	}
}
