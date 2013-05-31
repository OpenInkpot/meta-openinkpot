# make_logdir hack supposed to create /var/log,
# because for some reason it's not done for kdrive and fails installation
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://make_logdir.patch"

PACKAGECONFIG ??= "x11-fbdev"
PACKAGECONFIG[x11-fbdev] = "--disable-xorg --enable-kdrive --enable-kdrive-evdev,,,xserver-xorg-fbdev xkeyboard-config x11-common"
