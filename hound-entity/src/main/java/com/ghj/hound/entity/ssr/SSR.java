package com.ghj.hound.entity.ssr;

import java.util.List;
import java.util.Map;

public class SSR {
    private String server;

    private String server_ipv6;

    private String local_address;

    private Integer local_port;

    private List<Map> port_password;

    private Integer timeout;

    private String method;

    private String protocol;

    private String protocol_param;

    private String obfs;

    private String obfs_param;

    private String redirect;

    private Boolean dns_ipv6;

    private Boolean fast_open;

    private Integer workers;


    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getServer_ipv6() {
        return server_ipv6;
    }

    public void setServer_ipv6(String server_ipv6) {
        this.server_ipv6 = server_ipv6;
    }

    public String getLocal_address() {
        return local_address;
    }

    public void setLocal_address(String local_address) {
        this.local_address = local_address;
    }

    public Integer getLocal_port() {
        return local_port;
    }

    public void setLocal_port(Integer local_port) {
        this.local_port = local_port;
    }

    public List<Map> getPort_password() {
        return port_password;
    }

    public void setPort_password(List<Map> port_password) {
        this.port_password = port_password;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getProtocol_param() {
        return protocol_param;
    }

    public void setProtocol_param(String protocol_param) {
        this.protocol_param = protocol_param;
    }

    public String getObfs() {
        return obfs;
    }

    public void setObfs(String obfs) {
        this.obfs = obfs;
    }

    public String getObfs_param() {
        return obfs_param;
    }

    public void setObfs_param(String obfs_param) {
        this.obfs_param = obfs_param;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public Boolean getDns_ipv6() {
        return dns_ipv6;
    }

    public void setDns_ipv6(Boolean dns_ipv6) {
        this.dns_ipv6 = dns_ipv6;
    }

    public Boolean getFast_open() {
        return fast_open;
    }

    public void setFast_open(Boolean fast_open) {
        this.fast_open = fast_open;
    }

    public Integer getWorkers() {
        return workers;
    }

    public void setWorkers(Integer workers) {
        this.workers = workers;
    }
}


/*
{
        "server":"0.0.0.0",
        "server_ipv6":"::",
        "local_address":"127.0.0.1",
        "local_port":1080,
        "port_password": {
        "8989": "xx",
        "8990": "xxx"
        },
        "timeout":120,
        "method":"aes-256-cfb",
        "protocol":"origin",
        "protocol_param":"",
        "obfs":"plain",
        "obfs_param":"",
        "redirect":"",
        "dns_ipv6":false,
        "fast_open":true,
        "workers":1
        }*/
