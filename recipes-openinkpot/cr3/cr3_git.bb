SUMMARY = "Cross-platform XML/CSS based eBook reader"
SECTION = "x11/application"
LICENSE = "GPLv2"

S = "${WORKDIR}/git/"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "wayland"
RDEPENDS_${PN} = "weston"
SRC_URI = "git://github.com/OpenInkpot/cr3.git;protocol=git"

SRCREV = "master"

EXTRA_OECMAKE = " \
	-DMAX_IMAGE_SCALE_MUL=2 \
	-DCMAKE_BUILD_TYPE=Release \
	-DGUI=CRGUI_WL \
	-DUSE_EXTERNAL_EDICT_DICTIONARY=1 \
	"

inherit cmake
