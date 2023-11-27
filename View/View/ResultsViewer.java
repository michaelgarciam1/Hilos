package View;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import DTO.LabResults;

public class ResultsViewer extends JPanel implements Runnable {
    
    JTextField counter;

    JTextField timeThread;
    JTextField startThread;

    JTextField consumersTimeThread;
    JTextField producerTimeThread;

    JTextField quantityItemsProduced;
    JTextField quantityItemsConsumed;

    JTextField processingProductors;
    JTextField finishedProductors;
    JTextField pendingProductors;

    JTextField processingConsumers;
    JTextField finishedConsumers;
    JTextField pendingConsumers;
    
    LabResults resultados;

    public ResultsViewer(LabResults resultados) {
        this.resultados = resultados;
        this.counter = new JTextField("0");

        this.timeThread = new JTextField("0");
        this.startThread = new JTextField("0");

        this.consumersTimeThread = new JTextField("0");
        this.producerTimeThread = new JTextField("0");

        this.quantityItemsProduced = new JTextField("0");
        this.quantityItemsConsumed = new JTextField("0");

        this.processingProductors = new JTextField("0");
        this.finishedProductors = new JTextField("0");
        this.pendingProductors = new JTextField("0");

        this.processingConsumers = new JTextField("0");
        this.finishedConsumers = new JTextField("0");
        this.pendingConsumers = new JTextField("0");
        this.setLayout(new GridBagLayout());
        this.addComponentsToPane();
    }

    @Override
    public void run() {

    }

    private void addComponentsToPane() {
        GridBagConstraints c = new GridBagConstraints();
        JLabel lcounter = new JLabel("Contador");
        JLabel ltimeThread = new JLabel("Creacion objectes Thread (m/s)");
        JLabel lstartThread = new JLabel("Tiempo de inicio Threads (m/s)");

        JLabel lconsumersTimeThread = new JLabel("media Threads (m/s)");
        JLabel lproducerTimeThread = new JLabel("mdeia start() (m/s)");
        
        JLabel lquantityItemsProduced = new JLabel("items producidos");
        JLabel lquantityItemsConsumed = new JLabel("items consumidos");
        
        JLabel lprocessingProductors = new JLabel("procesamiento productores ");
        JLabel lfinishedProductors = new JLabel("productores finalizados");
        JLabel lpendingProductors = new JLabel("productores pendientes");
        
        JLabel lprocessingConsumers = new JLabel("procesamiento consumidores");
        JLabel lfinishedConsumers = new JLabel("consumidores finalizados");
        JLabel lpendingConsumers = new JLabel("consumidores pendientes");


        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 1;

        this.add(lcounter, c);
        c.gridx++;
        this.add(counter, c);

        c.gridx = 1;
        c.gridy++;
        this.add(ltimeThread, c);
        c.gridx++;
        this.add(this.timeThread, c);

        c.gridx = 1;
        c.gridy++;
        this.add(lstartThread, c);
        c.gridx++;
        this.add(startThread, c);
        
        c.gridx = 1;
        c.gridy++;
        this.add(lconsumersTimeThread, c);
        c.gridx++;
        this.add(consumersTimeThread, c);
        
        c.gridx = 1;
        c.gridy++;
        this.add(lproducerTimeThread, c);
        c.gridx++;
        this.add(producerTimeThread, c);
        
        c.gridx = 1;
        c.gridy++;
        this.add(lquantityItemsProduced, c);
        c.gridx++;
        this.add(quantityItemsProduced, c);

        c.gridx = 1;
        c.gridy++;
        this.add(lquantityItemsConsumed, c);
        c.gridx++;
        this.add(quantityItemsConsumed, c);

        c.gridx = 1;
        c.gridy++;
        this.add(lprocessingProductors, c);
        c.gridx++;
        this.add(processingProductors, c);

        c.gridx=1;
        c.gridy++;
        this.add(lfinishedProductors, c);
        c.gridx++;
        this.add(finishedProductors,c);

        c.gridx=1;
        c.gridy++;
        this.add(lpendingProductors, c);
        c.gridx++;
        this.add(pendingProductors,c);

        c.gridx=1;
        c.gridy++;
        this.add(lprocessingConsumers, c);
        c.gridx++;
        this.add(processingConsumers,c);

        c.gridx=1;
        c.gridy++;
        this.add(lfinishedConsumers, c);
        c.gridx++;
        this.add(finishedConsumers,c);

        c.gridx=1;
        c.gridy++;
        this.add(lpendingConsumers, c);
        c.gridx++;
        this.add(pendingConsumers,c);

        


    }

    public JTextField getCounter() {
        return this.counter;
    }

    public void setCounter(JTextField counter) {
        this.counter = counter;
    }

    public JTextField getTimeThread() {
        return this.timeThread;
    }

    public void setTimeThread(JTextField timeThread) {
        this.timeThread = timeThread;
    }

    public JTextField getStartThread() {
        return this.startThread;
    }

    public void setStartThread(JTextField startThread) {
        this.startThread = startThread;
    }

    public JTextField getConsumersTimeThread() {
        return this.consumersTimeThread;
    }

    public void setConsumersTimeThread(JTextField consumersTimeThread) {
        this.consumersTimeThread = consumersTimeThread;
    }

    public JTextField getProducerTimeThread() {
        return this.producerTimeThread;
    }

    public void setProducerTimeThread(JTextField producerTimeThread) {
        this.producerTimeThread = producerTimeThread;
    }

    public JTextField getQuantityItemsProduced() {
        return this.quantityItemsProduced;
    }

    public void setQuantityItemsProduced(JTextField quantityItemsProduced) {
        this.quantityItemsProduced = quantityItemsProduced;
    }

    public JTextField getQuantityItemsConsumed() {
        return this.quantityItemsConsumed;
    }

    public void setQuantityItemsConsumed(JTextField quantityItemsConsumed) {
        this.quantityItemsConsumed = quantityItemsConsumed;
    }

    public JTextField getProcessingProductors() {
        return this.processingProductors;
    }

    public void setProcessingProductors(JTextField processingProductors) {
        this.processingProductors = processingProductors;
    }

    public JTextField getFinishedProductors() {
        return this.finishedProductors;
    }

    public void setFinishedProductors(JTextField finishedProductors) {
        this.finishedProductors = finishedProductors;
    }

    public JTextField getPendingProductors() {
        return this.pendingProductors;
    }

    public void setPendingProductors(JTextField pendingProductors) {
        this.pendingProductors = pendingProductors;
    }

    public JTextField getProcessingConsumers() {
        return this.processingConsumers;
    }

    public void setProcessingConsumers(JTextField processingConsumers) {
        this.processingConsumers = processingConsumers;
    }

    public JTextField getFinishedConsumers() {
        return this.finishedConsumers;
    }

    public void setFinishedConsumers(JTextField finishedConsumers) {
        this.finishedConsumers = finishedConsumers;
    }

    public JTextField getPendingConsumers() {
        return this.pendingConsumers;
    }

    public void setPendingConsumers(JTextField pendingConsumers) {
        this.pendingConsumers = pendingConsumers;
    }

    public LabResults getResultados() {
        return this.resultados;
    }

    public void setResultados(LabResults resultados) {
        this.resultados = resultados;
    }



}