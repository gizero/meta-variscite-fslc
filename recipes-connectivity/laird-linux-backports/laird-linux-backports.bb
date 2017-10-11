DESCRIPTION = "Laird compat-wireless drivers for brcmfmac"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

PV = "3.5.5.8"
inherit module

SRCREV = "e82ec335896e1becca0ce9d0d2a4dedc9106216b"
BRANCH = "${PV}"

SRC_URI = "git://github.com/varigit/laird-linux-backports.git;protocol=git;branch=${BRANCH} \
	   file://0001-Makefile.real-skip-the-depmod-magic.patch"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "KLIB_BUILD=${STAGING_KERNEL_BUILDDIR} KLIB=${D}"

do_configure() {
    oe_runmake 'CC=${BUILD_CC}' defconfig-lwb-fcc-var
}

RDEPENDS_${PN} = "wireless-tools"
