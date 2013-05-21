DESCRIPTION = "FBReader"
SECTION = "x11/application"
#DEPENDS = "expat libjpeg libpng libgif eina evas ecore efreet edje glib2.0 pango1.0 liblinebreak fribidi xcb xcb-util xcb-util-wm sqlite3"
DEPENDS = "eina evas ecore efreet edje linebreak libeoi"
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://git.openinkpot.org/fbreader.git;protocol=git \
			file://x.patch"

SRCREV = ""

S = "${WORKDIR}/git/"

PR = "r1"

do_compile() {
	oe_runmake -C zlibrary/core ROOTDIR=${S} TARGET_ARCH=desktop UI_TYPE=ewl
	oe_runmake -C zlibrary/text ROOTDIR=${S} TARGET_ARCH=desktop UI_TYPE=ewl
	oe_runmake -C zlibrary/ui ROOTDIR=${S} TARGET_ARCH=desktop UI_TYPE=ewl
	oe_runmake -C fbreader ROOTDIR=${S} TARGET_ARCH=desktop UI_TYPE=ewl LD="${CXX}"
	oe_runmake -C po ROOTDIR=${S} TARGET_ARCH=desktop UI_TYPE=ewl
}

do_install() {
	oe_runmake -C zlibrary/core ROOTDIR=${S} TARGET_ARCH=desktop UI_TYPE=ewl DESTDIR=${D} do_install
	oe_runmake -C zlibrary/text ROOTDIR=${S} TARGET_ARCH=desktop UI_TYPE=ewl DESTDIR=${D} do_install
	oe_runmake -C zlibrary/ui ROOTDIR=${S} TARGET_ARCH=desktop UI_TYPE=ewl DESTDIR=${D} do_install
	oe_runmake -C fbreader ROOTDIR=${S} TARGET_ARCH=desktop UI_TYPE=ewl DESTDIR=${D} do_install
	oe_runmake -C po ROOTDIR=${S} TARGET_ARCH=desktop UI_TYPE=ewl DEST_DIR=${D} do_install
	oe_runmake -C themes/default
	oe_runmake -C themes/azbooka

	install -D -m 644 fbreader/desktop/desktop ${D}/usr/share/applications/FBReader.desktop
	mkdir -p ${D}/usr/share/eoi/themes/default
	install -m 644 themes/default/fbreader.edj ${D}/usr/share/eoi/themes/default
	install -m 644 themes/default/fbreader_messagebox.edj ${D}/usr/share/eoi/themes/default
	install -m 644 themes/default/fbreader_entrybox.edj ${D}/usr/share/eoi/themes/default
	mkdir -p ${D}/usr/share/eoi/themes/azbooka
	install -m 644 themes/azbooka/fbreader.edj \
		themes/azbooka/fbreader_messagebox.edj \
		themes/azbooka/fbreader_entrybox.edj \
		${D}/usr/share/eoi/themes/azbooka
	mkdir -p ${D}/usr/share/keys/help
	install -m 644 fbreader_help.ini ${D}/usr/share/keys/help/fbreader.ini

	mkdir -p ${D}/usr/share/help/fbreader

	# TODO: add oi-help-compiler
	#oi-help-compiler -u help ${DEB_DIR}/fbreader/usr/share/help/fbreader
	for FLAVOUR in n516; do \
		DEFAULT_DIR=${D}/usr/share/FBReader/default; \
			mkdir -p $DEFAULT_DIR; \
			install -m 0644 fbreader/data/default/config.$FLAVOUR.xml $DEFAULT_DIR/config.xml; \
			install -m 0644 fbreader/data/default/keymap.$FLAVOUR.xml $DEFAULT_DIR/keymap.xml; \
			install -m 0644 fbreader/data/default/styles.$FLAVOUR.xml $DEFAULT_DIR/styles.xml; \
			install -m 0644 fbreader/data/default/external.$FLAVOUR.xml $DEFAULT_DIR/external.xml; \
			sed -e 's/_("\(.*\)")/\1/' fbreader/data/default/keydefs.$FLAVOUR.tmpl > $DEFAULT_DIR/keydefs.ini; \
	done
}

# TODO: add separate package with data
# TODO: save different settings

FILES_${PN} += " /usr/share"

#FILES_${PN}-dbg += " /usr/lib/gm/configlets/.debug"

PARALLEL_MAKE = ""

BBCLASSEXTEND = "native"
