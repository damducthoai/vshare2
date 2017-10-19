package vshare.common.service;

import vshare.common.entity.ServerEntity;

import java.util.List;

public interface ServerManager {
    List<ServerEntity> getServers();

    ServerEntity createServer(ServerEntity server);

    ServerEntity getServer(String serverIp);

    ServerEntity updateServer(String serverIp, ServerEntity server);
}
