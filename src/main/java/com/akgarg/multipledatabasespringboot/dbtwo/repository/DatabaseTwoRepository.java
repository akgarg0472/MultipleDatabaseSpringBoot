package com.akgarg.multipledatabasespringboot.dbtwo.repository;

import com.akgarg.multipledatabasespringboot.dbtwo.entity.DatabaseTwo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Akhilesh Garg
 * GitHub: <a href="https://github.com/akgarg0472">https://github.com/akgarg0472</a>
 * Date: 10-06-2022
 */
public interface DatabaseTwoRepository extends JpaRepository<DatabaseTwo, String> {

}
