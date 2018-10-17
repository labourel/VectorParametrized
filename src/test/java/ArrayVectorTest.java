import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
}
