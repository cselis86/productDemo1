package com.elis.product1.product1.entities.dtos.product.create;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class CreateProductDto implements Serializable {
    private static final long serialVersionUID = 8344745034127101844L;

    @NonNull
    @Size(min = 2, max = 20)
    private String name;
    @NonNull
    private Timestamp createdDate;
    @NonNull
    @Positive
    private int type;

}
