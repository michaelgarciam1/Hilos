package Model;

import java.util.Random;

import DTO.LabParameters;
import DTO.LabResults;

public class Consumer implements Runnable {
    Product product;
    LabResults labResults;
    LabParameters labParameters;

    public Consumer(Product product, LabParameters labParameters, LabResults labResults) {
        this.product = product;
        this.labParameters = labParameters;
        this.labResults = labResults;
    }

    @Override
    public void run() {
        this.labResults.hilosProcesandoConsumidor++;
        if (labParameters.timeConsumeRandom) {
            consumirRandom();
        } else {
            consumirValorEspecifico();
        }
        this.labResults.hilosFinalizadosConsumidor++;
    }

    private void consumirRandom() {
        labResults.CustomerStartTime = System.currentTimeMillis();
        for (int i = 0; i < labParameters.itemstoconsume; i++) {
            this.labResults.consumedItems++;
            this.product.consume(labParameters.protectCriticalRegions);
            try {
                Random rand = new Random();
                int sleepTime = rand.nextInt(100);
                Thread.sleep(sleepTime); // Introduce una pausa de 100 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        labResults.CustomerEndTime = System.currentTimeMillis() - labResults.CustomerStartTime;
        // this.counter.updateCustomersTimes(endTime, startTime);
    }

    private void consumirValorEspecifico() {
        labResults.CustomerStartTime = System.currentTimeMillis();
        for (int i = 0; i < labParameters.itemstoconsume; i++) {
            this.labResults.consumedItems++;
            this.product.consume(labParameters.protectCriticalRegions);
            try {
                Thread.sleep(labParameters.sliderConsumer); // Introduce una pausa de 100 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        labResults.CustomerEndTime = System.currentTimeMillis() - labResults.CustomerStartTime;
        // this.counter.updateCustomersTimes(endTime, startTime);
    }
}
