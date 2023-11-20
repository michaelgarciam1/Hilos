package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class GeneralConfiguration extends JPanel {
    JTextField productors;
    JTextField consumidors;

    JCheckBox timeConsumeRandom;
    JCheckBox timeProduceRandom;

    JSlider sliderProducer;
    JSlider sliderConsumer;

    public GeneralConfiguration() {
        this.consumidors = new JTextField("0");
        this.productors = new JTextField("0");
        this.timeConsumeRandom = new JCheckBox();
        this.timeProduceRandom = new JCheckBox();
        this.sliderConsumer = new JSlider(0, 1000, 0);
        this.sliderProducer = new JSlider(0, 1000, 0);
        this.setLayout(new GridBagLayout());
        addComponentsToPane();
    }

    private void addComponentsToPane() {
        GridBagConstraints c = new GridBagConstraints();
        JLabel lProductor = new JLabel("Productors number");
        JLabel lConsumidor = new JLabel("Consumidor number");
        JLabel lTimeConsumeRandom = new JLabel("Tiempo consumidor aleatorio");
        JLabel lTimeProduceRandom = new JLabel("Tiempo productor aleatorio");
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy++;
        this.add(lConsumidor, c);
        c.gridx++;
        this.add(consumidors, c);

        c.gridx = 1;
        c.gridy++;
        this.add(lProductor, c);
        c.gridx++;
        this.add(productors, c);

        c.gridx = 1;
        c.gridy++;
        this.add(lTimeConsumeRandom, c);
        c.gridx++;
        this.add(timeConsumeRandom, c);
        c.gridx++;
        this.add(sliderConsumer, c);

        c.gridx = 1;
        c.gridy++;
        this.add(lTimeProduceRandom, c);
        c.gridx++;
        this.add(timeProduceRandom, c);
        c.gridx++;
        this.add(sliderProducer, c);

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

}
