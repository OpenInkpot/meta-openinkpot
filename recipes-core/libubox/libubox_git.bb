SUMMARY = "C utility functions for OpenWrt"
HOMEPAGE = "https://openwrt.org"
SECTION = "libs"
LICENSE = "GPLv2"

S = "${WORKDIR}/git/"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "json-c"
SRC_URI = "git://git.openwrt.org/project/libubox.git;protocol=git"

SRCREV = "master"

EXTRA_OECMAKE = "-DBUILD_LUA=0"

inherit cmake

FILES_${PN} += "${bindir} ${libdir} ${datadir}"
FILES_${PN}-dev = "${includedir}"
