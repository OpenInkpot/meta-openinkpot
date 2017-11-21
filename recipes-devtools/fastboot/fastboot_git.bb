DESCRIPTION = "Utility for flashing Kindle devices"
SECTION = "console/utils"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-2-Clause;md5=8bef8e6712b1be5aa76af1ebde9d6378"

SRC_URI = "git://github.com/OpenInkpot/Fastboot-Kindle.git;protocol=git"
SRCREV = "master"
S = "${WORKDIR}/git/"

do_install_class-native() {
	install -d ${D}${bindir}
	install -m0755 ${S}/fastboot ${D}${bindir}
}

BBCLASSEXTEND = "native nativesdk"
