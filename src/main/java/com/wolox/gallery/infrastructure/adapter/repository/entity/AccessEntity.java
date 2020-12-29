package com.wolox.gallery.infrastructure.adapter.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ACCESS")
public class AccessEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACCESS")
    @SequenceGenerator(sequenceName = "GALL_SEQ_ACCESS", name = "SEQ_ACCESS")
    @Column(name = "ID_ACCESS")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "access")
    private Set<AlbumEntity> albums = new HashSet<>();

}
