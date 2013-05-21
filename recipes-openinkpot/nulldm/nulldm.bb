DESCRIPTION = "trivial X display manager"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
SECTION = "x11"
PR = "r1"

SRC_URI = "file://nulldm"

S = "${WORKDIR}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
    install -d ${D}${sysconfdir}
    install -d ${D}${sysconfdir}/init.d
    install nulldm ${D}${sysconfdir}/init.d
}

inherit update-rc.d

INITSCRIPT_NAME = "nulldm"
INITSCRIPT_PARAMS = "start 9 5 2 . stop 20 0 1 6 ."
