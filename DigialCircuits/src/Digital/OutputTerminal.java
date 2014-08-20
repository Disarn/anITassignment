/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Digital;

import java.beans.*;

/**
 *
 * @author melatonind
 */
public class OutputTerminal implements Terminal {
    private boolean value;
    private PropertyChangeSupport prop =
        new PropertyChangeSupport(this);
    
    @Override
    public boolean getValue() {
        return value;
    }
    
    public void setValue(boolean v) {
        boolean oldValue = value;
        value = v;
        prop.firePropertyChange("Value",
                                   oldValue, value);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        prop.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        prop.removePropertyChangeListener(listener);
    }
    
}
