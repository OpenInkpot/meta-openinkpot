DESCRIPTION = "OpenInkpot-specific extensions for EFL libraries"
SECTION = "base"
DEPENDS = "evas edje efreet libkeys edje-native"
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI = "git://git.openinkpot.org/libeoi.git;protocol=git \
			file://x.patch"

SRCREV = ""

S = "${WORKDIR}/git/"

PR = "r1"

inherit autotools gettext

do_install_append() {
# TODO: package settings for other devices
	install -d ${D}/etc/eoi
	install -m 0644 ${S}/debian/choicebox-numbering-n516.ini ${D}/etc/eoi/choicebox-numbering.ini

	install -d ${D}/usr/share/keys
	install -m 0644 ${S}/debian/choicebox-n516.ini ${D}/usr/share/keys/choicebox.ini
	install -m 0644 ${S}/debian/evk.n516.ini ${D}/usr/share/keys/evk.ini
}

#PACKAGES += "${PN}-settings-n516 ${PN}-settings-v3 ${PN}-settings-azbooka ${PN}-settings-eb600 ${PN}-settings-prs505" 
#FILES_${PN}-settings-n516 = "/usr/share/keys/choicebox.ini /usr/share/keys/evk.ini /etc/eoi/choicebox-numbering.ini"

FILES_${PN} += " /usr/share/keys/* /usr/share/eoi/themes/*/*"
