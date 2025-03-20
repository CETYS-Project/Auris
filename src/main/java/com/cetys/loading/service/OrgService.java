package com.cetys.loading.service;

import com.cetys.loading.model.Org;
import com.cetys.loading.repository.OrgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrgService {

    @Autowired
    private OrgRepository orgRepository;

    public List<Org> getAllOrgs() {
        return orgRepository.findAll();
    }

    public Org getOrgById(Long id) {
        Optional<Org> org = orgRepository.findById(id);
        return org.orElse(null);
    }

    public Org createOrg(Org org) {
        return orgRepository.save(org);
    }

    public Org updateOrg(Long id, Org orgDetails) {
        Optional<Org> orgOptional = orgRepository.findById(id);
        if (orgOptional.isPresent()) {
            Org org = orgOptional.get();
            org.setName(orgDetails.getName());
            return orgRepository.save(org);
        } else {
            return null;
        }
    }

    public void deleteOrg(Long id) {
        orgRepository.deleteById(id);
    }
}