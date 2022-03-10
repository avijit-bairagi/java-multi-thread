package com.ovi.multithread.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class ThreadService {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(20);

    public static CompletableFuture<TaskResponse> addTask(Supplier<TaskResponse> task) {
        return CompletableFuture.supplyAsync(task, executorService);
    }
}
