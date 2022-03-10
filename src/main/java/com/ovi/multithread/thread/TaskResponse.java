package com.ovi.multithread.thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponse {

    private boolean isSuccessful;

    private String taskName;

    public String message;
}
