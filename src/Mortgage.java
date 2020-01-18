public class Mortgage {
    String customer;
    float totalLoan;
    float interest;
    int years;

    public Mortgage(String customer, float totalLoan, float interest, int years) {
        this.customer = customer;
        this.totalLoan = totalLoan;
        this.interest = interest;
        this.years = years;
    }
    public static float powerOf(float number, int exponent) {
        float result = number;
        if (exponent == 0) {
            return 1;
        }

        if(exponent == 1) {
            return number;
        }

        for(int i = 1; i < exponent; i++) {
            result *= number;
        }

        return result;
    }

    public static float MortgageFormula(Mortgage mortgage) {
        float b = mortgage.interest;
        float U = mortgage.totalLoan;
        int p = mortgage.years;
        float result;

        // E = U[b (1 + b)^p] / [(1 + b)^p - 1]

        result = U*(b*(powerOf((1+b),p))/(powerOf((1+b),p)-1));
        return result;
    }
}


