import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;

public class section1 {

    public static HashMap<Integer, LinkedList<String>> datasetA_Table = new HashMap<>(50);

    public static void buildTable() {

        File directory = new File("Project3Dataset-A");

        for (File file : directory.listFiles()) {
            // System.out.println(file.getName());

            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                String[] recordArray = line.split("\\.\\.\\."); // split the line into records
                for (String record : recordArray) {
                    String[] fieldArray = record.split(","); // split the record into fields
                    int RandomV = Integer.parseInt(fieldArray[3].replaceAll("\\s", "")); // extract the RandomV

                    System.out.println(RandomV);
                    // for (String s : fieldArray) {
                    //     System.out.println(s.replace(" ", ""));
                    // }

                    if (datasetA_Table.containsKey(RandomV)) { // if the RandomV is already in the table
                        datasetA_Table.get(RandomV).add(record);
                    }
                    else { // if the RandomV is not in the table
                        LinkedList<String> recordList = new LinkedList<>();
                        recordList.add(record);
                        datasetA_Table.put(RandomV, recordList);
                    };

                }
                br.close();
            } catch (Exception e) {
                System.out.println("Error reading file: " + file);
                e.printStackTrace();
            }

            break;
            
        }
        

    }
    
}
