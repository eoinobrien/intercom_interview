package flattener;

import flattener.ArrayFlattener;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayFlattenerTest {

    @Test
    public void testArrayFlattener() {
        ArrayFlattener flattener = new ArrayFlattener();
        Object [] sampleInput1 = new Object [] { new Object [] { 1, 2, new Object [] {3} }, 4 };
        Integer [] expectedResult1 = new Integer[] {1,2,3,4};

        assertArrayEquals(expectedResult1, flattener.arrayFlattener(sampleInput1).toArray());
    }

    @Test
    public void testArrayFlattenerTwo() {
        ArrayFlattener flattener = new ArrayFlattener();
        Object [] sampleInput1 = new Object [] { new Object [] { 1, 2, new Object [] {3} }, 4, new Object [] {5, 6, new Object [] {7}} };
        Integer [] expectedResult1 = new Integer[] {1,2,3,4,5,6,7};

        assertArrayEquals(expectedResult1, flattener.arrayFlattener(sampleInput1).toArray());
    }
}
