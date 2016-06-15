# filter out virtual/egl from deps, as fbdev backend doesn't need one
DEPENDS = "libxkbcommon gdk-pixbuf pixman cairo glib-2.0 jpeg wayland pango"
S = "${WORKDIR}/git/"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append = "file://weston.ini \
		  file://compositor \
		  file://weston \
		  file://rgb8_hack.patch \
		  file://panel-location.patch \
		  git://github.com/OpenInkpot/weston.git;branch=oi-1.5 \
"

SRCREV = "oi-1.5"

EXTRA_OECONF_append = "--disable-desktop-shell \
		       --disable-fullscreen-shell \
		       --enable-eink-shell \
		      "

do_install_append() {
	install -d ${D}/${sysconfdir}/init.d
	install -d ${D}/${sysconfdir}/profile.d
	install -d ${D}/${sysconfdir}/xdg/weston
	install ${WORKDIR}/weston.ini ${D}/${sysconfdir}/xdg/weston
	install ${WORKDIR}/compositor ${D}/${sysconfdir}/init.d
	install ${WORKDIR}/weston ${D}/${sysconfdir}/profile.d
}

#FIXME: move this biolerplate to separate class
pkg_postinst_${PN} () {
	_IDIR=$D/etc/init.d
	export IPKG_INSTROOT=$D
	$SHELL $D/etc/rc.common ${_IDIR}/compositor enable
}

pkg_prerm_${PN} () {
	_IDIR=$D/etc/init.d
	export IPKG_INSTROOT=$D
	$SHELL $D/etc/rc.common ${_IDIR}/compositor disable
}

FILES_${PN} += "${sysconfdir}"
