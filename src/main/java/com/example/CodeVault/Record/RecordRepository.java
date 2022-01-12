package com.example.CodeVault.Record;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    @Query("SELECT r FROM Record r WHERE r.name = ?1")
    Optional<Record> findRecordByName(String name);

    @Query("SELECT * FROM Record r WHERE r.vault_id =?1")
    List<Optional<Record>> findRecordsByVaultId(Long vault_id);
}
