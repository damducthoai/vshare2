package vshare.common.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import vshare.common.service.UrlService;

import java.util.Base64;

@Service("urlService")
public class UrlServiceImpl implements UrlService {

    private final String template = "%d/%s%s %s";

    @Override
    public String getAccessMd5(long expire, String fileName, String ip, String secretString, String originalName) {

        String input = String.format(template, expire, fileName, ip, secretString);
        byte[] md5 = DigestUtils.md5(input);
        byte[] base64 = Base64.getEncoder().encode(md5);
        String output = new String(base64);
        output = output.replaceAll("=", "")
                .replaceAll("[+]", "-")
                .replaceAll("[/]", "_");

        return output;
    }
}
