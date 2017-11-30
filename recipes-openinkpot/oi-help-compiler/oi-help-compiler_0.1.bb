DESCRIPTION = "Compiler from/to gettext .po format, to internal OI help format"
SECTION = "base"
DEPENDS = "python-babel"
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://github.com/OpenInkpot/oi-help-compiler.git;protocol=git"

SRCREV = "master"

S = "${WORKDIR}/git/"

PR = "r1"

do_install() {
	install -d ${D}${bindir}
	install -m0755 ${S}/oi-help-compiler ${D}${bindir}
}


#PARALLEL_MAKE = ""

BBCLASSEXTEND = "native"
