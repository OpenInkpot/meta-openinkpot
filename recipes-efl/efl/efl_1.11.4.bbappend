FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"
# filter out x11 libs in favour of wayland
DEPENDS = "virtual/libiconv tslib curl glib-2.0 gnutls pkgconfig zlib jpeg openssl libsndfile1 dbus libexif librsvg freetype libpng tiff fontconfig libfribidi giflib udev efl-native"

SRC_URI += "file://0001-wcore-wayland-fix-screen-size-get.patch"

EXTRA_OECONF_append_class-target = " \
	--disable-fb \
	--disable-sdl \
	--disable-cocoa \
	--disable-drm \
	--disable-drm-hw-accel \
	--disable-egl \
	--with-x11=none \
"
PACKAGECONFIG = "luajit wayland"
PACKAGECONFIG[wayland] = "--enable-wayland,--disable-wayland,wayland"
# fix original bb: luajit must be in RDEPENDS as well, otherwise not installed
PACKAGECONFIG[luajit] = "--disable-lua-old,--enable-lua-old,luajit,luajit"

# filter out ecore-x as no X support included
RDEPENDS_ecore = "ecore-audio ecore-input-evas ecore-input ecore-imf-evas ecore-imf ecore-file ecore-con ecore-ipc ecore-evas"
