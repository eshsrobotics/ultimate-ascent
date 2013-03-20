package com.eshsrobotics.ultimateascent.util;

/**
 * Simple interface for printing text, allowing redirection to various
 * targets.
 */
public interface Printer
{
    /**
     * Write a line of text to the output. There is no need to terminate
     * the given string with a newline.
     */
    void println(String x);
}
