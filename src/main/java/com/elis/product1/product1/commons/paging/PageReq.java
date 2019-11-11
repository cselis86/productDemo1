package com.elis.product1.product1.commons.paging;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
public class PageReq {

    @PositiveOrZero
    private int offset;
    @Positive
    private int limit = 20;
    private String orderColumn;
    private boolean asc = true;
}
