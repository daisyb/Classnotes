import java.util.Random;


public class Gauss{
    int[][] matrix;
    int col, row;
    Random rnd = new Random();

    public Gauss(int n, int m){
        matrix = new int [n][m];
        row = n;
        col = m;
    }

    /**
       Sets value at row r col c to n
       for imputing data
    **/
    public void set(int r, int c, int n){
        matrix[r][c] = n;
    }

    /**
        Exchanges values of row at index a with those of row at index b
    **/
    
    public void exchange(int a, int b){
        for(int i=0;i<row;i++){
	    int tmp = matrix[a][i];
            matrix[a][i] = matrix[b][i];
	    matrix[b][i] = tmp;
	}
    }
    
    /** 
        dilates row r by dilation factor d
    **/
    public void dilate(int r, int d){
        for(int i =0;i<row;i++){
            matrix[r][i] = d*matrix[r][i];
        }
    }
    /**
        performs a sheer on row a by row b and a factor of c
    **/

    public void sheer(int a, int b, int c){
        for(int i=0;i<row;i++){
            matrix[a][i] += matrix[b][i] * c;
        }
     }

    public boolean checkLeads(int[] a, int[] b){
	for(int i=0;i<a.length && i<b.length;i++){
	    if(a[i] = 0 && b[i] != 0){
		return false;
	    }
	    if(a[i] = 

    public int[][] reduce(){ 
	for(int i=0;i<col;i++){
	    for(int k=0;k<col;k++){
		
    }

    /**
       fills the matriz for random values between 0 and maxVal
    **/
    public void randomMatrix(int maxVal){
	for(int i =0; i<row;i++){
	    for(int j=0;j<col;j++){
		matrix[i][j] = rnd.nextInt(maxVal);
	    }
	}
    }
    
    //default randomMatrix
    public void randomMatrix(){
	randomMatrix(10);
    }

    public String toString(){
	String s = " _         _\n";
	for(int i =0; i<row;i++){
	    s+= "| ";
	    for(int j=0;j<col;j++){
		s+=matrix[i][j] +" ";		
	    }
	    s+="|\n";
	}
	return s;
    }

    public static void main(String[] args){
	Gauss g = new Gauss(5,5);
	g.randomMatrix(10);
	System.out.println(g);
	g.sheer(2,3,-2);
	System.out.println(g);
    }
}    
