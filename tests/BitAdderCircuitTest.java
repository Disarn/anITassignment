/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Digital;

import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kellyw
 */
public class BitAdderCircuitTest 
{    
    BitAdderCircuit instance;
    OutputTerminal i0, i1, i2;
    Terminal o0, o1;

    @Before
    public void setUp() 
    {
        instance = new BitAdderCircuit();
        
        i0 = new OutputTerminal();
        instance.getPin1().setInput0(i0);
        
        i1 = new OutputTerminal();
        instance.getPin2().setInput0(i1);
        
        i2 = new OutputTerminal();
        instance.getPin3().setInput0(i2);
        
        o0 = instance.getPin4().getOutput();
        o1 = instance.getPin5().getOutput();
    }
    
    @Test
    public void testSum() 
    {
        for (int in0 = 0; in0 < 2; in0++)
            for (int in1 = 0; in1 < 2; in1++)
                for (int in2 = 0; in2 < 2; in2++)
                {
                    i0.setValue(in0 == 1);
                    i1.setValue(in1 == 1);
                    i2.setValue(in2 == 1);
                    
                    int sum = in0 + in1 + in2;
                    
                    int out0 = o0.getValue() ? 1 : 0;
                    int out1 = o1.getValue() ? 1 : 0;
                    int out = (out1 << 1) | out0;
                    
                    System.out.println(in0 + " + " + in1 + " + " + in2 + " = " + out1 + out0);
                    
                    assertEquals("wrong result", sum, out);
                }
    }
}