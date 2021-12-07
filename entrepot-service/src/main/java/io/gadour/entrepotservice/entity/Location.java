package io.gadour.entrepotservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "location")
public class Location extends AbstractEntity{

    @Column(name = "locationName")
    private String locationName;

    @OneToMany(mappedBy = "location")
    private Set<Entrepot> entrepots;

}
