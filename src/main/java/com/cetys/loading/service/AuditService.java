package com.cetys.loading.service;

import com.cetys.loading.model.Audit;
import com.cetys.loading.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

    public List<Audit> getAllAudits() {
        return auditRepository.findAll();
    }

    public Audit getAuditById(Long id) {
        Optional<Audit> audit = auditRepository.findById(id);
        return audit.orElse(null);
    }

    public Audit createAudit(Audit audit) {
        return auditRepository.save(audit);
    }

    public Audit updateAudit(Long id, Audit auditDetails) {
        Optional<Audit> auditOptional = auditRepository.findById(id);
        if (auditOptional.isPresent()) {
            Audit audit = auditOptional.get();
            audit.setSubarea(auditDetails.getSubarea());
            return auditRepository.save(audit);
        } else {
            return null;
        }
    }

    public void deleteAudit(Long id) {
        auditRepository.deleteById(id);
    }
}