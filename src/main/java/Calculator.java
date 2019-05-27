import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Calculator {

    static String calculate4factor(String dataString, int numberOfMultipliers) {

        int largestFactor = 0;
        int dataRowLength = 0;
        int bestRow = -1;
        int bestColumn = -1;
        String bestDirection = "notFound";

        //  Convert data to iterable lists
        List<List<String>> data = new ArrayList<List<String>>();
        for (String currentRow : dataString.split("\n")){
            dataRowLength++;
            data.add(Arrays.asList(currentRow.split(" ")));
        }

        //  Check factor from all possible elements
        for (int i = 0; i < (dataRowLength - numberOfMultipliers); i++){
            for (int j = 0; j < (dataRowLength - numberOfMultipliers); j++){
                //  Calculate factor in all possible directions
                int tempFactorHorizontal = 1;
                int tempFactorVertical = 1;
                int tempFactorDiagonal = 1;
                for (int step = 0; step < numberOfMultipliers; step++){
                    tempFactorHorizontal *= Integer.parseInt(data.get(i).get(j+step));
                    tempFactorVertical *= Integer.parseInt(data.get(i+step).get(j));
                    tempFactorDiagonal *= Integer.parseInt(data.get(i+step).get(j+step));
                }
                if (tempFactorHorizontal > largestFactor){
                    largestFactor = tempFactorHorizontal;
                    bestRow = i;
                    bestColumn = j;
                    bestDirection = "horizontal";
                }
                if (tempFactorVertical > largestFactor){
                    largestFactor = tempFactorVertical;
                    bestRow = i;
                    bestColumn = j;
                    bestDirection = "vertical";
                }
                if (tempFactorDiagonal > largestFactor){
                    largestFactor = tempFactorDiagonal;
                    bestRow = i;
                    bestColumn = j;
                    bestDirection = "diagonal";
                }
            }
        }

        return "Largest factor: " + largestFactor
                + "\nrow: " + bestRow
                + "\ncolumn: " + bestColumn
                + "\ndirection: " + bestDirection;
    }
}
