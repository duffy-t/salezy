package com.arkinfosys.salezy.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arkinfosys.salezy.common.system.RequestContext;
import com.arkinfosys.salezy.domain.user.UserInfo;
import com.arkinfosys.salezy.service.system.SetupService;

/**
 * セットアップコントローラクラス.
 */
@RestController
public class SetupController {
    /** セットアップユーザID. */
    private static final String SETUP_USER_ID = "setup";

    /** セットアップサービス. */
    @Autowired
    private SetupService setupService;

    @CrossOrigin
    @GetMapping(value="/salezy/setup")
    public String execute(@RequestParam(name = "passwd", defaultValue = "") String passwd) {
        // 仮ユーザでセットアップする
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(SETUP_USER_ID);

        try (RequestContext context = new RequestContext(userInfo)) {
            setupService.execute();

            return "OK";

        } catch (Exception e) {
            e.printStackTrace();
            return "NG";
        }
    }
}
