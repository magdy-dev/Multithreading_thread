package com.andersen.threading.thread;

/**
 * A simple implementation of the Runnable interface that demonstrates
 * how to create and run tasks in separate threads using Java multithreading.
 * <p>
 * Each instance of this class represents a named task that logs its execution
 * steps to the console.
 * </p>
 *
 * Example usage:
 * <pre>{@code
 * Thread thread = new Thread(new com.andersen.threading.thread.MultithreadingEx("Example Task"));
 * thread.start();
 * }</pre>
 */
public class MultithreadingEx implements Runnable {

    /**
     * The name of the task to be executed by the thread.
     */
    private String taskName;

    /**
     * Sets the name of the task.
     * <p><b>Note:</b> This method is named like a constructor but it's a setter.
     * Consider renaming to {@code setTaskName(String)} for clarity.</p>
     *
     * @param taskName the name of the task
     */
    public void TaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * Constructs a new {@code com.andersen.threading.thread.MultithreadingEx} instance with a specific task name.
     *
     * @param taskName the name of the task to be run in a thread
     */
    public MultithreadingEx(String taskName) {
        this.taskName = taskName;
    }

    /**
     * The logic that will be executed when the thread is started.
     * It prints the start and end of the task and simulates work using {@code Thread.sleep}.
     */
    @Override
    public void run() {
        System.out.println("[" + Thread.currentThread().getName() + "] Starting task: " + taskName);
        try {
            // Simulate some work
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("[" + Thread.currentThread().getName() + "] Task interrupted.");
        }
        System.out.println("[" + Thread.currentThread().getName() + "] Finished task: " + taskName);
    }
}
