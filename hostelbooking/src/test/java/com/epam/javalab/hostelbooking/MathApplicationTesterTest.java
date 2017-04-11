package com.epam.javalab.hostelbooking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTesterTest {

    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    @Mock
    CalculatorService calculatorService;

    @Test
    public void testAdd() {
        when(calculatorService.add(10.0, 20.0)).thenReturn(30.00);

        //Assert.assertEqual(mathApplication.add(10.0, 20.0), 30.0, 0);
    }
}