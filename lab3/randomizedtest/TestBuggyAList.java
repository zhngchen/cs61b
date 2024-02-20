package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove()
    {
        AListNoResizing<Integer> willCorrects = new AListNoResizing<>();
        BuggyAList<Integer> buggys = new BuggyAList<>();
        for (int i = 0; i < 3; i += 1)
        {
            willCorrects.addLast(i + 4);
            buggys.addLast(i + 4);
        }

        assertEquals(willCorrects.removeLast(), buggys.removeLast());
        assertEquals(willCorrects.removeLast(), buggys.removeLast());
        assertEquals(willCorrects.removeLast(), buggys.removeLast());
    }

    @Test
    public void randomizedTest()
    {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggys = new BuggyAList<>();

        int N = 50000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggys.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int LSize = L.size();
                int buggySize = buggys.size();
                assertEquals(LSize, buggySize);
            } else if (operationNumber == 2)
            {
                // getLast
                if (L.size() == 0)
                    continue;

                int last = L.getLast();
                int buggyLast = buggys.getLast();
                assertEquals(last, buggyLast);
            } else if (operationNumber == 3)
            {
                // removeLast
                if (L.size() == 0)
                    continue;

                int last = L.removeLast();
                int buggyLast = buggys.removeLast();
                assertEquals(last, buggyLast);
            }
        }
    }

}
