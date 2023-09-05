package com.example.playerTracker;

import com.example.playerTracker.controller.PlayerController;
import com.example.playerTracker.model.Player;
import com.example.playerTracker.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PlayerController.class)
class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;

    @Test
    void testGetAllPlayers() throws Exception {
        when(playerService.getAllPlayers()).thenReturn(Arrays.asList(new Player("Bryn", 27, "ST", 80, 90, 70, 85, 81.25, "Hares")));

        mockMvc.perform(get("/api/players"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }

}

