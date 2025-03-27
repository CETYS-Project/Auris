package com.cetys.loading.controller;

import com.cetys.loading.model.OrgInvite;
import com.cetys.loading.service.OrgInviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/org-invite")
public class OrgInviteController {

    @Autowired
    private OrgInviteService orgInviteService;

    @GetMapping("/")
    public List<OrgInvite> getAllOrgInvites() {
        return orgInviteService.getAllOrgInvites();
    }

    @GetMapping("/{id}")
    public OrgInvite getOrgInviteById(@PathVariable Long id) {
        return orgInviteService.getOrgInviteById(id);
    }

    @PostMapping("/")
    public OrgInvite createOrgInvite(@RequestBody OrgInvite orgInvite) {
        return orgInviteService.createOrgInvite(orgInvite);
    }

    @PutMapping("/{id}")
    public OrgInvite updateOrgInvite(@PathVariable Long id, @RequestBody OrgInvite orgInviteDetails) {
        return orgInviteService.updateOrgInvite(id, orgInviteDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteOrgInvite(@PathVariable Long id) {
        orgInviteService.deleteOrgInvite(id);
    }
}