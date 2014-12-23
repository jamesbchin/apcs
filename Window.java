public class Window {
    
    private int myNumRows, myNumCols;
    private int [ ] [ ] myMat;
    
    public Window(int r, int c) {
	myNumRows = r;
	myNumCols = c;

	myMat = new int[r][c];
	fillWindow();
    }

    public void fillWindow() {
	for (int i=0; i < myNumRows; i++ )
	    for (int j = 0; j < myNumCols; j++ )
		myMat[i][j] = (int)(Math.random() * 90) + 10;
    }
	
    public String toString() {
	String s = "";

	for (int i=0; i < myNumRows; i++ ) {
	    for (int j = 0; j < myNumCols; j++ )
		s+= myMat[i][j] + " ";
	    s+= "\n";
	}
	return s;
    }


    //SOLUTIONS GO HERE!!!

    public boolean isInBounds(int row, int col) {
    
    if (row >= 0 && col >= 0 && row < myNumRows && col < myNumCols)
      return true;
    else    
      return false;
      
    }
    
    public void colorSquare( int ULrow, int ULcol, int n, int val ) {
    
    for (int i = ULrow; i < ULrow + n; i++) {
      for (int j = ULcol; j < ULcol + n; j++) {
        myMat[i][j] = val;
      }
    }
    
    }
    
    public void enlarge( int ULrow, int ULcol, int numRows, int numCols, int factor ) {

    int [][] save = new int[numRows][numCols];
    
    for (int i = ULrow; i < ULrow + numRows - 1; i++) {
      for (int j = ULcol; j < ULcol + numCols - 1; j++) {
        save[i - ULrow][j - ULrow] = myMat[i][j];
        System.out.println(save[i - ULrow][j - ULrow]);
      }
    }
    
    int col, row;
    int c, r = 0;
    
    while (c < myNumCols && r < myNumRows) {
      for (r = ULrow; r < ULrow + numRows - 1; r++) {
        for (c = ULcol; c < ULcol + numCols - 1; c++) {
          
        }
      }
    }
    }
    
    public static void main(String[] args) {

	Window w = new Window(10, 9);
	System.out.println(w);
  w.enlarge(2,2,4,4,3);
	System.out.println(w);
  w.colorSquare(1,1,5,40);
	System.out.println(w);
	
	
    }
}
