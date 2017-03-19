/*
    The MIT License (MIT)

    ${PROJECT_NAME} Copyright (c) ${YEAR} ${USER}

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
*/

package com.thomas.needham.kotlinutils.files

import java.io.*

/**
 * Object containing utility functions to be used with file objects
 */
object Files {
    /**
     * Returns a binary files contents
     * @param path the path of the file to return
     * @return The Contents of the file
     * @throws IOException
     */
    @Throws(IOException::class)
    @JvmStatic fun fileToString(path : String) : String {
        val builder = StringBuilder()
        val reader = BufferedReader(FileReader(path))

        var line : String?

        line = reader.readLine()
        while (line != null) {
            builder.append(line).append('\n')
            line = reader.readLine()
        }

        reader.close()

        return builder.toString()
    }

    /**
     * Returns a text files contents
     * @param path the path of the file to return
     * @return The Contents of the file
     * @throws IOException
     * @throws FileNotFoundException
     */
    @Throws(IOException::class, FileNotFoundException::class)
    fun ReadAllText(file : File) : String {
        if (file.isDirectory || !file.canRead()) {
            throw FileNotFoundException("Invalid File: ${file.path}")
        }
        val fr : FileReader = FileReader(file)
        val br : BufferedReader = BufferedReader(fr)
        val contents = br.readText()
        if (contents.isNullOrBlank() || contents.isNullOrEmpty())
            println("File is Empty: ${file.path}")
        br.close()
        fr.close()
        return contents
    }

}