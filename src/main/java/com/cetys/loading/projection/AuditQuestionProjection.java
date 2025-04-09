package com.cetys.loading.projection;

import com.cetys.loading.model.AuditAnswer;

public interface AuditQuestionProjection {
    Long getId();

    String getQuestion();

    Long getAuditCategoryId();

    AuditAnswer getAuditAnswer();
}
