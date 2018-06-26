import Practice4.LocaleWork;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class LocaleWorkTest {

    @Test
    public void testMatch(){
        String result= LocaleWork.match("apple en");
        assertEquals("apple",result);
    }

}
