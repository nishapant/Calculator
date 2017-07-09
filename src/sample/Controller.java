package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Controller{
    @FXML
    private Label label;
    @FXML
    private GridPane gpane, gpane2;
    @FXML
    private TextArea window;
    @FXML
    private ListView listView;

    @FXML
    private ImageView imageView;

    @FXML
    private TextField one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve,thirteen,fourteen, fifteen, sixteen, seventeen, eighteen, nineteen,
            twenty, twentyone;

    private String[][] calculator = new String[7][5];
    private boolean second = false;
    private String display = "";
    private boolean on = false;
    int press = 0;
    private boolean stat, math, list, editList,checkStat;
    private ObservableList mathFunctions =  FXCollections.observableArrayList();
    private ObservableList statList =  FXCollections.observableArrayList();
    private ObservableList listInfo = FXCollections.observableArrayList();
    private ArrayList <Object> firstArrayList = new ArrayList<>();
    private ArrayList <Object> secondArrayList = new ArrayList<>();
    private ArrayList <Object> thirdArrayList = new ArrayList<>();
    private String varX = "0.0";



    @FXML
    private void handleStart(ActionEvent event){
        JTextArea a = new JTextArea("test");
        a.setEnabled(false);
        a.setDisabledTextColor(Color.red);
        listView.setVisible(false);
        gpane2.setVisible(false);
        on = !on;
        press++;
        if(press == 1){
            calculator [0][0] = "2nd";
            calculator [0][1] = "math";
            calculator [0][2] = "del";
            calculator [0][3] = "stat";
            calculator [0][4] = "x";
            calculator [1][0] = "x^-1";
            calculator [1][1] = "sin";
            calculator [1][2] = "cos";
            calculator [1][3] = "tan";
            calculator [1][4] = "clear";
            calculator [2][0] = "x^2";
            calculator [2][1] = "^";
            calculator [2][2] = "(";
            calculator [2][3] = ")";
            calculator [2][4] = "÷";
            calculator [3][0] = "log";
            calculator [3][1] = "7";
            calculator [3][2] = "8";
            calculator [3][3] = "9";
            calculator [3][4] = "×";
            calculator [4][0] = "ln";
            calculator [4][1] = "4";
            calculator [4][2] = "5";
            calculator [4][3] = "6";
            calculator [4][4] = "–";
            calculator [5][0] = "sto";
            calculator [5][1] = "1";
            calculator [5][2] = "2";
            calculator [5][3] = "3";
            calculator [5][4] = "+";
            calculator [6][0] = "on";
            calculator [6][1] = "0";
            calculator [6][2] = ".";
            calculator [6][3] = "(-)";
            calculator [6][4] = "enter";

            mathFunctions.add(">FRAC");
            mathFunctions.add(">DEC");
            mathFunctions.add("nDeriv()");
            mathFunctions.add("abs()");
            mathFunctions.add("lcm()");
            mathFunctions.add("gcf()");
            mathFunctions.add("rand");
            mathFunctions.add("nPr");
            mathFunctions.add("nCr");
            mathFunctions.add("!");
            mathFunctions.add("fnInt()");

            statList.add("edit");
            statList.add("sortA()");
            statList.add("sortD()");
            statList.add("clrList");
            statList.add("LinReg(a+bx)");

            listInfo.add("L1");
            listInfo.add("L2");
            listInfo.add("L3");
        }

    }
    @FXML
    private void handleClick(ActionEvent event) {
        if (on) {
            Integer row = GridPane.getRowIndex((Node) event.getSource());
            Integer column = GridPane.getColumnIndex((Node) event.getSource());
            if (row == null) {
                row = 0;
            }
            if (column == null) {
                column = 0;
            }
            String operation = calculator[row][column];
            switch (operation) {
                case "2nd":
                    second = !second;
                    break;
                case "math":
                    window.setVisible(false);
                    listView.setVisible(true);
                    math();
                    break;
                case "del":
                    if(second){
                        second = !second;
                        window.setVisible(true);
                        listView.setVisible(false);
                        gpane2.setVisible(false);
                    }
                    else if (!(display.equals(""))) {
                        display = display.substring(0, display.length() - 1);
                    }

                    break;
                case "stat":
                    if(second){
                        secondStat();
                        second = false;
                    }
                    else{
                        stat();
                    }
                    break;
                case "x":
                    display += "x";
                    break;
                case "x^-1":
                    display += "^-1";
                    break;
                case "sin":
                    if (second) {
                        display += "arcsin(";
                        second = false;
                    } else {
                        display += "sine(";
                    }
                    break;
                case "cos":
                    if (second) {
                        display += "arccos(";
                        second = false;
                    } else {
                        display += "cosine(";
                    }
                    break;
                case "tan":
                    if (second) {
                        display += "arctan(";
                        second = false;
                    } else {
                        display += "tangent(";
                    }
                    break;
                case "clear":
                    display = "";
                    break;
                case "x^2":
                    if (second) {
                        display += "√(";
                        second = false;
                    } else {
                        display += "^2";
                    }
                    break;
                case "^":
                    if (second) {
                        display += "π";
                        second = false;
                    } else {
                        display += "^";
                    }
                    break;
                case "(":
                    display += "(";
                    break;
                case ")":
                    display += ")";
                    break;
                case "÷":
                    display += "/";
                    break;
                case "log":
                    if (second) {
                        display += "10^(";
                    } else {
                        display += "log(";
                    }

                    break;
                case "7":
                    display += "7";
                    break;
                case "8":
                    display += "8";
                    break;
                case "9":
                    display += "9";
                    break;
                case "×":
                    display += "*";
                    break;
                case "ln":
                    if (second) {
                        display += "e^(";
                    } else {
                        display += "ln(";
                    }

                    break;
                case "4":
                    display += "4";
                    break;
                case "5":
                    display += "5";
                    break;
                case "6":
                    display += "6";
                    break;
                case "–":
                    display += "–";
                    break;
                case "sto":
                    display += ">";

                    break;
                case "1":
                    display += "1";
                    break;
                case "2":
                    display += "2";
                    break;
                case "3":
                    display += "3";
                    break;
                case "+":
                    display += "+";
                    break;
                case "0":
                    display += "0";
                    break;
                case ".":
                    if(second){
                        display+= ",";
                        second = false;
                    }else{
                        display += ".";
                    }
                    break;
                case "(-)":
                    display+= "-";
                    break;
                case "enter":
                    System.out.println("list " + list);
                    System.out.println("editList "+ editList);
                    System.out.println("stat "+stat);
                    if(list){
                        list = false;
                    }
                    else if(checkStat){
                        checkStat = false;
                        lists();
                        statistics();
                    }else if (editList){
                        editList = false;
                        lists();
                        gpane2.setVisible(false);
                        window.setVisible(true);
                        listView.setVisible(false);
                    }else if(stat){
                        stat();
                        lists();
                        window.setVisible(true);
                        gpane2.setVisible(false);
                        listView.setVisible(false);
                    }
                    else{
                        sto(display);
                        MathOperations calculate = new MathOperations(display, varX);
                        display = calculate.answer();
                    }
                    break;
                default:
                    break;
            }
            window.setText(display);
        }
    }

    @FXML
    private void handleMenuClick(MouseEvent event){
        int index = listView.getSelectionModel().getSelectedIndex();
        System.out.println(index);

        if(math){
            switch(index){
                case 0:
                    display+= ">FRAC";
                    break;
                case 1:
                    display+= ">DEC";
                    break;
                case 2:
                    display+= "nDeriv(";
                    break;
                case 3:
                    display+= "absValue(";
                    break;
                case 4:
                    display+= "lcm(";
                    break;
                case 5:
                    display+= "gcf(";
                    break;
                case 6:
                    display+= "rand";
                    break;
                case 7:
                    display+= "nPr";
                    break;
                case 8:
                    display += "nCr";
                    break;
                case 9:
                    display+= "!";
                    break;
                case 10:
                    display+= "fnInt(";
                    break;
                default:
                    break;
            }
            listView.setVisible(false);

            window.setVisible(true);
            math = false;
        }
        if(stat){
            switch(index){
                case 0:
                    gpane2.setVisible(true);
                    window.setVisible(false);
                    editList = true;
                    break;
                case 1:
                    checkStat = true;
                    display+= "SortA(";
                    window.setVisible(true);
                    break;
                case 2:
                    checkStat = true;
                    display+= "SortD(";
                    window.setVisible(true);
                    break;
                case 3:
                    checkStat = true;
                    display+= "ClrList";
                    clear();
                    window.setVisible(true);
                    break;
                case 4:
                    checkStat = true;
                    display+= "LinReg(";
                    window.setVisible(true);
                    break;
                default:
                    display = "";
                    display+= "error";
                    window.setVisible(true);
                    break;
            }
            stat = false;
            listView.setVisible(false);
            window.setText(display);
        }

        if(list){
            switch(index){
                case 0:
                    display+="L1";
                    break;
                case 1:
                    display+= "L2";
                    break;
                case 2:
                    display+="L3";
                    break;
                default:
                    display = "";
                    display+= "error";
                    break;
            }
            window.setVisible(true);
            listView.setVisible(false);
            gpane2.setVisible(false);
            list = false;
        }

        window.setText(display);
    }

    private void math(){
        math = true;
        listView.setItems(mathFunctions);

    }

    private void stat(){
        stat = true;
        listView.setItems(statList);
        listView.setVisible(true);
        window.setVisible(false);
        System.out.println("list = " + list);
    }

    private void lists(){
        firstArrayList.clear();
        secondArrayList.clear();
        thirdArrayList.clear();

        firstArrayList.add(one.getText());
        firstArrayList.add(two.getText());
        firstArrayList.add(three.getText());
        firstArrayList.add(four.getText());
        firstArrayList.add(five.getText());
        firstArrayList.add(six.getText());
        firstArrayList.add(seven.getText());
        secondArrayList.add(eight.getText());
        secondArrayList.add(nine.getText());
        secondArrayList.add(ten.getText());
        secondArrayList.add(eleven.getText());
        secondArrayList.add(twelve.getText());
        secondArrayList.add(thirteen.getText());
        secondArrayList.add(fourteen.getText());
        thirdArrayList.add(fifteen.getText());
        thirdArrayList.add(sixteen.getText());
        thirdArrayList.add(seventeen.getText());
        thirdArrayList.add(eighteen.getText());
        thirdArrayList.add(nineteen.getText());
        thirdArrayList.add(twenty.getText());
        thirdArrayList.add(twentyone.getText());

        for(int i = 0; i<firstArrayList.size(); i++){
            if(firstArrayList.get(i).equals("")){

            }else{
                String temp = (String) firstArrayList.get(i);
                firstArrayList.set(i,Double.parseDouble(temp));
            }
        }

        for(int i = 0; i<secondArrayList.size(); i++){
            if(secondArrayList.get(i).equals("")){
                secondArrayList.set(i,null);
            }else{
                String temp = (String) secondArrayList.get(i);
                secondArrayList.set(i,Double.parseDouble(temp));
            }
        }

        for(int i = 0; i<thirdArrayList.size(); i++){
            if(thirdArrayList.get(i).equals("")){
                thirdArrayList.set(i,null);
            }else{
                String temp = (String) thirdArrayList.get(i);
                thirdArrayList.set(i,Double.parseDouble(temp));
            }
        }
        System.out.println("first array list "+firstArrayList);
        System.out.println("second array list " + secondArrayList);

    }

    private void statistics(){
        if(display.contains("SortA(")){
            if(display.contains(")")){
                int index = display.indexOf("(");
                int index2 = display.indexOf(")");
                System.out.println("index = " +index);
                System.out.println("index2 = " +index2);
                String list = display.substring(index+1, index2);
                System.out.println(list);
                EditStat x;
                if(list.equals("L1")){
                    x = new EditStat(firstArrayList);
                    firstArrayList = x.SortA();
                }
                if(list.equals("L2")){
                    x = new EditStat(secondArrayList);
                    secondArrayList= x.SortA();

                }
                if(list.equals("L3")){
                    x = new EditStat(thirdArrayList);
                    thirdArrayList = x.SortA();
                }
                setArraySize();
                setTextArea();
                System.out.println("first array list = " + firstArrayList);
            }

        }
        if(display.contains("SortD(")){
            if(display.contains(")")){
                int index = display.indexOf("(");
                int index2 = display.indexOf(")");
                System.out.println("index = " +index);
                System.out.println("index2 = " +index2);
                String list = display.substring(index+1, index2);
                System.out.println(list);
                EditStat x;
                if(list.equals("L1")){
                    x = new EditStat(firstArrayList);
                    firstArrayList = x.SortD();
                }
                if(list.equals("L2")){
                    x = new EditStat(secondArrayList);
                    secondArrayList= x.SortD();

                }
                if(list.equals("L3")){
                    x = new EditStat(thirdArrayList);
                    thirdArrayList = x.SortD();
                }
                setArraySize();
                setTextArea();
                System.out.println("first array list = " + firstArrayList);
            }
        }
        if(display.contains("LinReg(")){
            if(display.contains(")") && display.contains(",")){
                int index = display.indexOf("(");
                int index2 = display.indexOf(")");
                int index3 = display.indexOf(",");

                String list1 = display.substring(index+1, index3);
                String list2 = display.substring(index3+1, index2);
                ArrayList<Object> first = new ArrayList<>();
                ArrayList<Object> second = new ArrayList<>();

                LinearRegression x;

                if(list1.equals("L1")){
                    first = firstArrayList;
                }else if (list1.equals("L2")){
                    first = secondArrayList;
                }else{
                    first = thirdArrayList;
                }

                if(list2.equals("L1")){
                    second = firstArrayList;
                }else if(list2.equals("L2")){
                    second = secondArrayList;
                }else{
                    second = thirdArrayList;
                }
                System.out.println("first "+ first);
                System.out.println("second "+ second);
                x = new LinearRegression(first,second);
                display = "";
                display = x.lineOfRegression();
                window.setText(display);
            }
        }
    }

    private void secondStat(){
        list = true;
        listView.setItems(listInfo);
        window.setVisible(false);
        listView.setVisible(true);
    }

    private void setArraySize(){
        while(firstArrayList.size()<7){
            firstArrayList.add(null);
        }
        while(secondArrayList.size()<7){
            secondArrayList.add(null);
        }
        while(thirdArrayList.size()<7){
            thirdArrayList.add(null);
        }

        System.out.println("text area 1 " + firstArrayList);
        System.out.println("text area 2 " + secondArrayList);
        System.out.println("text area 3 " + thirdArrayList);
    }

    private void setTextArea(){
        if(firstArrayList.get(0)== null){
            one.setText("");
        }
        else{
            one.setText(Double.toString((Double)firstArrayList.get(0)));
        }

        if(firstArrayList.get(1)== null){
            two.setText("");
        }
        else{
            two.setText(Double.toString((Double)firstArrayList.get(1)));
        }

        if(firstArrayList.get(2)== null){
            three.setText("");
        }
        else{
            three.setText(Double.toString((Double)firstArrayList.get(2)));
        }

        if(firstArrayList.get(3)== null){
            four.setText("");
        }
        else{
            four.setText(Double.toString((Double)firstArrayList.get(3)));
        }

        if(firstArrayList.get(4)== null){
            five.setText("");
        }
        else{
            five.setText(Double.toString((Double)firstArrayList.get(4)));
        }

        if(firstArrayList.get(5)== null){
            six.setText("");
        }
        else{
            six.setText(Double.toString((Double)firstArrayList.get(5)));
        }

        if(firstArrayList.get(6)== null){
            seven.setText("");
        }
        else{
            seven.setText((Double.toString((Double)firstArrayList.get(6))));
        }

        if(secondArrayList.get(0)== null){
            eight.setText("");
        }
        else{
            eight.setText(Double.toString((Double)secondArrayList.get(0)));
        }

        if(secondArrayList.get(1)== null){
            nine.setText("");
        }
        else{
            nine.setText(Double.toString((Double)secondArrayList.get(1)));
        }

        if(secondArrayList.get(2)== null){
            ten.setText("");
        }
        else{
            ten.setText(Double.toString((Double)secondArrayList.get(2)));
        }

        if(secondArrayList.get(3)== null){
            eleven.setText("");
        }
        else{
            eleven.setText(Double.toString((Double)secondArrayList.get(3)));
        }

        if(secondArrayList.get(4)== null){
            twelve.setText("");
        }
        else{
            twelve.setText(Double.toString((Double)secondArrayList.get(4)));
        }

        if(secondArrayList.get(5)== null){
            thirteen.setText("");
        }
        else{
            thirteen.setText(Double.toString((Double)secondArrayList.get(5)));
        }

        if(secondArrayList.get(6)== null){
            fourteen.setText("");
        }
        else{
            fourteen.setText(Double.toString((Double)secondArrayList.get(6)));
        }

        if(thirdArrayList.get(0)== null){
            fifteen.setText("");
        }
        else{
            fifteen.setText(Double.toString((Double)thirdArrayList.get(0)));
        }

        if(thirdArrayList.get(1)== null){
            sixteen.setText("");
        }
        else{
            sixteen.setText(Double.toString((Double)thirdArrayList.get(1)));
        }

        if(thirdArrayList.get(2)== null){
            seventeen.setText("");
        }
        else{
            seventeen.setText(Double.toString((Double)thirdArrayList.get(2)));
        }

        if(thirdArrayList.get(3)== null){
            eighteen.setText("");
        }
        else{
            eighteen.setText(Double.toString((Double)thirdArrayList.get(3)));
        }

        if(thirdArrayList.get(4)== null){
            nineteen.setText("");
        }
        else{
            nineteen.setText(Double.toString((Double)thirdArrayList.get(4)));
        }

        if(thirdArrayList.get(5)== null){
            twenty.setText("");
        }
        else{
            twenty.setText(Double.toString((Double)thirdArrayList.get(5)));
        }

        if(thirdArrayList.get(6)== null){
            twentyone.setText("");
        }
        else{
            twentyone.setText(Double.toString((Double)thirdArrayList.get(6)));
        }

    }

    private void sto(String input) {

        if (input.contains(">")) {
            varX = input.substring(0, input.indexOf(">"));

            System.out.println(varX);
        }
        System.out.println(varX);

    }

    private void clear(){
        firstArrayList.clear();
        secondArrayList.clear();
        thirdArrayList.clear();
        one.setText("");
        two.setText("");
        three.setText("");
        four.setText("");
        five.setText("");
        six.setText("");
        seven.setText("");
        eight.setText("");
        nine.setText("");
        ten.setText("");
        eleven.setText("");
        twelve.setText("");
        thirteen.setText("");
        fourteen.setText("");
        fifteen.setText("");
        sixteen.setText("");
        eighteen.setText("");
        nineteen.setText("");
        twenty.setText("");
        twentyone.setText("");







    }
}

