package Model;
import java.util.Random;

public class Producer implements Runnable {
    Counter counter;
    Long startTime;
    Long endTime;
    boolean random;
    int sleepTime;

    public Producer(Counter counter,boolean random,int sleepTime) {
        this.setCounter(counter);
        this.random=random;
        this.sleepTime=sleepTime;
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        if(random){
            producirRandom();
        }else{
            producirValorEspecifico();
        }

    }

    private void producirRandom(){
        this.startTime =  System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            this.counter.increment();
            try {
                Random rand = new Random();
                int sleepTime= rand.nextInt(100);
                Thread.sleep(sleepTime); // Introduce una pausa de 100 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.endTime = System.currentTimeMillis()- startTime;
        this.counter.updateProducersTimes(endTime,startTime);
    }

    private void producirValorEspecifico(){
        this.startTime =  System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            this.counter.increment();
            try {
                Thread.sleep(this.sleepTime); // Introduce una pausa de 100 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.endTime = System.currentTimeMillis()- startTime;
        this.counter.updateProducersTimes(endTime,startTime);
    }
}