package async.example;

/**
 *
 * @author nvduc
 */
import java.util.Date;
 
public class SequentialWorker {
    public SequentialWorker() {
    }
    private static int NUMBER_OF_JOBS = 5;
 
    public static void main(String[] args) {
        Date startTime = new java.util.Date();
        System.out.println("Start Work"  + startTime);
        for(int i=0;i <NUMBER_OF_JOBS;i++) {
          System.out.println("* Start worker "+i);
          SlowWorker worker = new SlowWorker(i);
          worker.doWork();
        }
        System.out.println("... try to do something while the work is being done....");
 
        Date endTime = new java.util.Date();
        System.out.println("End work at " + endTime);
        System.out.println("Job took " + 0.001*(endTime.getTime() - startTime.getTime())+ " seconds");
        System.exit(0);
    }
}