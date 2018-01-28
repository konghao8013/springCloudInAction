package com.konghao.book.consumer.order.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.konghao.book.user.facade.UserFacade;

@FeignClient(name = "e-book-user")
public interface UserService extends UserFacade {

}
