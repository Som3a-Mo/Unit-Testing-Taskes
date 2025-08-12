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

}
