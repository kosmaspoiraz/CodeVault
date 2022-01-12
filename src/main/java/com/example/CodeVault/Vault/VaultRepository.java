package com.example.CodeVault.Vault;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VaultRepository extends JpaRepository<Vault, Long> {

    @Query("SELECT v FROM Vault v WHERE v.user_id = ?1")
    Optional<Vault> findVaultByUserId(Long userId);
}
