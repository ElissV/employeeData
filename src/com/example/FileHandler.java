package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FileHandler {

    private static EmployeeList employeeList;
    private static String filePath;
    private static File file;


    static {
        employeeList = new EmployeeList();
        filePath = "resources/employees.bin";
        file = new File(filePath);
    }

    private void createFileIfNotExists() {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e1) {
                System.out.println("Error. Couldn't create file");
                System.exit(-1);
            }
        }
    }

    void readFile() {
        createFileIfNotExists();
        if (file.length() != 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                convertFileContentsToObjects(ois);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void convertFileContentsToObjects(ObjectInputStream ois) {
        List<Employee> listFromFile = new ArrayList<>();
        Object obj;
        try {
            while ((obj = ois.readObject()) != null) {
                Employee e = (Employee) obj;
                listFromFile.add(e);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error. Couldn't read employee file. \nClassNotFound exception");
        } catch (EOFException ignored) {

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error. Couldn't read employee file. \nIOE exception");
        }
        employeeList.fillEmployeeList(listFromFile);
    }

    void writeToFile() {
        createFileIfNotExists();
        if (!EmployeeList.employeeListIsEmpty()) {
            writeObjects();
        }
    }

    private void writeObjects() {
        try (ObjectOutputStream oos = new ObjectOutputStream(createFileOutputStream())) {
            List<Employee> employees = employeeList.getList();
            for (Employee employee : employees) {
                oos.writeObject(employee);
            }
        } catch (IOException e) {
            System.out.println("Error. Couldn't write data to file");
        }
    }

    private FileOutputStream createFileOutputStream() {
        try {
            return new FileOutputStream(filePath, false);
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}
