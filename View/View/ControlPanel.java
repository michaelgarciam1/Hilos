package View;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ControlPanel extends JPanel{
    JToggleButton playPause;
    JCheckBox protectCriticalRegions;
    JCheckBox preventNegativeStock;


    public ControlPanel(){
        this.playPause=new JToggleButton("playPause");
        this.preventNegativeStock=new JCheckBox();
        this.protectCriticalRegions=new JCheckBox();
        this.setLayout(new GridBagLayout());
        addComponentsToPane();
    }

    private void addComponentsToPane(){
        
        GridBagConstraints c= new GridBagConstraints();
        JLabel lplayPause= new JLabel("Boton play-Pause");
        JLabel lprotectCriticalRegions = new JLabel("Proteger regiones criticas");
        JLabel lpreventNegativeStock= new JLabel("prevenir resultados negativos");

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
         
        this.add(lplayPause,c);
        c.gridx++;
        this.add(this.playPause,c);
        c.gridx = 1;
        c.gridy++;
        this.add(lprotectCriticalRegions,c);
        c.gridx++;
        this.add(protectCriticalRegions,c);

        c.gridx = 1;
        c.gridy++;
        this.add(lpreventNegativeStock,c);
        c.gridx++;
        this.add(preventNegativeStock,c);
    }

    public JToggleButton getPlayPause() {
        return this.playPause;
    }

    public void setPlayPause(JToggleButton playPause) {
        this.playPause = playPause;
    }

    public JCheckBox getProtectCriticalRegions() {
        return this.protectCriticalRegions;
    }

    public void setProtectCriticalRegions(JCheckBox protectCriticalRegions) {
        this.protectCriticalRegions = protectCriticalRegions;
    }

    public JCheckBox getPreventNegativeStock() {
        return this.preventNegativeStock;
    }

    public void setPreventNegativeStock(JCheckBox preventNegativeStock) {
        this.preventNegativeStock = preventNegativeStock;
    }


}
