package com.eshsrobotics.ultimateascent.util;

import com.eshsrobotics.ultimateascent.Robot;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Heavily inspired by android.util.Log.
 *
 * API for sending log output.
 *
 * <p>You should generally use the Log.v(), Log.d(), Log.w(), and Log.w()
 * methods.</p>
 *
 * <p>In order of terms of verbosity from at least to most is ERROR, WARN, INFO,
 * DEBUG, VERBOSE.</p>
 *
 * <p><b>Tip:</b></p> A good convention is to declare a <code>TAG</code> constant
 * in your class:
 *
 * <pre>private static final String TAG = "Climber";</pre>
 *
 * and use that in subsequent calls to the log methods.</p>
 */
public final class Log
{
    public static final String TAG = "Log";

    /**
     * Priority constant for the println method; use Log.v.
     */
    public static final int VERBOSE = 2;

    /**
     * Priority constant for the println method; use Log.d.
     */
    public static final int DEBUG = 3;

    /**
     * Priority constant for the println method; use Log.i.
     */
    public static final int INFO = 4;

    /**
     * Priority constant for the println method; use Log.w.
     */
    public static final int WARN = 5;

    /**
     * Priority constant for the println method; use Log.e.
     */
    public static final int ERROR = 6;

    /**
     * Priority constant for the println method.
     */
    public static final int ASSERT = 7;

    /**
     * Format for printing date of the log.
     */
    private static DateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");

    /**
     * Exception class used to capture a stack trace in {@link #wtf(String, String)}.
     */
    private static class TerribleFailure extends Exception
    {
        TerribleFailure(String msg, Throwable cause)
        {
            super(msg, cause);
        }
    }

    /**
     * Interface to handle terrible failures from {@link #wtf(String, String)}.
     *
     * @hide
     */
    public interface TerribleFailureHandler
    {
        void onTerribleFailure(String tag, TerribleFailure what);
    }

    private static TerribleFailureHandler sWtfHandler = new TerribleFailureHandler()
    {
        public void onTerribleFailure(String tag, TerribleFailure what)
        {
            Robot.wtf(tag, what);
        }
    };

    private Log()
    {
    }

    /**
     * Send a {@link #VERBOSE} log message.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static void v(String tag, String msg)
    {
        println(VERBOSE, tag, msg);
    }

    /**
     * Send a {@link #VERBOSE} log message and log the exception.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static void v(String tag, String msg, Throwable tr)
    {
        println(VERBOSE, tag, msg + '\n' + getStackTraceString(tr));
    }

    /**
     * Send a {@link #DEBUG} log message.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static void d(String tag, String msg)
    {
        println(DEBUG, tag, msg);
    }

    /**
     * Send a {@link #DEBUG} log message and log the exception.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static void d(String tag, String msg, Throwable tr)
    {
        println(DEBUG, tag, msg + '\n' + getStackTraceString(tr));
    }

    /**
     * Send an {@link #INFO} log message.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static void i(String tag, String msg)
    {
        println(INFO, tag, msg);
    }

    /**
     * Send a {@link #INFO} log message and log the exception.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static void i(String tag, String msg, Throwable tr)
    {
        println(INFO, tag, msg + '\n' + getStackTraceString(tr));
    }

    /**
     * Send a {@link #WARN} log message.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static void w(String tag, String msg)
    {
        println(WARN, tag, msg);
    }

    /**
     * Send a {@link #WARN} log message and log the exception.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static void w(String tag, String msg, Throwable tr)
    {
        println(WARN, tag, msg + '\n' + getStackTraceString(tr));
    }

    /**
     * Send a {@link #WARN} log message and log the exception.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param tr An exception to log
     */
    public static void w(String tag, Throwable tr)
    {
        println(WARN, tag, getStackTraceString(tr));
    }

    /**
     * Send an {@link #ERROR} log message.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static void e(String tag, String msg)
    {
        println(ERROR, tag, msg);
    }

    /**
     * Send a {@link #ERROR} log message and log the exception.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    public static void e(String tag, String msg, Throwable tr)
    {
        println(ERROR, tag, msg + '\n' + getStackTraceString(tr));
    }

    /**
     * What a Terrible Failure: Report a condition that should never happen.
     *
     * The error will always be logged at level ASSERT with the call stack.
     *
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     */
    public static void wtf(String tag, String msg)
    {
        wtf(tag, msg, null);
    }

    /**
     * What a Terrible Failure: Report an exception that should never happen.
     *
     * Similar to {@link #wtf(String, String)}, with an exception to log.
     *
     * @param tag Used to identify the source of a log message.
     * @param tr An exception to log.
     */
    public static void wtf(String tag, Throwable tr)
    {
        wtf(tag, tr.getMessage(), tr);
    }

    /**
     * What a Terrible Failure: Report an exception that should never happen.
     *
     * Similar to {@link #wtf(String, Throwable)}, with a message as well.
     *
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     * @param tr An exception to log.  May be null.
     */
    public static void wtf(String tag, String msg, Throwable tr)
    {
        TerribleFailure what = new TerribleFailure(msg, tr);
        println(ASSERT, tag, getStackTraceString(tr));
        sWtfHandler.onTerribleFailure(tag, what);
    }

    /**
     * Handy function to get a loggable stack trace from a Throwable.
     *
     * @param tr An exception to log
     */
    public static String getStackTraceString(Throwable tr)
    {
        if (tr == null)
        {
            return "";
        }

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        tr.printStackTrace(pw);

        return sw.toString();
    }

    /**
     * Logging call.
     *
     * @param priority The priority/type of this log message.
     * @param tag      Used to identify the source of a log message. It usually identifies
     *                 the class or activity where the log call occurs.
     * @param msg      The message you would like logged.
     */
    public static void println(int priority, String tag, String msg)
    {
        String priorityString = null;

        switch (priority)
        {
            case VERBOSE:
                priorityString = "VERBOSE";
                break;

            case DEBUG:
                priorityString = "DEBUG";
                break;

            case INFO:
                priorityString = "INFO";
                break;

            case WARN:
                priorityString = "WARN";
                break;

            case ERROR:
                priorityString = "ERROR";
                break;

            case ASSERT:
                priorityString = "ASSERT";
                break;

            default:
                wtf(TAG, new IllegalArgumentException("Invalid priority level!"));
        }

        // Format: "MM-DD HH:MM:SS: PRIORITY/Tag: Message'
        System.out.println(dateFormat.format(Robot.date) + ": " + priorityString + "/" + tag + ": " +  msg);
    }
}
