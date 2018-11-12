package containers;

import java.util.ArrayList;
import java.util.List;

public class NumbersContainer {
    private int number1 = 121;
    private int number2 = 122;
    private int number3 = 123;
    private int number4 = 124;
    private int number5 = 125;
    private int number6 = 126;
    private int number7 = 127;
    private int number8 = 128;
    private int number9 = 129;
    private int number10 = 130;

    private List<Integer> listOfNumbers;

    public NumbersContainer(){
        listOfNumbers = new ArrayList<>();

        listOfNumbers.add(number1);
        listOfNumbers.add(number2);
        listOfNumbers.add(number3);
        listOfNumbers.add(number4);
        listOfNumbers.add(number5);
        listOfNumbers.add(number6);
        listOfNumbers.add(number7);
        listOfNumbers.add(number8);
        listOfNumbers.add(number9);
        listOfNumbers.add(number10);


    }

    public List<Integer> getListOfNumbers() {
        return listOfNumbers;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public int getNumber3() {
        return number3;
    }

    public int getNumber4() {
        return number4;
    }

    public int getNumber5() {
        return number5;
    }

    public int getNumber6() {
        return number6;
    }

    public int getNumber7() {
        return number7;
    }

    public int getNumber8() {
        return number8;
    }

    public int getNumber9() {
        return number9;
    }

    public int getNumber10() {
        return number10;
    }




}
