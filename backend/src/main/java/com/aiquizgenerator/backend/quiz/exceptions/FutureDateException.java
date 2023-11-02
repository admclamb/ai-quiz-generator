package com.aiquizgenerator.backend.quiz.exceptions;

import com.aiquizgenerator.backend.common.pagination.labels.PaginationLabels;

public class FutureDateException extends RuntimeException {
    public FutureDateException() { super(PaginationLabels.TIMESTAMP_IS_IN_FUTURE);}
}
