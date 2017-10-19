DESCRIPTION = "Firmware files for use with BCM4343w WIFI and Bluetooth"
S = "${WORKDIR}/git"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=8cba1397cda6386db37210439a0da3eb"

PV = "0.43"
PR = "r1"

PROVIDES += "bcm4343w-fw"

BRANCH = "3.5.5.18"

SRC_URI = "git://github.com/varigit/bcm_4343w_fw.git;protocol=git;branch=${BRANCH}"
SRCREV = "423be46b06b5629e45a4943f98a3053c819091ce"

inherit allarch

do_install() {
	install -d ${D}/lib/firmware/brcm
	install -d ${D}/lib/firmware/bcm
	install -m 0755 ${S}/brcm/* ${D}/lib/firmware/brcm/
	install -m 0755 ${S}/*.hcd ${D}/lib/firmware/bcm
	install -m 0644 ${S}/LICENSE ${D}/lib/firmware/bcm/
	install -m 0644 ${S}/LICENSE ${D}/lib/firmware/brcm/
}

FILES_${PN} =  "/lib/firmware/brcm/*"
FILES_${PN} += "/lib/firmware/bcm/*"

ALTERNATIVE_bcm4343w-fw = "brcmfmac43430-sdio.bin"
ALTERNATIVE_TARGET_bcm4343w-fw[brcmfmac43430-sdio.bin] = "/lib/firmware/brcm/brcmfmac43430-sdio.bin"
#ALTERNATIVE_PRIORITY_bcm4343w-fw[brcmfmac-sdio.bin] = "40"
ALTERNATIVE_bcm4343w-fw = "brcmfmac4339-sdio.bin"
ALTERNATIVE_TARGET_bcm_4343w-fw[brcmfmac4339-sdio.bin] = "/lib/firmware/brcm/brcmfmac4339-sdio.bin"
#ALTERNATIVE_PRIORITY_bcm_4343w_fw[brcmfmac4339-sdio.bin] = "40"
