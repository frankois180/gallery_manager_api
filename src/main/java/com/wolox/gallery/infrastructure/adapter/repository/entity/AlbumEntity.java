package com.wolox.gallery.infrastructure.adapter.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Column;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ALBUM")
public class AlbumEntity {

    @Id
    @Column(name = "ID_ALBUM")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private UserEntity user;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "SHARE",
            joinColumns = {
                    @JoinColumn(name = "ID_ALBUM", referencedColumnName = "ID_ALBUM",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "ID_ACCESS", referencedColumnName = "ID_ACCESS",
                            nullable = false, updatable = false)}
    )
    private Set<AccessEntity> access = new HashSet<>();

}
