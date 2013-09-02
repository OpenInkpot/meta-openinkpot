require core-image-x11-dev.bb
DESCRIPTION = "Core OpenInkpot libs, apps & tools"
LICENSE = "MIT"
IMAGE_INSTALL_append = " oi-hotplug uuwm fbreader gm locopdf mupdf uk nulldm language-selector liberation-fonts kernel-modules"
PREFERRED_PROVIDER_jpeg = "libjpeg-turbo"
PREFERRED_PROVIDER_jpeg_armv5te = "jpeg"
PREFERRED_PROVIDER_jpeg-native = "libjpeg-turbo-native"
