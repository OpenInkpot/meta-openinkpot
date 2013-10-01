DESCRIPTION = "language setup manipulation library"
SECTION = "base"
DEPENDS = "liblops"
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI = "git://git.openinkpot.org/liblanguage.git;protocol=git \
		file://use_datapath.patch \
"

SRCREV = ""

S = "${WORKDIR}/git/"

PR = "r1"

inherit autotools gettext

# TODO: add separate package with data

FILES_${PN} += " /usr/share/i18n/languages/*"
