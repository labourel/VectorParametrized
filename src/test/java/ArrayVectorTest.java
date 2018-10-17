import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

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

}
