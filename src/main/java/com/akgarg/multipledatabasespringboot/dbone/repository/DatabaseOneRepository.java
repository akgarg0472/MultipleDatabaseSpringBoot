package com.akgarg.multipledatabasespringboot.dbone.repository;

import com.akgarg.multipledatabasespringboot.dbone.entity.DatabaseOne;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Akhilesh Garg
 * GitHub: <a href="https://github.com/akgarg0472">https://github.com/akgarg0472</a>
 * Date: 10-06-2022
 */
public interface DatabaseOneRepository extends JpaRepository<DatabaseOne, String> {

}
