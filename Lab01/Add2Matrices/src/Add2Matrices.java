
public class Add2Matrices {
	public static void main(String args[]){  
		// 2 matrices 3 x 3
		int a[][]={{90,3,4},{132,4,31},{0,1,2}};    
		int b[][]={{31,34,2},{4,4,4},{126,77,12}};    
		      
		int c[][]=new int[3][3];  
		System.out.println("Result: ");
		
		for(int i=0;i<3;i++){    
		for(int j=0;j<3;j++){    
		c[i][j]=a[i][j]+b[i][j];     
		System.out.print(c[i][j]+" ");    
		}    
		System.out.println(); 
		}    
		}

}
