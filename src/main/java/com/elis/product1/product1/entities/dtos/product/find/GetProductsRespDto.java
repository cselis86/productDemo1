package com.elis.product1.product1.entities.dtos.product.find;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetProductsRespDto implements Serializable {
    private static final long serialVersionUID = -4046118752093557456L;

    private int id;
    private Timestamp createdDate;
    private String name;
    private int type;

}
