package com.elis.product1.product1.service;

import com.elis.product1.product1.commons.paging.PageReq;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.ComparableExpressionBase;

import java.util.Map;

import static java.lang.String.format;

public abstract class SortableService extends DefaultService{
    protected Map<String, ComparableExpressionBase> orderColumns;

    protected OrderSpecifier[] orderBy(PageReq pr, OrderSpecifier secondOrder) {

        ComparableExpressionBase ceb = orderColumns.get(pr.getOrderColumn());
        if (ceb == null) {
            throw new IllegalArgumentException(format("Order column: '%s' not found, available are: %s", pr.getOrderColumn(), orderColumns.keySet()));
        }

        OrderSpecifier firstOrder = pr.isAsc() ? ceb.asc() : ceb.desc();

        return new OrderSpecifier[]{firstOrder, secondOrder};
    }
}
