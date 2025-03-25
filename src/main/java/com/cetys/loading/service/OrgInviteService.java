package com.cetys.loading.service;

import com.cetys.loading.model.OrgInvite;
import com.cetys.loading.repository.OrgInviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrgInviteService {

    @Autowired
    private OrgInviteRepository orgInviteRepository;

    public List<OrgInvite> getAllOrgInvites() {
        return orgInviteRepository.findAll();
    }

    public OrgInvite getOrgInviteById(Long id) {
        Optional<OrgInvite> orgInvite = orgInviteRepository.findById(id);
        return orgInvite.orElse(null);
    }

    public OrgInvite createOrgInvite(OrgInvite orgInvite) {
        return orgInviteRepository.save(orgInvite);
    }

    public OrgInvite updateOrgInvite(Long id, OrgInvite orgInviteDetails) {
        Optional<OrgInvite> orgInviteOptional = orgInviteRepository.findById(id);
        if (orgInviteOptional.isPresent()) {
            OrgInvite orgInvite = orgInviteOptional.get();
            orgInvite.setOrg(orgInviteDetails.getOrg());
            orgInvite.setCode(orgInviteDetails.getCode());
            orgInvite.setExpires(orgInviteDetails.getExpires());
            return orgInviteRepository.save(orgInvite);
        } else {
            return null;
        }
    }

    public void deleteOrgInvite(Long id) {
        orgInviteRepository.deleteById(id);
    }
}