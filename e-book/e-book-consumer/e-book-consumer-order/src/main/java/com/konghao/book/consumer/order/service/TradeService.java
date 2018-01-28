package com.konghao.book.consumer.order.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.konghao.book.trade.facade.TradeFacade;

@FeignClient(name="e-book-trade")
public interface TradeService extends TradeFacade{

}
