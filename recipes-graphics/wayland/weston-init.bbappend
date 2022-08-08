# We generally do not want a full desktop environment when running on an embedded system
do_install:append() {
    sed -i -e "/^\[core\]/a shell=kiosk-shell.so" ${D}${sysconfdir}/xdg/weston/weston.ini
}
