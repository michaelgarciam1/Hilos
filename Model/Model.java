package Model;
public class Model {
    Counter counter;

    public  Model (){
        counter = new Counter();
    }

    public  void play(int productores, int sliderProductor, boolean produceRandom, int consumidores,
    int sliderConsumidor,
    boolean consumeRandom){
        Thread []  customersThreads = new Thread[consumidores];
        Thread []  producersThreads = new Thread[productores];

        for (int i = 0; i < customersThreads.length; i++) {
            long tiempohilo=System.currentTimeMillis();
            customersThreads[i] = new Thread(new Customer(counter,consumeRandom,sliderConsumidor));
            tiempohilo=System.currentTimeMillis()-tiempohilo;
            this.counter.setThreadTime(tiempohilo+counter.getThreadTime());

            long tiempoStart=System.currentTimeMillis();
            customersThreads[i].start();
            tiempoStart=System.currentTimeMillis()-tiempoStart;
            this.counter.setTimeStart(counter.getTimeStart()+tiempoStart);
        }

        for (int i = 0; i < producersThreads.length; i++) {
            long tiempohilo=System.currentTimeMillis();
            producersThreads[i] = new Thread(new Producer(counter,produceRandom,sliderProductor));
            tiempohilo=System.currentTimeMillis()-tiempohilo;
            this.counter.setThreadTime(tiempohilo+counter.getThreadTime());


            long duracionStart=System.currentTimeMillis();
            producersThreads[i].start();
            duracionStart=System.currentTimeMillis()-duracionStart;
            this.counter.setTimeStart(duracionStart+this.counter.getTimeStart());
        }
        System.out.println(counter.getTimeStart());
        this.counter.setAvgThread(this.counter.getThreadTime()/(float)(consumidores+productores));
        this.counter.setAvgStart(this.counter.getTimeStart()/(float)(consumidores+productores));
//        try {
//            for( Thread hilo:customersThreads){
//                hilo.join();
//            }
//        } catch (Exception e) {}
//
//        try {
//            for( Thread hilo:producersThreads){
//                hilo.join();
//            }
//        } catch (Exception e) {}
    }

    public Counter getCounter() {
        return counter;
    }

}
