package com.primogemstudio.live2dbase

import java.io.FilterInputStream
import java.io.IOException
import java.io.InputStream


open class CountingInputStream(`in`: InputStream?) : FilterInputStream(`in`) {
    var count: Long = 0
        private set

    @Throws(IOException::class)
    override fun read(): Int {
        val b = super.read()
        if (b != -1) {
            count++
        }
        return b
    }

    @Throws(IOException::class)
    override fun read(b: ByteArray, off: Int, len: Int): Int {
        val n = super.read(b, off, len)
        if (n != -1) {
            count += n.toLong()
        }
        return n
    }

    @Throws(IOException::class)
    override fun skip(n: Long): Long {
        val skip = super.skip(n)
        count += skip
        return skip
    }
}