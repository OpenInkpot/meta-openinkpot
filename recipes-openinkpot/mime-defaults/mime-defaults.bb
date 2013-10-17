DESCRIPTION = "Default MIME bindings for OpenInkpot"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
SECTION = "base"
PR = "r1"

SRC_URI = "file://defaults.list"

S = "${WORKDIR}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
    install -d ${D}${datadir}
    install -d ${D}${datadir}/applications
    install defaults.list ${D}${datadir}/applications/
}
