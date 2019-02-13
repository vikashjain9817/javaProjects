import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Question8B extends TimerTask {

    @Override
    public void run() {
        System.out.println("Timer task started at:"+new Date());
        completeTask();
    }

    private void completeTask() {
        try {
        
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        TimerTask timerTask = new Question8B();
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 10*1000);
        System.out.println("TimerTask started");
        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        
        System.out.println("TimerTask cancelled");
    }
}