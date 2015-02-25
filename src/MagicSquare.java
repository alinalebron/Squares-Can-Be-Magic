/**
 * File : MagicSquare.java
 *
 * A class that represents a magic square object.
 * This magic square is a square matrix
 * (N rows by N columns) with the following properties:
 * 1.	It contains the numbers 1 through N2,
 * with each number appearing exactly once.
 * 2.	The sums of each row, each column,
 * and both main diagonals are equal.
 *
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 * Created by @AlinaLebron on 2/24/15.
 */


import java.util.Scanner;


public class MagicSquare
{

    private int [][] square; // the table aka the square


    /**
     * Constructs a magic square object
     * with two methods that set the size
     * of the magic square and fills the square
     * accordingly.
     */

    public MagicSquare()
    {

        setSize();
        fillSquare();

    }

    /**
     * A method that sets the size
     * of the magic square from the user.
     * It only accepts positive odd-numbered values.
     */

    private void setSize()
    {

        Scanner input= new Scanner((System.in)); // retrieves user input

        int n; // will represent the integer (one side of the square)

        /*
        Checks to see if the user types in an even number or odd
        number. If the user types in an even number, it asks
        again for an odd number.
         */

        do
        {

            System.out.println("Please enter an odd number: ");

            n = input.nextInt(); // stores the input
        }

        while (n % 2 == 0 ); // checks if division by 2 yields a 0 remainder

        square = new int[n][n]; // creates the 2D array with "n x n" size

    }


    /**
     * Fills the square with integers 1 to N
     * according to these rules:
     *
     * 1. Place a 1 in the "middle" column of the last row.
     * 2. Place the integers from 2 to N^2 into the
     * matrix in succession, according to these rules:
     *
     *  a.	Attempt to place each number in a position that is
     *  one row below and one column to the right
     *  of the previous number.
     *
     *  b.	If rule (a.) leads to a non-existent row and
     *  a non-existent column, then the number is placed instead in
     *  the position directly above the previous number
     *  (i.e., same column, previous row).
     *
     *  c.	If rule (a.) leads to a non-existent row,
     *  then the number is placed instead in the first row,
     *  one column to the right.
     *
     *  d.	If rule (a.) leads to a non-existent column,
     *  then the number is placed instead in the
     *  first column, one row down.
     *
     *  e.	If rule (a.) leads to a position that is not
     *  empty (i.e., already contains a value),
     *  then the number is placed instead in the
     *  position directly above the previous number.
     *
     */

    private void fillSquare ()
    {

        /*
         * Bogus output for debugging
         */

        /*
         * System.out.println("filling square");
         */

        /*
         * Creates a variable that represents the
         * length of rows & columns according to
         * array principles (in example
         * length of 3 goes from
         * index 0 - 2 which = length - 1)
         */

        int n = square.length - 1;

        /*
         * Sets the size of the 2D array
         */

        int size = (n+1) * (n+1);

        /*
         * Places the first number, "1"
         * in the last row, middle column.
         */

        int row = n;

        int column = n / 2;

        square[row][column] = 1; // places the 1

       /*
        * Starts filling the square, from the next integer (2)
        * while following the set of rules
        * listed above until it reaches the
        * size of the magic square (the 2D array)
        */

        for (int i = 2; i < size + 1 ; i++) //
        {

            /*
             * Applies rule a
             */

            if ( ((row + 1) <= n) && ((column + 1) <= n) ) // row & column exist
            {

                /*
                 * Applies rule e
                 */

                if (square[row + 1][column + 1] != 0) // if the cell isn't empty
                {

                    row--; // move up a row only

                    square[row][column] = i; // place the next integer there

                    /*
                     * Console print for debugging
                     */

                    /*
                     * System.out.println("row: " + row + " "
                            + "column: " + column + " " + "i: " + i + " ");
                     * System.out.println();
                     */


                }

                else
                {

                    row++; // move down a row

                    column++; // move right a column

                    square[row][column] = i; // place the next number there

                    /*
                     * Console print for debugging
                     */

                    /*
                     * System.out.println("row: " + row + " "
                            + "column: " + column + " " + "i: " + i + " ");
                     * System.out.println();
                     */
                }
            }

            /*
             * Applies rule b
             */

            else if (((row + 1) > n) && ((column + 1) > n)) // row & column don't exist

            {

                row--; // move up a row

                square[row][column] = i; // place the number there

                 /*
                  * Console print for debugging
                  */

                 /*
                  * System.out.println("row: " + row + " "
                            + "column: " + column + " " + "i: " + i + " ");
                  * System.out.println();
                  */

            }

            /*
             * Applies rule c
             */

            else if (((row + 1) > n) && ((column + 1) <= n)) // row doesn't exist
            {

                row = 0; // move to the first row

                column++; // move a column to the right

                square[row][column] = i ; // place the number there

                 /*
                  * Console print for debugging
                  */

                 /*
                  * System.out.println("row: " + row + " "
                            + "column: " + column + " " + "i: " + i + " ");
                  * System.out.println();
                  */

            }

            /*
             * Applies rule d
             */

            else if (((column + 1) > n) && ((row + 1) <= n ))  // the column doesn't exist
            {

                column = 0; // move to the first column

                row++; // move one row down

                square[row][column] = i; // place the number there


                 /*
                  * Console print for debugging
                  */

                 /*
                  * System.out.println("row: " + row + " "
                            + "column: " + column + " " + "i: " + i + " ");
                  * System.out.println();
                  */

            }


        }

    }

    /**
     * Calculates the sum of all of the numbers
     * in one row and compares it to a constant sum
     * to see if all rows are equal.
     * This method is executed in the isMagic() method
     * to compare the sums of the rows with the sums
     * of the diagonals and columns.
     * @param square the 2D array (the magic square)
     * @param constant the magic sum of a row : n(n^2 +1)/2
     * @return 0 if it's not equal, 1 if it is
     */

    public int checkRows(int[][] square, int constant)
    {


        for (int i = 0; i < square.length ; i++)
        {

            int rowSum = 0 ; // initializes the total of the row

            for (int j = 0; j < square[i].length ; j++) // iterates through each column

            {

                rowSum += square[i][j]; // adds the value of each cell to the sum

            }

            if (rowSum != constant)

            {

                return 0;

            }

        }

        return 1;
    }

    /**
     * Calculates the sum of all of the numbers
     * in one column and compares it to a constant sum
     * to see if all columns are equal.
     * This method is executed in the isMagic() method
     * to compare the sums of the columns with the sums
     * of the diagonals and rows.
     * @param square the 2D array (the magic square)
     * @param constant the magic sum of a column : : n(n^2 +1)/2
     * @return 0 if it's not equal, 1 if it is
     */

    public int checkColumns (int[][] square, int constant)
    {

        for (int i = 0; i < square.length ; i++)
        {

            int colSum = 0 ; // initializes the total of the column

            for (int j = 0; j < square[i].length ; j++)
            {

                colSum += square[j][i]; // adds the value of each cell to the sum

            }

            if (colSum != constant)
            {

                return 0;

            }

        }

        return 1;
    }

    /**
     * Calculates the sum of all of the numbers
     * from the diagonal going left-to-right
     * (left-most column in the first row to the right-most
     * column in the last row)
     * and the diagonal going right-to-left
     * (right-most column in the first row to the left-most
     * column in the last row)
     * @param square the 2D array (the magic square)
     * @param constant the magic sum of a diagonal: : n(n^2 +1)/2
     * @return 0 if it's not equal, 1 if it is
     */

    public int checkDiagonals(int[][] square, int constant)
    {

        int diagonalSum = 0;

        for (int i = 0; i < square.length ; i++) // checks first diagonal
        {

            diagonalSum += square[i][i];

        }

        if (diagonalSum != constant)
        {

            return 0;
        }

        diagonalSum = 0 ;

        for (int i = square.length - 1; i > -1 ; i--) // checks second diagonal
        {

            diagonalSum += square[i][i];

        }

        if (diagonalSum != constant)
        {

            return 0;

        }

        else
        {

            return 1;

        }


    }

    /**
     * Tells if the square is magic
     * if and only if the sum of every row,
     * column, and both diagonals are equal
     * @return true or false if the square is magic
     *
     */

    public boolean isMagic ()
    {

        int length = square.length; // assigns length of array to a variable

        /*
         * The magic square constant or magic sum, represented by the
         * formula M = n * (n^2 + 1) / 2
         */
        int constant = (length * ((length * length) + 1)) / 2;

        /*
         * Applies check methods from above to the rows, columns,
         * and diagonals
         */

        int rowsSum = checkRows(square, constant);
        int columnsSum = checkColumns(square, constant);
        int diagonalsSum = checkDiagonals(square, constant);

        /*
         * Checks if all sums returned 1 (which means the
         * sums are equal). If so, the entire square is magic!
         */

        if ((rowsSum == 1) && (columnsSum == 1) && (diagonalsSum == 1) )
        {

            return true; // it's magic!

        }

        else
        {

            return false;

        }

    }


    /**
     * Prints out the magic square in a
     * multi-line string
     * @return the magic square in table format
     */

    @Override
    public String toString()
    {

        String thePrint = ""; // initializes an empty string

        for (int i = 0; i < square.length ; i++) // iterates through each row
        {

            for (int j = 0; j <square[i].length ; j++) // iterates through each column
            {
                /*
                 * Adds each integer to the string with a space by converting
                 * that integer to a string
                 */

                thePrint += Integer.toString(square[i][j]) + " ";
                
            }

            thePrint += "\n";

        }

        return thePrint;
    }
}
