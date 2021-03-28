package hust.soict.globalict.garbage;

public class ConcatenationInLoops {
	public static void main(String args[]){  
		StringBuilder sb=new StringBuilder("czczcz ");  
		sb.append("czxczxczcz"); 
		
		 StringBuffer sBuffer = new StringBuffer("czczcz ");
	      sBuffer.append("czxczxczcz");
	      
	     String str= "czczcz " +"czxczxczcz";
		}  
}
