package com.wolox.gallery.infrastructure.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.wolox.gallery.application.dto.admin.AlbumAccessDto;
import com.wolox.gallery.application.service.AdminAppService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AdminControllerTest {

    private static final PodamFactory FACTORY = new PodamFactoryImpl();

    private AdminAppService adminAppService;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Before
    public void setUp() {

        objectMapper = new ObjectMapper();
        adminAppService = mock(AdminAppService.class);
        AdminController adminController = new AdminController(adminAppService);
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();

    }
    @Test
    public void enablePermissionForUser() throws Exception {

        // Arrange
        AlbumAccessDto request = FACTORY.manufacturePojo(AlbumAccessDto.class);

        when(adminAppService.enableAccessForUser(any())).thenReturn(true);

        // Act - Assert
        mockMvc.perform(post("/v1/admin/album-access")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(request)))
                .andDo(print()).andExpect(status().isCreated());

    }
}
