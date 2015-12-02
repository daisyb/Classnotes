//import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Gauss{
    double[][] matrix;
    int[] leadIndices; 
    int col, row;
    Random rnd = new Random();

    public Gauss(int n, int m){
        matrix = new double[n][m];
	leadIndices = new int[n];
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

    public boolean isZero(double value, double threshold){
	return value >= -threshold && value <= threshold;
    }


    /**
       finds index of first non-zero number in row
    **/
    public int leadIndex(int r){
	for(int i = 0;i<col;i++){

	    if(!isZero(matrix[r][i], Math.pow(10,-5))){
		return i;
	    }
	}
	return (col-1);
    }

    /**
       fills array of non-zero indices for all rows
       for easy acess and storage
    **/
    public void fillLeadIndices(){
	for(int i = 0; i < matrix.length;i++){
	    System.out.println(leadIndex(i));
	    leadIndices[i] = leadIndex(i);
	    System.out.print(leadIndices[i]);
	}
	System.out.println();
    }

    /**
        Exchanges values of row at index a row at index b
	also modifies leadIndicies array
    */
      public void exchange(int a, int b){
        for(int i=0;i<row;i++){
	    double tmp = matrix[a][i];
            matrix[a][i] = matrix[b][i];
	    matrix[b][i] = tmp;
	    int alead = leadIndices[a];
	    leadIndices[a] = leadIndices[b];
	    leadIndices[b] = alead;
	}
    }

    /** 
        dilates row r by dilation factor d
    **/
    public void dilate(int r, double d){
        for(int i =0;i<row;i++){
            matrix[r][i] = d*matrix[r][i];
        }
    }

    // // /**
    // //     performs a sheer on row a by row b and a factor of c
    // // **/
    // // public void sheer(int a, int b, double c){
    // //     for(int i=0;i<row;i++){
    // //         matrix[a][i] += matrix[b][i] * c;
    // // 	    leadIndices[a] = leadIndex(a);
    // //     }
    // //  }
		 

    // // /**
    // //    sorts matrix rows by lead entries
    // //    leadIndices is used/exists to avoid looping through to find
    // //    the lead entry index every comparison
    // // **/
    // // public void sort(){
    // // 	for(int i = 0; i < row-1; i++){
    // // 	    for(int j = 1; j < row-i;j++){
		
    // // 		if(leadIndices[j-1] > leadIndices[j]){
    // // 		    S
			ystem.out.println(j+ " " +leadIndices[j-1] + " " + leadIndices[j]);
		    exchange(j-1,j);
		    System.out.println(this);
		}
	    }
	}
    }

		    
    
    public void reduce(){ 
	for(int i = 0; i<row;i++){
	    sort();
	    //System.out.println(this);
	    //sets dialtion factor to the reciprical of lead entry
	    double dFactor = matrix[i][leadIndices[i]];
	    //System.out.println("lead " + leadIndices[i]);
	    //System.out.println(dFactor);
	    if(dFactor != 0){
	    dFactor = 1/dFactor;
	    //System.out.println(dFactor);
	    dilate(i,dFactor);
	    //System.out.println(this);
	    for(int j = i+1;j < row; j++){
		double c = -1*(matrix[j][leadIndices[i]]);	
		sheer(j,i,c);
	     }
	    //System.out.println("new lead " + leadIndices[col-1]);
	    }
	}		
    }
    
    /**
       Sets column j to values in col
       Any unspecified values are set to zero
    **/
    public void setCol(int j, double[] colVals){
	for(int i = 0; i < row;i++){
	    if(i<colVals.length){
		matrix[i][j] = colVals[i];
	    } else {
		matrix[i][j] = 0;
	    }
	}
    }
    
    /**
       Same as first setCol but takes
       a string separated by columns instead of
       a double[]
    **/
    public void setCol(int j, String s){
	String[] colVals = s.split(",");
	for(int i = 0; i< row;i++){
	    String cv = colVals[i].replaceAll("\\ .,","");
	    if (i < colVals.length){
		matrix[i][j] = Double.parseDouble(cv);
	    }else {
		matrix[i][j] = 0;
	    }
	}
    }
    
    /**
       Takes a string of numbers separated by commas
       and adds them to row i
       any unspecified values are set to zero
    **/
    public void setRow(int i, String s){
	String[] rowVals = s.split(",");
	for(int j = 0; j < row;j++){
	    String rv = rowVals[i].replaceAll("\\ .,","");
	     if (i < rowVals.length){
		matrix[i][j] = Double.parseDouble(rv);
	    }else {
		matrix[i][j] = 0;
	    }
	}
    }


    /**
       fills the matriz for random values between 0 and maxVal
    **/
    public void randomMatrix(int maxVal){
	for(int i =0; i<row;i++){
	    for(int j=0;j<col;j++){
		//increases likelihood of a zero
		if(Math.random() < .4){
		    matrix[i][j] = 0;
		} else {
		    matrix[i][j] = (double)rnd.nextInt(maxVal);
		}
	    }
	}
	fillLeadIndices();
    }
    
    //default randomMatrix
    public void randomMatrix(){
	randomMatrix(10);
    }

    public String noFormat(){
	String s = " _         _\n";
	for(int i =0; i<row;i++){
	    s+= "| ";
	    for(int j=0;j<col;j++){
		double d = matrix[i][j];
		
		if(matrix[i][j] == -0.0){//java has negative zeros
		    s+= 0.0 + " ";
		} else {
		    s+=matrix[i][j] +" ";
		}
		
	    }
	    s+="|\n";
	}
	return s;
    }

    public String toString(){
	String s = " _         _\n";
	DecimalFormat decimalFormat = new DecimalFormat("#0.###");
	for(int i =0; i<row;i++){
	    s+= "| ";
	    for(int j=0;j<col;j++){
		double d = matrix[i][j];		
		if(d == -0.0){//java has negative zeros
		    s+= 0.0 + " ";
		} else {
		    	s+= decimalFormat.format(d) + " ";
		}
		
	    }
	    s+="|\n";
	}
	return s;
    }

    public static void pause(int n){
       try {
	   Thread.sleep(n);
	   } catch (Exception e) {}
    }


    public static void main(String[] args){
	
	Scanner scan = new Scanner(System.in);
	String input;
	System.out.println(Math.pow(10,-5));
	System.out.println("Set the space");
	pause(5);
	
	System.out.println("\n# of rows:");
	input  = scan.nextLine();
	int rows = Integer.parseInt(input.trim());
	
	System.out.println("\n# of columns");
	input = scan.nextLine();
	int cols = Integer.parseInt(input.trim());
	Gauss g = new Gauss(rows,cols);
	pause(2);
	
	System.out.println("\nRandom Matrix? y/n");
	input = scan.nextLine();
	input = input.trim().toLowerCase();

	if (input.equals("n") || input.equals("no")){
	    System.out.println("\n\nInput column values as a list of numbers separated by commas");
	    pause(4);
	    System.out.println("eg. 1,2,3,4,5 . . .");
	    pause(4);
	    String colVals;
	    for(int j = 0;j<cols;j++){
		System.out.println("\ncol " + (j+1) + ": ");
		colVals = scan.nextLine();
		g.setCol(j, colVals);
	    }
	} else{
	    g.randomMatrix(10);
	} 
	System.out.println(g);
	g.sort();
	System.out.println(g);
	
	/*
	pause(5);
	g.fillLeadIndices();
	System.out.println("\n\n\nOrginal Matrix");
	System.out.println(g);
	g.sort();
	System.out.println("\n" + g);
	g.reduce();
	pause(5);
	System.out.println("\n\n\nReduced Echelon Form");
	System.out.println(g);
	System.exit(0);
	
	*/
	
	/*
	Gauss g = new Gauss(5,5);
	g.randomMatrix(10);
	System.out.println(g);
	g.sort();
	System.out.println(g);
	g.reduce();
	System.out.println(g);
	*/
    }
}    
