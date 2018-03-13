package com.controller.bill;

import com.api.common.CommonDataService;
import com.domain.ResponseMessage;
import com.domain.entity.Lawcase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    CommonDataService commonDataService;


    /**
     *
     * @param accountID
     * @return
     */
    @RequestMapping(value = "/case",method = RequestMethod.GET)
    public ResponseMessage caseInfo(@RequestBody int accountID){
       ResponseMessage responseMessage = ResponseMessage.getOkResponseMessage();
       responseMessage.setData(commonDataService.caseInfo(accountID));
        List<Lawcase> lawcases = commonDataService.caseInfo(accountID);

        return responseMessage;
    }

    @RequestMapping(value = "/super",method = RequestMethod.GET)
    public ResponseMessage superInfo(@RequestBody int accountID){
        ResponseMessage responseMessage = ResponseMessage.getOkResponseMessage();
        responseMessage.setData(commonDataService.supInfo(accountID));
        return responseMessage;
    }

    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public ResponseMessage countInfo(@RequestBody int accountID){
        ResponseMessage responseMessage = ResponseMessage.getOkResponseMessage();
        responseMessage.setData(commonDataService.uploadInfo(accountID));
        return responseMessage;
    }

    @RequestMapping(value = "/caseNumber",method = RequestMethod.GET)
    public ResponseMessage caseNumber(){
        ResponseMessage responseMessage = ResponseMessage.getOkResponseMessage();
        responseMessage.setData(commonDataService);
        return responseMessage;
    }

}
