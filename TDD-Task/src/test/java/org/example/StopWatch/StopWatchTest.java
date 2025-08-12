package org.example.StopWatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StopWatchTest {
    @Test
    public void minutesShouldAdd(){
        // Arrange
        StopWatch sw = new StopWatch();

        // Act
        sw.addMinutes(5);
        int minutes = sw.getMinutes();

        // Assert
        Assertions.assertEquals(5, minutes);
    }

    @Test
    public void negativeMinutesShouldNotBeAllowed(){
        StopWatch sw = new StopWatch();

        sw.addMinutes(-5);
        int minutes = sw.getMinutes();

        Assertions.assertEquals(0, minutes);
    }

    @Test
    public void hoursShouldBeAdded(){
        StopWatch sw = new StopWatch();

        sw.addMinutes(61);
        int hours = sw.getHours();
        int minutes = sw.getMinutes();

        Assertions.assertArrayEquals(new int[]{1 , 1}, new int[]{minutes, hours});
    }

}
