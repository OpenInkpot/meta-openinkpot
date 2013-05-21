IMAGE_FEATURES_append = " x11 ssh-server-dropbear"

IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL} uuwm fbreader gm locopdf madshelf mupdf uk xserver-nodm-init language-selector liberation-fonts kernel-modules"
PREFERRED_PROVIDER_jpeg = "libjpeg-turbo"
PREFERRED_PROVIDER_jpeg_armv5te = "jpeg"
PREFERRED_PROVIDER_jpeg-native = "libjpeg-turbo-native"
