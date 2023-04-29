import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        section1 s1 = new section1();
        s1.buildTable();

        if (section1.datasetA_Table.containsKey(229)) {
            for (String record : section1.datasetA_Table.get(229) ) {
                System.out.println(record);
            }
        }
        

        // while (true) {
        //     System.out.println("\nProgram is ready and waiting for user command.");
        //     String Command = sc.nextLine();
        //     System.out.println("");





        // }
    }
}