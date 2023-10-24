package com.utfpr.bd2.repository;

import com.utfpr.bd2.entity.Dirige;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DirigeRepository extends JpaRepository<Dirige,Long> {

    @Query( "SELECT d FROM Dirige d WHERE d.Data >= :d1  and d.Data <= :d2")
    public List<Dirige> findByPeriod(@Param("d1")LocalDate d1,@Param("d2") LocalDate d2);

}
