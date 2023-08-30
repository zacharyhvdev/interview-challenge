package com.globant.Models;

import com.globant.Models.RequestBody.HiredEmployeewithIDs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class HiredEmployeeService {

    private final HiredEmployeeRepository hiredEmployeeRepository;

    private static final DateTimeFormatter formatter
            = DateTimeFormatter.ofPattern("uuuuMMdd'T'HHmmssX")
            .withResolverStyle(ResolverStyle.STRICT);

    @Autowired
    public HiredEmployeeService(HiredEmployeeRepository hiredEmployeeRepository) {
        this.hiredEmployeeRepository = hiredEmployeeRepository;
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
}
