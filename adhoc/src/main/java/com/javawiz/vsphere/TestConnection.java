package com.javawiz.vsphere;

public class TestConnection {

    public static void main(String[] args) throws Exception {
        VimAuthenticationHelper vimAuthenticationHelper = new VimAuthenticationHelper();
        vimAuthenticationHelper.loginByUsernameAndPassword("10.254.4.67","qi-readonly@vsphere.local","cpt}bORS1SmIpOI$");
    }
}