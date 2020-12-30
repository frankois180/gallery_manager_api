package com.wolox.gallery.domain.service;

import com.wolox.gallery.domain.model.album.Access;
import com.wolox.gallery.domain.model.album.AccessType;
import com.wolox.gallery.domain.model.album.Album;
import com.wolox.gallery.domain.model.user.User;
import com.wolox.gallery.domain.port.external.AlbumExternalPort;
import com.wolox.gallery.domain.port.repository.AlbumRepositoryPort;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AlbumServiceTest {
    @Mock
    private AlbumExternalPort albumExternalPort;
    @Mock
    private AlbumRepositoryPort albumRepositoryPort;
    @InjectMocks
    private AlbumService albumService;

    private List<Album> albums;

    private static final int albumId = 1;

    @Before
    public void init() {
        albums = singletonList(Album.builder().id(albumId).title("title")
                .access(singletonList(Access.builder().id(1l).type(AccessType.READ).build()))
                .user(User.builder().name("francisco").build()).build());
    }


    @Test
    public void findAllPhotos() {

        //Arrange
        when(albumExternalPort.findAllAlbums())
                .thenReturn(albums);
        //Act
        List<Album> albums = albumService.findAllAlbums();

        //Assert
        assertThat(albums).isNotEmpty();


    }

    @Test
    public void findAllAlbumsByUserId() {
        //Arrange
        when(albumRepositoryPort.findByUserId(1)).thenReturn(albums);
        when(albumExternalPort.findAllAlbumsByUserId(1)).thenReturn(albums);

        //Act
        List<Album> albums = albumService.findAllAlbumsByUserId(albumId);

        //Assert
        assertThat(albums).isNotEmpty();


    }

}
