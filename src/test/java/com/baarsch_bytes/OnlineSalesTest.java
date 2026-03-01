package com.baarsch_bytes;

import com.baarsch_bytes.Converters.LongConstantConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvFileSource;
import com.baarsch_bytes.OnlineSalesOld.Status;
import com.baarsch_bytes.OnlineSalesOld.Status.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlineSalesTest {

    @ParameterizedTest
    @CsvFileSource(resources="/OnlineSalesDiscount_tests.csv", numLinesToSkip = 1)
    public void testGiveDiscount(String id, @ConvertWith(LongConstantConverter.class) long bonusPoints, boolean goldCustomer,
                                 OnlineSalesOld.Status expected) {

        OnlineSalesRevised salesComputer = new OnlineSalesRevised();

        assertEquals(expected,
               // OnlineSalesOld.giveDiscount(bonusPoints, goldCustomer) );
                salesComputer.giveDiscount(bonusPoints, goldCustomer) );
    }


}
