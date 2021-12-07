package io.gadour.entrepotservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "entrepot")
public class Entrepot extends AbstractEntity{

    @Column(name = "entrepotName")
    private String entrepotName;

    @Column(name = "capacity")
    private Long capacity;

    @ManyToOne
    private Location location;

}
