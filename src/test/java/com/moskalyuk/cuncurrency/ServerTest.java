package com.moskalyuk.cuncurrency;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServerTest {

    @Mock
    Server server;

    @Test
    void processRequestShouldReturnValue() throws InterruptedException {
        when(server.process(anyInt())).thenReturn(new Response(90));

        int value = 10;
        Response expected = new Response(90);
        Response result = server.process(value);
        assertThat(result).isEqualTo(expected);
    }


}