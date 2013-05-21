DESCRIPTION = "Userspace autosuspend arbiter"
SECTION = "base"
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://git.openinkpot.org/unsuspendd.git \
			file://x.patch"

SRCREV = ""

S = "${WORKDIR}/git/"

PR = "r1"

do_install() {
	oe_runmake install DESTDIR=${D} prefix=/usr

    install -d ${D}var/lib/unsuspendd
    install -d ${D}${sysconfdir}
    install -d ${D}${sysconfdir}/init.d
    install ${S}debian/init.d ${D}${sysconfdir}/init.d/unsuspendd
}


inherit update-rc.d

INITSCRIPT_NAME = "unsuspendd"
INITSCRIPT_PARAMS = "start 50 S . stop 50 0 6 ."
