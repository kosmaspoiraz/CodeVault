package com.example.CodeVault.Vault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class VaultService {

    private final VaultRepository vaultRepository;

    @Autowired
    public VaultService(VaultRepository vaultRepository) {
        this.vaultRepository = vaultRepository;
    }

    @Transactional
    public void createNewVault(Long userId) {
        Vault vault = new Vault();
        vault.setUsers_id(userId);
        vaultRepository.save(vault);
    }

    public void deleteVault(Long userId) {
        Optional<Vault> vaultToDelete = vaultRepository.findVaultByUserId(userId);
        vaultRepository.deleteById(vaultToDelete.orElse(null).getId());
    }
}
