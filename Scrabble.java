
import java.util.Scanner;

public class Scrabble {

    public static Scanner scan = new Scanner(System.in);//scanner for all inputs besides choice of selection.
    protected static Scanner sc = new Scanner(System.in);//scanner for choice of selection.

    // Initializing and declaring the attributes for details...
    public static String Alphabets = "a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z",
            Player1, Player2, inputOfPlayer1, inputOfPlayer2, reply, YesORNO;
    public static int choice, count = 1;
    char arr[], new_char;//array that will convert string to char arrays
    int combined1 = 0;
    int combined2 = 0;

// this method prints out the details of all the players playing as well as the game being played.
    public void Print() {
        // Game begins.....
        System.out.println("WELCOME TO THE WORD WARS GAME");

        System.out.println("Press (1) to start the game. "
                + "\n" + "Press ANY NUMBER to exit the game"
                + "\n" + "ENTER YOUR SELECTION");
        choice = sc.nextInt();

        switch (choice) {
            case 1:

                System.out.println("************************" + "\n" + "Enter player 1 name: ");
                Player1 = scan.nextLine();

                System.out.println("************************" + "\n" + "Enter player 2 name: ");
                Player2 = scan.nextLine();

                System.out.println("LETS PLAY!!! ");
                System.out.println("Alphabet letters left:" + Alphabets);

                while (count < 2)  
                {
                    
                    //loop for player 1
                    System.out.println(Player1 + " Please enter you word");
                    inputOfPlayer1 = scan.next().toLowerCase();//program is case sensitive

                    if (!inputOfPlayer1.equals("???")) {
                        System.out.println("\n" + "Enter yes if both players agree on the word entered>>");
                        reply = scan.next();

                        arr = inputOfPlayer1.toCharArray();
                        valid();
                    } else {
                        if (inputOfPlayer1.equals("???")) {
                            winner();
                        }
                        PlayAgain();
                        System.exit(0);
                    }

                    //loop for player two
                    System.out.println(Player2 + " Please enter you word");
                    inputOfPlayer2 = scan.next().toLowerCase();//program is case sensitive

                    if (!inputOfPlayer2.equals("???")) {
                        System.out.println("\n" + "Enter yes if both players agree on the word entered>>");
                        reply = scan.next();
                        arr = inputOfPlayer2.toCharArray();
                        valid();

                    } else {
                        if (inputOfPlayer2.equals("???")) {
                            winner();
                        }
                        PlayAgain();
                        System.exit(0);//forcely stops the game once player types "???"
                    }
                }
                break;
            default:
                System.out.println("GOODBYE!!!");//game ends!!!
        }

    }

// this method determines the winner of the game.
    public void winner() {
        combined1 += inputOfPlayer1.length();
        combined2 += inputOfPlayer2.length();

        //final results
        if (combined1 > combined2) {
            System.out.println("WINNER OF THE GAME IS: " + Player1 + " WITH A SCORE OF:" + combined1
                    + "\n" + " YOUR NAME HAS BEEN SAVED TO THE HALL OF FAME !!!"
                    + "\n" + " THE GAME IS NOW OVER.THANK YOU FOR PLAYING WORD WARS!!!");

        } else if (combined1 < combined2) {
            System.out.println("WINNER OF THE GAME IS: " + Player2 + " WITH A SCORE OF:" + combined2
                    + "\n" + " YOUR NAME HAS BEEN SAVED TO THE HALL OF FAME !!!"
                    + "\n" + " THE GAME IS NOW OVER.THANK YOU FOR PLAYING WORD WARS!!!");
        } else if (combined1 == combined2) {
            System.out.println("WINNERS OF THE GAME ARE: " + Player2 + " WITH A SCORE OF: " + combined2
                    + "\n" + " AND " + Player1 + " WITH A SCORE OF: " + combined1
                    + "\n" + " YOUR NAMES HAS BEEN SAVED TO THE HALL OF FAME !!!"
                    + "\n" + " THE GAME IS NOW OVER.THANK YOU FOR PLAYING WORD WARS!!!");
        }

    }

// this method has the code to remove letters selected by each player to create a word.
    public void valid() {
        for (char c : arr) {
            int position = Alphabets.indexOf(c);

            if (position != -1 && Alphabets.charAt(position) != 'a' && Alphabets.charAt(position) != 'e'
                    && Alphabets.charAt(position) != 'i'
                    && Alphabets.charAt(position) != '0'
                    && Alphabets.charAt(position) != 'u') {
                 new_char = (Alphabets.charAt(position));
                Alphabets = Alphabets.replace(c, ' ');
            }
        }
        if (reply.equals("yes")) {
            System.out.println("Alphabet letters left :" + Alphabets);
        } else {
            System.out.println("YOU HAVE ENTERED AN INVALID WORD THAT MAY EITHER CONTAIN A NON EXISTING LETTER/LETTERS ");
        }
    }

    // play again method!
    public void PlayAgain() {
        System.out.println("WOULD YOU LIKE TO PLAY AGAIN??");
        YesORNO = scan.next();
        if (YesORNO.equals("yes")) {
            Print();
        } else {
            System.out.println("THANK YOU FOR PLAYING!!!");
        }
    }
}
