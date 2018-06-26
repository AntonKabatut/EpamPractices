import Practice4.ParseTypes;
import org.junit.Test;

import java.io.FileNotFoundException;

import static junit.framework.Assert.assertEquals;

public class ParseTypesTest {

    @Test
    public void testMatch() throws FileNotFoundException {
        StringBuilder stringBuilder= ParseTypes.match("String");
        assertEquals(new StringBuilder("-------------------------\n" +
                "weggwe rgerge fff greger \n" +
                "-------------------------\n").toString(),stringBuilder.toString());
    }

}
