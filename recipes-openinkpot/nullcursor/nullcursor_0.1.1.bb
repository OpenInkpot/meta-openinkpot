DESCRIPTION = "X11 root window cursor nullificator"
SECTION = "base"
DEPENDS = "libxcb xcb-util"
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://git.openinkpot.org/nullcursor.git;protocol=git"

SRCREV = ""

S = "${WORKDIR}/git/"

PR = "r1"

do_install () {
	oe_runmake install DESTDIR=${D} PREFIX=/usr

	install -d ${D}etc/Xsession.d
	install -m 0644 ${S}debian/00nullcursor ${D}etc/Xsession.d/
}

PARALLEL_MAKE = ""

BBCLASSEXTEND = "native"
