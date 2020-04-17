package by.epam.BookSpace.utils;

import java.util.Scanner;

public abstract class InputData <T, K> {
    protected final Scanner input = new Scanner(System.in);

    public abstract T inputItem();
    public abstract K inputId();
}