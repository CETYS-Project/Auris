package com.cetys.loading.controller;

import com.cetys.loading.model.Org;
import com.cetys.loading.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/org")
public class OrgController {

    @Autowired
    private OrgService orgService;

    @GetMapping("/")
    public List<Org> getAllOrgs() {
        return orgService.getAllOrgs();
    }

    @GetMapping("/{id}")
    public Org getOrgById(@PathVariable Long id) {
        return orgService.getOrgById(id);
    }

    @PostMapping("/")
    public Org createOrg(@RequestBody Org org) {
        return orgService.createOrg(org);
    }

    @PutMapping("/{id}")
    public Org updateOrg(@PathVariable Long id, @RequestBody Org orgDetails) {
        return orgService.updateOrg(id, orgDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteOrg(@PathVariable Long id) {
        orgService.deleteOrg(id);
    }
}
