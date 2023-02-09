import java.util.Objects;
import java.util.Arrays;

public class DetailAnalyzation {
    public String dataAnalyze(String[] linesInput, String[] linesCorrect) {
        boolean correctData = true;
        String returnString = "";

        if (linesInput.length == linesCorrect.length) {
            for (int i = 0; i < linesCorrect.length; i++) {
                if (!Objects.equals(linesInput[i], linesCorrect[i])) {
                    correctData = false;
                    returnString =  returnString + "\tError: '" + linesInput[i] + "' should look like this: '" + linesCorrect[i] + "'\n";
                }
            }
        } else {
            returnString = returnString + "\tIncorrect amount of Datasets";
            correctData = false;
        }
        if (correctData) {
            returnString = "Valid";
        } else{
            returnString = "Invalid: \n" + returnString;
        }
        return returnString;
    }

    public String outDatAnalyze(String input, String correct, String determiter) {
        String returnString;

        String[] linesInput = input.split(determiter);
        String[] linesCorrect = correct.split(determiter);

        Arrays.sort(linesCorrect);
        Arrays.sort(linesInput);

        returnString = "Data: " + dataAnalyze(linesInput, linesCorrect);

        linesInput = input.split(determiter);
        linesCorrect = correct.split(determiter);

        returnString = returnString + "\nOrdering: " + dataAnalyze(linesInput, linesCorrect);

        return returnString;
    }

    public void analyze(String correct, String input) {
        String columnsCorr = correct.substring(0, correct.indexOf("\n"));
        String restCorr = correct.substring(correct.indexOf("\n") + 1);
        String dataCorr = restCorr.substring(restCorr.indexOf("\n") + 1);

        String columnsIn = input.substring(0, input.indexOf("\n"));
        String restIn = input.substring(input.indexOf("\n") + 1);
        String dataIn = restIn.substring(restIn.indexOf("\n") + 1);

        System.out.println("\nHeader-column:");
        System.out.println(outDatAnalyze(columnsIn, columnsCorr, " |  "));

        System.out.println("*******************************************");

        System.out.println("\nDatasets:");
        System.out.println(outDatAnalyze(dataIn, dataCorr, "\n"));
    }
}
