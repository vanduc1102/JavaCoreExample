/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package async.example;

/**
 *
 * @author nvduc
 */
import java.util.concurrent.Callable;
 
public class CallingBackWorker implements Callable {
    private CallbackInterface employer;
 
    public CallingBackWorker() {
    }
 
    public Object call() {
        new SlowWorker().doWork();
        employer.returnResult("Task Completed!");
        return null;
    }
 
    public void setEmployer(CallbackInterface employer) {
        this.employer = employer;
    }
 
    public CallbackInterface getEmployer() {
        return employer;
    }
}