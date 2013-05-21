inherit kernel
require recipes-kernel/linux/linux-yocto.inc

KBRANCH="master"
SRC_URI = "git://git.openinkpot.org/linux-2.6.git;protocol=file;branch=${KBRANCH} \
		   file://defconfig"

LINUX_VERSION ?= "2.6.37"
LINUX_VERSION_EXTENSION ?= "-custom"

SRCREV="a6cd0b6b94e746f28452c0819bd5b8c8902163c0"

PR = "r1"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "eb600"
