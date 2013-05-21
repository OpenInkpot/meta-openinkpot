inherit kernel
require recipes-kernel/linux/linux-yocto.inc

KBRANCH="e60-3.4.32"
SRC_URI = "git://git.openinkpot.org/linux-2.6.git;protocol=file;branch=${KBRANCH} \
		   file://defconfig"

LINUX_VERSION ?= "3.4.32"
LINUX_VERSION_EXTENSION ?= "-custom"

SRCREV="e6c6b22ab2b6bc70abd30d6365dc60bd04f98afb"

PR = "r1"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "e60"
