do_install_append() {
	install -d ${D}${base_sbindir}
	ln -s ../init ${D}${base_sbindir}/init
}
FILES_${PN} += " ${base_sbindir}/init"
