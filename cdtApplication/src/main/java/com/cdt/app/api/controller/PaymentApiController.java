package com.cdt.app.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cdt.app.api.dto.request.PaymentReqDto;
import com.cdt.app.api.dto.response.PaymentResDto;
import com.cdt.app.api.dto.response.StoreResDto;
import com.cdt.app.mapper.PaymentMapper;
import com.cdt.app.model.PaymentEntity;
import com.cdt.app.service.PaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "CDT Challenge - Payment Services")
@RequestMapping(value = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaymentApiController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Realiza um pagamento", notes = "Serviço de pagamento de um pedido")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Pagamento realizado com sucesso", response = StoreResDto.class),
			@ApiResponse(code = 400, message = "Parâmetros inválidos", response = Error.class),
			@ApiResponse(code = 500, message = "Erro interno no servidor", response = Error.class) })
	public PaymentResDto executePayment(@RequestBody @ApiParam(value = "Dados da modalidade de postagem", required = true) PaymentReqDto dto) throws Exception {
		PaymentEntity order = paymentService.executePayment(dto);
		return new PaymentMapper().entityToDto(order);
	}
	
	@PostMapping("/refund/")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Realiza o reembolso de um pagamento", notes = "Serviço de reembolso de um pagamento")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Reembolso realizado com sucesso", response = StoreResDto.class),
			@ApiResponse(code = 400, message = "Parâmetros inválidos", response = Error.class),
			@ApiResponse(code = 500, message = "Erro interno no servidor", response = Error.class) })
	public PaymentResDto refundPayment(@RequestBody @ApiParam(value = "Dados da modalidade de postagem", required = true) PaymentReqDto dto) throws Exception {
		PaymentEntity order = paymentService.refundPayment(dto);
		return new PaymentMapper().entityToDto(order);
	}
}
