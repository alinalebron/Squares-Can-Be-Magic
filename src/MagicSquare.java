import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by alina on 2/22/15.
 */
public class MagicSquare {

    private int [][] square; // the table aka the square


    /**
     * Constructs a magic square object
     * with the same amount of rows and colums
     */

    public MagicSquare() {

        getSize();
        fillSquare();

    }

    /**
     * A method that sets the size from the user.
     * It only accepts positive odd-numbered values
     *
     */

    private void getSize() {

        Scanner input= new Scanner((System.in));

        int n;
        do {
            System.out.println("Please enter an odd number: ");
            n = input.nextInt();
        } while (n % 2 == 0 );

        square = new int[n][n];

    }







    /**
     * Fills the square with integers 1 to N
     * according to these rules:
     *
     * 1. Place a 1 in the "middle" column of the last row.
     * 2. Place the integers from 2 to N^2 into the matrix in succession, according to these rules:
     *
     *  a.	Attempt to place each number in a position that is one row below and one column to the right
     *  of the previous number.
     *
     *  b.	If rule (a.) leads to a non-existent row and a non-existent column, then the number is
     *  placed instead in the position directly above the previous number (i.e., same column, previous row).
     *
     *  c.	If rule (a.) leads to a non-existent row, then the number is placed instead in the first row,
     *  one column to the right.
     *
     *  d.	If rule (a.) leads to a non-existent column, then the number is placed instead in the
     *  first column, one row down.
     *
     *  e.	If rule (a.) leads to a position that is not empty (i.e., already contains a value),
     *  then the number is placed instead in the position directly above the previous number.
     *
     */

    private void fillSquare () {

        System.out.println("filling square");
        int n = square.length - 1;

        int size = (n+1) * (n+1);

        int row = n;
        int column = n / 2;

        square[row][column] = 1;

       // to start filling in the square, starting from 2

        for (int i = 2; i < size + 1 ; i++) {

            /*
             Applies rule a
             */

            if ( ((row + 1) <= n) && ((column + 1) <= n) ) {
                /*
                Applies rule e
                */
                if (square[row + 1][column + 1] != 0) {

                    row--;

                    square[row][column] = i;

                    System.out.println("row: " + row + " " + "column: " + column + " " + "i: " + i + " ");
                    System.out.println();

                }
                else {

                    row++;

                    column++;

                    square[row][column] = i;

                    System.out.println("row: " + row + " " + "column: " + column + " " + "i: " + i + " ");
                    System.out.println();
                }
            }

            /*
             Applies rule b
             */

            else if (((row + 1) > n) && ((column + 1) > n)) {

                row--;

                square[row][column] = i;

                System.out.println("row: " + row + " " + "column: " + column + " " + "i: " + i + " ");
                System.out.println();            }

            /*
            Applies rule c
             */

            else if (((row + 1) > n) && ((column + 1) <= n)) {

                row = 0;

                column++;

                square[row][column] = i ;

                System.out.println("row: " + row + " " + "column: " + column + " " + "i: " + i + " ");
                System.out.println();            }

            /*
            Applies rule d
             */

            else if (((column + 1) > n) && ((row + 1) <= n )) {

                column = 0;

                row++;

                square[row][column] = i;


                System.out.println("row: " + row + " " + "column: " + column + " " + "i: " + i + " ");
                System.out.println();

            }


        }

    }

    /**
     * Calculates the sum of all of the numbers
     * in one row
     * @param total the initial total of the row
     * @return the sum of an entire row
     */

    public int rowSum(int total) {

        return total;
    }

    public int columnSum (int total) {

        return total;
    }

    /**
     * Calculates the sum of all of the numbers
     * from the diagonal going left-to-right
     * (left-most column in the first row to the right-most
     * column in the last row)
     * @param total
     * @return
     */

    public int diagonalOneSum (int total) {

        return total;
    }

    /**
     * Calculates the sum of all of the numbers
     * from the diagonal going right-to-left
     * (right-most column in the first row to the left-most
     * column in the last row)
     * @param total
     * @return
     */

    public int diagonalTwoSum(int total) {

        return total;
    }



    /**
     * Tells if the square is magic
     * if and only if the sum of every row,
     * column, and both diagonals are equal
     * @return true or false if the square is magic
     */

    public boolean isMagic () {

        /*TODO:
        Compare the sums of each row, column
        and both diagonals
        and see if they're equal
        if row 1 == row 2 == row 3...==column 1...==diagonalOne==diagonalTwo
         */
        return true;
    }


    /**
     * Prints out the magic square in a
     * multi-line string
     * @return
     */
    @Override
    public String toString() {

        String whatever = Arrays.deepToString(square);


        return whatever;
    }
}
