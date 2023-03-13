package com.moskalyuk.cuncurrency;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


@RequiredArgsConstructor
@Data
public class Client {

    private final List<Request> requests;

    private final List<Response> responses = new ArrayList<>();

    public void send(Server server) {
        ExecutorService service = Executors.newFixedThreadPool(requests.size());
        List<Future<Response>> futures = new ArrayList<>();
        requests.forEach(request -> futures.add(service.submit(() -> server.process(request.getValue()))));
        futures.forEach(this::addResponse);
        service.shutdown();
    }

    private void addResponse(Future<Response> response) {
        try {
            responses.add(response.get(20000,TimeUnit.MILLISECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

}
