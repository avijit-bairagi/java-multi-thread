package com.ovi.multithread.thread;

import java.util.function.Supplier;

public class Task implements Supplier<TaskResponse> {

    private final String taskName;

    private final int sleep;

    public Task(String taskName, int sleep) {
        this.taskName = taskName;
        this.sleep = sleep;
    }

    @Override
    public TaskResponse get() {

        try {
            Thread.sleep(1000L * sleep);
            return new TaskResponse(true, taskName, "");
        } catch (InterruptedException e) {
            e.printStackTrace();
            return new TaskResponse(false, taskName, e.getMessage());
        }

    }
}