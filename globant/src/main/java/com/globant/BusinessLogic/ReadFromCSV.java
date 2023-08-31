package com.globant.BusinessLogic;

import com.globant.Models.Department;
import com.globant.Models.HiredEmployee;
import com.globant.Models.Job;
import org.springframework.cglib.core.Local;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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


        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");


        List<HiredEmployee> hiredEmployees = new ArrayList<>();
        for (List<String> record : records) {

            if (record.size() < 5) {
                record.add(null);
            }

            String input = record.get(2);

            String hiredEmployeeName = record.get(1);
            LocalDateTime hiredEmployeeDateTime = input != null ? input.isEmpty() ? null : LocalDateTime.parse(input, format) : null;
            String hiredEmployeeDepartmentId = record.get(3) != null  ? record.get(3).isEmpty()? null : record.get(3) : null;
            String hiredEmployeeJobId = record.get(4) != null  ? record.get(4).isEmpty()? null : record.get(4) : null;

            HiredEmployee hiredEmployee = new HiredEmployee();
            hiredEmployee.setId(Integer.parseInt(record.get(0)));
            hiredEmployee.setName(hiredEmployeeName);
            hiredEmployee.setDatetime((hiredEmployeeDateTime != null) ? hiredEmployeeDateTime : LocalDateTime.now());

            Department department = hiredEmployeeDepartmentId != null ?
                    new Department(Integer.parseInt(hiredEmployeeDepartmentId), null) :
                    new Department(-1, "no job");
            hiredEmployee.setDepartment(department);

            Job job = hiredEmployeeJobId != null ? new Job(Integer.parseInt(hiredEmployeeJobId), null) :
                    new Job(-1, "no job");
            hiredEmployee.setJob(job);

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
