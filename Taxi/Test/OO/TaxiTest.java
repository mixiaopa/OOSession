package OO;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TaxiTest {

    private Taxi taxi;

    @org.junit.Test
    public void shouldCharge6WhenDistanceIs1() throws Exception {
        assertEquals(taxi.getFee(1), 6, 0.1);
    }

    @Test
    public void shouldCharge6WhenDistanceIs2() throws Exception {
        assertEquals(taxi.getFee(2), 6, 0.1);
    }

    @Test
    public void shouldChargeMoreThan6WhenDistanceMoreThan2() throws Exception {
        assertThat(taxi.getFee(2.1) - 6 > 0, is(true));
    }

    @Test
    public void shouldCharge10WhenDistanceIs7() throws Exception {
        assertEquals(taxi.getFee(7), 10.0, 0.1);
    }

    @Test
    public void shouldCharge10p8WhenDistanceIs8() throws Exception {
        assertEquals(taxi.getFee(8), 10.8, 0.000001);
    }

    @Test
    public void shouldCharge12WhenDistanceIs9() throws Exception {
        assertEquals(taxi.getFee(9), 12, 0.000001);
    }

    @Test
    public void shouldCharge13p2WhenDistanceIs10() throws Exception {
        assertEquals(taxi.getFee(10), 13.2, 0.000001);
    }

    @Before
    public void setUp() throws Exception {
        taxi = new Taxi();


    }

    @Test
    public void shouldCharge6p25WhenDistanceIs1AndStopTimeIs1() throws Exception {
        taxi.setStopTime(1);
        assertEquals(taxi.getFee(1), 6.25, 0.0000001);
    }

    @Test
    public void shouldCharge6p5WhenDistanceIs1AndStopTimeIs2() throws Exception {
        taxi.setStopTime(2);
        assertEquals(taxi.getFee(1), 6.5, 0.0000001);
    }
}
