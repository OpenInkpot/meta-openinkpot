DESCRIPTION = "Implementation of the line breaking algorithm"
SECTION = "base"
DEPENDS = ""
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://LICENCE;md5=3715191da62bafb5cfc4ff36195b2ec3"

SRC_URI = "git://github.com/lunohod/linebreak.git;protocol=git"

SRCREV = ""

S = "${WORKDIR}/git/"

PR = "r1"

inherit autotools gettext
