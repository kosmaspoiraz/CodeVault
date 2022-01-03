package com.example.CodeVault.Record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "codevault/record")
public class RecordController {

    private final RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping
    public List<Record> getRecords(){
        return recordService.getRecords();
    }

    @PostMapping
    public void addNewRecord(@RequestBody Record newRecord){
        recordService.addNewRecord(newRecord);
    }

    @DeleteMapping(path = "{recordId}")
    public void deleteRecord(@PathVariable("recordId") Long recordId){
        recordService.deleteRecord(recordId);
    }

    @PutMapping(path = "/update/{recordId}")
    public void updateRecordById(
            @PathVariable("recordId") Long recordId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password){
        recordService.updateRecord(recordId, name, username, password);
    }
}
