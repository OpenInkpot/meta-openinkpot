DESCRIPTION = "micro-implementation of hotkeys for X"
SECTION = "x11/application"
DEPENDS = "liblops xcb-util"
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://git.openinkpot.org/uk.git;protocol=git \
			file://x.patch"

SRCREV = ""

S = "${WORKDIR}/git/"

PR = "r1"

inherit autotools gettext

do_install_append() {
	mkdir -p ${D}/etc/X11/Xsession.d
	cp ${S}/debian/50uk ${D}/etc/X11/Xsession.d

	cp ${S}/debian/n516.conf ${D}/etc/uk.conf

#for i in v3 n516 eb600 prs505; do \
#mkdir -p $(CURDIR)/debian/uk-settings-$$i/etc; \
#cp $(CURDIR)/debian/$$i.conf $(CURDIR)/debian/uk-settings-$$i/etc/uk.conf; \
#done
}
