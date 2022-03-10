package com.ovi.multithread.scheduler;

import com.ovi.multithread.thread.Task;
import com.ovi.multithread.thread.ThreadService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Component
public class Scheduler {

    @Scheduled(initialDelay = 1000 * 2, fixedDelay = Long.MAX_VALUE)
    public void task() {

        int totalTask = 100;
        AtomicInteger totalSleepTime = new AtomicInteger(0);
        AtomicInteger counter = new AtomicInteger(0);
        LocalDateTime startTime = LocalDateTime.now();

        IntStream.range(0, totalTask).forEach(i -> {
            String taskName = "TASK_" + i;
            int sleepTime = new Random().nextInt(20);
            totalSleepTime.addAndGet(sleepTime);
            System.out.println("Task name: " + taskName + ", sleep time: " + sleepTime);

            ThreadService.addTask(new Task(taskName, sleepTime))
                    .thenAccept(response -> {
                        if (response.isSuccessful()) {
                            System.out.println("Done: " + taskName + "/" + response.getTaskName());
                        } else {
                            System.out.println("Failed: " + taskName + "/" + response.getTaskName());
                        }
                        counter.set(counter.get() + 1);

                        if (counter.get() == totalTask) {
                            LocalDateTime endTime = LocalDateTime.now();
                            System.out.println("Total sleep time: " + totalSleepTime.get());
                            System.out.println("Total task:" + totalTask);
                            System.out.println("Total time elapsed: " + ChronoUnit.SECONDS
                                    .between(startTime, endTime));
                        }
                    });
        });
    }

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(6);

        System.out.println(atomicInteger.addAndGet(9));
        System.out.println(atomicInteger.get());
    }
}
