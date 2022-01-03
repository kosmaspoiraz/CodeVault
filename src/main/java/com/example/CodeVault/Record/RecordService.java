package com.example.CodeVault.Record;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {

    @Autowired
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    private final RecordRepository recordRepository;

    public List<Record> getRecords(){
        return recordRepository.findAll();
    }

    public void addNewRecord(Record newRecord) {
        Optional<Record> recordByName = recordRepository.findRecordByName(newRecord.getName());
        if (recordByName.isPresent()){
            throw new IllegalStateException(newRecord.getName() + " already exists!");
        }
        recordRepository.save(newRecord);
    }

    public void deleteRecord(Long recordId) {
        boolean exists = recordRepository.existsById(recordId);
        if(!exists){
            throw new IllegalStateException("Record with id:" + recordId + " does not exist!");
        }
        recordRepository.deleteById(recordId);
    }

    @Transactional
    public void updateRecord(Long recordId, String name, String username, String password) {
        boolean exists = recordRepository.existsById(recordId);
        if(!exists){
            throw new IllegalStateException("Record with id:" + recordId + " does not exist!");
        }
        Record recordToUpdate = recordRepository.getById(recordId);
        if(name != null)
            recordToUpdate.setName(name);
        if(username != null)
            recordToUpdate.setUsername(username);
        if(password != null)
            recordToUpdate.setPassword(password);
    }
}
