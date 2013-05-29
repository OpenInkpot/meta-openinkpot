DESCRIPTION = "A collection of tools for internationalizing Python applications"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=8237792789cd839644733545601d9915"
SRCNAME = "Babel"

PR = "r0"

SRC_URI = "http://ftp.edgewall.com/pub/babel/Babel-0.9.6.tar.gz"

SRC_URI[md5sum] = "f0edcad03dfdb5505f337ef1a7690325"
SRC_URI[sha256sum] = "4a3a085ecf1fcd2736573538ffa114f1f4331b3bbbdd69381e6e172c49c9750f"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
