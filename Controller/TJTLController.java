
package Controller;
import DTO.*;
import Model.TJTLModel;
import View.TJTLView;
import View.View;

public class TJTLController {

    public TJTLModel model;
    // View view;
    TJTLView view;
    LabParameters labParameters;
    LabResults labResults;

    public TJTLController() {
        this.model = new TJTLModel();
        // this.view = new View(this);
        this.view= new TJTLView(this.labParameters,this.labResults,this);
    }

    public void play(int productores, int sliderProductor, boolean produceRandom, int consumidores,
            int sliderConsumidor,
            boolean consumeRandom) {

        this.model.counter.setCount(0);
        this.model.counter.setProducerStartTime(0);
        this.model.counter.setProducerEndTime(0);
        this.model.counter.setCustomerStartTime(0);
        this.model.counter.setCustomerEndTime(0);
        this.model.counter.setAvgThread(0);
        this.model.counter.setThreadTime(0);
        this.model.counter.setTimeStart(0);
        this.model.counter.setAvgStart(0);

        this.model.play(productores, sliderProductor, produceRandom, consumidores, sliderConsumidor,
        consumeRandom);
    }

    public TJTLView getView() {
        return view;
    }

    public static void main(String[] args) {
        TJTLController controller = new TJTLController();

        Thread thread = new Thread(controller.getView());
        thread.start();

    }
}
