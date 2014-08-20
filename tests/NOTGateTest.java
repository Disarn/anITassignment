package Digital;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;



public class NOTGateTest 
{
    private NOTGate instance;  
    private TestTerminal input0, input1, input2;    
    private Terminal output;
    
    @Before
    public void setUp() {
        instance = new NOTGate();
        output = instance.getOutput();
        input0 = new TestTerminal();
        input1 = new TestTerminal();   
        input2 = new TestTerminal();         
    }
    
    @Test
    public void testOutput() { 
        Terminal output = instance.getOutput();
        assertTrue(output != null);
        assertTrue(output.getClass() == OutputTerminal.class);  
    }         
    
@Test
    public void testInput0() {
        instance.setInput0(input0);
        Terminal result = instance.getInput0();
        assertEquals("get input0 should return the Terminal set by setInput0", input0, result);
    }    
       
    @Test
    public void testTrue() {
        input0.setValue(true);
        instance.setInput0(input0);
        assertEquals("not true should generate false", false, output.getValue());
    }
    
    @Test
    public void testFalse() {
        input0.setValue(false);
        instance.setInput0(input0);
        assertEquals("not false should generate true", true, output.getValue());
    }    
  
    @Test
    public void testNoInput() {
        instance.setInput0(null);
        assertEquals("if one of the inputs is not connected then that input value should be treated as false", true, output.getValue());
    }      
    
    @Test
    public void testInput0ValueChanged() {
        input0.setValue(true);
        instance.setInput0(input0);
        assertEquals(output.getValue(), false);      
        input0.setValue(false);
        assertEquals("if the value of input0 changes then the output of the pin needs to be recomputed", true, output.getValue());        
    }    
    
    @Test
    public void testInput0Changed() {
        input0.setValue(true);
        instance.setInput0(input0);
        assertEquals(output.getValue(), false);
        input2.setValue(false);
        instance.setInput0(input2);
        assertEquals("if input0 is connected to a different output terminal then the output of the NOT gate needs to be recomputed", true, output.getValue());        
    }   
    
    @Test
    public void testInput0Cleared() {
        input0.setValue(true);
        instance.setInput0(input0);
        assertEquals(output.getValue(), false);
        
        instance.setInput0(null);
        assertEquals("if input0 is disconnected then the output of the NOT gate needs to be recomputed", true, output.getValue());        
    }     
}