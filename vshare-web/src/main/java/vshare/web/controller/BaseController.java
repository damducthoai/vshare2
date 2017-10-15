package vshare.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import vshare.common.service.Biz;

@Controller
@CrossOrigin
public class BaseController {
    @Autowired
    protected Biz biz;
}
