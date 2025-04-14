package com.andersen.threading;

import com.andersen.threading.thread.MultithreadingEx;

/**
 * The {@code com.andersen.threading.Main} class demonstrates how to create and run multiple threads in Java
 * using the {@link MultithreadingEx} class which implements {@link Runnable}.
 * <p>
 * Each thread represents a separate task (e.g., data processing, image downloading, and
 * email notification), and the main method ensures all threads complete before printing
 * a final message.
 * </p>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * public static void main(String[] args) {
 *     Thread t1 = new Thread(new com.andersen.threading.thread.MultithreadingEx("Task 1"), "Worker-1");
 *     t1.start();
 * }
 * }</pre>
 */
public class Main {

    /**
     * The entry point of the program.
     * <p>
     * This method creates and starts three threads, each performing a distinct task.
     * After starting the threads, it waits for all of them to finish using {@code join()},
     * ensuring synchronous completion before printing the final message.
     * </p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Creating multiple threads using Runnable
        Thread dataProcessing = new Thread(new MultithreadingEx("Data Processing"), "Worker-1");
        Thread imageDownload = new Thread(new MultithreadingEx("Image Download"), "Worker-2");
        Thread emailNotification = new Thread(new MultithreadingEx("Email Notification"), "Worker-3");

        // Starting threads
        dataProcessing.start();
        imageDownload.start();
        emailNotification.start();

        // Joining threads to ensure main waits for them to finish
        try {
            dataProcessing.join();
            imageDownload.join();
            emailNotification.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("com.andersen.threading.Main thread interrupted while waiting for others.");
        }

        System.out.println("All tasks completed.");
    }
}
