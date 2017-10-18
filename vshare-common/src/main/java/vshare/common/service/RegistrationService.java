package vshare.common.service;

import vshare.common.binding.ActionResult;
import vshare.common.binding.RegisterInfo;

public interface RegistrationService {
    ActionResult createAccount(RegisterInfo info);
}
