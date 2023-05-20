package test;

import main.core.GasMater;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GasMaterTest {

    @Test
    void getNameModel (){

        GasMater gasMater1 = new GasMater("0001","Siemens",12834,0);

        Assertions.assertEquals(gasMater1.getNameModel(),"Siemens");
    }

    @Test
    void setIdGasMater (){

        GasMater gasmater1 = new GasMater();
        gasmater1.setIdGasMater("342");

        Assertions.assertEquals(gasmater1.getIdGasMater(),"342");
    }
}
