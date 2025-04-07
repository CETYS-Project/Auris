package com.cetys.loading.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cetys.loading.dto.request.AnswerDtoRequest;
import com.cetys.loading.dto.response.AuditAnswerDtoResponse;
import com.cetys.loading.dto.response.AuditCategoryDtoResponse;
import com.cetys.loading.dto.response.AuditDtoResponse;
import com.cetys.loading.dto.response.AuditQuestionDtoResponse;
import com.cetys.loading.dto.response.BaseCategoryDtoResponse;
import com.cetys.loading.dto.response.BaseQuestionDtoResponse;
import com.cetys.loading.enums.SCategory;
import com.cetys.loading.model.Audit;
import com.cetys.loading.model.AuditAnswer;
import com.cetys.loading.model.AuditCategory;
import com.cetys.loading.model.AuditQuestion;
import com.cetys.loading.model.BaseCategory;
import com.cetys.loading.model.BaseQuestion;

@Mapper(componentModel = "spring")
public interface AuditMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "auditQuestions", ignore = true)
    @Mapping(target = "audit", source = "audit")
    @Mapping(target = "baseCategory", source = "baseCategory")
    @Mapping(target = "sCategory", source = "sCategory")
    AuditCategory toAuditCategory(BaseCategory baseCategory, Audit audit, SCategory sCategory);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "auditAnswer", ignore = true)
    @Mapping(target = "auditCategory", source = "auditCategory")
    @Mapping(target = "baseQuestion", source = "baseQuestion")
    AuditQuestion toAuditQuestion(BaseQuestion baseQuestion, AuditCategory auditCategory);

    AuditDtoResponse toDto(Audit audit);

    AuditCategoryDtoResponse toDto(AuditCategory auditCategory);

    AuditQuestionDtoResponse toDto(AuditQuestion auditQuestion);

    BaseCategoryDtoResponse toDto(BaseCategory baseCategory);

    BaseQuestionDtoResponse toDto(BaseQuestion baseQuestion);

    AuditAnswerDtoResponse toDto(AuditAnswer auditAnswer);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "auditQuestion", ignore = true)
    AuditAnswer toEntity(AnswerDtoRequest answerDtoRequest);

}
