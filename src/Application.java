import com.sun.jdi.FloatValue;

import java.util.ArrayList;
import java.util.regex.*;
import java.io.*;
import java.util.Scanner;
import java.util.List;

public class Application {


    public static void main(String[] args) {
        List<Mortgage> mortgages = new ArrayList<>();
        String csvSplit = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
        String filePath;
        Scanner in = new Scanner(System.in);
        filePath = in.nextLine();
        File file = new File(filePath);
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(filePath));
            String header = csvReader.readLine();
            String row;
            while ((row = csvReader.readLine()) != null && !row.isEmpty()) {
                String[] data = row.split(csvSplit);
                Mortgage mortgage = new Mortgage(data[0],Float.parseFloat(data[1]),Float.parseFloat(data[2]),Integer.parseInt(data[3]));
                mortgages.add(mortgage);
            }
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }

        for (Mortgage mortgage: mortgages) {
            System.out.println(String.format("%s wants to borrow %s€ for a period of %s years and pay %s€ each month",mortgage.customer,mortgage.totalLoan,mortgage.years,Mortgage.MortgageFormula(mortgage)));
        }

    }

}
