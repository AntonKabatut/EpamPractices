import Practice4.SortingInfFromFiles;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;


public class SortingInfFromFilesTest {

    @Test
    public void testSortArr(){
        int [] arr= SortingInfFromFiles.sortArr(new int[]{6,4,5});
        assertEquals(Arrays.toString(new int[]{4, 5, 6}), Arrays.toString(arr));
    }



}
