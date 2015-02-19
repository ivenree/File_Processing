import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author wenfeng ren
 * @version Nov 1, 2014
 */
public class Quicksort
{

    // ----------------------------------------------------------
    /**
     * main method.
     *
     * @param args inputs
     * @throws IOException
     */
    public static void main(String[] args)
        throws IOException
    {
        String disk = args[0];
        int numBuffer = Integer.parseInt(args[1]);
        String statFile = args[2];

        // stat info update
        Stat.fileName = disk;

        long start = System.currentTimeMillis();
        // sort file
        Sorting sorting = new Sorting(disk, numBuffer);

        sorting.sort();
        // flush when sorting is done.
        sorting.flush();

        long end = System.currentTimeMillis();

        // update stat info.
        Stat.executionTime = end - start;

        // write stat info to file:
        File stat = new File(statFile);
        stat.createNewFile();
        FileWriter statfileWriter = new FileWriter(stat, true);
        BufferedWriter statOut = new BufferedWriter(statfileWriter);
        statOut.write(Stat.output());
        statOut.flush();
        statOut.close();
    }

}
