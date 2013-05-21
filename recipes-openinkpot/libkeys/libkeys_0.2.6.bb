DESCRIPTION = "This library provides a code for handling keys for OpenInkpot applications"
SECTION = "base"
DEPENDS = "eina efreet evas"
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI = "git://git.openinkpot.org/libkeys.git;protocol=git \
			file://x.patch"

SRCREV = ""

S = "${WORKDIR}/git/"

PR = "r1"

inherit autotools gettext
