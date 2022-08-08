inherit flutter-app

# i.MX6 SoC's don't support integer division instructions
do_compile:append:mx6-generic-bsp() {
    if ${@bb.utils.contains('FLUTTER_RUNTIME', 'release', 'true', 'false', d)} || \
       ${@bb.utils.contains('FLUTTER_RUNTIME', 'profile', 'true', 'false', d)}; then
        cd ${S}/${FLUTTER_APPLICATION_PATH}

        #
        # Create libapp.so
        #
        ${S}/engine_sdk/sdk/clang_x64/gen_snapshot \
            --snapshot_kind=app-aot-elf \
            --elf=libapp.so \
            --strip \
            --no-use-integer-division \
            .dart_tool/flutter_build/*/app.dill
    fi
}
