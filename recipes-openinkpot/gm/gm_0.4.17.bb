DESCRIPTION = "Global Menu"
SECTION = "x11/application"
DEPENDS = "ecore evas edje efreet liblanguage liblops libkeys libeoi xcb-util-wm"
RDEPENDS_${PN} = "eabout madshelf"
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "git://git.openinkpot.org/gm.git;protocol=git \
			file://x.patch \
			file://scalable_theme.patch \
			file://native_x_size.patch \
"

SRCREV = ""

S = "${WORKDIR}/git/"

PR = "r1"

inherit autotools gettext

do_install_append() {
	install -d -m 755  ${D}/etc/X11/Xsession.d
		install -m 755 ${S}/debian/Xsession ${D}/etc/X11/Xsession.d/90gm
		install -m 755 ${S}/debian/cur-user ${D}/etc/X11/Xsession.d/08cur-user
		mkdir -p ${D}/usr/share/keys/help
		install -m 644 ${S}/gm_help.ini ${D}/usr/share/keys/help/gm.ini
		cp -a ${S}/help ${D}/usr/share

		mkdir -p ${D}/var/lib/gm

		rm -f ${D}/usr/lib/gm/configlets/*.a
}

# TODO: add separate package with data

FILES_${PN} += " /usr/share/help /usr/share/keys /usr/share/eoi /var/lib/gm"

FILES_${PN}-dbg += " /usr/lib/gm/configlets/.debug"
