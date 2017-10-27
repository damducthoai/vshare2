package vshare.common.service;

public interface UrlService {
    String getAccessMd5(long expire, String fileName, String ip, String secretString, String originalName);
}
