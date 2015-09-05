SUMMARY = "OpenWrt process management daemon"
HOMEPAGE = "https://openwrt.org"
SECTION = "base"
LICENSE = "GPLv2"

S = "${WORKDIR}/git/"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "json-c ubus"
SRC_URI = "git://github.com/OpenInkpot/procd.git;protocol=git \
		file://inittab \
		file://procd.sh \
		file://hotplug.json"

SRCREV = "master"

EXTRA_OECMAKE = " \
	-DCMAKE_INSTALL_PREFIX:PATH=${base_prefix} \
	-DCMAKE_INSTALL_SBINDIR:PATH=${base_sbindir} \
	-DCMAKE_INSTALL_LIBDIR:PATH=${base_libdir} \
	"

inherit cmake

do_install_append() {
	install -d ${D}${sysconfdir}
	install -d ${D}${base_libdir}/functions

	install -m 0644 ${WORKDIR}/inittab ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/hotplug.json ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/procd.sh ${D}${base_libdir}/functions
}

FILES_${PN} = "${sysconfdir} ${base_sbindir} ${base_libdir}"
FILES_${PN}-dev = "${includedir}"
