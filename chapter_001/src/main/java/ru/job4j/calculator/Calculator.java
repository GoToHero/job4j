package ru.job4j.calculator;

/**
 * Простейший калькулятор.
 */
public class Calculator {
    /**
     * Результат операции - дробное число.
     */
    private double result;

    /**
     * Операция сложения.
     * @param first первое число.
     * @param second второе число.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Операция вычитания.
     * @param first первое число.
     * @param second второе число.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Операция деления.
     * @param first первое число.
     * @param second второе число.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Операция умножения.
     * @param first первое число.
     * @param second второе число.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Метод, возвращающий результат операции.
     * @return результат операции.
     */
    public double getResult() {
        return this.result;
    }
}