package com.javatpoint.testcase;

import static org.junit.Assert.*;
import com.javatpoint.logic.*;
import org.junit.Test;

public class TestLogic {

    @Test
    public void testInventoryOrder(){
        // TestCase1: Multiple warehouses
        assertEquals([{ name: owd, inventory: { apple: 5, orange: 5 }, { name: dm, inventory: {banana: 5}}],
        Main.computeOrder({apple: 5,banana: 5,orange: 5},[{name: owd,inventory:{apple: 5,orange: 10}},
        {name: dm:,inventory:{banana: 5,orange: 10 }}]));
        // TestCase2: Single Warehouse               
        assertEquals([{owd:{apple: 1}}], Main.computeOrder({apple: 1},[{name: owd,inventory:{apple: 1}}]));
        // TestCase3: Not enough inventory
        assertEquals([], Main.computeOrder({apple: 1 },[{name: owd,inventory:{apple: 0}}]));
    }
}
