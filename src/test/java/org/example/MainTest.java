package org.example;

import com.jayway.jsonpath.ReadContext;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private static ReadContext ctx;

    @BeforeAll
    public static void setup() throws IOException {
        ctx = JsonUtil.readJson("src/test/resources/data.json");
    }

    @Test
    public void testPrintNumbers() {
        Main main = new Main();
        List<Integer> numbers = ctx.read("$.numbers");

        int[] numbersArray = numbers.stream().mapToInt(i -> i).toArray();
        assertDoesNotThrow(() -> main.printNumbers(numbersArray));
    }

    @Test
    public void testPrintNames() {
        Main main = new Main();
        List<String> names = ctx.read("$.names");

        String[] namesArray = names.toArray(new String[0]);
        assertDoesNotThrow(() -> main.printNames(namesArray));
    }

    @Test
    public void testProcessNamesList() {
        Main main = new Main();
        List<String> names1 = ctx.read("$.names1");

        assertDoesNotThrow(() -> main.processNamesList(names1));
        assertEquals("Ann", names1.get(0));
    }
}
