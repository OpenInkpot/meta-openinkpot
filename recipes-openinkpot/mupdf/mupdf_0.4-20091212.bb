DESCRIPTION = "mupdf"
SECTION = "base"
#DEPENDS = "eina evas ecore efreet edje linebreak"
HOMEPAGE = "http://www.openinkpot.org"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://github.com/lunohod/mupdf.git;protocol=git \
			file://x.patch"

SRCREV = ""

S = "${WORKDIR}/git/"

PR = "r1"

inherit autotools gettext

do_compile_prepend() {
	${BUILD_CC} -o mupdf/cmapdump mupdf/cmapdump.c fitz/base_*.c fitz/stm_*.c -Ifitz -lm
	${BUILD_CC} -o mupdf/fontdump mupdf/fontdump.c

# mupdf uses couple of tools for code generation during build process
# so we need to compile them first with host compiler
	#unset CFLAGS LDFLAGS
	#oe_runmake build/release
	#oe_runmake build/release/cmapdump LD=${BUILD_CC} CC=${BUILD_CC}
	#oe_runmake build/release/fontdump LD=${BUILD_CC} CC=${BUILD_CC}

# ...and then we fire 'make', feeding proper
# cross-compilation flags through Makerules file
#	oe_runmake LD="${CC}"
}

#do_install() {
#}

# TODO: add separate package with data
# TODO: save different settings

#FILES_${PN} += " /usr/share"

#FILES_${PN}-dbg += " /usr/lib/gm/configlets/.debug"

PARALLEL_MAKE = ""

BBCLASSEXTEND = "native"
