DESCRIPTION = "autosuspend enabler"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
SECTION = "base"
PR = "r1"

SRC_URI = "file://autosuspend-support \
			file://default"

S = "${WORKDIR}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
    install -d ${D}${sysconfdir}
    install -d ${D}${sysconfdir}/init.d
    install autosuspend-support ${D}${sysconfdir}/init.d
    install -d ${D}${sysconfdir}/default
    install default ${D}${sysconfdir}/default/autosuspend-support
}

inherit update-rc.d

INITSCRIPT_NAME = "autosuspend-support"
INITSCRIPT_PARAMS = "start 03 S . stop 01 0 6 ."
