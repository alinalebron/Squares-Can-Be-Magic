/**
 * File : MagicSquareTester.java
 *
 * A
 *
 * I affirm that this program is entirely my own work and none of it is the work of any other person.
 * Created by @AlinaLebron on 2/24/15.
 */
public class MagicSquareTester {


    public static void main(String[] args) {

        MagicSquare magic = new MagicSquare();

        if(magic.isMagic()) {

            System.out.println(magic.toString());

            System.out.println("The square is magic");

        }

        else {

            System.out.println("Sorry! This square isn't magic!");
        }

    }

}
