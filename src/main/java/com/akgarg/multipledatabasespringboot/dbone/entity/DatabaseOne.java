package com.akgarg.multipledatabasespringboot.dbone.entity;

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
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class DatabaseOne {

    @Id
    @Column(length = 36)
    private String id;

    private String name;
    private String email;

    public DatabaseOne(String name, String email) {
        this.name = name;
        this.email = email;
        this.id = UUID.randomUUID().toString();
    }

}
