package com.example;

import java.io.*;
import java.util.ArrayList;

class FileHandler {

    private static String filePath = "resources/employees.bin";
    private static File file = new File(filePath);

    private static boolean checkFile() {      // Checks if the file exists and it isn't empty
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return file.length() != 0;
    }

    static void readFile() {
        if (checkFile()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                ArrayList<Employee> list = new ArrayList<>();
                Object obj;
                while ((obj = ois.readObject()) != null) {
                    Employee e = (Employee) obj;
                    list.add(e);
                }
                EmployeeData.fillEmployeeList(list);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    static void writeToFile() {
        checkFile();    // If the file doesn't exist, then it adds it
        if (!EmployeeData.employeeListEmpty()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath, false))) {
                ArrayList<Employee> employees = EmployeeData.getList();
                for (Employee employee : employees) {
                    oos.writeObject(employee);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
