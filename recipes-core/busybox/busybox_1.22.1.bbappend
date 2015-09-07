FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

#FIXME: move this biolerplate to separate class
pkg_postinst_${PN}-syslog_append () {
	_IDIR=$D/etc/init.d
	export IPKG_INSTROOT=$D
	$SHELL $D/etc/rc.common ${_IDIR}/syslog enable
}

pkg_prerm_${PN}-syslog_append () {
	_IDIR=$D/etc/init.d
	export IPKG_INSTROOT=$D
	$SHELL $D/etc/rc.common ${_IDIR}/syslog disable
}

do_install_append() {
	# won't get installed if sysvinit disabled
	install -m 0644 ${WORKDIR}/syslog-startup.conf ${D}${sysconfdir}/syslog-startup.conf

	# HACK: proper name to be able to enable it in pkg_preinst
	mv ${D}${sysconfdir}/init.d/syslog.busybox \
		${D}${sysconfdir}/init.d/syslog
}
