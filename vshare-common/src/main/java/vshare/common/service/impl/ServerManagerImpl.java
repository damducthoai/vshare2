package vshare.common.service.impl;

import org.springframework.stereotype.Service;
import vshare.common.entity.ServerEntity;
import vshare.common.repository.FileServerMetaRepository;
import vshare.common.repository.ServerRepository;
import vshare.common.service.SecurityService;
import vshare.common.service.ServerManager;
import vshare.common.service.StorageManager;

import javax.annotation.Resource;
import java.util.List;

@Service("serverManager")
public class ServerManagerImpl implements ServerManager {
    @Resource(name = "securityService")
    SecurityService securityService;
    @Resource(name = "serverRepository")
    ServerRepository serverRepository;
    @Resource(name = "storageManager")
    StorageManager storageManager;

    @Resource(name = "fileServerMetaRepository")
    FileServerMetaRepository fileServerMetaRepository;

    @Override
    public List<ServerEntity> getServers() {
        return serverRepository.findAll();
    }

    @Override
    public ServerEntity createServer(ServerEntity server) {
        ServerEntity res = null;
        if (serverRepository.findOne(server.getServerIp()) == null) {
            serverRepository.save(server);
            res = server;
        }
        return res;
    }

    @Override
    public ServerEntity getServer(String serverIp) {
        ServerEntity server = serverRepository.findOne(serverIp);
        return server;
    }

    @Override
    public ServerEntity updateServer(String serverIp, ServerEntity server) {
        ServerEntity res = null;
        if (serverRepository.findOne(server.getServerIp()) != null && server.getServerIp().equals(serverIp)) {
            serverRepository.save(server);
            res = server;
        }
        return res;
    }

    @Override
    public boolean deleteServer(String ip) {
        if (fileServerMetaRepository.findByServerIp(ip) != null) return false;
        serverRepository.delete(ip);
        return true;
    }
}
