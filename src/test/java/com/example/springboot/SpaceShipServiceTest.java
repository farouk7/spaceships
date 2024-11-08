package com.example.springboot;

import com.example.springboot.model.SpaceShip;
import com.example.springboot.repository.SpaceShipRepository;

import com.example.springboot.service.SpaceShipService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class SpaceShipServiceTest {

    @Mock
    private SpaceShipRepository spaceShipRepository;
    @InjectMocks
    private SpaceShipService spaceShipService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testSearchShipsWithPagination() {
        // Datos de prueba
        SpaceShip spaceShip1 = new SpaceShip( "USS Enterprise", "Star Trek", "Earth");
        SpaceShip spaceShip2 = new SpaceShip( "Enterprise-D", "Star Trek: The Next Generation", "Earth");
        // Crear Pageable para la paginación
        PageRequest pageable = PageRequest.of(0, 2);
        when(spaceShipRepository.findByNameContaining("Enterprise", pageable))
                .thenReturn(new org.springframework.data.domain.PageImpl<>(Arrays.asList(spaceShip1, spaceShip2), pageable, 2));

        Page<SpaceShip> result = spaceShipService.findByName("Enterprise", pageable);
        assertEquals(2, result.getContent().size());
        assertEquals("USS Enterprise", result.getContent().get(0).getName());
        assertEquals("Enterprise-D", result.getContent().get(1).getName());
        assertEquals(2, result.getTotalElements());
    }
}
