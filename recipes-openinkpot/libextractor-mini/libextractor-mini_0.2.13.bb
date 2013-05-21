DESCRIPTION = "Minimalistic metadata extractor"
SECTION = "base"
DEPENDS = "mupdf libzip libid3tag tremor"
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "git://git.openinkpot.org/libextractor-mini.git;protocol=git \
			file://x.patch"

SRCREV = ""

S = "${WORKDIR}/git/"

PR = "r1"

inherit autotools gettext

do_install_append() {
	rm ${D}/usr/lib/extractor-mini/libextractor_fb2_zip.so
}

pkg_postinst_${PN}() {
#!/bin/sh -e

ln -sf /usr/lib/extractor-mini/libextractor_fb2.so /usr/lib/extractor-mini/libextractor_fb2_zip.so
}

FILES_${PN} += " /usr/lib/extractor-mini/libextractor_*.so"
