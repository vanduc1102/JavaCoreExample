package async.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author nvduc
 */
public class SequentialAsynchronousWorker {
    public SequentialAsynchronousWorker() {
    }
    private static final int NUMBER_OF_JOBS = 5;
 
    public static void main(String args[]) {
        Date startTime = new java.util.Date();
        System.out.println("Start Work"  + startTime);
        ExecutorService es = Executors.newFixedThreadPool(3);
        List<Future> futures = new ArrayList<>();
        for(int i=0;i<NUMBER_OF_JOBS;i++) {
          System.out.println("* Start worker "+i);
          futures.add(es.submit(new Callable() {
                        @Override
                        public Object call() throws Exception {
                            new SlowWorker().doWork();
                            return null;
                        }
                    }));
        }
 
        System.out.println("... try to do something while the work is being done....");
        System.out.println("... and more ....");
        int ctr=0;
        for (Future future:futures)
        try {
            future.get();  // blocking call, explicitly waiting for the response from a specific task, not necessarily the first task that is completed
            System.out.println("** response worker "+ ++ctr +" is in");
        } catch (InterruptedException | ExecutionException e) {
            System.err.println(e);
        }
 
        Date endTime = new Date();
        System.out.println("End work at " + endTime);
        System.out.println("Job took " + 0.001*(endTime.getTime() - startTime.getTime())+ " seconds");
        System.exit(0);
    }
}