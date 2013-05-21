DESCRIPTION = "Clock settings application for OpenInkpot"
SECTION = "x11/apps"
DEPENDS = "evas edje ecore efreet libeoi"
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://git.openinkpot.org/etimetool.git;protocol=git"

SRCREV = ""

S = "${WORKDIR}/git/"

PR = "r1"

FILES_${PN} += " /usr/share"

inherit autotools gettext
