package com.cdt.app.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cdt.app.api.dto.request.OrderReqDto;
import com.cdt.app.api.dto.response.OrderResDto;
import com.cdt.app.api.dto.response.StoreResDto;
import com.cdt.app.mapper.OrderMapper;
import com.cdt.app.model.OrderEntity;
import com.cdt.app.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "CDT Challenge - Order Services")
@RequestMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderApiController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/findOrders/")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Retorna todos os pedidos", notes = "Serviço que retorna todos os pedidos")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Pedidos encontrado", response = OrderResDto.class),
			@ApiResponse(code = 400, message = "Parâmetros inválidos", response = Error.class),
			@ApiResponse(code = 500, message = "Erro interno no servidor", response = Error.class) })
	public List<OrderResDto> findOrders() throws Exception {
		
		List<OrderEntity> orders = orderService.findAllOrders();
		return new OrderMapper().entitiesToDtos(orders);
	}
	
	@GetMapping("/findOrders/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Retorna pedido pelo Id", notes = "Serviço que retorna pedido pelo id")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Pedidos encontrado", response = OrderResDto.class),
			@ApiResponse(code = 400, message = "Parâmetros inválidos", response = Error.class),
			@ApiResponse(code = 500, message = "Erro interno no servidor", response = Error.class) })
	public OrderResDto findOrderById(@ApiParam(value = "Id do pedido", required = true) @PathVariable("id") Long id) throws Exception {
		
		OrderEntity order = orderService.findOrderById(id);
		return new OrderMapper().entityToDto(order);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Cria um pedido", notes = "Serviço de cadastro de pedido")
	@ApiResponses({
			@ApiResponse(code = 201, message = "Modalidade de postagem alterada com sucesso", response = StoreResDto.class),
			@ApiResponse(code = 400, message = "Parâmetros inválidos", response = Error.class),
			@ApiResponse(code = 500, message = "Erro interno no servidor", response = Error.class) })
	public OrderResDto createOrder(@RequestBody @ApiParam(value = "Dados da modalidade de postagem", required = true) OrderReqDto dto) throws Exception {
		OrderEntity order = orderService.saveOrder(dto);
		return new OrderMapper().entityToDto(order);
	}
}
