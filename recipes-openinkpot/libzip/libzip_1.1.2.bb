DESCRIPTION = "library for reading, creating, and modifying zip archives"
SECTION = "libs"
HOMEPAGE = "http://www.nih.at/libzip"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=23ebf7ca347ed9703b4ef40824d0ef66"
DEPENDS = "zlib"
PR = "r1"

SRC_URI = "http://www.nih.at/${PN}/${PN}-${PV}.tar.gz"

inherit autotools gettext

SRC_URI[md5sum] = "0820a1ae5733518f5d6e289cb642c08e"
SRC_URI[sha256sum] = "59ac7c09b0aa9aa7e21849c236d0a66a97aa6d442d78335c2fdfe0ee16366221"
