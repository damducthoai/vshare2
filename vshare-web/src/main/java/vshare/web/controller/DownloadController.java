package vshare.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vshare.common.binding.DownloadRole;
import vshare.common.entity.FileEntity;
import vshare.common.entity.FileServerMetaEntity;
import vshare.common.repository.FileServerMetaRepository;
import vshare.common.repository.ServerRepository;
import vshare.common.service.FileManager;
import vshare.common.service.IpService;
import vshare.common.service.UrlService;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
@RequestMapping(path = "download")
public class DownloadController extends BaseController {

    private final String TEMPLATE = "http://%s.%s/%s?md5=%s&expires=%s&title=%s";

    @Autowired
    IpService ipService;

    @Autowired
    UrlService urlService;

    @Autowired
    FileManager fileManager;

    @Autowired
    FileServerMetaRepository fileServerMetaRepository;

    @Autowired
    ServerRepository serverRepository;

    @PostMapping
    public String download(HttpServletRequest request, @RequestParam("filePhysicalName") String physicalName) {
        String res = null;
        String accessMd5 = null;
        String ip = "";
        DownloadRole role;

        String accessUrl = "";

        FileEntity file = getFile(physicalName);
        if (file == null) {
            res = "/404";
        } else {
            role = fileManager.getDownloadRole();
            Calendar cal = Calendar.getInstance();
            long expire = System.currentTimeMillis() + (2 * 3600000);
            ip = ipService.getAccessIp(request);


            FileServerMetaEntity metaEntity = fileServerMetaRepository.findByFileId(file.getFileId());

            String alias = serverRepository.findOne(metaEntity.getServerIp()).getServerAlias();

            if (role == DownloadRole.VIP) {
                accessMd5 = urlService.getAccessMd5(expire, file.getFilePhysicalName(), ip, "node1", file.getFileOriginalName());
                accessUrl = String.format(TEMPLATE, "node1", alias, file.getFilePhysicalName(), accessMd5, expire, file.getFileOriginalName());
            } else {
                accessMd5 = urlService.getAccessMd5(expire, file.getFilePhysicalName(), ip, "node2", file.getFileOriginalName());
                accessUrl = String.format(TEMPLATE, "node2", alias, file.getFilePhysicalName(), accessMd5, expire, file.getFileOriginalName());
            }
            res = accessUrl;
        }
        return "redirect:" + res;
    }
}
