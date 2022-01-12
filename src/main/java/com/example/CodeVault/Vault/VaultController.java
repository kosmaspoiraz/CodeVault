package com.example.CodeVault.Vault;

import com.example.CodeVault.Record.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "codevault/vault")
public class VaultController {

    private final VaultService vaultService;
    private final RecordService recordService;

    @Autowired
    public VaultController(VaultService vaultService, RecordService recordService) {
        this.vaultService = vaultService;
        this.recordService = recordService;
    }

    @PostMapping
    public void createNewVault(Long userId){vaultService.createNewVault(userId);}

    @DeleteMapping(path = "{vaultId}")
    public void deleteVault(@PathVariable("vaultId") Long vaultId){
        vaultService.deleteVault(vaultId);
        recordService.deleteAllRecordsByVaultId(vaultId);
    }
}
