package com.moskalyuk;

import com.moskalyuk.cuncurrency.Client;
import com.moskalyuk.cuncurrency.Request;
import com.moskalyuk.cuncurrency.Server;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        List<Client> clients = List.of(
                new Client(List.of(new Request(new Random().nextInt(100)), new Request(new Random().nextInt(100)), new Request(new Random().nextInt(100)), new Request(new Random().nextInt(100)))),
                new Client(List.of(new Request(new Random().nextInt(100)), new Request(new Random().nextInt(100)), new Request(new Random().nextInt(100)), new Request(new Random().nextInt(100)))),
                new Client(List.of(new Request(new Random().nextInt(100)), new Request(new Random().nextInt(100)), new Request(new Random().nextInt(100)), new Request(new Random().nextInt(100)))),
                new Client(List.of(new Request(new Random().nextInt(100)), new Request(new Random().nextInt(100)), new Request(new Random().nextInt(100)), new Request(new Random().nextInt(100)))),
                new Client(List.of(new Request(new Random().nextInt(100)), new Request(new Random().nextInt(100)), new Request(new Random().nextInt(100)), new Request(new Random().nextInt(100))))
        );
        clients.forEach(client -> client.send(server));

        clients.stream().flatMap(client -> client.getResponses().stream())
                .forEach(response -> System.out.println("Value: " + response.getValue()));
    }

}