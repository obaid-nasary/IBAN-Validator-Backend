package com.example.IBAN;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IbanRepository extends JpaRepository<Iban, Boolean> {

    @Query("SELECT s FROM Iban s WHERE s.valid = ?1")
    List<Iban> findIbanByValid(Long valid);


}
