DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
S = "${WORKDIR}/git/"

inherit kernel

LINUX_VERSION ?= "3.19"
BRANCH="oi-${LINUX_VERSION}"

SRC_URI = "git://github.com/OpenInkpot/linux.git;protocol=git;branch=${BRANCH}"
SRCREV="${BRANCH}"

PR = "r1"
PV = "${LINUX_VERSION}+git${SRCPV}"

do_configure_eb600() {
	oe_runmake -C ${S} eb600_defconfig
}

do_configure_qemuarm() {
	oe_runmake -C ${S} versatile_defconfig
}

PACKAGES =+ "kernel-headers"
FILES_kernel-headers = "${exec_prefix}/src/linux*"
