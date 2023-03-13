package com.moskalyuk.cuncurrency;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientTest {

    @Mock
    Server server;

    Client client;
    @BeforeEach
    void setup() {
        client = new Client( List.of(new Request(90), new Request(80),new Request(70),new Request(60)));
    }

    @Test
    void sendRequestsShouldCorrect() throws InterruptedException {
        when(server.process(anyInt())).thenReturn(new Response(1));

        client.send(server);

        verify(server,times(4)).process(anyInt());
    }

}