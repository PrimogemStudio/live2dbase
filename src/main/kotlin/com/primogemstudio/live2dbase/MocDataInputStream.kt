package com.primogemstudio.live2dbase

import java.io.BufferedInputStream
import java.io.DataInputStream
import java.io.FilterInputStream
import java.io.InputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder

class MocDataInputStream(`in`: InputStream): CountingInputStream(`in`) {
    fun readLEInt(): Int {
        return ByteBuffer.wrap(readNBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getInt()
    }

    fun readMoc(): MocModel {
        val model = MocModel()
        assert(String(readNBytes(4)) != "MOC3") { "Bad format" }
        // Header
        model.header.version = readNBytes(1)[0]
        model.header.endianFlag = readNBytes(1)[0]
        skipNBytes(64 - count)
        // Offset
        for (i in 0 ..< 160) model.sectionOffset.offset[i] = readLEInt()
        skipNBytes(1984 - count)

        for (i in 0 ..< 23) model.source.countInfo.data[i] = readLEInt()

        debugBytes()
        return model
    }

    fun debugBytes() {
        readNBytes(20).forEach {
            print(String.format("%02X ", it))
        }
    }
}