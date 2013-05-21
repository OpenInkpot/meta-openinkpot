DESCRIPTION = "OpenInkpot firmware file generation tool"
SECTION = "base"
DEPENDS = "python"
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://git.openinkpot.org/mk-oifw.git;protocol=git"

SRCREV = ""

S = "${WORKDIR}/git/"

PR = "r1"

do_install() {
	install -d ${D}${bindir}
	install -m755 ${S}/mk-oifw ${D}${bindir}
}

BBCLASSEXTEND = "native"
