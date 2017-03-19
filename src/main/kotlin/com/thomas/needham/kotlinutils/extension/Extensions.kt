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

package com.thomas.needham.kotlinutils.extension

/**
 * Object Containing Useful Extension Functions
 */
object Extensions {
    /**
     * Extension method for Double that safely tries to parse a double
     * @param value the value to parse
     * @return true if the parse succeeded false if the parse failed
     */
    fun Double.Companion.TryParse(value : String) : Boolean { // Companion is required to make TryParse Static
        try {
            value.toDouble()
            return true
        } catch (nfe : NumberFormatException) {
            return false
        }
    }
    /**
     * Extension method for Int that safely tries to parse a int
     * @param value the value to parse
     * @return true if the parse succeeded false if the parse failed
     */
    fun Int.Companion.TryParse(value : String) : Boolean {
        try {
            value.toInt()
            return true
        }
        catch (nfe : NumberFormatException){
            return false
        }
    }
    /**
     * Extension method for Long that safely tries to parse a int
     * @param value the value to parse
     * @return true if the parse succeeded false if the parse failed
     */
    fun Long.Companion.TryParse(value : String) : Boolean {
        try{
            value.toLong()
            return true
        }
        catch(nfe : NumberFormatException){
            return false
        }
    }

    /**
     * Extension Function to reverse a strings byte order
     * e.g. "2B00FFEC" becomes "ECFF002B"
     * @return the reversed string
     */
    fun String.reverseString() : String {
        val result = StringBuilder()
        var i = 0
        while (i <= this.length - 2) {
            result.append(StringBuilder(this.substring(i, i + 2)).reverse())
            i += 2
        }
        return result.reverse().toString()
    }
}