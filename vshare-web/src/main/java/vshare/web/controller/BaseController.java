package vshare.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import vshare.common.service.Biz;

@Controller
public class BaseController {
    @Autowired
    protected Biz biz;
}
