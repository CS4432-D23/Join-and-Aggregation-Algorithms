import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class section1 {

    public HashMap<Integer, ArrayList<String>> datasetA_Table = new HashMap<>(50);

    public void buildTable() {

        File directory = new File("Project3Dataset-A");

        for (File file : directory.listFiles()) {
            // System.out.println(file.getName());
            // System.out.println(file);

            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                String[] recordArray = line.split("\\.\\.\\."); // split the line into records
                for (String record : recordArray) {
                    String[] fieldArray = record.split(","); // split the record into fields
                    int RandomV = Integer.parseInt(fieldArray[3].replaceAll("\\s", "")); // extract the RandomV

                    // System.out.println(RandomV);
                    // for (String s : fieldArray) {
                    //     System.out.println(s.replace(" ", ""));
                    // }

                    if (datasetA_Table.containsKey(RandomV)) { // if the RandomV is already in the table
                        ArrayList<String> recordList = datasetA_Table.get(RandomV);
                        recordList.add(record);
                        datasetA_Table.put(RandomV, recordList);
                    }
                    else { // if the RandomV is not in the table
                        ArrayList<String> recordList = new ArrayList<>();
                        recordList.add(record);
                        datasetA_Table.put(RandomV, recordList);
                    };

                }
                br.close();
            } catch (Exception e) {
                System.out.println("Error reading file: " + file);
                e.printStackTrace();
            }
            
        }
        

    }
    
    public void equalJoin() {
        ArrayList <String> recordList = new ArrayList<>();
        File directory = new File("Project3Dataset-B");

        for (File file : directory.listFiles()) {
            // System.out.println(file.getName());
            // System.out.println(file);

            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                String[] recordArray = line.split("\\.\\.\\."); // split the line into records
                for (String record : recordArray) {
                    String[] fieldArray = record.split(","); // split the record into fields
                    int RandomV = Integer.parseInt(fieldArray[3].replaceAll("\\s", "")); // extract the RandomV
                    // String col1 = fieldArray[0].substring(fieldArray[0].indexOf('-') + 1);
                    String col1 = fieldArray[0].replaceAll("\\s", "");
                    String col2 = fieldArray[1].replaceAll("\\s", "");
                    // System.out.println(col1 + " " + col2);
                    if (datasetA_Table.containsKey(RandomV)) {
                        ArrayList<String> randomVList = datasetA_Table.get(RandomV);
                        for (String SR : randomVList) {
                            String[] SRfieldArray = SR.split(","); // split the record into fields
                            int SRRandomV = Integer.parseInt(fieldArray[3].replaceAll("\\s", "")); // extract the RandomV
                            // String SRCol1 = SRfieldArray[0].substring(SRfieldArray[0].indexOf('-') + 1);
                            String SRCol1 = SRfieldArray[0].replaceAll("\\s", "");
                            String SRCol2 = SRfieldArray[1].replaceAll("\\s", "");
                            if (SRRandomV == RandomV) {
                                String newRecord = col1 + ", " + col2 + ", " + SRCol1 + ", " + SRCol2;
                                recordList.add(newRecord);
                                System.out.println(newRecord);
                            }
                        }
                    }


                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (String record : recordList) {
            // System.out.println(record);
        }
        // System.out.println("# of Records: " + recordList.size());

    }

}
