require oi-default-nulldm.inc
DESCRIPTION = "X server settings for qemuarm"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
SECTION = "x11"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
	install -d ${D}/etc/default
	echo "SERVER_ARGS=\""${OI_NULLDM_SERVER_ARGS} "-screen 640x480x8/8 -nocursor -render gray\"" > ${D}/etc/default/nulldm
}

FILES_${PN} = "/etc/default"
