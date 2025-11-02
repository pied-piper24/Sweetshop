package com.sweetshop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuItemTest {

    @Test
    public void testMenuItemCreation() {
        MenuItem item = new MenuItem("Laddu", 10.0, "Sweet");
        assertEquals("Laddu", item.getName());
        assertEquals(10.0, item.getPrice());
        assertEquals("Sweet", item.getCategory());
    }
}