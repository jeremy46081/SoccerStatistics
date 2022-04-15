package soccer;

import soccer.stats.Reader;

import java.io.File;

/**
 * Demo-2
 * Object oriented program that tracks statistics of a game of soccer
 *
 * @Author Jeremy Thomas
 * @Author Jessica Thomas
 * Kimiya Saadat T07
 * Date: 24th March 2022
 */

public final class Main1 {
    /**
     * Checks and reads Files and runs the program
     *
     * @param args Program arguments
     */
    public static void main(String[] args) {

        File stats = new File(args[0]);

        checkFiles(stats);
        Reader reader = new Reader();

        //Menu.runProgram(stats, reader);


    }

    /**
     * Verify if files exists and can be accessed properly
     *
     * @param stats file containing game data
     */

    private static void checkFiles(File stats) {
        if (!stats.exists() || !stats.isFile() || !stats.canRead()) {
            System.err.printf("The stats file %s does not exist!%n", stats.getAbsoluteFile());
            System.exit(1);
        }

    }

}