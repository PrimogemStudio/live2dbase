package com.primogemstudio.live2dbase

class MocModel {
    var header = MocHeader()
    var sectionOffset = MocSectionOffset()
    var source = MocModelSource()
}
class MocHeader {
    var version = 0.toByte()
    var endianFlag = 0.toByte()
}

class MocSectionOffset {
    var offset = IntArray(640) { 0 }
}

class MocModelSource {
    var countInfo = CountInfo()
    class CountInfo {
        var data = IntArray(23) { 0 }
    }
}