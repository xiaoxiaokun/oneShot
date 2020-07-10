package web;

import dto.exposer;
import dto.oneShotExecution;
import dto.oneShotResult;
import entity.products;
import enums.oneShotStateEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.oneShotService;
import exception.*;

import java.util.Date;
import java.util.List;

/**
 * @Author jxx
 * @create 2020/7/9 11:02 下午
 */


@Controller
@RequestMapping("/oneShot")    // url:/模块/资源/{}/细分
public class oneShotController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private oneShotService shotService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        //获取列表页
        List<products> list = shotService.getProductsList();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping(value = "/{oneShotId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("oneShotId") Long oneShotId, Model model) {
        if (oneShotId == null)
            return "redirect:/oneShot/list";

        products p = shotService.getById(oneShotId);
        if (p == null)
            return "forward:/oneShot/list";

        model.addAttribute("oneShot", p);
        return "detail";
    }


    @RequestMapping(value = "/{oneShotId}/exposer", method = RequestMethod.POST,
                    produces = {"application/json;character=UTF-8"})
    @ResponseBody
    public oneShotResult<exposer> exposer(@PathVariable("oneShotId") Long oneShotId) {
        oneShotResult<exposer> result;

        try {
            exposer exposer = shotService.exportOneShotUrl(oneShotId);
            result = new oneShotResult<>(true, exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new oneShotResult<>(false, e.getMessage());
        }

        return result;
    }


    @RequestMapping(value = "/{oneShotId}/{md5}/execution", method = RequestMethod.POST,
                    produces = {"application/json;character=UTF-8"})
    @ResponseBody
    public oneShotResult<oneShotExecution> execute(@PathVariable("oneShotId") Long oneShotId,
                                                   @CookieValue(value = "shotPhone", required = false) Long userPhone,
                                                   @PathVariable("md5") String md5) {
        oneShotResult<oneShotExecution> result;

        if (userPhone == null) {
            return new oneShotResult<>(false, "未注册");
        }
        try {
            oneShotExecution execution = shotService.executeOneShot(oneShotId, userPhone, md5);
            return new oneShotResult<>(true, execution);
        } catch (repeatShotException e){
            oneShotExecution execution = new oneShotExecution(oneShotId, oneShotStateEnum.REPEAT_ONESHOT);
            return new oneShotResult<>(false, execution);
        } catch (shotCloseException e) {
            oneShotExecution execution = new oneShotExecution(oneShotId, oneShotStateEnum.END);
            return new oneShotResult<>(false, execution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            oneShotExecution execution = new oneShotExecution(oneShotId, oneShotStateEnum.INNER_ERROR);
            return new oneShotResult<>(false, execution);
        }
    }

    @RequestMapping(value = "/time/now", method = RequestMethod.GET)
    @ResponseBody
    public oneShotResult<Long> time(){
        Date date = new Date();
        return new oneShotResult<>(true, date.getTime());
    }
}
