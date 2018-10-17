import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Arnaud Labourel on 30/09/2018.
 */
public class ArrayVectorTest {

    @Test
    void anArrayVectorCreatedWithoutParameterShouldHaveCapacity10(){
        Vector<Integer> vector = new ArrayVector<>();
        assertEquals(10,vector.capacity());
    }

    @Test
    void anNewlyCreatedArrayVectorShouldHaveSize0(){
        Vector<Integer> vector = new ArrayVector<>();
        assertEquals(0, vector.size());
        assertTrue(vector.isEmpty());
    }
    @Test
    void testAddAndGet(){
        Vector<Integer> vector = new ArrayVector<>();
        for (int i = 0 ; i<10; i++){
            vector.add(i);
        }
        for (int i = 0 ; i<10; i++){
            assertEquals(Integer.valueOf(i), vector.get(i));
        }
    }

    @Test
    void testIndexOf(){
        Vector<Integer> vector = new ArrayVector<>();
        for (int i =0 ; i<10; i++){
            vector.add(i);
        }
        for (int i =0 ; i<10; i++){
            assertEquals(i, vector.indexOf(i));
        }
        assertEquals(-1, vector.indexOf(-12));
        for (int i = 0 ; i<5; i++){
            assertEquals(-1, vector.indexOf(i, 6));
        }
        for (int i =0 ; i<10; i++){
            assertEquals(i, vector.lastIndexOf(i));
        }
    }

    @Test
    void testRemove(){
        Vector<Integer> vector = new ArrayVector<>();
        for (int i =0 ; i<10; i++){
            vector.add(i);
        }
        vector.remove(5);
        assertEquals(9, vector.size());
        for (int i = 5 ; i<9; i++){
            assertEquals(Integer.valueOf(i+1), vector.get(i));
        }
        assertFalse(vector.remove(Integer.valueOf(5)));
        assertTrue(vector.remove(Integer.valueOf(9)));

    }
    @Test
    void testLastAndFirstElement(){
        Vector<Integer> vector = new ArrayVector<>();
        for (int i =0 ; i<10; i++){
            vector.add(i);
        }
        assertEquals(Integer.valueOf(0), vector.firstElement());
        assertEquals(Integer.valueOf(9), vector.lastElement());
    }

    @Test
    void testInsert() {
        Vector<Integer> vector = new ArrayVector<>();
        for (int i = 0; i < 5; i++) {
            vector.add(i);
        }
        vector.insertElementAt(9,3);
        assertEquals(6, vector.size());
        for (int i = 0; i < 3; i++) {
            assertEquals(Integer.valueOf(i), vector.get(i));
        }
        assertEquals(Integer.valueOf(9), vector.get(3));
        for (int i = 4; i < 6; i++) {
            assertEquals(Integer.valueOf(i-1), vector.get(i));
        }
    }

    @Test
    void testContains(){
        Vector<Integer> vector = new ArrayVector<>();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        List<Integer> col1= new ArrayList<>();
        col1.add(1);
        col1.add(3);

        List<Integer> col2= new ArrayList<>();
        col2.add(1);
        col2.add(10);

        assertTrue(vector.containsAll(col1));
        assertFalse(vector.containsAll(col2));
    }
    @Test
    void testToArray(){
        Vector<Integer> vector = new ArrayVector<>();
        Integer[] expectedArray = new Integer[10];
        for (int i = 0; i < 10; i++) {
            vector.add(i);
            expectedArray[i]=i;
        }
        assertArrayEquals(expectedArray, vector.toArray());
    }
}
