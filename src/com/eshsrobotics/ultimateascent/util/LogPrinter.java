package com.eshsrobotics.ultimateascent.util;

/**
 * Implementation of a {@link com.eshsrobotics.ultimateascent.util.Printer}
 * that sends its output to the system log.
 */
public class LogPrinter implements Printer
{
    private final int priority;
    private final String tag;

    /**
     * Create a new Printer that sends to the log with the given priority
     * and tag.
     *
     * @param priority The desired log priority:
     * {@link com.eshsrobotics.ultimateascent.util.Log#VERBOSE Log.VERBOSE},
     * {@link com.eshsrobotics.ultimateascent.util.Log#DEBUG Log.DEBUG},
     * {@link com.eshsrobotics.ultimateascent.util.Log#INFO Log.INFO},
     * {@link com.eshsrobotics.ultimateascent.util.Log#WARN Log.WARN}, or
     * {@link com.eshsrobotics.ultimateascent.util.Log#ERROR Log.ERROR}.
     * @param tag A string tag to associate with each printed log statement.
     */
    public LogPrinter(int priority, String tag)
    {
        this.priority = priority;
        this.tag = tag;
    }

    public void println(String x)
    {
        Log.println(priority, tag, x);
    }
}
