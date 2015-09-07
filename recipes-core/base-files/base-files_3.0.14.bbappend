FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://preinit \
	    file://rc.common \
	    file://rc.local \
	    file://functions.sh \
	    file://service.sh \
	    file://usbplug \
	    file://umount \
	    file://usb \
	    file://boot \
	    file://fstab \
	    "

do_install_append () {
	install -d ${D}${sysconfdir}/hotplug.d
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/rc.d
	install -d ${D}${base_libdir}/functions

	install -m 0755 ${WORKDIR}/preinit ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/rc.common ${D}${sysconfdir}
	install -m 0755 ${WORKDIR}/rc.local ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/functions.sh ${D}${base_libdir}
	install -m 0644 ${WORKDIR}/service.sh ${D}${base_libdir}/functions
	install -m 0755 ${WORKDIR}/usbplug ${D}${sysconfdir}/hotplug.d
	install -m 0755 ${WORKDIR}/umount ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/usb ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/boot ${D}${sysconfdir}/init.d
}

#FIXME: move this biolerplate to separate class
pkg_postinst_${PN} () {
	_IDIR=$D/etc/init.d
	export IPKG_INSTROOT=$D
	$SHELL $D/etc/rc.common ${_IDIR}/boot enable
	$SHELL $D/etc/rc.common ${_IDIR}/usb enable
	$SHELL $D/etc/rc.common ${_IDIR}/umount enable
}

pkg_prerm_${PN} () {
	_IDIR=$D/etc/init.d
	export IPKG_INSTROOT=$D
	$SHELL $D/etc/rc.common ${_IDIR}/boot disable
	$SHELL $D/etc/rc.common ${_IDIR}/usb disable
	$SHELL $D/etc/rc.common ${_IDIR}/umount disable
}
