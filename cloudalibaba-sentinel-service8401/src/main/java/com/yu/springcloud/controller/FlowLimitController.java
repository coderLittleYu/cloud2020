package com.yu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

        @GetMapping("/testA")
        public String testA(){
            /*try {
                TimeUnit.MILLISECONDS.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            this.getLine();
            return "------testA";
        }

        @GetMapping("/testB")
        public String testB(){
            log.info(Thread.currentThread().getName()+"\t"+"...testB");
            this.getLine();
            return "------testB";
        }


        @SentinelResource("getOrderResource")
        public void getLine(){
            log.info("***********链路中被调用的方法。");
        }


    @GetMapping("/testD")
    public String testD()
    {
        //try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        //log.info("testD 测试RT");

        log.info("testD 异常比例");
        int age = 10/0;
        return "------testD";
    }
    @GetMapping("/testE")
    public String testE()
    {
        log.info("testE 测试异常数");
        int age = 10/0;
        return "------testE 测试异常数";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler ="deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2){
           // int a=10/0; 运行时出错，不会兜底。另加其他配置fallback
        return "------testHotKey";
    }


    public  String deal_testHotKey(String p1, String p2, BlockException blockException){
        return "------deal_testHotKey,o(╥﹏╥)o";  //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
    }


}
