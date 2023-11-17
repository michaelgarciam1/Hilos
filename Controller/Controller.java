
package Controller;
import Model.Model;
import View.View;

public class Controller {

    public Model model;
    View view;

    public Controller() {
        this.model = new Model();
        this.view = new View(this);
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

    public View getView() {
        return view;
    }

    public static void main(String[] args) {
        Controller controller = new Controller();

        Thread thread = new Thread(controller.getView());
        thread.start();

    }
}
