package com.elis.product1.product1.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "p_product")
public class Product implements Serializable {
    private static final long serialVersionUID = 9140669560328917869L;

    public static final String SEQ = "p_product_seq";
    @Id
    @GeneratedValue(generator = SEQ)
    @SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
    private Integer id;

    private String name;
    @Column(name = "created_date")
    private Timestamp createdDate;
    private Integer type;
}
