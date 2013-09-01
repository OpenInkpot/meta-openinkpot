# debug-tweaks -- to set empty root password (remove this from production build)
IMAGE_FEATURES_append = " x11-fbdev ssh-server-dropbear debug-tweaks"

IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL} xserver-xorg oi-hotplug uuwm fbreader gm locopdf mupdf uk nulldm language-selector liberation-fonts kernel-modules"
PREFERRED_PROVIDER_jpeg = "libjpeg-turbo"
PREFERRED_PROVIDER_jpeg_armv5te = "jpeg"
PREFERRED_PROVIDER_jpeg-native = "libjpeg-turbo-native"
