package com.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Sudheer.
 *
 *This class is used thread pool executor
 */
public class TestCallble {
    private static BlockingQueue<Runnable> queue;
    private static ThreadPoolExecutor threadPoolExecutor;
    private static int j=3;
    public static void main(String[] args) throws Exception {
            getTokens();
    }

    public static void getTokens()throws ExecutionException, InterruptedException {
        queue = new ArrayBlockingQueue<Runnable>(4);
        threadPoolExecutor = new ThreadPoolExecutor(8, 8, 10, TimeUnit.SECONDS, queue,
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());//abort policy which will throw a rejected execution exception if queue is full

        List<Future> futures = new ArrayList<Future>();
        for (int i = 0; i <= 100; i++) {
            ExCallable exCallable = new ExCallable(i);

            Future<Object> future = threadPoolExecutor.submit(exCallable);
            futures.add(future);
        }
        for (Future future : futures) {
            future.get();
        }
    }
}
