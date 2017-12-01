DESCRIPTION = "Global Menu"
SECTION = "x11/application"
DEPENDS = "ecore evas edje efreet liblanguage liblops libkeys libeoi"
RDEPENDS_${PN} = "eabout madshelf"
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "git://github.com/OpenInkpot/gm.git;protocol=git \
	   file://globalmenu \
"

SRCREV = "master"

S = "${WORKDIR}/git/"

PR = "r1"

inherit autotools gettext

do_install_append() {
	install -d ${D}/${sysconfdir}/init.d
	install -d ${D}/${datadir}/keys/help
	install -d ${D}/${datadir}/help/gm
	install ${WORKDIR}/globalmenu ${D}/${sysconfdir}/init.d
	install -m 644 ${S}/gm_help.ini ${D}/${datadir}/keys/help/gm.ini
	cp -a ${S}/help/gm/* ${D}/${datadir}/help/gm

	#TODO: handle this in makefiles
	rm -f ${D}/usr/lib/gm/configlets/*.a
}

#FIXME: move this biolerplate to separate class
pkg_postinst_${PN} () {
	_IDIR=$D/etc/init.d
	export IPKG_INSTROOT=$D
	$SHELL $D/etc/rc.common ${_IDIR}/globalmenu enable
}

pkg_prerm_${PN} () {
	_IDIR=$D/etc/init.d
	export IPKG_INSTROOT=$D
	$SHELL $D/etc/rc.common ${_IDIR}/globalmenu disable
}

# TODO: add separate package with data
FILES_${PN} += "${datadir} ${sysconfdir}"
FILES_${PN}-dbg += "${libdir}/gm/configlets/.debug"
