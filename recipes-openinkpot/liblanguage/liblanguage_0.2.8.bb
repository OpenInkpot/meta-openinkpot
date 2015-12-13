DESCRIPTION = "language setup manipulation library"
SECTION = "base"
DEPENDS = "liblops"
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI = "git://github.com/OpenInkpot/liblanguage.git;protocol=git"

SRCREV = "master"

S = "${WORKDIR}/git/"

PR = "r1"

inherit cmake

# TODO: add separate package with data

FILES_${PN} += "${datadir}/i18n/languages"
