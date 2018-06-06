package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        double result;
        long startTime = System.nanoTime();
        result = calculateMultLCMFast(23);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("This operation took " + duration/1000 + " microseconds to complete...");
        System.out.println(result);
    }

    //Really Fast Method------------------------------------------------------------------------------------------------
    private static ArrayList<Double> calculateFactors(double num) {
        ArrayList<Double> result = new ArrayList<Double>();
        for (int i = 1; i <= Math.abs(num) / 2; i++) {
            if (num % i == 0) {
                result.add(num / i);
            }
        }
        return result;
    }

    private static double primeExp(ArrayList<Double> nums) {
        double min = nums.get(nums.size() - 1);
        for (int i = nums.size() - 2; i > 0; i--) {
            if (nums.get(i) % min != 0) {
                return 1;
            }
        }
        return min;
    }

    private static double calculateMultLCMFast(int num) {
        double result = 1;
        ArrayList<Double> factList;
        for (int i = 2; i <= num; i++) {
            factList = calculateFactors(i);
            if (factList.size() == 1) {
                result *= i;
            }
            else {
                result *= primeExp(factList);
            }
        }
        return result;
    }
    //------------------------------------------------------------------------------------------------------------------

    //Very Slow Method-------------------------------------------------------------------------------------------------------
    private static double gcf(double num1, double num2) {
        double gcf;
        int prime = 1;
        double number1;
        double number2;
        ArrayList<Double> factor1 = calculateFactors(num1);
        ArrayList<Double> factor2 = calculateFactors(num2);
        for (int i = 0; i < factor1.size(); i++) {
            number1 = factor1.get(i);
            for (int j = 0; j < factor2.size(); j++) {
                number2 = factor2.get(j);
                if (number1 == number2) {
                    gcf = number1;
                    return gcf;
                }
            }
        }
        if (num1 == 0 || num2 == 0) {
            return 0;
        }
        else if (num1 < 0 && num2 > 0 || num1 > 0 && num2 < 0) {
            return 0;
        }
        else {
            return prime;
        }
    }

    private static double lcm(double num1, double num2) {
        double gcf = gcf(num1, num2);
        return num1 * (num2 / gcf);
    }

    private static double calculateMultLCMSlow(int num) {
        double result = 1;
        for (int i = 2; i <= num; i++) {
            result = lcm(result, i);
        }
        return result;
    }
    //------------------------------------------------------------------------------------------------------------------
}
