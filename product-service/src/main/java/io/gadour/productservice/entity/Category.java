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
@Table(name = "category")
public class Category extends AbstractEntity{

    @Column(name = "categoryName")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;
}
