package async.example;

/**
 *
 * @author nvduc
 */
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
public class ParallelWorker {
    public ParallelWorker() {
    }
 
    private static final int NUMBER_OF_JOBS = 5;
    public static int workerId;
    
    public static void main(String args) {
        Date startTime = new java.util.Date();
        System.out.println("Start Work"  + startTime);
        ExecutorService es = Executors.newFixedThreadPool(3);
        CompletionService<Object> cs = new ExecutorCompletionService<>(es);
        for (int i=0;i<NUMBER_OF_JOBS;i++) {
            workerId = i;
            cs.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    new SlowWorker( ParallelWorker.workerId).doWork();
                    return null;
                }});
          }
        System.out.println("... try to do something while the work is being done....");
        System.out.println("... and more ....");
 
        for (int i = 0; i < NUMBER_OF_JOBS; i++) {
          Object x;
            try {
                x = cs.take().get(); // find the first completed task
                System.out.println("Task finished "+ x.toString());
            } catch (InterruptedException | ExecutionException e) {
                System.err.println(e);
            }
        }
 
        Date endTime = new java.util.Date();
        System.out.println("End work at " + endTime);
        System.out.println("Job took " + 0.001*(endTime.getTime() - startTime.getTime())+ " seconds");
        System.exit(0);
    }
 
}
