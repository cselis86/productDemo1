package com.elis.product1.product1.commons.paging;

import lombok.Getter;

import java.util.List;

import static java.util.Collections.emptyList;

@Getter
public class PageResp<T> {

    @SuppressWarnings("unchecked")
    public static final PageResp EMPTY = new PageResp(0, emptyList());

    private int total;
    private List<T> content;

    public PageResp(int total, List<T> content) {
        this.total = total;
        this.content = content;
    }

    public static <T> PageResp<T> of(int total, List<T> content){
        return new PageResp<>(total, content);
    }

    public static <T> PageResp<T> empty(){
        return EMPTY;
    }
}
