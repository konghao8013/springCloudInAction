package com.konghao.book.trade.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.konghao.book.order.facade.OrderFacade;


@FeignClient(name="e-book-order")
public interface OrderService extends OrderFacade{

}
