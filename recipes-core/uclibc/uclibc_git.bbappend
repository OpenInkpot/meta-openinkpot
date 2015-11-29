FILESEXTRAPATHS_append := ":${THISDIR}/files"
SRC_URI_append := "file://0001-arm-Fix-POP_RET-for-armv4t-interworking.patch \
		   file://0001-mkostemp-fix-implementation.patch \
		   file://0002-add-mkstemps-mkstemps64-and-mkostemps-mkostemps64-fu.patch \
"
