package com.globant.Models;

import com.globant.BusinessLogic.ReadFromCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;

@Service
public class HiredEmployeeService {

    private final HiredEmployeeRepository hiredEmployeeRepository;
    private final JobRepository jobRepository;
    private final DepartmentRepository departmentRepository;

    private static final DateTimeFormatter formatter
            = DateTimeFormatter.ofPattern("uuuuMMdd'T'HHmmssX")
            .withResolverStyle(ResolverStyle.STRICT);

    @Autowired
    public HiredEmployeeService(HiredEmployeeRepository hiredEmployeeRepository, JobRepository jobRepository, DepartmentRepository departmentRepository) {
        this.hiredEmployeeRepository = hiredEmployeeRepository;
        this.jobRepository = jobRepository;
        this.departmentRepository = departmentRepository;
    }
    public List<HiredEmployee> getHiredEmployee(int id) {
        return hiredEmployeeRepository.findAll();
    }

    public ResponseEntity<String> addHiredEmployee(ArrayList<HiredEmployee> hiredEmployee) {


            //if (hiredEmployee.get)
        hiredEmployeeRepository.saveAll(hiredEmployee);

        return new ResponseEntity<>("Hired Employee added successfully", HttpStatus.OK);
    }

    private static boolean isParseableBasicIso8601(String str) {
        try {
            OffsetDateTime odt = OffsetDateTime.parse(str, formatter);
            return odt.getOffset().equals(ZoneOffset.UTC);
        } catch (DateTimeParseException dtpe) {
            return false;
        }
    }

    public ResponseEntity<String> migrateHiredEmployee(String file_name) throws IOException {

        ReadFromCSV readFromCSV = new ReadFromCSV();

        List<HiredEmployee> hiredEmployees = ReadFromCSV.LoadCSVtoHiredEmployee(file_name);

        for (HiredEmployee hiredEmployee : hiredEmployees) {

            Job jobExist = jobRepository.findById(hiredEmployee.getJob().getId()).orElse(null);

            if (jobExist == null) {
                continue;
            }

            Department departmentExist = departmentRepository.findById(hiredEmployee.getDepartment().getId()).orElse(null);

            if (departmentExist == null) {
                continue;
            }

            hiredEmployeeRepository.save(hiredEmployee);
        }

        return new ResponseEntity<>("Hired Employee migrated successfully", HttpStatus.OK);
    }
}
