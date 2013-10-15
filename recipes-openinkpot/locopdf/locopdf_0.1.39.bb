DESCRIPTION = "pdf/djvu reader"
SECTION = "x11/application"
DEPENDS = "oi-help-compiler-native"
RDEPENDS_${PN} = "ecore evas edje emupdf edjvu libeoi libkeys"
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI = "git://git.openinkpot.org/locopdf.git;protocol=git \
			file://x.patch \
			file://native_x_size.patch \
"

SRCREV = ""

S = "${WORKDIR}/git/"

PR = "r1"

inherit autotools gettext pythonnative

do_install_append() {
	mkdir -p ${D}/etc/keys
	install -m 0644 ${S}/debian/n516.ini ${D}/etc/keys/locopdf.ini

	#	mkdir -p $(CURDIR)/debian/locopdf-settings-prs505/etc/keys
	#	install -m 0644 $(CURDIR)/debian/prs505.ini $(CURDIR)/debian/locopdf-settings-prs505/etc/keys/locopdf.ini
}

# TODO: add separate package with data

FILES_${PN} += " /etc/keys /usr/share"
