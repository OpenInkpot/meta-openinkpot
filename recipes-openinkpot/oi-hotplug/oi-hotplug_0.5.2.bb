DESCRIPTION = "OpenInkpot hotplugging infrastructure. Contains scripts which control hotplugging for OpenInkpot"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
RDEPENDS_${PN} = "busybox-mdev unsuspendd"
SRC_URI = "git://git.openinkpot.org/oi-hotplug.git"
SRCREV="zelazny/0.5.2"

S = "${WORKDIR}/git/"

do_install() {
    install -d ${D}/sbin
    install -d ${D}/etc/default
    install -d ${D}/etc/mdev.conf.d
    install -d ${D}/lib/mdev/handlers.d

    install ${S}/50automount ${D}/etc/mdev.conf.d
    install ${S}/mdev ${D}/etc/default
    install ${S}/oi-hotplug.sh ${D}/sbin/
    install ${S}/automount ${D}/lib/mdev
    install ${S}/01power-supply ${D}/lib/mdev/handlers.d
    install ${S}/02power-supply-signal ${D}/lib/mdev/handlers.d
}

FILES_${PN} = "${base_sbindir} ${base_libdir} ${sysconfdir}"
