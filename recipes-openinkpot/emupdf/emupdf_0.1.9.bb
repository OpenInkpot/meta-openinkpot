DESCRIPTION = "EFL bindings for mupdf library"
SECTION = "base"
DEPENDS = "evas ecore mupdf"
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "git://git.openinkpot.org/emupdf.git;protocol=git" 

SRCREV = ""

S = "${WORKDIR}/git/"

PR = "r1"

inherit autotools gettext
