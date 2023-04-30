import java.util.Scanner;
import java.util.Set;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("");
            System.out.println("\nProgram is ready and waiting for user command.");
            String Command = sc.nextLine();
            System.out.println("");
            String[] commandArray = Command.split(" ");

            if (Command.equals("SELECT A.Col1, A.Col2, B.Col1, B.Col2  FROM  A, B WHERE A.RandomV = B.RandomV")) {
                System.out.println("");
                long startTime = System.currentTimeMillis();
                section1 s1 = new section1();
                s1.buildTable();
                s1.equalJoin();
                long endTime = System.currentTimeMillis();
                System.out.println("");
                System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
            }

            else if(Command.equals("SELECT count(*)  FROM  A, B WHERE A.RandomV > B.RandomV")) {
                System.out.println("");
                long startTime = System.currentTimeMillis();

                section2 s2 = new section2();
                
                s2.nestedJoin();

                long endTime = System.currentTimeMillis();
                System.out.println("");
                System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");

            }

            else if(Command.toUpperCase().equals("EXIT")) {
                System.out.println("");
                System.out.println("Program terminated.");
                break;
            }

            else {
                System.out.println("");
                System.out.println("Invalid command. Please try again.");
            }
        }

        

    }
}
