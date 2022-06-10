package com.akgarg.multipledatabasespringboot.dbtwo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Author: Akhilesh Garg
 * GitHub: <a href="https://github.com/akgarg0472">https://github.com/akgarg0472</a>
 * Date: 10-06-2022
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class DatabaseTwo {

    @Id
    @Column(length = 36)
    private String id;

    @Column(name = "name")
    private String entityName;

    @Column(name = "email")
    private String entityEmail;

    @Column(name = "contact_number")
    private String entityContactNumber;

    public DatabaseTwo(String entityName, String entityEmail, String entityContactNumber) {
        this.entityName = entityName;
        this.entityEmail = entityEmail;
        this.entityContactNumber = entityContactNumber;
        this.id = UUID.randomUUID().toString();
    }

}
