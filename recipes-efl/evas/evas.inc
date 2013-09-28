PR .= ".1"

DEPENDS += " libxcb xcb-util xcb-util-image xcb-util-renderutil fribidi"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://x.patch \
	    file://soft8_font.patch \
"

EXTRA_OECONF = "    --disable-rpath \
					--disable-doc \
					--enable-fontconfig \
					--enable-fribidi \
					--disable-evas-cserve \
					--enable-buffer=static \
					--disable-software-xlib \
					--disable-gl-xlib \
					--disable-gl-xcb \
					--disable-wayland-shm \
					--disable-wayland-egl \
					--disable-software-xcb \
					--enable-software-8-x11=static \
					--enable-static-software-8 \
					--disable-fb \
					--disable-directfb \
					--disable-software-16-x11 \
					--enable-static-software-generic \
					--disable-image-loader-edb \
					--enable-image-loader-eet=static \
					--disable-font-loader-eet \
					--enable-image-loader-gif \
					--enable-image-loader-jpeg \
					--disable-image-loader-pmaps \
					--enable-image-loader-png=static \
					--disable-image-loader-svg \
					--enable-image-loader-tiff \
					--enable-image-loader-xpm \
					--disable-pthreads \
					--disable-async-events \
					--disable-async-preload \
					--enable-cpu-c \
					--disable-evas-magic-debug \
					--enable-scale-sample \
					--enable-scale-smooth \
					--enable-convert-yuv \
					--disable-small-dither-mask \
					--disable-line-dither-mask \
					--enable-no-dither-mask \
					--disable-convert-8-rgb-332 \
					--disable-convert-8-rgb-666 \
					--disable-convert-8-rgb-232 \
					--disable-convert-8-rgb-222 \
					--disable-convert-8-rgb-221 \
					--disable-convert-8-rgb-121 \
					--disable-convert-8-rgb-111 \
					--disable-convert-16-rgb-565 \
					--disable-convert-16-bgr-565 \
					--disable-convert-16-rgb-555 \
					--disable-convert-16-rgb-444 \
					--disable-convert-16-rgb-ipq \
					--disable-convert-16-rgb-rot-0 \
					--disable-convert-16-rgb-rot-180 \
					--disable-convert-16-rgb-rot-270 \
					--disable-convert-16-rgb-rot-90 \
					--disable-convert-24-rgb-888 \
					--disable-convert-24-bgr-888 \
					--disable-convert-24-rgb-ezx \
					--disable-convert-32-rgb-ezx \
					--disable-convert-32-rgb-8888 \
					--disable-convert-32-rgbx-8888 \
					--disable-convert-32-bgr-8888 \
					--disable-convert-32-bgrx-8888 \
					--disable-convert-32-rgb-rot-0 \
					--disable-convert-32-rgb-rot-180 \
					--disable-convert-32-rgb-rot-270 \
					--disable-convert-32-rgb-rot-90 \
					--disable-convert-8-gry-1 \
					--disable-convert-8-gry-16 \
					--disable-convert-8-grayscale-64 \
					--disable-convert-8-rgb-666 \
					--disable-evas-cserve2 \
					--enable-evas-cserve \
"
