package Digital;

import java.beans.PropertyChangeEvent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;


public class OutputTerminalTest implements java.beans.PropertyChangeListener {
     
    private OutputTerminal instance;
    
    @Before
    public void setUp() {
        instance = new OutputTerminal();        
    }

    @Test
    public void testSetTrue() {
        instance.setValue(true);
        assertEquals("if value has been set to true then getValue should return true", true, instance.getValue());
    }

    @Test
    public void testSetFalse() {
        instance.setValue(false);
        assertEquals("if value has been set to false then getValue should return false", false, instance.getValue());
    }
    
    @Test
    public void testPropertyChangeEvent1() {
        instance.setValue(true);
        instance.addPropertyChangeListener(this);
        fired = null;
        instance.setValue(false);
        assertTrue("if the value has been changed then the property change event should be fired", fired != null);
        assertEquals("the name of the changed property should be Value", "Value", fired.getPropertyName());
        assertEquals("the old value of the property change event should be true", true, fired.getOldValue());
        assertEquals("the new value stored in the property change event should be false", false, fired.getNewValue());        
    }
    
    @Test
    public void testPropertyChangeEvent2() {
        instance.setValue(false);
        instance.addPropertyChangeListener(this);
        fired = null;
        instance.setValue(true);
        assertTrue("if the value has been changed then the property change event should be fired", fired != null);
        assertEquals("the name of the changed property should be Value", "Value", fired.getPropertyName());
        assertEquals("the old value of the property change event should be false", false, fired.getOldValue());
        assertEquals("the new value stored in the property change event should be true", true, fired.getNewValue());
        instance.removePropertyChangeListener(this);
    }
    
    @Test
    public void testPropertyChangeEvent3() {
        instance.setValue(true);
        instance.addPropertyChangeListener(this);
        fired = null;
        instance.setValue(true);
        assertEquals("if the value has been changed then the property change event should not be fired", null, fired);      
    }
   
    @Test
    public void testPropertyChangeEvent4() {
        instance.setValue(false);
        instance.addPropertyChangeListener(this);
        fired = null;
        instance.setValue(false);
        assertEquals("if the value has been changed then the property change event should not be fired", null, fired);      
    }    

    @Test
    public void testPropertyChangeEvent5() {
        instance.setValue(false);
        OutputTerminalTest other = new OutputTerminalTest();
        instance.addPropertyChangeListener(this);
        instance.addPropertyChangeListener(other);
        fired = null;
        other.fired = null;
        instance.setValue(true);
        assertTrue("if the value has been changed then the property change event should be fired", fired != null);
        assertTrue("if the value has been changed then the property change event should be fired", other.fired != null);        
    }    
    
    @Test
    public void testRemovePropertyChangeListener() {
        instance.setValue(false);
        instance.addPropertyChangeListener(this);
        fired = null;
        instance.removePropertyChangeListener(this);
        instance.setValue(true);
        assertEquals("this should have been removed from the list of property change listeners", null, fired); 
    }
    
    public PropertyChangeEvent fired = null;
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        fired = evt;   
    }
}
