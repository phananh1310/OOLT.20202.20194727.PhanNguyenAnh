package hust.soict.globalict.garbage;

public class NoGarbage {
	public static void main(String[] args) 
	{
		long i;
		StringBuilder sb=new StringBuilder("czczczsdasdasdada "); 
		while(true) {
			sb=new StringBuilder("czczczsdasdasdada ");
			System.gc();
			System.out.println("OK");
		}
}

}
