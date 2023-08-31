package com.globant.BusinessLogic;

import com.globant.Models.Department;
import com.globant.Models.HiredEmployee;
import com.globant.Models.Job;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFromCSV {


    private static ReadFromCSV instance;

    public ReadFromCSV() {
    }

    public ReadFromCSV getInstance() {

        if (instance == null) {
            instance = new ReadFromCSV();
        }

        return instance;
    }

    public static List<Department> LoadCSVtoDepartment(String fileName) throws IOException {

        List<List<String>> records = readFromCSV(fileName);


        List<Department> departments = new ArrayList<>();
        for (List<String> record : records) {
            Department department = new Department();
            department.setId(Integer.parseInt(record.get(0)));
            department.setDepartment(record.get(1));

            departments.add(department);
        }

        return departments;
    }

    public static List<Job> LoadCSVtoJob(String fileName) throws IOException {

        List<List<String>> records = readFromCSV(fileName);


        List<Job> jobs = new ArrayList<>();
        for (List<String> record : records) {
            Job job = new Job();
            job.setId(Integer.parseInt(record.get(0)));
            job.setJob(record.get(1));

            jobs.add(job);
        }

        return jobs;
    }

    public static List<HiredEmployee> LoadCSVtoHiredEmployee(String fileName) throws IOException {

        List<List<String>> records = readFromCSV(fileName);


        List<HiredEmployee> hiredEmployees = new ArrayList<>();
        for (List<String> record : records) {
            HiredEmployee hiredEmployee = new HiredEmployee();
            hiredEmployee.setId(Integer.parseInt(record.get(0)));
            hiredEmployee.getDepartment().setId(Integer.parseInt(record.get(2)));
            hiredEmployee.getJob().setId(Integer.parseInt(record.get(3)));

            hiredEmployees.add(hiredEmployee);
        }

        return hiredEmployees;
    }


    private static List<List<String>> readFromCSV(String fileName) throws FileNotFoundException {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        }

        return records;
    }
    private static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
