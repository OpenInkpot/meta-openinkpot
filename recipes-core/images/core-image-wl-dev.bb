require core-image-dev.bb
DESCRIPTION = "Image for testing Wayland components' work"
LICENSE = "MIT"

IMAGE_INSTALL_append = " weston"
