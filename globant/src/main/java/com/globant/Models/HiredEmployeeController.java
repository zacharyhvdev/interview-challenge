package com.globant.Models;

import com.globant.Exceptions.HttpMessageNotReadableExceptionHandler;
import com.globant.Models.RequestBody.HiredEmployeewithIDs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hired_employee")
public class HiredEmployeeController {

    public static HiredEmployeeService hiredEmployeeService;


    @Autowired
    public HiredEmployeeController(HiredEmployeeService hiredEmployeeService) {
        this.hiredEmployeeService = hiredEmployeeService;
    }

    @GetMapping
    public static List<HiredEmployee> getHiredEmployee(@RequestParam(value = "id", defaultValue = "1") int id) {
        return hiredEmployeeService.getHiredEmployee(id);
    }

    @PostMapping
    public static ResponseEntity<String> addHiredEmployee(
            @RequestBody ArrayList<HiredEmployee> hiredEmployee
            ) {


        System.out.println(hiredEmployee.get(0).getId());

        return hiredEmployeeService.addHiredEmployee(hiredEmployee);
    }

    @ExceptionHandler(DateTimeParseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleException(DateTimeParseException e) {
        return new ResponseEntity<>("Datetime format is not valid", HttpStatus.BAD_REQUEST);
    }
}
