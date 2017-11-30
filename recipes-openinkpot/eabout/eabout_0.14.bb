DESCRIPTION = "About dialog"
SECTION = "x11/apps"
DEPENDS = "evas edje ecore efreet liblops libeoi libkeys oi-help-compiler-native"
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://github.com/OpenInkpot/eabout.git;protocol=git"

SRCREV = "master"

S = "${WORKDIR}/git/"

PR = "r1"

inherit pythonnative

do_install_append() {
	install -d ${D}/etc
	install -m644 ${S}vendors/n516.conf ${D}/etc/eabout.conf
}

FILES_${PN} += " /usr/share"

inherit autotools gettext
