package com.cetys.loading.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cetys.loading.dto.request.SubareaCreateDtoRequest;
import com.cetys.loading.dto.response.SubareaDtoResponse;
import com.cetys.loading.mapper.SubareaMapper;
import com.cetys.loading.model.Area;
import com.cetys.loading.model.BaseCategory;
import com.cetys.loading.model.BaseQuestion;
import com.cetys.loading.model.Subarea;
import com.cetys.loading.repository.AreaRepository;
import com.cetys.loading.repository.BaseQuestionRepository;
import com.cetys.loading.repository.SubareaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubareaService {

    private final AreaRepository areaRepository;
    private final SubareaRepository subareaRepository;
    private final BaseQuestionRepository baseQuestionRepository;
    private final SubareaMapper subareaMapper;

    public List<Subarea> getAllSubareasByAreaId(Long areaId) {
        return subareaRepository.findByAreaId(areaId);
    }

    @Transactional
    public SubareaDtoResponse createSubarea(Long orgId, Long areaId, SubareaCreateDtoRequest subareaCreateDtoRequest) {
        Area area = areaRepository.findById(areaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró la área"));

        Subarea subarea = subareaMapper.toEntity(subareaCreateDtoRequest);
        area.addSubarea(subarea);

        List<BaseCategory> baseCategories = BaseCategoryService.getDefaultBaseCategories();
        for (BaseCategory baseCategory : baseCategories) {
            subarea.addBaseCategory(baseCategory);
        }
        Subarea savedSubarea = subareaRepository.save(subarea);

        List<BaseQuestion> baseQuestions = BaseQuestionService.getDefaultBaseQuestions(baseCategories);
        baseQuestionRepository.saveAll(baseQuestions);

        return subareaMapper.toDto(savedSubarea);
    }

    public List<SubareaDtoResponse> getSubareas(Long areaId) {
        Area area = areaRepository.findById(areaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró la área"));
        return area.getSubareas().stream()
                .map(subareaMapper::toDto)
                .collect(Collectors.toList());
    }
}