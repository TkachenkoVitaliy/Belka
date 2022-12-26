package ru.vtkachenko.belka_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vtkachenko.belka_backend.repository.RecordRepository;
import ru.vtkachenko.belka_backend.entity.Record;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RecordService {

    private final RecordRepository recordRepository;

    @Autowired
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Transactional
    public Record saveRecord(Record record) {
        return recordRepository.save(record);
    }

    @Transactional
    public List<Record> saveRecords(List<Record> records) {
        return recordRepository.saveAll(records);
    }

    public List<Record> getRecordsByMonthAndYear(Integer month, Integer year) {
        return recordRepository.findRecordsByMonthAndYear(month, year);
    }
}
