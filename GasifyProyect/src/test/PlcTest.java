package test;

import main.core.Plc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlcTest {


    @Test
    void getPlc(){

        Plc Plc1 = new Plc();

        Plc1.setIdPlc("1");
        Assertions.assertEquals(Plc1.getIdPlc(),"1");
    }


    @Test
    void getModelPlc(){

        Plc Plc1 = new Plc();

        Plc1.setModelPlc("Siemens");
        Assertions.assertEquals(Plc1.getModelPlc(),"Siemens");
    }
}
