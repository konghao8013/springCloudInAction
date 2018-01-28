package com.konghao.book.trade.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.konghao.book.order.domain.Order;
import com.konghao.book.trade.domain.Trade;
import com.konghao.book.trade.facade.TradeFacade;
import com.konghao.book.trade.service.OrderService;
import com.konghao.book.trade.service.TradeService;

@RestController
public class TradeFacadeImpl implements TradeFacade {

	@Autowired
	TradeService tradeService;

	@Autowired
	OrderService orderService;

	@Override
	public void createTrade(@RequestBody Trade obj) {
		this.tradeService.createTrade(obj);

		// 回填 订单里面的交易号
		Order order = this.orderService.findOrderById(obj.getOrderId());
		// Order order=new Order();
		// order.setId(obj.getId());
		order.setTradeId(obj.getId());
		order.setTradeStatus((byte) 1);
		this.orderService.updateOrderByTrade(order);
	}

}
