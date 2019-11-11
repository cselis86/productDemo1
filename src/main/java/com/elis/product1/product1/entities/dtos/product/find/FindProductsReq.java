package com.elis.product1.product1.entities.dtos.product.find;

import com.elis.product1.product1.commons.paging.PageReq;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class FindProductsReq extends PageReq {

    private Timestamp from;
    private Timestamp to;
    private Integer type;
    private String filter;

    private List<Integer> ids;

}
