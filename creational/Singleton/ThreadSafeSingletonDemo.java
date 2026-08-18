/**
 * Case Study 2: Thread-Safe Double-Checked Locking Singleton
 * Reference: Slides 36-37, 39-42 in slide.md
 * 
 * Demonstrates thread-safe lazy initialization using volatile keyword and double-checked locking.
 */

class ThreadSafeSingleton {
    // Volatile reference guarantees visibility of changes across threads
    private static volatile ThreadSafeSingleton instance = null;
    private String data;

    // Private constructor
    private ThreadSafeSingleton() {
        // Heavy initialization simulation
        this.data = "Initialized at System Timestamp: " + System.currentTimeMillis();
        System.out.println("-> Constructor called by Thread: " + Thread.currentThread().getName());
    }

    // Public static creation method with double-checked locking
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) { // Second check (with locking)
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    public void logMessage(String msg) {
        System.out.println("[" + Thread.currentThread().getName() + "] Singleton Log: " + msg + " (Data: " + data + ")");
    }
}

// Client Demo Class with Multi-Threaded Validation
public class ThreadSafeSingletonDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Thread-Safe Double-Checked Singleton Demo ===");

        int threadCount = 5;
        Thread[] threads = new Thread[threadCount];

        System.out.println("\nSpawning " + threadCount + " concurrent threads accessing Singleton instance simultaneously...\n");

        for (int i = 0; i < threadCount; i++) {
            final int threadId = i + 1;
            threads[i] = new Thread(() -> {
                ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
                singleton.logMessage("Task " + threadId + " completed execution.");
            }, "Thread-" + threadId);
        }

        // Start all threads concurrently
        for (Thread t : threads) {
            t.start();
        }

        // Wait for all threads to finish
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("\nMulti-Threaded Verification Completed Successfully.");
    }
}
