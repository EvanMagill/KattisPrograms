import java.util.*;

public class AboveAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numSets = input.nextInt();
        input.nextLine();
        for(int i = 0; i < numSets; i ++) {
            String dataSet = input.nextLine();
            Scanner dataReader = new Scanner(dataSet);
            int numData = dataReader.nextInt();
            int[] data = new int[numData];
            double total = 0.0;
            for(int j = 0; j < numData; j ++) {
                data[j] = dataReader.nextInt();
                total += data[j];
            }
            dataReader.close();
            double average = total/numData;
            double aboveAverage = 0.0;
            for(int j = 0; j < numData; j ++) {
                if(data[j] > average) {
                    aboveAverage ++;
                }
            }
            System.out.printf("%.3f%%",aboveAverage/numData*100);
            if(i + 1 < numSets) {
                System.out.println();
            }
        }
        input.close();
    }
}