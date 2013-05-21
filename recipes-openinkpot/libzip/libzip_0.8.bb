DESCRIPTION = "library for reading, creating, and modifying zip archives"
SECTION = "base"
DEPENDS = ""
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://github.com/lunohod/libzip.git;protocol=git"

SRCREV = ""

S = "${WORKDIR}/git/"

PR = "r1"

inherit autotools gettext
