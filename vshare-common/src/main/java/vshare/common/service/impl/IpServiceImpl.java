package vshare.common.service.impl;

import org.springframework.stereotype.Service;
import vshare.common.service.IpService;

import javax.servlet.http.HttpServletRequest;

@Service("ipService")
public class IpServiceImpl implements IpService {
    @Override
    public String getAccessIp(HttpServletRequest request) {
        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }
}
