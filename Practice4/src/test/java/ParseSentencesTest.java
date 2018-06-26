import Practice4.ParseSentences;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class ParseSentencesTest {

    @Test
    public void testCutSentences(){
        String[] expected=new String[]{"Good day!","Sometimes day is bad.","Is it true?","But it is not sentence, are you sure?"};
        String[] sentences= ParseSentences.cutSentences("Good day! Sometimes day is bad. Is it true? hello it is me. But it is not sentence, are you sure?");
        assertEquals(Arrays.toString(expected), Arrays.toString(sentences));
    }

}
