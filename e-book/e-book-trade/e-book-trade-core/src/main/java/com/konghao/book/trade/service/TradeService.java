package com.konghao.book.trade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konghao.book.trade.domain.Trade;
import com.konghao.book.trade.persistence.TradeMapper;

@Service
public class TradeService {

	@Autowired
	private TradeMapper tradeMapper;

	public void createTrade(Trade obj) {
		this.tradeMapper.insert(obj);
	}
}
