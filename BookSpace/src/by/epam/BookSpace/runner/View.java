package by.epam.BookSpace.runner;

import by.epam.BookSpace.services.Service;
import by.epam.BookSpace.utils.InputData;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class View <T, K> {
    protected Service<T, K> service;
    protected InputData<T, K> inputData;
    protected final Scanner input = new Scanner(System.in);

    public View() {
    }

    public void add() {
        T item = inputData.inputItem();
        if (item != null) {
            if (!service.insert(item)) {
                System.out.println("Такой элемент уже существует");
            }
        } else {
            System.out.println("Некорректные данные");
        }
        System.out.println();
    }

    public void printAll() {
        ArrayList<T> items = service.getAll();
        for (T item : items) {
            System.out.println(item);
        }
        System.out.println();
    }

    public void change() {
        System.out.print("Введите id: ");
        K id = inputData.inputId();
        T item = service.getById(id);
        if (item != null) {
            T newItem = inputData.inputItem();
            service.update(id, newItem);
        } else {
            System.out.println("Некорректные данные");
        }
        System.out.println();
    }

    public void delete() {
        System.out.print("Введите id: ");
        K id = inputData.inputId();
        T item = service.getById(id);
        if (item != null) {
            service.delete(id);
        } else {
            System.out.println("Некорректные данные");
        }
        System.out.println();
    }

    public void print() {
        System.out.print("Введите id: ");
        K id = inputData.inputId();
        T item = service.getById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Некорректные данные");
        }
        System.out.println();
    }
}