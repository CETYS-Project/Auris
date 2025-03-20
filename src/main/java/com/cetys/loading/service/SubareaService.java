package com.cetys.loading.service;

import com.cetys.loading.model.Subarea;
import com.cetys.loading.repository.SubareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubareaService {

    @Autowired
    private SubareaRepository subareaRepository;

    public List<Subarea> getAllSubareas() {
        return subareaRepository.findAll();
    }

    public Subarea getSubareaById(Long id) {
        Optional<Subarea> subarea = subareaRepository.findById(id);
        return subarea.orElse(null);
    }

    public Subarea createSubarea(Subarea subarea) {
        return subareaRepository.save(subarea);
    }

    public Subarea updateSubarea(Long id, Subarea subareaDetails) {
        Optional<Subarea> subareaOptional = subareaRepository.findById(id);
        if (subareaOptional.isPresent()) {
            Subarea subarea = subareaOptional.get();
            subarea.setArea(subareaDetails.getArea());
            subarea.setName(subareaDetails.getName());
            return subareaRepository.save(subarea);
        } else {
            return null;
        }
    }

    public void deleteSubarea(Long id) {
        subareaRepository.deleteById(id);
    }
}