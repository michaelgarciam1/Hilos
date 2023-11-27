package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Controller.TJTLController;
import DTO.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.http.WebSocket.Listener;

public class TJTLView extends JFrame implements ActionListener, ChangeListener, Listener, Runnable {

    ControlPanel controlPanel;
    GeneralConfiguration generalConfiguration;
    ResultsViewer resultsViewer;
    LabParameters labParameters;
    LabResults labResults;
    TJTLController controller;
    JToggleButton playPause;
    public TJTLView(LabParameters labParameters, LabResults labResults, TJTLController controller) {
        this.controller = controller;
        this.labResults = labResults;
        this.labParameters = labParameters;
        this.controlPanel = new ControlPanel();
        this.resultsViewer = new ResultsViewer(labResults);
        this.generalConfiguration = new GeneralConfiguration();
        this.playPause = controlPanel.getPlayPause();
        this.playPause.addActionListener(this);
        this.configureJFrame();
        this.setVisible(true);
    }

    private void configureJFrame() {
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.addComponentsToPane(this.getContentPane());
    }

    private void addComponentsToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();
        JLabel lcontroPanel = new JLabel("Control Panel");
        JLabel lgeneralConfiguration = new JLabel("General Configuration");
        JLabel lresultsViewer = new JLabel("Results Viewer");

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 1;

        // Set highlight and background color for labels
        lcontroPanel.setOpaque(true);
        lcontroPanel.setBackground(new Color(239, 186, 186));
        lgeneralConfiguration.setOpaque(true);
        lgeneralConfiguration.setBackground(new Color(186, 239, 202));
        lresultsViewer.setOpaque(true);
        lresultsViewer.setBackground(new Color(237, 186, 239));

        panel.add(lcontroPanel, c);
        c.gridy++;
        panel.add(controlPanel, c);
        c.gridy++;
        panel.add(lgeneralConfiguration, c);
        c.gridy++;
        panel.add(generalConfiguration, c);
        c.gridy++;
        panel.add(lresultsViewer, c);
        c.gridy++;
        panel.add(resultsViewer, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "playPause":

                labParameters.productores = Integer.parseInt(generalConfiguration.getProductors().getText());
                labParameters.consumidores = Integer.parseInt(generalConfiguration.getConsumidors().getText());
                labParameters.sliderConsumer = generalConfiguration.sliderConsumer.getValue();
                labParameters.sliderProducer = generalConfiguration.sliderProducer.getValue();
                labParameters.timeConsumeRandom = generalConfiguration.timeConsumeRandom.isSelected();
                labParameters.timeProduceRandom = generalConfiguration.timeProduceRandom.isSelected();
                labParameters.itemstoconsume = Integer.parseInt(generalConfiguration.getConsumerQuantity().getText());
                System.out.println(labParameters.itemstoconsume+" labParameters.itemstoconsume");

                labParameters.itemstoproduce = Integer.parseInt(generalConfiguration.getProducerQuantity().getText());
                System.out.println(labParameters.itemstoproduce+" labParameters.itemstoproduce");
                labParameters.protectCriticalRegions = controlPanel.protectCriticalRegions.isSelected();
                labParameters.preventNegativeStock = controlPanel.preventNegativeStock.isSelected();
                this.controller.play();
                break;

            default:
                System.err.println("Acción NO tratada: " + e);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stateChanged'");
    }

    @Override
    public void run() {
        while (true) {
                        try {
                            // System.out.println("hola");
                            Thread.sleep(100);
                            this.resultsViewer.getCounter().setText(String.valueOf(this.controller.getmodel().getProduct().getStock()));
                            this.resultsViewer.getTimeThread().setText(String.valueOf(labResults.threadTime));
                            this.resultsViewer.getStartThread().setText(String.valueOf(labResults.timeStart));
                            this.resultsViewer.getConsumersTimeThread().setText(String.valueOf(labResults.avgThread));
                            this.resultsViewer.getProducerTimeThread().setText(String.valueOf(labResults.avgStart));
                            this.resultsViewer.getQuantityItemsConsumed().setText(String.valueOf(labResults.consumedItems));
                            this.resultsViewer.getQuantityItemsProduced().setText(String.valueOf(labResults.producedItems));
                            this.resultsViewer.getProcessingProductors().setText(String.valueOf(labResults.hilosProcesandoProductor));
                            this.resultsViewer.getProcessingConsumers().setText(String.valueOf(labResults.hilosProcesandoConsumidor));
                            this.resultsViewer.getFinishedProductors().setText(String.valueOf(labResults.hilosFinalizadosProductor));
                            this.resultsViewer.getFinishedConsumers().setText(String.valueOf(labResults.hilosFinalizadosConsumidor));
                            this.resultsViewer.getPendingConsumers().setText(String.valueOf(labParameters.consumidores-labResults.hilosFinalizadosConsumidor));
                            this.resultsViewer.getPendingProductors().setText(String.valueOf(labParameters.productores-labResults.hilosFinalizadosProductor));
                            // this.resultsViewer.getQuantityItemsProduced().setText(String.valueOf(labResults.producedItems));
                            // System.out.println(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
    }


