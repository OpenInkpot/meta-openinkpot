require core-image-wl-dev.bb
DESCRIPTION = "Core OpenInkpot libs, apps & tools"
LICENSE = "MIT"
IMAGE_INSTALL += "liberation-fonts mime-defaults shared-mime-info gm"
PREFERRED_PROVIDER_jpeg = "libjpeg-turbo"
PREFERRED_PROVIDER_jpeg_armv5te = "jpeg"
PREFERRED_PROVIDER_jpeg-native = "libjpeg-turbo-native"
