require core-image-dev.bb
DESCRIPTION = "Image for testing X components' work"
LICENSE = "MIT"
IMAGE_FEATURES_append = " x11-fbdev"

IMAGE_INSTALL_append = " xserver-xorg xauth xset xinit xterm xclock xeyes"
IMAGE_INSTALL_append_qemuarm = " oi-default-nulldm-qemuarm"
