require recipes-core/images/core-image-minimal.bb
DESCRIPTION = "Minimal image with handy dev tools"
LICENSE = "MIT"
IMAGE_FEATURES_append = " ssh-server-dropbear debug-tweaks package-management"
IMAGE_INSTALL_append = " strace gdbserver evtest"
IMAGE_ROOTFS_EXTRA_SPACE_qemuarm = "102400"
