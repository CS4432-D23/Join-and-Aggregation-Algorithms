import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class section2 {

    public void nestedJoin() {

        ArrayList<String> recordList = new ArrayList<>();

        File Adirectory = new File("Project3Dataset-A");
        File Bdirectory = new File("Project3Dataset-B");

        int count = 0;

        // make the array
        for (File Afile : Adirectory.listFiles()) {

            String recordArr[] = new String[500];

            try {
                BufferedReader br = new BufferedReader(new FileReader(Afile));
                String line = br.readLine();
                String[] recordArray = line.split("\\.\\.\\."); // split the line into records
                for (String record : recordArray) {
                    String[] fieldArray = record.split(","); // split the record into fields
                    int RandomV = Integer.parseInt(fieldArray[3].replaceAll("\\s", "")); // extract the RandomV
                    if (recordArr[RandomV - 1] == null) {
                        recordArr[RandomV - 1] = record;
                    } else {
                        recordArr[RandomV - 1] = recordArr[RandomV - 1] + "..." + record;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            // print out the array
            // for (int i = 1 ; i < recordArr.length + 1 ; i++) {
            // System.out.println("randomV " + i + ": " + recordArr[i - 1]);
            // }

            for (File Bfile : Bdirectory.listFiles()) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(Bfile));
                    String line = br.readLine();
                    String[] recordArray = line.split("\\.\\.\\."); // split the line into records
                    for (String record : recordArray) {
                        String[] fieldArray = record.split(","); // split the record into fields
                        int BRandomV = Integer.parseInt(fieldArray[3].replaceAll("\\s", "")); // extract the RandomV

                        for (int i = BRandomV; i < 500; i++) {
                            if (recordArr[i] != null) {
                                String[] recordArr2 = recordArr[i].split("\\.\\.\\.");
                                for (String record2 : recordArr2) {
                                    String[] fieldArray2 = record2.split(",");
                                    int ARandomV = Integer.parseInt(fieldArray2[3].replaceAll("\\s", ""));
                                    if (ARandomV > BRandomV) {
                                        // recordList.add(record + "..." + record2);
                                        count++;
                                    }
                                }

                            }
                        }

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            for (String record : recordList) {
                // System.out.println(record);
            }

        }

        System.out.println(count);

    }

}
