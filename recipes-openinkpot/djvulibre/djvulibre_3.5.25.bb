DESCRIPTION = "Djvu image format library"
SECTION = "base"
DEPENDS = ""
#HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=c93c0550bd3173f4504b2cbd8991e50b"

SRC_URI = "git://git.code.sf.net/p/djvu/djvulibre-git;protocol=git;tag=master"

SRCREV = "9ad44a1813025d288b3e7d17afe6bae32a286439"

EXTRA_OECONF = "--disable-desktopfiles \
				--enable-static \
				--enable-shared \
				--disable-xmltools \
				--disable-djview \
				--disable-i18n"

S = "${WORKDIR}/git/"

PR = "r1"

inherit autotools gettext
