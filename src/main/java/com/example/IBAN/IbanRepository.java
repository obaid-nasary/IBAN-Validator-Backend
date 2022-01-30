package com.example.IBAN;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IbanRepository extends JpaRepository<Iban, Integer> {

    void deleteIbanById(Long id);

    @Query("SELECT s FROM Iban s WHERE s.valid = ?1")
    List<Iban> findIbanByValid(Integer valid);


}
