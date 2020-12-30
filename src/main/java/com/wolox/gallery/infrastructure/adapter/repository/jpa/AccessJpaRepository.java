package com.wolox.gallery.infrastructure.adapter.repository.jpa;

import com.wolox.gallery.infrastructure.adapter.repository.entity.AccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessJpaRepository extends JpaRepository<AccessEntity, Long> {

    AccessEntity findByName(String name);

}