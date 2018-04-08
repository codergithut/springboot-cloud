package elasticsearch;

import com.domain.entity.HotWorld;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {

    @Test
    public void restTest() {
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
//  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//  封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap params= new LinkedMultiValueMap<String, String>();
//  也支持中文
        params.add("begin", "1");
        params.add("end", "5");
        params.add("size", "10");
        params.add("caseType", "72");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        //HotWorld[] obs = restTemplate.getForObject("http://127.0.0.1:8081/api/hotWorld?begin=1&end=6&size=10&caseType=72", HotWorld[].class, param);
        HotWorld[] obs1 = restTemplate.postForObject("http://127.0.0.1:8081/api/hotWorld", requestEntity, HotWorld[].class);
        System.out.println("");
//        System.out.println(obs.length);
    }

}
