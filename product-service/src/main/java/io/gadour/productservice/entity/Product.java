package io.gadour.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product extends AbstractEntity{

    @Column(name ="productName")
    private String productName;

    @Column(name = "price")
    private Long price;



    @ManyToOne
    private Category category;

    @ManyToOne
    private BrandMark brand;

    private Long entrepotId;
}
