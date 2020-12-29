package com.wolox.gallery.infrastructure.adapter.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ROL")
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ROL")
    @SequenceGenerator(sequenceName = "GALL_SEQ_ROL", name = "SEQ_ROL")
    @Column(name = "ID_ROL")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "rol")
    private Set<UserEntity> users;

}
