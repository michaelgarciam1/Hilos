package Model;
import java.util.Random;

import DTO.LabParameters;
import DTO.LabResults;

public class Producer implements Runnable {
    Product product;
    LabParameters labParameters;
    LabResults  labResults;

    public Producer(Product product, LabParameters labParameters,LabResults labResults) {
        this.product = product;
        this.labParameters = labParameters;
        this.labResults = labResults;
    }


    @Override
    public void run() {
        this.labResults.hilosProcesandoProductor++;
        if(labParameters.timeProduceRandom){
            producirRandom();
        }else{
            producirValorEspecifico();
        }
        this.labResults.hilosFinalizadosProductor++;
    }

    private void producirRandom(){
        labResults.ProducerStartTime =  System.currentTimeMillis();
        for (int i = 0; i < labParameters.itemstoproduce; i++) {
            this.labResults.producedItems++;
            this.product.produce(labParameters.protectCriticalRegions);
            try {
                Random rand = new Random();
                int sleepTime= rand.nextInt(100);
                Thread.sleep(sleepTime); // Introduce una pausa de 100 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        labResults.ProducerEndTime = System.currentTimeMillis()- labResults.ProducerStartTime;
    }

    private void producirValorEspecifico(){
        labResults.ProducerStartTime =  System.currentTimeMillis();
        for (int i = 0; i < labParameters.itemstoproduce; i++){
            this.labResults.producedItems++;
            this.product.produce(labParameters.protectCriticalRegions);
            System.out.println(labParameters.protectCriticalRegions);
            try {
                Thread.sleep(this.labParameters.sliderProducer); // Introduce una pausa de 100 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        labResults.ProducerEndTime = System.currentTimeMillis()- labResults.ProducerStartTime ;
    }
}
