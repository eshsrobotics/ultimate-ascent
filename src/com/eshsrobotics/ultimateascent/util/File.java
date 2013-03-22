package com.eshsrobotics.ultimateascent.util;

import com.sun.squawk.microedition.io.FileConnection;

import javax.microedition.io.Connector;
import java.io.IOException;
import java.io.OutputStream;

/**
 * A file to write data to.
 */
public class File
{
    public final String TAG = "File";

    private String fileName;
    private FileConnection fileConnection;
    private OutputStream outputStream;

    /**
     * Instantiates a new file.
     *
     * @param fileName Name of the file to use. Ex. myfile.txt
     * @param createFile Whether a file should be created with the
     *                   given name if it doesn't already exist.
     */
    public File(String fileName, boolean createFile)
    {
        try
        {
            fileConnection = (FileConnection) Connector.open(fileName, Connector.READ_WRITE);

            if (!fileConnection.exists() && createFile)
            {
                fileConnection.create();
            }

            outputStream = fileConnection.openOutputStream();
        }
        catch(IOException e)
        {
            Log.wtf(TAG, e);
        }
        catch(SecurityException e)
        {
            Log.wtf(TAG, e);
        }
    }

    /**
     * Write a string to the file. Default charset is UTF-8.
     *
     * @param string The string to write.
     */
    public void write(String string)
    {
        if(fileConnection == null)
        {
            Log.e(TAG, "File connection not opened!");
        }
        else if(outputStream == null)
        {
            Log.e(TAG, "Output stream not opened!");
        }
        else
        {
            try
            {
                outputStream.write(string.getBytes("UTF-8"));
            }
            catch(IOException e)
            {
                Log.e(TAG, "Error writing string to file!");
            }
        }
    }

    /**
     * Closes the output stream and file connection.
     */
    public void close()
    {
        try
        {
            outputStream.close();
            fileConnection.close();
        }
        catch(IOException e)
        {
            Log.wtf(TAG, e);
        }
    }
}
