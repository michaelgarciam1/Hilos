package View;
import javax.swing.*;
import Controller.TJTLController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View extends JFrame implements ActionListener, Runnable {
    TJTLController controller;
    JButton startButton;

    JTextField counter;

    JTextField ProducerStartTime;

    JTextField CustomerStartTime;

    JTextField ProducerEndTime;

    JTextField CustomerEndTime;

    JTextField productors;

    JTextField consumidors;

    

    JCheckBox timeConsumeRandom;
    JCheckBox timeProduceRandom;

    JSlider sliderProducer;
    JSlider sliderConsumer;

    JTextField sumaCreacionHilos;
    JTextField mediaCreacionHilos;

    JTextField sumaStart;
    JTextField mediaStart;


    public View(TJTLController controller) {
        this.controller = controller;

        this.startButton = new JButton("Play");
        this.startButton.addActionListener(this);

        this.counter = new JTextField("0");
        this.ProducerStartTime = new JTextField("0");
        this.CustomerStartTime = new JTextField("0");
        this.ProducerEndTime = new JTextField("0");
        this.CustomerEndTime = new JTextField("0");
        this.consumidors = new JTextField("0");
        this.productors = new JTextField("0");
        this.timeConsumeRandom = new JCheckBox();
        this.timeProduceRandom = new JCheckBox();
        this.sliderConsumer = new JSlider(0, 1000, 0);
        this.sliderProducer = new JSlider(0, 1000, 0);
        this.sumaCreacionHilos=new JTextField("0");
        this.mediaCreacionHilos= new JTextField("0");
        this.sumaStart=new JTextField("0");
        this.mediaStart=new JTextField("0");

        this.configureJFrame();

        this.setVisible(true);
    }

    private void addComponentsToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        JLabel lCounter = new JLabel("Valor del contador: ");
        JLabel lProducerStarTime = new JLabel("Producer start time : ");
        JLabel lProducerEndTime = new JLabel("Producer end time : ");
        JLabel lCustomerStarTime = new JLabel("Customer start time : ");
        JLabel lCustomerEndTime = new JLabel("Customer end time : ");
        JLabel lProductor = new JLabel("Productors number");
        JLabel lConsumidor = new JLabel("Consumidor number");
        JLabel lTimeConsumeRandom = new JLabel("Tiempo consumidor aleatorio");
        JLabel lTimeProduceRandom = new JLabel("Tiempo productor aleatorio");
        JLabel lsumacreacionHilos= new JLabel("Tiempo total creacion de hilos");
        JLabel lmediaCreacionHilos=new JLabel("Media creacion de hilos");
        JLabel lSumaStart=new JLabel("Tiempo total del start");
        JLabel lmediaStart=new JLabel("Media del tiempo del start");
        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 1;

        panel.add(this.startButton, c);

        c.gridx++;
        panel.add(lCounter, c);
        c.gridx++;
        panel.add(this.counter, c);
        c.gridx = 1;
        c.gridy++;
        panel.add(lProducerStarTime, c);
        c.gridx++;
        panel.add(ProducerStartTime, c);
        c.gridx = 1;
        c.gridy++;
        panel.add(lCustomerStarTime, c);
        c.gridx++;
        panel.add(CustomerStartTime, c);
        c.gridx = 1;
        c.gridy++;
        panel.add(lProducerEndTime, c);
        c.gridx++;
        panel.add(ProducerEndTime, c);
        c.gridx = 1;
        c.gridy++;
        panel.add(lCustomerEndTime, c);
        c.gridx++;
        panel.add(CustomerEndTime, c);

        c.gridx = 1;
        c.gridy++;
        panel.add(lConsumidor, c);
        c.gridx++;
        panel.add(consumidors, c);

        c.gridx = 1;
        c.gridy++;
        panel.add(lProductor, c);
        c.gridx++;
        panel.add(productors, c);

        c.gridx = 1;
        c.gridy++;
        panel.add(lTimeConsumeRandom, c);
        c.gridx++;
        panel.add(timeConsumeRandom, c);
        c.gridx++;
        panel.add(sliderConsumer, c);

        c.gridx = 1;
        c.gridy++;
        panel.add(lTimeProduceRandom, c);
        c.gridx++;
        panel.add(timeProduceRandom, c);
        c.gridx++;
        panel.add(sliderProducer, c);


        c.gridx = 1;
        c.gridy++;
        panel.add(lsumacreacionHilos, c);
        c.gridx++;
        panel.add(sumaCreacionHilos, c);

        c.gridx = 1;
        c.gridy++;
        panel.add(lmediaCreacionHilos, c);
        c.gridx++;
        panel.add(mediaCreacionHilos, c);

        c.gridx=1;
        c.gridy++;
        panel.add(lSumaStart, c);
        c.gridx++;
        panel.add(sumaStart,c);

        c.gridx=1;
        c.gridy++;
        panel.add(lmediaStart, c);
        c.gridx++;
        panel.add(mediaStart,c);
    

    }

    private void configureJFrame() {
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.addComponentsToPane(this.getContentPane());
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                this.getTextField().setText(String.valueOf(controller.model.getCounter().getCount()));
                this.getProducerStartTime()
                        .setText(String.valueOf(controller.model.getCounter().getProducerStartTime()));
                this.getCustomerStartTime()
                        .setText(String.valueOf(controller.model.getCounter().getCustomerStartTime()));
                this.getProducerEndTime().setText(String.valueOf(controller.model.getCounter().getProducerEndTime()));
                this.getCustomerEndTime().setText(String.valueOf(controller.model.getCounter().getCustomerEndTime()));
                this.getSumaCreacionHilos().setText(String.valueOf(controller.model.getCounter().getThreadTime()));
                this.getMediaCreacionHilos().setText(String.valueOf(controller.model.getCounter().getAvgThread()));
                this.getSumaStart().setText(String.valueOf(controller.model.getCounter().getTimeStart()));
                this.getMediaStart().setText(String.valueOf(controller.model.getCounter().getAvgStart()));
                // System.out.println(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Play":
                this.getTextField().setText("0");
                this.getProducerStartTime().setText("0");
                this.getProducerEndTime().setText("0");
                this.getCustomerStartTime().setText("0");
                this.getCustomerEndTime().setText("0");
                int productores = Integer.parseInt(productors.getText());
                int consumidores = Integer.parseInt(consumidors.getText());
                int sliderConsumidor = sliderConsumer.getValue();
                int sliderProductor = sliderProducer.getValue();
                System.out.println("sliderConsumidor"+ sliderConsumidor);
                System.out.println("sliderProductor"+ sliderProductor);
                boolean consumeRandom = timeConsumeRandom.isSelected();
                boolean produceRandom = timeProduceRandom.isSelected();
                controller.play(productores, sliderProductor, produceRandom, consumidores, sliderConsumidor,
                        consumeRandom);

                break;
            default:
                System.err.println("Acción NO tratada: " + e);
        }
    }

    public JTextField getTextField() {
        return counter;
    }

    public JTextField getProducerStartTime() {
        return ProducerStartTime;
    }

    public JTextField getCustomerStartTime() {
        return CustomerStartTime;
    }

    public JTextField getProducerEndTime() {
        return ProducerEndTime;
    }

    public JTextField getCustomerEndTime() {
        return CustomerEndTime;
    }

    public JButton getStartButton() {
        return this.startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    public JTextField getCounter() {
        return this.counter;
    }

    public void setCounter(JTextField counter) {
        this.counter = counter;
    }
    public void setProducerStartTime(JTextField ProducerStartTime) {
        this.ProducerStartTime = ProducerStartTime;
    }
    public void setCustomerStartTime(JTextField CustomerStartTime) {
        this.CustomerStartTime = CustomerStartTime;
    }
    public void setProducerEndTime(JTextField ProducerEndTime) {
        this.ProducerEndTime = ProducerEndTime;
    }
    public void setCustomerEndTime(JTextField CustomerEndTime) {
        this.CustomerEndTime = CustomerEndTime;
    }

    public JTextField getProductors() {
        return this.productors;
    }

    public void setProductors(JTextField productors) {
        this.productors = productors;
    }

    public JTextField getConsumidors() {
        return this.consumidors;
    }

    public void setConsumidors(JTextField consumidors) {
        this.consumidors = consumidors;
    }

    public TJTLController getController() {
        return this.controller;
    }

    public void setController(TJTLController controller) {
        this.controller = controller;
    }

    public JCheckBox getTimeConsumeRandom() {
        return this.timeConsumeRandom;
    }

    public void setTimeConsumeRandom(JCheckBox timeConsumeRandom) {
        this.timeConsumeRandom = timeConsumeRandom;
    }

    public JCheckBox getTimeProduceRandom() {
        return this.timeProduceRandom;
    }

    public void setTimeProduceRandom(JCheckBox timeProduceRandom) {
        this.timeProduceRandom = timeProduceRandom;
    }

    public JSlider getSliderProducer() {
        return this.sliderProducer;
    }

    public void setSliderProducer(JSlider sliderProducer) {
        this.sliderProducer = sliderProducer;
    }

    public JSlider getSliderConsumer() {
        return this.sliderConsumer;
    }

    public void setSliderConsumer(JSlider sliderConsumer) {
        this.sliderConsumer = sliderConsumer;
    }

    public JTextField getSumaCreacionHilos() {
        return this.sumaCreacionHilos;
    }

    public void setSumaCreacionHilos(JTextField sumaCreacionHilos) {
        this.sumaCreacionHilos = sumaCreacionHilos;
    }

    public JTextField getMediaCreacionHilos() {
        return this.mediaCreacionHilos;
    }

    public void setMediaCreacionHilos(JTextField mediaCreacionHilos) {
        this.mediaCreacionHilos = mediaCreacionHilos;
    }

    public JTextField getSumaStart() {
        return this.sumaStart;
    }

    public void setSumaStart(JTextField sumaStart) {
        this.sumaStart = sumaStart;
    }

    public JTextField getMediaStart() {
        return this.mediaStart;
    }

    public void setMediaStart(JTextField mediaStart) {
        this.mediaStart = mediaStart;
    }

}