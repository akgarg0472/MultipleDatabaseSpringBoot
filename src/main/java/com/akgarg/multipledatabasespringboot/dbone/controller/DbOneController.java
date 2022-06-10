package com.akgarg.multipledatabasespringboot.dbone.controller;

import com.akgarg.multipledatabasespringboot.dbone.entity.DatabaseOne;
import com.akgarg.multipledatabasespringboot.dbone.repository.DatabaseOneRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Author: Akhilesh Garg
 * GitHub: <a href="https://github.com/akgarg0472">https://github.com/akgarg0472</a>
 * Date: 11-06-2022
 */
@RestController
@RequestMapping("/api/v1/db-one")
@AllArgsConstructor
public class DbOneController {

    private final static String[] names = {"Shubham", "Sameeksha", "Aman", "Jyoti", "Prince"};
    private final static String[] emails = {"shubham@email.com", "sameeksha@email.com", "aman@email.com", "jyoti@email.com", "prince@email.com"};

    private final DatabaseOneRepository databaseOneRepository;
    private final Logger logger = LoggerFactory.getLogger(DbOneController.class);

    @PostMapping
    public ResponseEntity<?> addDatabaseOne() {
        int index = Math.abs(new Random().nextInt() % names.length);
        DatabaseOne one = new DatabaseOne(names[index], emails[index]);
        DatabaseOne savedDatabaseOne = databaseOneRepository.save(one);
        logger.info(String.format("%s: Inserting record into multidbone: %s", LocalDateTime.now(), one));
        return new ResponseEntity<>(savedDatabaseOne, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllDatabaseOneRecords() {
        return new ResponseEntity<>(databaseOneRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{recordId}")
    public ResponseEntity<?> getSingleDatabaseOneRecord(@PathVariable("recordId") String recordId) {
        DatabaseOne databaseRecord = databaseOneRepository.findById(recordId).orElse(null);
        logger.info(String.format("%s: Fetching record from multidbone having id: %s", LocalDateTime.now(), recordId));

        if (databaseRecord != null) {
            return new ResponseEntity<>(databaseRecord, HttpStatus.OK);
        }

        return new ResponseEntity<>("No record found with id: " + recordId, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{recordId}")
    public ResponseEntity<?> deleteDatabaseOneRecord(@PathVariable("recordId") String recordId) {
        logger.warn(String.format("%s: Received request to delete record having id %s from multidbone", LocalDateTime.now(), recordId));

        DatabaseOne record = databaseOneRepository.findById(recordId).orElse(null);

        if (record != null) {
            databaseOneRepository.deleteById(recordId);
            logger.warn(String.format("%s: Record having id %s deleted successfully from multidbone", LocalDateTime.now(), recordId));
            return new ResponseEntity<>("databaseRecord deleted successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("No record found with id: " + recordId, HttpStatus.BAD_REQUEST);
    }

}
