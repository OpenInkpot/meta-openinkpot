require core-image-dev.bb
DESCRIPTION = "Image for testing X components' work"
LICENSE = "MIT"

IMAGE_INSTALL_append = " xserver-xorg-fbdev xauth xset xinit xterm xclock xeyes"
IMAGE_INSTALL_append_qemuarm = " oi-default-nulldm-qemuarm"
