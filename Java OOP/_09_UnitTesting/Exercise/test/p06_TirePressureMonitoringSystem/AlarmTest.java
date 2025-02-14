package _exercise.p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlarmTest {
    private static final double LOW_PRESSURE_THRESHOLD = 16;
    private static final double HIGH_PRESSURE_THRESHOLD = 22;

    private Alarm alarm;
    private Sensor sensor;

    @Before
    public void setUp() {
        this.sensor = mock(Sensor.class);
        this.alarm = new Alarm(sensor);
    }

    @Test
    public void testAlarmShouldBeOnBecausePressureIsLow() {

        when(sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_THRESHOLD);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmShouldBeOnBecausePressureIsHigh() {

        when(sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_THRESHOLD);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }
}