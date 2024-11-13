

package com.raaz.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicUnitTest {
    @Test
    public void sampleTest() {
        Assert.assertEquals(1 + 1, 2, "Sample test to check TestNG setup.");
    }
}
