package sample;

/**
 * Created by nishapant on 4/29/17.
 */
import bsh.Interpreter;

import java.util.ArrayList;

public class MathOperations {
    private String input;
    private String varX;


    MathOperations(String string, String xValue) {
        input = string;
        varX = xValue;
    }

    public String squared(String equation) {
        while (equation.contains("^")) {
            String before = "";
            String firstNumber = "";
            String secondNumber = "";
            String after = "";
            int index = equation.indexOf("^");
            for (int i = index - 1; i >= 0; i--) {
                int character = (int) equation.charAt(i);
                if ((character >= 48 && character <= 57) || (character == 45) || (character == 46)|| (character == 40) || (character == 41)) {
                    firstNumber = equation.charAt(i) + firstNumber;
                    before = equation.substring(0, i);

                    if(firstNumber.contains("(")){
                        int indexParentheses1 =firstNumber.indexOf("(");
                        firstNumber = firstNumber.substring(indexParentheses1+1);
                    }
                    if(firstNumber.contains(")")){
                        int indexParentheses2 =firstNumber.indexOf(")");
                        firstNumber = firstNumber.substring(0,indexParentheses2) ;
                    }
                } else {
                    break;
                }
            }
            for (int k = index + 1; k < equation.length(); k++) {
                int character = (int) equation.charAt(k);
                if ((character >= 48 && character <= 57) || (character == 45) || (character == 46)|| (character == 40) || (character == 41)) {
                    secondNumber = secondNumber + equation.charAt(k);
                    after = equation.substring(k + 1);

                    if(secondNumber.contains("(")){
                        int indexParentheses1 =secondNumber.indexOf("(");
                        secondNumber = secondNumber.substring(indexParentheses1+1);
                    }
                    if(secondNumber.contains(")")){
                        int indexParentheses2 =secondNumber.indexOf(")");
                        secondNumber = secondNumber.substring(0,indexParentheses2);
                    }
                } else {
                    break;
                }
            }
            equation = before + Double.toString(Math.pow(Double.parseDouble(firstNumber),Double.parseDouble(secondNumber)))+ after;

        }
        return equation;
    }

    public void squareroot() {
        while (input.contains("√(")) {
            String before = "";
            String after = "";
            String number = "";
            int index1 = input.indexOf("√(");
            after = input.substring(index1);
            before = input.substring(0, index1);
            if (after.contains(")")) {
                int index2 = after.indexOf(")");
                String squareRoot = after.substring(2, index2);
                after = after.substring(index2 + 1);
                input = before + "Math.sqrt(" + squareRoot + ")" + after;
            } else {
                System.out.println("error");
            }

        }
    }

    public void pi() { //Adds the constant pi to the input string
        while (input.contains("π")) {
            int index = input.indexOf("π");
            String before = input.substring(0, index);
            String after = input.substring(index + 1);
            System.out.println(after);
            input = before + Math.PI + after;

        }
    }

    public void trig() { //method computes all trig functions and inverse trig functions
        while (input.contains("sine(") || input.contains("cosine(") || input.contains("tangent(") || input.contains("arcsin(") || input.contains("arccos(") || input.contains("arctan(")) {
            String trigFunction;
            int index1;
            if (input.contains("cosine(")) { //if the string contains one of the trig functions the method computes the corresponding calculation
                trigFunction = "Math.cos(";
                index1 = input.indexOf("cosine(");
            }
            else if (input.contains("tangent(")) {
                trigFunction = "Math.tan(";
                index1 = input.indexOf("tangent(");
            }
            else if (input.contains("arcsin(")) {
                trigFunction = "Math.asin(";
                index1 = input.indexOf("arcsin(");
            }
            else if (input.contains("arccos(")) {
                trigFunction = "Math.acos(";
                index1 = input.indexOf("arccos(");
            }
            else if (input.contains("arctan(")) {
                trigFunction = "Math.atan(";
                index1 = input.indexOf("arctan(");
            }
            else {
                trigFunction = "Math.sin(";
                index1 = input.indexOf("sine(");
            }
            System.out.println(index1);
            String after = input.substring(index1);
            String before = input.substring(0, index1);
            if (after.contains(")")) {
                String number;
                int index2 = after.indexOf(")");
                if (trigFunction.equals("Math.cos(")) {
                    number = after.substring(7, index2);
                    after = after.substring(index2 + 1);
                    System.out.println("before = " + before);
                    System.out.println("after = " + after);
                    input = before + trigFunction + number + ")" + after;
                }
                else if (trigFunction.equals("Math.sin(")) {
                    number = after.substring(5, index2);
                    after = after.substring(index2 + 1);
                    input = before + trigFunction + number + ")" + after;
                    System.out.println("before = " + before);
                    System.out.println("after = " + after);
                }
                else if (trigFunction.equals("Math.asin(")) {
                    number = after.substring(7, index2);
                    after = after.substring(index2 + 1);
                    input = before + trigFunction + number + ")" + after;
                    System.out.println("before = " + before);
                    System.out.println("after = " + after);
                }
                else if (trigFunction.equals("Math.acos(")) {
                    number = after.substring(7, index2);
                    after = after.substring(index2 + 1);
                    input = before + trigFunction + number + ")" + after;
                    System.out.println("before = " + before);
                    System.out.println("after = " + after);
                }
                else if (trigFunction.equals("Math.atan(")) {
                    number = after.substring(7, index2);
                    after = after.substring(index2 + 1);
                    input = before + trigFunction + number + ")" + after;
                    System.out.println("before = " + before);
                    System.out.println("after = " + after);
                }
                else {
                    number = after.substring(8, index2);
                    after = after.substring(index2 + 1);
                    input = before + trigFunction + number + ")" + after;
                    System.out.println("before = " + before);
                    System.out.println("after = " + after);
                }


            } else {
                System.out.println("error");
            }
        }
    }

    public void log() { //computes the log of a given input
        while (input.contains("log(")) {
            int index1 = input.indexOf("log(");
            String after = input.substring(index1);
            String before = input.substring(0, index1);
            if (after.contains(")")) {
                int index2 = after.indexOf(")");
                System.out.println(index2);
                String number = after.substring(4, index2);
                after = after.substring(index2 + 1);
                System.out.println(number);
                System.out.println("before = " + before);
                System.out.println("after = " + after);
                input = before + "Math.log10(" + number + ")" + after;
            } else {
                System.out.println("error");
            }
        }
    }

    public String subtraction(String equation) { //distinguishes between a subtration symbol and a negative sign
        while (equation.contains("–")) {
            int index1 = equation.indexOf("–");
            String after = equation.substring(index1);
            String before = equation.substring(0, index1);
            after = equation.substring(index1 + 1);
            equation = before + "-" + after;
        }
        return equation;
    }

    public void ln() { //computes the natural log of the input
        while (input.contains("ln(")) {
            int index1 = input.indexOf("ln(");
            String after = input.substring(index1);
            String before = input.substring(0, index1);
            if (after.contains(")")) {
                int index2 = after.indexOf(")");
                String number = after.substring(3, index2);
                after = after.substring(index2 + 1);
                input = before + "Math.log(" + number + ")" + after;
            } else {
                System.out.println("error");
            }
        }
    }

    public void e(){ //computes e to the power of the input
        while (input.contains("e^")) {
            String before = "";
            String number = "";
            String after = "";
            int index = input.indexOf("e^");
            before = input.substring(0,index);
            for (int k = index + 2; k < input.length(); k++) {
                int character = (int) input.charAt(k);
                if ((character >= 48 && character <= 57) || (character == 45) || (character == 46)|| (character == 40) || (character == 41)) {
                    number = number + input.charAt(k);
                    after = input.substring(k + 1);

                    if(number.contains("(")){
                        int indexParentheses1 =number.indexOf("(");
                        number = number.substring(indexParentheses1+1);
                    }
                    if(number.contains(")")){
                        int indexParentheses2 =number.indexOf(")");
                        number = number.substring(0,indexParentheses2);
                    }
                } else {
                    break;
                }
            }

            input = before + Math.exp(Double.parseDouble(number))+ after;

        }
    }

    public String answer() { //this method computes the final answer from the string input
        pi();
        rand();
        nDeriv();
        fnInt();
        e();
        input = squared(input);
        squareroot();
        trig();
        log();
        ln();
        factorial();
        absValue();
        lowestCommonMultiple();
        permutation();
        combination();
        input = subtraction(input);
        greatestCommonFactor();
        store();
        coeff(); //runs every math operation method in order to replace the input string with any values needed to be computed
        input = input.replace("x", varX);

        if(input.contains(">FRAC")){
            int index = input.indexOf(">FRAC");
            System.out.println(input.substring(0,index));
            return toFraction();

        }
        if(input.contains(">DEC")){
            int index = input.indexOf(">DEC");
           toDecimal();
           return toDecimal();
        }

            Interpreter i = new Interpreter();
            String answer;
            try {
                i.eval("double y = " + input + ";");
                answer = "" + i.get("y");
                System.out.println(i.get("y"));
            } catch (Exception ex) {
                answer = "error";
                System.out.println("error");
            }
            return answer;//beanshell interpreter that transforms a string into interpretable code


    }

    public void absValue(){//returns the absolute value of the input
        while(input.contains("absValue(")){
            int index1 = input.indexOf("absValue(");
            String after = input.substring(index1);
            String before = input.substring(0, index1);
            if (after.contains(")")) {
                int index2 = after.indexOf(")");
                System.out.println(index2);
                String number = after.substring(9, index2);
                after = after.substring(index2 + 1);

                input = before + "Math.abs(" + number + ")" + after;
            } else {
                System.out.println("error");
            }
        }
    }

    public void nDeriv() {//returns the derivative of a given equation and value
        while(input.contains("nDeriv(")){
            int index1 = input.indexOf("nDeriv(");
            String after = input.substring(index1);
            String before = input.substring(0, index1);

            if (after.contains(")") && after.contains(",")) {
                int index2 = after.indexOf(")");
                int index3 = after.indexOf(",");
                String equation = after.substring(7, index3);
                if (equation.contains("x") || equation.contains("(")){
                    for (int i = 1; i < equation.length(); i++) {
                        int character = (int) equation.charAt(i - 1);
                        System.out.println("character" + character);
                        if ((equation.substring(i,i+1).equals("(") || equation.substring(i,i+1).equals("x")) && ((character >= 48 && character <= 57) || (character == 45) || (character == 46))) {
                            equation = equation.substring(0, i) + "*" + equation.substring(i, equation.length());

                            System.out.println(input);
                        }
                    }
                }
                Double value = Double.parseDouble(after.substring(index3 + 1, index2));
                after = after.substring(index2 + 1);
                Double x1, x2;
                String y1, y2;
                x1 = value;
                x2 = value + 0.00000000001;//small step size returns very close approximation

                if(equation.contains("^")){
                    System.out.println(equation.replaceAll("x", x1.toString()));
                    System.out.println(equation.replaceAll("x",x2.toString()));
                    y1 = subtraction(squared(equation.replaceAll("x",x1.toString())));
                    y2 = subtraction(squared(equation.replaceAll("x",x2.toString())));
                }else{
                    y1 = equation.replaceAll("x",x1.toString());
                    y2 = equation.replaceAll("x",x2.toString());//creates expression to compute y values by replacing any x with the given value

                }

                double slope = 0;
                Interpreter i = new Interpreter();
                try {
                    i.eval("double y1= " + y1 + ";");

                    i.eval("double y2= " +y2+ ";");
                    Double Y1 = (Double) i.get("y1");
                    Double Y2 = (Double) i.get("y2");
                    slope = (Y2 - Y1) / (x2 - x1); //
                    System.out.println(i.get("y1"));
                    System.out.println(i.get("y2"));
                } catch (Exception ex) {
                    System.out.println("error");
                }
                input = before + slope + after;
            }
            else {
                System.out.println("error");//beanshell interpreter to calculate the y values and slope
            }


        }

    }

    public void fnInt() { //returns a definite integral approximation using rectangular approximation
        while (input.contains("fnInt(")) {
            int index1 = input.indexOf("fnInt(");
            String after = input.substring(index1);
            String before = input.substring(0, index1);
            if (after.contains(")")) {
                int index2 = after.indexOf(")");
                System.out.println(index2);
                int firstComma = after.indexOf(",");
                String extra = after.substring(firstComma+1,index2);
                int secondComma = extra.indexOf(",");
                int parentheses1 = after.indexOf("(");
                int parentheses2 = extra.indexOf(")");//finds substrings of equation and lower and upper bounds
                String equation = after.substring(parentheses1+1, firstComma);
                if (equation.contains("x") || equation.contains("(")){
                    for (int i = 1; i < equation.length(); i++) {
                        int character = (int) equation.charAt(i - 1);
                        System.out.println("character" + character);
                        if ((equation.substring(i,i+1).equals("(") || equation.substring(i,i+1).equals("x")) && ((character >= 48 && character <= 57) || (character == 45) || (character == 46))) {
                            equation = equation.substring(0, i) + "*" + equation.substring(i, equation.length());

                            System.out.println(input);
                        }
                    }
                }
                Double lowerBound = Double.parseDouble(extra.substring(0,secondComma));
                Double upperBound = Double.parseDouble(extra.substring(secondComma+1));
                after = after.substring(index2 + 1);


                Double height;
                Double index;
                Double area = 0.0;
                for (double j = lowerBound; j < upperBound; j += 0.01) {
                    index = lowerBound + j;
                    Interpreter i = new Interpreter();
                    try {
                        i.eval("double height = " + equation.replaceAll("x", index.toString()) + ";");//beanshell interpreter that finds the y value at each index and add compute each recangle to add together
                        Double H = (Double) i.get("height");
                        area += H * 0.01;
                    } catch (Exception ex) {
                        System.out.println("error");
                    }

                }
                input = before + area + after;
            }
            else {
                System.out.println("error");
            }
        }
    }

    public void factorial() { //computes a factorial
        while(input.contains("!")){
            String before = "";
            String number = "";
            String after = "";
            int index = input.indexOf("!");
            System.out.println(index);
            for (int i = index - 1; i >= 0; i--) {
                int character = (int) input.charAt(i);
                if ((character >= 48 && character <= 57) || (character == 45) || (character == 46) || (character == 40) || (character == 41)) {
                    number = input.charAt(i) + number;
                    before = input.substring(0, i);
                    System.out.println("number: " + number);
                    System.out.println("");
                    if(number.contains("(")){
                        int indexParentheses1 =number.indexOf("(");
                        number = number.substring(indexParentheses1+1);
                    }
                    if(number.contains(")")){
                        int indexParentheses2 = number.indexOf(")");
                        number = number.substring(0,indexParentheses2) ;
                    }
                } else {
                    break;
                }
            }
            after = input.substring(index+1);
            Integer value = Integer.parseInt(number);
            Integer product = 1;
            for (int i = value; i > 0; i--) {
                product *= i;
            }
            input = before + Integer.toString(product) + after;

        }
    }

    public Double compFact(String num){//computes a factorial for purely logic purposes
        Double value = Double.parseDouble(num);
        Double product = 1.0;
        for (Double i = value; i > 0; i--) {
            product *= i;
        }
        return product;
    }

    public void permutation () {//computes a permutation using the above factorial method
        while (input.contains("nPr")) {
            String before = "";
            String firstNumber = "";
            String secondNumber = "";
            String after = "";
            int index = input.indexOf("nPr");
            for (int i = index - 1; i >= 0; i--) {
                int character = (int) input.charAt(i);
                if ((character >= 48 && character <= 57) || (character >= 44 && character <= 46) || (character == 40) || (character == 41)) {
                    firstNumber = input.charAt(i) + firstNumber;
                    before = input.substring(0, i);
                    System.out.println("first number: " + firstNumber);
                    System.out.println("");
                } else {
                    break;
                }
            }
            for (int k = index + 3; k < input.length(); k++) {
                int character = (int) input.charAt(k);
                if ((character >= 48 && character <= 57) || (character >= 44 && character <= 46) || (character == 40) || (character == 41)) {
                    secondNumber = secondNumber + input.charAt(k);
                    after = input.substring(k + 1);
                    System.out.println("second number: " + secondNumber);
                    System.out.println("");
                } else {
                    break;
                }
            }
                String num1 = input.substring(0, input.indexOf("n"));
                String num2 = input.substring(input.indexOf("r") + 1, input.length());
                Integer val1 = Integer.parseInt(firstNumber);
                Integer val2 = Integer.parseInt(secondNumber);
                Integer val3 = val1 - val2;

                input = before + Double.toString(compFact(firstNumber) / (compFact(val3.toString()))) + after;

            }


        }

    public Double compPerm(String num1,String num2) {//computes a permutation for logic purposes
        Double val1 = Double.parseDouble(num1);
        Double val2 = Double.parseDouble(num2);
        Double val3 = val1 - val2;
        return  compFact(num1)/(compFact(val3.toString()));
    }

    public void combination () {//computes a combination using the above permutation and factorial methods
        while (input.contains("nCr")) {
            String before = "";
            String firstNumber = "";
            String secondNumber = "";
            String after = "";
            int index = input.indexOf("nCr");
            for (int i = index - 1; i >= 0; i--) {
                int character = (int) input.charAt(i);
                if ((character >= 48 && character <= 57) || (character >= 44 && character <= 46) || (character == 40) || (character == 41)) {
                    firstNumber = input.charAt(i) + firstNumber;
                    before = input.substring(0, i);
                    System.out.println("first number: " + firstNumber);
                    System.out.println("");
                } else {
                    break;
                }
            }
            for (int k = index + 3; k < input.length(); k++) {
                int character = (int) input.charAt(k);
                if ((character >= 48 && character <= 57) || (character >= 44 && character <= 46) || (character == 40) || (character == 41)) {
                    secondNumber = secondNumber + input.charAt(k);
                    after = input.substring(k + 1);
                    System.out.println("second number: " + secondNumber);
                    System.out.println("");
                } else {
                    break;
                }
            }
            String num1 = input.substring(0, input.indexOf("n"));
            String num2 = input.substring(input.indexOf("r") + 1, input.length());
            Integer val1 = Integer.parseInt(firstNumber);
            Integer val2 = Integer.parseInt(secondNumber);
            Integer val3 = val1 - val2;

            input = before + Double.toString(compPerm(firstNumber, secondNumber)/compFact(secondNumber.toString())) + after;

        }
    }

    public void lowestCommonMultiple() {//computes the lcm of two numbers
        while (input.contains("lcm(")) {
            String before = "";
            String firstNumber = "";
            String secondNumber = "";
            String after = "";
            String temp = "";
            int index = input.indexOf("lcm(");
            temp = input.substring(index);
            if (temp.contains(")")) {
                int index2 = temp.indexOf(",");
                int index3 = temp.indexOf(")");
                firstNumber = temp.substring(4,index2);
                secondNumber = temp.substring(index2+1,index3);
                before = input.substring(0,index);
                after = temp.substring(index3+1);
                System.out.println("before " + before );
                System.out.println("after " + after);
                System.out.println("first number " +firstNumber);
                System.out.println("second number " + secondNumber);
                Double val1 = Double.parseDouble(firstNumber);
                Double val2 = Double.parseDouble(secondNumber);
                Double i = 0.0;
                i = val1 * (val2 / calcGCF(val1.toString(),val2.toString()));

                input = before + i + after;

            } else {
                System.out.println("error");
            }

        }
    }

    public void greatestCommonFactor (){
        while(input.contains("gcf(")){
            String before = "";
            String firstNumber = "";
            String secondNumber = "";
            String after = "";
            String temp = "";
            int index = input.indexOf("gcf(");
            temp = input.substring(index);
            if(temp.contains(")")){
                int index2 = temp.indexOf(",");
                int index3 = temp.indexOf(")");
                firstNumber = temp.substring(4,index2);
                secondNumber = temp.substring(index2+1,index3);
                before = input.substring(0,index);
                after = temp.substring(index3+1);
                Double val1 = Double.parseDouble(firstNumber);
                Double val2 = Double.parseDouble(secondNumber);
                ArrayList<Double> factors1 = new ArrayList<>();
                ArrayList<Double> factors2 = new ArrayList<>();
                for(Double i = val1; i > 0; i--) {
                    if (val1%i == 0) {
                        factors1.add(i);
                    }
                }
                for(Double i = val2; i > 0; i--) {
                    if (val2%i == 0) {
                        factors2.add(i);
                    }
                }
                Double gcf = 1.0;
                for(int i = 0; i < factors1.size(); i++) {
                    if (factors2.contains(factors1.get(i))) {
                        gcf = factors1.get(i);
                        break;
                    }
                }

                input = before +  Double.toString(gcf) + after;
            }else{
                input = "error";
            }

        }

    }

    public double calcGCF(String num1, String num2){
        Double val1 = Double.parseDouble(num1);
        Double val2 = Double.parseDouble(num2);
        ArrayList<Double> factors1 = new ArrayList<Double>();
        ArrayList<Double> factors2 = new ArrayList<Double>();
        for(Double i = val1; i > 0; i--) {
            if (val1%i == 0) {
                factors1.add(i);
            }
        }
        for(Double i = val2; i > 0; i--) {
            if (val2%i == 0) {
                factors2.add(i);
            }
        }
        Double gcf = 1.0;
        for(int i = 0; i < factors1.size(); i++) {
            if (factors2.contains(factors1.get(i))) {
                gcf = factors1.get(i);
                break;
            }
        }

        return gcf;
    }

    public String toDecimal(){
        String fraction = input.substring(0, input.indexOf(">"));
        Double numerator = Double.parseDouble(fraction.substring(0, fraction.indexOf("/")));
        Double denominator = Double.parseDouble(fraction.substring(fraction.indexOf("/") + 1, fraction.length()));
        return Double.toString(numerator/denominator);
    }

    public String toFraction() {
        {
            String decimal = input.substring(0, input.indexOf(">"));
            Double numer = Double.parseDouble(decimal);
            Double denom = 1.0;
            for (int i = 0; i < decimal.substring(decimal.indexOf(".") + 1, decimal.length()).length(); i++) {
                numer *= 10;
                denom *= 10;
            }
            Double newNumer = numer;
            Double newDenom = denom;
            while (calcGCF(numer.toString(), denom.toString()) != 1) {

                Double temp = numer;
                numer /= calcGCF(numer.toString(), denom.toString());
                denom /= calcGCF(denom.toString(), temp.toString());
            }

            return numer.toString() + "/" + denom.toString();
        }
    }

    public String calcSquared(){
        return "";
    }

    public void store(){
        if(input.contains(">")){
            input = input.substring(0, input.indexOf(">"));
        }

    }

    public void coeff() {
        if (input.contains("x") || input.contains("(")){
            for (int i = 1; i < input.length(); i++) {
                int character = (int) input.charAt(i - 1);
                System.out.println("character" + character);
                if ((input.substring(i,i+1).equals("(") || input.substring(i,i+1).equals("x")) && ((character >= 48 && character <= 57) || (character == 45) || (character == 46))) {
                    input = input.substring(0, i) + "*" + input.substring(i, input.length());

                    System.out.println(input);
                }
            }
        }
    }

    public void rand(){
        while(input.contains("rand")){
            int index = input.indexOf("rand");
            String before = input.substring(0, index);
            String after = input.substring(index + 4);
            input = before + Math.random() + after;
        }
    }

}