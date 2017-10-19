package vshare.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vshare.common.entity.ServerEntity;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "servers")
public class ServerController extends BaseController {
    @GetMapping
    String getServerList(Model model) {
        model.addAttribute("servers", getServers());
        model.addAttribute("server", new ServerEntity());
        model.addAttribute("action", "Create Server");
        model.addAttribute("formId", "createServerForm");
        return "server";
    }

    @GetMapping("{serverIp}")
    String getServerInfo(Model model, @PathVariable String serverIp) {
        model.addAttribute("server", getServer(serverIp));
        model.addAttribute("action", "Update Server");
        model.addAttribute("formId", "updateServerForm");
        model.addAttribute("serverIp", serverIp);
        return "update_server";
    }

    @PostMapping
    @ResponseBody
    ResponseEntity<ServerEntity> createServer(@Valid @ModelAttribute("server") ServerEntity server, BindingResult result) {
        ResponseEntity<ServerEntity> res = new ResponseEntity<ServerEntity>(HttpStatus.OK);
        if (result.hasErrors()) {
            res = new ResponseEntity<ServerEntity>(HttpStatus.BAD_REQUEST);
        } else {
            server.setServerUseableSize(server.getServerSize());
            ServerEntity createdServer = createServer(server);
            if (createdServer == null) {
                res = new ResponseEntity<ServerEntity>(HttpStatus.BAD_REQUEST);
            }
        }
        return res;
    }

    @PostMapping("{serverIp}")
    @ResponseBody
    ResponseEntity<ServerEntity> updateServer(@Valid @ModelAttribute("server") ServerEntity server, BindingResult result, @PathVariable String serverIp) {
        ResponseEntity<ServerEntity> res = new ResponseEntity<ServerEntity>(HttpStatus.OK);
        if (result.hasErrors()) {
            res = new ResponseEntity<ServerEntity>(HttpStatus.BAD_REQUEST);
        } else {
            server.setServerUseableSize(server.getServerSize());
            ServerEntity updatedServer = updateServer(serverIp, server);
            if (updatedServer == null) {
                res = new ResponseEntity<ServerEntity>(HttpStatus.BAD_REQUEST);
            }
        }
        return res;
    }
}
