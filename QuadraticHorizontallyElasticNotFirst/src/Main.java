import java.io.BufferedWriter;
import java.io.FileWriter;

/*public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = "Data/j60/opt";
        LowerBoundOfInstance lb = new LowerBoundOfInstance(fileName, 48,10);
        DestructiveLowerBound sample;
        String directory = "Data/j60/";
        String nameFile;
        for (int i = 1; i <= 48; i++) {
            for (int j = 1; j <= 10; j++) {
                if (lb.lowerBound[i-1][j-1] < lb.upperBound[i-1][j-1]) {
                    nameFile = directory + "j60_" + i + "_" + j + ".rcp";
                    String name = "j60_" + i + "_" + j;
                    System.out.print(name + ".rcp" + " | ");
                    for (int prop = 0; prop < 2; prop++) {
                        int initialLowerBound = lb.lowerBound[i - 1][j - 1];
                        sample = new DestructiveLowerBound(nameFile, prop, 5, initialLowerBound);
                        while (!sample.isConsistence()) {
                            initialLowerBound++;
                            sample = new DestructiveLowerBound(nameFile, prop, 0, initialLowerBound);
                        }
                        System.out.print(initialLowerBound + " | ");
                    }
                    System.out.println("");
                }
            }
        }

    }
}*/
/*public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = "Data/j60/opt";
        LowerBoundOfInstance lb = new LowerBoundOfInstance(fileName, 48,10);
        ProofOptimality sample;
        String directory = "Data/j60/";
        String nameFile;
        for (int i = 1; i <= 48; i++) {
            for (int j = 1; j <= 10; j++) {
                nameFile = directory + "j60_" + i + "_" + j + ".rcp";
                String name = "j60_" + i + "_" + j;
                if (lb.lowerBound[i-1][j-1] == lb.upperBound[i-1][j-1]) {
                    System.out.print(name + ".rcp" + " | ");
                    for (int prop = 0; prop < 2; prop++) {
                        sample = new ProofOptimality(nameFile, prop, 0, lb.lowerBound[i-1][j-1]);
                        System.out.print(+sample.howMuchTime() + " | " + sample.howManyBacktracks() + " | " + sample.makeSpanSolution() + " | " + sample.howManyAdjustments() + " | ");
                    }
                }

                System.out.println("");
            }
        }

    }
}*/

/*public class Main {
    public static void main(String[] args) throws Exception {
        DestructiveLowerBound sample;
        String directory = "Data/data_pack_d/";
        String nameFile;
        String name = null;
        for (int i = 1; i <= 55; i++) {
            if (i < 10) {
                nameFile = directory + "pack00" + i + ".rcp";
                name = "pack00" + i;
            }else{
                nameFile = directory + "pack0" + i + ".rcp";
                name = "pack0" + i;
            }
            System.out.print(name + ".rcp" + " | ");
                for (int prop = 0; prop < 7; prop++) {
                    int initialLowerBound = 400;
                    sample = new DestructiveLowerBound(nameFile, prop, 0, initialLowerBound);
                    while (!sample.isConsistence()) {
                        initialLowerBound ++;
                        sample = new DestructiveLowerBound(nameFile, prop, 0, initialLowerBound);
                    }
                    System.out.print(initialLowerBound + " | ");
                }
                System.out.println("");
        }

    }
}*/

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName;
        RunRCPSP sample;
        String dir = "Data/BL/";
        BufferedWriter writer = new BufferedWriter(new FileWriter("Data/NewResults/BL25Results.txt"));
        for (int search = 0; search < 3; search++) {
            if (search == 0) {
                System.out.println("Static Search Results");
                writer.write("Static Search Results");
                writer.newLine();
            }else if (search == 1) {
                System.out.println("COS + First-Fail Results");
                writer.write("COS + First-Fail Results");
                writer.newLine();
            }else {
                System.out.println("COS + domOverWegSearch Results");
                writer.write("COS + domOverWegSearch Results");
                writer.newLine();
            }
            for (int i = 1; i <= 20; i++) {
                fileName = dir + "bl25_" + i + ".rcp";
                String name = "bl25_" + i;
                System.out.print(name + ".rcp" + " | ");
                writer.write(name + ".rcp" + " | ");

                for (int prop = 0; prop < 10; prop++) {
                    sample = new RunRCPSP(fileName, prop, search, 10);
                    System.out.print(+sample.howMuchTime() + " | " + sample.howManyBacktracks() + " | " + sample.makeSpanSolution() + " | " + sample.howManyAdjustments() + " | ");
                    writer.write(+sample.howMuchTime() + " | " + sample.howManyBacktracks() + " | " + sample.makeSpanSolution() + " | " + sample.howManyAdjustments() + " | ");
                }
                System.out.println("");
                writer.newLine();
            }

        }
        writer.close();

    }
}
/*public class Main {
    public static void main (String[] args) throws Exception {
        String fileName;
        RunRCPSP sample;
        String dir =  "Data/Pack/";
        int NbSolveByAll = 0;

        int makespanTL = -1;
        int makespanH = -1;
        int makespanCH = -1;
        int makespanOH = -1;

        int NbSolveByTL = 0;
        int NbSolveByH = 0;
        int NbSolveByCH = 0;
        int NbSolveByOH = 0;

        long BacktTL = 0;
        long BacktH = 0;
        long BacktCH = 0;
        long BacktOH = 0;

        double timeTL = 0;
        double timeH = 0;
        double timeCH = 0;
        double timeOH = 0;

        long TotalBacktTL = 0;
        long TotalBacktH = 0;
        long TotalBacktCH = 0;
        long TotalBacktOH = 0;

        double TotalTimeTL = 0;
        double TotalTimeH = 0;
        double TotalTimeCH = 0;
        double TotalTimeOH = 0;
        BufferedWriter writer = new BufferedWriter(new FileWriter("Data/Results/FinalresultsPack.txt"));
        writer.write("Inst |" + "timeTL |" + "backtTL |" + "makespanTL |" + "propTL |"
                                  + "timeH |" + "backtH |" + "makespanH |" + "propH |"
                                  + "timeCTLH |" + "backtCTLH |" + "makespanCTLH |" + "propCTLH |"
                                  + "timeCH |" + "backtCH |" + "makespanCH |" + "propCH |");
        writer.newLine();
        //for (int i = 1; i <= 48; i++) {
            for(int j = 1; j<= 55; j++) {
                if (j < 10){
                    fileName = dir + "pack00" +j + ".rcp";
                    String name = "pack00" + j;
                    System.out.print(name + ".rcp" + " | ");
                    writer.write(name + ".rcp" + " | ");
                }else{
                    fileName = dir + "pack0" +j + ".rcp";
                    String name = "pack0" + j;
                    System.out.print(name + ".rcp" + " | ");
                    writer.write(name + ".rcp" + " | ");
                }
                for (int prop = 0; prop < 4; prop++) {
                    sample = new RunRCPSP(fileName, prop, 3);
                    if (prop == 0) {
                        makespanTL = sample.makeSpanSolution();
                        if (makespanTL != -1) {
                            NbSolveByTL += 1;
                            BacktTL = sample.howManyBacktracks();
                            timeTL = sample.howMuchTime();
                        }
                    }
                    if (prop == 1) {
                        makespanH = sample.makeSpanSolution();
                        if (makespanH != -1){
                            NbSolveByH += 1;
                            BacktH = sample.howManyBacktracks();
                            timeH = sample.howMuchTime();
                        }
                    }
                    if (prop == 2) {
                        makespanCH = sample.makeSpanSolution();
                        if (makespanCH != -1) {
                            NbSolveByCH += 1;
                            BacktCH = sample.howManyBacktracks();
                            timeCH = sample.howMuchTime();
                        }
                    }
                    if (prop == 3) {
                        makespanOH = sample.makeSpanSolution();
                        if (makespanOH != -1) {
                            NbSolveByOH += 1;
                            BacktOH = sample.howManyBacktracks();
                            timeOH = sample.howMuchTime();
                        }
                    }
                    writer.write(+sample.howMuchTime() + " | " + sample.howManyBacktracks() + " | " + sample.makeSpanSolution() + " | " + sample.howManyAdjustments() + " | ");
                    System.out.print(+sample.howMuchTime() + " | " + sample.howManyBacktracks() + " | " + sample.makeSpanSolution() + " | " + sample.howManyAdjustments() + " | ");
                }
                System.out.println("");
                writer.newLine();
                if (makespanTL != - 1 && makespanH != -1 && makespanCH != -1 && makespanOH != -1) {
                    TotalBacktTL += BacktTL;
                    TotalBacktH += BacktH;
                    TotalBacktCH += BacktCH;
                    TotalBacktOH += BacktOH;

                    TotalTimeTL += timeTL;
                    TotalTimeH += timeH;
                    TotalTimeCH += timeCH;
                    TotalTimeOH += timeOH;

                    NbSolveByAll += 1;
                }
            }
        //}

        System.out.println("Solve by All :" +NbSolveByAll);
        System.out.println("NbTL :"+ NbSolveByTL + ", NbH :"+NbSolveByH + ", NbCH :"+NbSolveByCH + ", NbOH :"+NbSolveByOH);
        System.out.println("TimeTL :"+ TotalTimeTL/NbSolveByAll + ", TimeH :"+TotalTimeH/NbSolveByAll + ", TimeCH :"+TotalTimeCH/NbSolveByAll + ", TimeOH :"+TotalTimeOH/NbSolveByAll);
        System.out.println("BackTL :"+ TotalBacktTL/NbSolveByAll + ", BackH :"+TotalBacktH/NbSolveByAll + ", BackCH :"+TotalBacktCH/NbSolveByAll + ", BackOH :"+TotalBacktOH/NbSolveByAll);

        writer.write("Solve by All :" +NbSolveByAll + "     ");
        writer.write("  NbTL :"+ NbSolveByTL + ", NbH :"+NbSolveByH + ", NbCH :"+NbSolveByCH + ", NbOH :"+NbSolveByOH);
        writer.write("   TimeTL :"+ TotalTimeTL/NbSolveByAll + ", TimeH :"+TotalTimeH/NbSolveByAll + ", TimeCH :"+TotalTimeCH/NbSolveByAll + ", TimeOH :"+TotalTimeOH/NbSolveByAll);
        writer.write("   BackTL :"+ TotalBacktTL/NbSolveByAll + ", BackH :"+TotalBacktH/NbSolveByAll + ", BackCH :"+TotalBacktCH/NbSolveByAll + ", BackOH :"+TotalBacktOH/NbSolveByAll);
        writer.close();
    }
}*/
