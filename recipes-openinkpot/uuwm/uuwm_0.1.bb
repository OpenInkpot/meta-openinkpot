DESCRIPTION = "uuwm - micro-micro window manager"
SECTION = "base"
DEPENDS = "libxcb xcb-util xcb-util-keysyms xcb-util-image xcb-util-renderutil xcb-util-wm"
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=d0ec8f794fa4f6387d321d7cdad70378"

SRC_URI = "git://git.openinkpot.org/uuwm.git;protocol=git \
		   file://0001-Update-to-new-xcb-event.patch"

SRCREV = ""

S = "${WORKDIR}/git/"

PR = "r1"

do_install () {
	oe_runmake install DESTDIR=${D} PREFIX=/usr

	install -d ${D}/etc/Xsession.d
	install -m 0644 ${S}/debian/05uuwm ${D}/etc/Xsession.d/
}

PARALLEL_MAKE = ""

BBCLASSEXTEND = "native"
