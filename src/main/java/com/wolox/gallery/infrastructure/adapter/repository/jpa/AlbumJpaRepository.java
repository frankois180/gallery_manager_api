package com.wolox.gallery.infrastructure.adapter.repository.jpa;

import com.wolox.gallery.infrastructure.adapter.repository.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumJpaRepository extends JpaRepository<AlbumEntity, Long> {

    @Query("select ab from AlbumEntity ab where ab.user.id = :userId")
    List<AlbumEntity> findByUserId(@Param("userId") Long userId);

}