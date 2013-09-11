# make_logdir hack supposed to create /var/log,
# because for some reason it's not done for kdrive and fails installation
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://make_logdir.patch"

RDEPENDS_${PN}-fbdev += "xkeyboard-config x11-common"
EXTRA_OECONF += "--disable-xorg \
		--enable-kdrive \
		--enable-kdrive-evdev \
"
