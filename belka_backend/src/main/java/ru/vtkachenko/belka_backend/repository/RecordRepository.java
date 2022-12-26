package ru.vtkachenko.belka_backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vtkachenko.belka_backend.entity.Record;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    public List<Record> findRecordsByMonthAndYear(Integer month, Integer year);
}
