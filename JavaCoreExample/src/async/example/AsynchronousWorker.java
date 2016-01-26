package async.example;
 
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
 
public class AsynchronousWorker {
    public AsynchronousWorker() {
    }
 
    public static void main(String[] args) {
        System.out.println("Start Work"  + new java.util.Date());
        ExecutorService es = Executors.newFixedThreadPool(3);
        final Future future = es.submit(new Callable() {
                    @Override
                    public Object call() throws Exception {
                        new SlowWorker().doWork();
                        return null;
                    }
                });
 
        System.out.println("... try to do something while the work is being done....");
        System.out.println("... and more ....");
        try {
            future.get(); // blocking call - the main thread blocks until task is done
        } catch (InterruptedException | ExecutionException e) {
            System.err.println(e);
        }
        System.out.println("End work" + new java.util.Date());
        System.exit(0);
    }
}