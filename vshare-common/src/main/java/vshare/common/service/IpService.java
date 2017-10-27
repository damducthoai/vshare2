package vshare.common.service;

import javax.servlet.http.HttpServletRequest;

public interface IpService {
    String getAccessIp(HttpServletRequest request);
}
