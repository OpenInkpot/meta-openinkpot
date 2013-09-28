# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS += " libxcb xcb-util xcb-util-image xcb-util-keysyms xcb-util-renderutil xcb-util-wm"

PR .= ".1"

SRC_URI += "file://x.patch \
	    file://fix_atoms_count.patch \
"

do_compile_prepend() {
	oe_runmake CC="${BUILD_CC}" CCLD="${BUILD_CCLD}" LDFLAGS="${BUILD_LDFLAGS}" -C ${S}/src/util
}

ECORE_OECONF = "\
  --enable-ecore-evas-software-8-x11 \
  --enable-ecore-x-xcb \
"
