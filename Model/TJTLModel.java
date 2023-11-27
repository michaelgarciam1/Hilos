package Model;

import DTO.*;

public class TJTLModel {
    private Product product;
    private LabParameters parameters;
    private LabResults results;

    public TJTLModel(LabParameters parameters, LabResults results) {
        product = new Product("Producto");
        this.parameters = parameters;
        this.results = results;
    }
 
    public void play() {
        int consumidores = parameters.consumidores;
        int productores = parameters.productores;


        Thread[] customersThreads = new Thread[consumidores];
        Thread[] producersThreads = new Thread[productores];


        for (int i = 0; i < customersThreads.length; i++) {
            long tiempohilo = System.currentTimeMillis();
            customersThreads[i] = new Thread(new Consumer(product, parameters, results));
            tiempohilo = System.currentTimeMillis() - tiempohilo;
            this.results.threadTime = tiempohilo + this.results.threadTime;
            // this.counter.setThreadTime(tiempohilo+counter.getThreadTime());

            long tiempoStart = System.currentTimeMillis();
            customersThreads[i].start();
            
            tiempoStart = System.currentTimeMillis() - tiempoStart;
            this.results.timeStart = tiempoStart + this.results.timeStart;
        }

        for (int i = 0; i < producersThreads.length; i++) {
            long tiempohilo = System.currentTimeMillis();
            producersThreads[i] = new Thread(new Producer(product, parameters, results));
            tiempohilo = System.currentTimeMillis() - tiempohilo;
            this.results.threadTime = tiempohilo + this.results.threadTime;

            long duracionStart = System.currentTimeMillis();
            producersThreads[i].start();
            duracionStart = System.currentTimeMillis() - duracionStart;
            this.results.timeStart = duracionStart + this.results.timeStart;
        }

        // System.out.println(counter.getTimeStart());
        this.results.avgThread = this.results.threadTime / (float) (consumidores + productores);
        this.results.avgStart = this.results.timeStart / (float) (consumidores + productores);
    }

    // try {
    // for( Thread hilo:customersThreads){
    // hilo.join();
    // }
    // } catch (Exception e) {}
    //
    // try {
    // for( Thread hilo:producersThreads){
    // hilo.join();
    // }
    // } catch (Exception e) {}

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LabParameters getParameters() {
        return this.parameters;
    }
    

    public void setParameters(LabParameters parameters) {
        this.parameters = parameters;
    }

    public LabResults getResults() {
        return this.results;
    }

    public void setResults(LabResults results) {
        this.results = results;
    }



}
