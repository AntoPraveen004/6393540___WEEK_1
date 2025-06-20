package ForeCast;

public class Forecast {

 
    public static double forecast(int years, double currentValue, double growthRate) {
        if (years == 0) {
            return currentValue;
        }
        return forecast(years - 1, currentValue, growthRate) * (1 + growthRate);
    }

    public static void main(String[] args) {
        int years = 5;
        double initialValue = 10000;  
        double growthRate = 0.08;     

        double futureValue = forecast(years, initialValue, growthRate);
        System.out.printf("Future Value after %d years: ₹%.2f\n", years, futureValue);
    }
}
