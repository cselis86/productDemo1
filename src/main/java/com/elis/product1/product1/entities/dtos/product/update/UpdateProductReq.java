package com.elis.product1.product1.entities.dtos.product.update;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class UpdateProductReq implements Serializable {

    @NonNull
    private int id;
    @Size(min = 2, max = 20)
    private String name;
    private int type;

}
