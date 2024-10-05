package cn.qfys521;

import org.apache.commons.cli.*;

/**
 * This is the main entry point for the application.
 * It parses command-line arguments using Apache Commons CLI and provides help and version information.
 */
public class Main {

    /**
     * The main entry point for the application.
     *
     * @param args The command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        // Create command-line options
        Options options = new Options();
        options.addOption("h", "help", false, "Print this message");
        options.addOption("v", "version", false, "Print version information");

        // Create a parser to parse the command-line arguments
        CommandLineParser parser = new DefaultParser();

        try {
            // Parse the command-line arguments
            CommandLine cmd = parser.parse(options, args);

            // Handle help option
            if (cmd.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("-h [command]", options);
            }

            // Handle version option
            if (cmd.hasOption("v")) {
                System.out.println("Version: " + "1.0.0-SNAPSHOT");
            }
        } catch (ParseException e) {
            // Print an error message if there's a parsing error
            System.err.println("Error parsing command-line arguments: " + e.getMessage());
        }
    }
}