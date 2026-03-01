package com.baarsch_bytes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ArkansasWeatherServiceTest {

    @Mock
    DatabaseConnection mockDb;

    @Test
    public void testGetTemp() {
        String testCity = "Little Rock";

        when(mockDb.queryTemp(testCity)).thenReturn(65.0);
        ArkansasWeatherService service = new ArkansasWeatherService(mockDb);

        double result = service.getTemp(testCity);

        assertEquals(65.0, result, "Get Temp test for " + testCity + " failed: " + result);
    }





}
