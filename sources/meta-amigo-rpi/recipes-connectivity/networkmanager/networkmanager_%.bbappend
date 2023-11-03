SUMMARY = "Add wi-fi config to networkmanager"
DESCRIPTION = "Add wi-fi config to networkmanager"
LICENSE = "MIT"

SRC_URI:append = " \
	file://Amigo.nmconnection \
    "

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
FILES:${PN} += " \
    ${sysconfdir}/NetworkManager/* \
    "

do_install:append() {
    install -d ${D}${sysconfdir}/NetworkManager/system-connections
    install -m 0600 ${WORKDIR}/Amigo.nmconnection  ${D}${sysconfdir}/NetworkManager/system-connections/Amigo.nmconnection
}