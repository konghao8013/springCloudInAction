package com.konghao.book.zull.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductFallbackProvider implements ZuulFallbackProvider {

	@Override
	public String getRoute() {
		// TODO 自动生成的方法存根 代表未那个服务提供fallback
		return "e-book-product";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		// TODO 自动生成的方法存根
		return new ClientHttpResponse() {

			@Override
			public InputStream getBody() throws IOException {
				// TODO 自动生成的方法存根
				String input = "商品服务不可用,请联系管理员！";
				return new ByteArrayInputStream(input.getBytes());
			}

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders header = new HttpHeaders();
				MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
				header.setContentType(mt);
				return header;
			}

			@Override
			public HttpStatus getStatusCode() throws IOException {
				// TODO 自动生成的方法存根 httpresponse的fallback的状态码 httpStatus值
				return HttpStatus.OK;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				//  httpresponse的fallback的状态码 int值
				return this.getStatusCode().value();
			}

			@Override
			public String getStatusText() throws IOException {
				// httpresponse的fallback的状态码 string值
				return this.getStatusCode().getReasonPhrase();
			}

			@Override
			public void close() {
				// TODO 自动生成的方法存根

			}
		};
	}

}
