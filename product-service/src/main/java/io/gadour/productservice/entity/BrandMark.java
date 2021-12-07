package io.gadour.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "brand")
public class BrandMark extends AbstractEntity{

    @Column(name = "brandName")
    private String brandName;

    @OneToMany(mappedBy = "brand")
    private Set<Product> products;
}
