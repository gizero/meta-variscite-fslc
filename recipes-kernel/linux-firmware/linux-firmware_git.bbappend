do_install_append_var-som-mx6() {
	# wl18xx-fw-4.bin from linux-firmware is updated to FW 8.9.0.0.69
	# better using the one from wl18xx-firmware updated to FW 8.9.0.0.70
	rm ${D}/lib/firmware/ti-connectivity/wl18xx-fw-4.bin
}
