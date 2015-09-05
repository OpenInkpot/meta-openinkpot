SUMMARY = "OpenWrt micro bus"
HOMEPAGE = "https://openwrt.org"
SECTION = "base"
LICENSE = "GPLv2"

S = "${WORKDIR}/git/"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "json-c libubox"
SRC_URI = "git://git.openwrt.org/project/ubus.git;protocol=git \
	   file://cmake_install.patch"

SRCREV = "master"

EXTRA_OECMAKE = " \
	-DBUILD_LUA=0 \
	-DBUILD_EXAMPLES=0 \
	-DENABLE_SYSTEMD=0 \
	-DCMAKE_INSTALL_BINDIR:PATH=${bindir} \
	-DCMAKE_INSTALL_SBINDIR:PATH=${base_sbindir} \
	-DCMAKE_INSTALL_LIBDIR:PATH=${base_libdir} \
	-DCMAKE_INSTALL_INCLUDEDIR:PATH=${includedir} \
	"

inherit cmake

FILES_${PN} += "${bindir} ${base_libdir} ${base_sbindir}"
FILES_${PN}-dev = "${includedir}"
