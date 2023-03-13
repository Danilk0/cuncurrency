package com.moskalyuk.cuncurrency;

import lombok.RequiredArgsConstructor;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Server {
    private final Lock lock = new ReentrantLock();

    public Response process(Integer reqValue) throws InterruptedException {
        lock.lock();
        Thread.sleep(new Random().nextInt(2000));
        lock.unlock();
        return new Response(100 - reqValue);
    }
}
