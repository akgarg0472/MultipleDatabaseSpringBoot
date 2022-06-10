package com.akgarg.multipledatabasespringboot.dbtwo.controller;

import com.akgarg.multipledatabasespringboot.dbtwo.entity.DatabaseTwo;
import com.akgarg.multipledatabasespringboot.dbtwo.repository.DatabaseTwoRepository;
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
@RequestMapping("/api/v1/db-two")
@AllArgsConstructor
public class DbTwoController {

    private final static String[] names = {"Shubham", "Sameeksha", "Aman", "Jyoti", "Prince"};
    private final static String[] emails = {"shubham@email.com", "sameeksha@email.com", "aman@email.com", "jyoti@email.com", "prince@email.com"};
    private final static String[] contactNumber = {"shubham1234", "sameeksha1234", "aman1234", "jyoti1234", "prince1234"};

    private final DatabaseTwoRepository databaseTwoRepository;
    private final Logger logger = LoggerFactory.getLogger(DbTwoController.class);

    @PostMapping
    public ResponseEntity<?> addDatabaseTwo() {
        int index = Math.abs(new Random().nextInt() % names.length);
        DatabaseTwo two = new DatabaseTwo(names[index], emails[index], contactNumber[index]);
        DatabaseTwo savedDatabaseTwo = databaseTwoRepository.save(two);
        logger.info(String.format("%s: Inserting new record %s into multidbtwo", LocalDateTime.now(), two));
        return new ResponseEntity<>(savedDatabaseTwo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllDatabaseTwoRecords() {
        return new ResponseEntity<>(databaseTwoRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{recordId}")
    public ResponseEntity<?> getSingleDatabaseTwoRecord(@PathVariable("recordId") String recordId) {
        DatabaseTwo databaseRecord = databaseTwoRepository.findById(recordId).orElse(null);

        if (databaseRecord != null) {
            return new ResponseEntity<>(databaseRecord, HttpStatus.OK);
        }

        return new ResponseEntity<>("No record found with id: " + recordId, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{recordId}")
    public ResponseEntity<?> deleteDatabaseTwoRecord(@PathVariable("recordId") String recordId) {
        DatabaseTwo record = databaseTwoRepository.findById(recordId).orElse(null);
        logger.warn(String.format("%s: Received request to delete record having id %s from multidbtwo", LocalDateTime.now(), recordId));

        if (record != null) {
            databaseTwoRepository.deleteById(recordId);
            logger.warn(String.format("%s: Record having id %s deleted successfully from multidbone", LocalDateTime.now(), recordId));
            return new ResponseEntity<>("databaseRecord deleted successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("No record found with id: " + recordId, HttpStatus.BAD_REQUEST);
    }

}
