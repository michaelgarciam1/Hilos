
package Controller;
import DTO.*;
import Model.TJTLModel;
import View.ResultsViewer;
import View.TJTLView;
// import View.OldView;

public class TJTLController {

    public TJTLModel model;
    // View view;
    TJTLView view;
    LabParameters labParameters;
    LabResults labResults;

    public TJTLController() {

        this.labParameters = new LabParameters();
        this.labResults = new LabResults();
        this.model = new TJTLModel(labParameters, labResults);
        this.view= new TJTLView(this.labParameters,this.labResults,this);
    }

    public void play() {
        this.model.play();
    }

    public TJTLView getView() {
        return view;
    }

    public static void main(String[] args) {
        TJTLController controller = new TJTLController();
        Thread thread = new Thread(controller.getView());
        thread.start();
    }

    public TJTLModel getmodel() {
        return this.model;
    }
}
