package sample;

/**
 * Created by nishapant on 4/29/17.
 */
import java.util.ArrayList;
public class LinearRegression {
    ArrayList<Object> xvalues;
    ArrayList<Object> yvalues;
    double standardDeviationx;
    double standardDeviationy;
    double xMeanValues=0;
    double yMeanValues=0;
    double correlation;
    double slope;
    double integer;

    public LinearRegression(ArrayList<Object> x, ArrayList<Object> y){
        xvalues = x;
        yvalues = y;
    }

    public void calculateMeans(){
        for(int i = 0; i < xvalues.size();i++){
            xMeanValues += (Double)xvalues.get(i);
        }
        xMeanValues = xMeanValues/xvalues.size();

        for(int i = 0; i < yvalues.size();i++){
            System.out.println();
            System.out.println("y value " + i + " =" + yvalues.get(i));
            yMeanValues += (Double)yvalues.get(i);
        }
        yMeanValues = yMeanValues/yvalues.size();
        System.out.println("mean of xvalues "+ xMeanValues);
        System.out.println("mean of yvalues "+ yMeanValues);
    }

    public void calculateStandardDeviation(){
        double sumOfx = 0;
        double sumOfy = 0;
        for(int i = 0; i < xvalues.size();i++){
            double number = Math.pow(((Double)xvalues.get(i)-xMeanValues), 2);
            sumOfx += number;
        }

        for(int i = 0; i < yvalues.size();i++){
            double number = Math.pow((Double)yvalues.get(i)-yMeanValues, 2);
            sumOfy += number;
        }

        standardDeviationx = Math.sqrt(sumOfx / (xvalues.size()-1));
        standardDeviationy = Math.sqrt(sumOfy / (yvalues.size()-1));

        System.out.println("standard deviation x " +standardDeviationx);
        System.out.println("standard deviation y " +standardDeviationy);


    }

    public void calculateCorrelation(){
        ArrayList<Double> correlationx = new ArrayList<>();
        ArrayList<Double> correlationy= new ArrayList<>();
        ArrayList<Double> correlationxy= new ArrayList<>();
        double sum = 0;
        for(int i = 0; i<xvalues.size();i++){
            correlationx.add(((Double)xvalues.get(i)-xMeanValues)/standardDeviationx);
        }

        for(int i = 0; i<yvalues.size();i++){
            correlationy.add(((Double)yvalues.get(i)-yMeanValues)/standardDeviationy);
        }

        for(int i = 0; i<correlationx.size(); i++){
            correlationxy.add(correlationx.get(i)*correlationy.get(i));
        }

        for(int i = 0; i<correlationxy.size(); i++){
            sum += correlationxy.get(i);
        }

        correlation = sum / (xvalues.size()-1);
        System.out.println("correlation: "+correlation);
    }

    public void calculateSlope(){
        slope = correlation * (standardDeviationy/standardDeviationx);
    }

    public void calculateInt(){
        integer = yMeanValues - (slope * xMeanValues);
    }

    public String lineOfRegression(){
        calculateMeans();
        calculateStandardDeviation();
        calculateCorrelation();
        calculateSlope();
        calculateInt();
        if(integer > 0){
            return ("y = "+slope+"x + " +integer);
        }
        return ("y = "+slope+"x "+ integer);
    }
}
