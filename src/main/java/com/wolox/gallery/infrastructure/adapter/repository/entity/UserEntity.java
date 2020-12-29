package com.wolox.gallery.infrastructure.adapter.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USER_GALLERY")
public class UserEntity {

    @Id
    @Column(name = "ID_USER")
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    private String password;

    @OneToMany(mappedBy = "user")
    private Set<AlbumEntity> albums;

    @ManyToOne()
    @JoinColumn(name = "ID_ROL")
    private RolEntity rol;

}
