import java.io.File;
import java.util.Scanner;

public class LowerBoundOfInstance {
    public int[][] lowerBound;
    public int[][] upperBound;
    public String[][] nameInstance;
    public LowerBoundOfInstance(String fileName, int numClass, int numInstancesClass) throws Exception {
        Scanner s = new Scanner (new File(fileName)).useDelimiter("\\s+");
        // skip the information lines
        s.nextLine();
        s.nextLine();
        s.nextLine();
        s.nextLine();
        // start reading data
        nameInstance = new String[numClass][numInstancesClass];
        lowerBound = new int[numClass][numInstancesClass];
        upperBound = new int[numClass][numInstancesClass];
        for (int i = 0; i < numClass; i++) {
            for (int j = 0; j < numInstancesClass; j++) {
                String[] line = s.nextLine().split("\\s+");
                nameInstance[i][j] = line[0];
                lowerBound[i][j] = Integer.parseInt(line[1]);
                upperBound[i][j] = Integer.parseInt(line[2]);
            }
        }
        s.close();
    }
}
