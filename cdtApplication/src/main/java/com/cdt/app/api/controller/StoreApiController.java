package com.cdt.app.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cdt.app.api.dto.request.StoreReqDto;
import com.cdt.app.api.dto.response.StoreResDto;
import com.cdt.app.mapper.StoreMapper;
import com.cdt.app.model.StoreEntity;
import com.cdt.app.service.StoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@Api(tags = "CDT Challenge - Store Services")
@RequestMapping(value = "/store", produces = MediaType.APPLICATION_JSON_VALUE)
public class StoreApiController {

	@Autowired
	private StoreService storeService;
	
	@GetMapping("/findStores/")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Retorna todas as lojas", notes = "Serviço que retorna todas as lojas cadastradas")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Lojas encontradas com sucesso", response = StoreResDto.class),
			@ApiResponse(code = 400, message = "Parâmetros inválidos", response = Error.class),
			@ApiResponse(code = 500, message = "Erro interno no servidor", response = Error.class) })
	public List<StoreResDto> findStore() throws Exception {
		
		List<StoreEntity> stores = storeService.findAllStore();
		return new StoreMapper().entitiesToDtos(stores);
	}
	
	@GetMapping("/findStores/{name}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Retorna a loja pelo nome", notes = "Serviço que retorna uma loja pelo nome")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Loja encontradas com sucesso", response = StoreResDto.class),
			@ApiResponse(code = 400, message = "Parâmetros inválidos", response = Error.class),
			@ApiResponse(code = 500, message = "Erro interno no servidor", response = Error.class) })
	public StoreResDto findStoreByName(@ApiParam(value = "Nome da loja", required = true) @PathVariable("name") String name) throws Exception {
		
		StoreEntity store = storeService.findStoreByName(name);
		return new StoreMapper().entityToDto(store);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Cria uma loja", notes = "Serviço de cadastro de uma loja")
	@ApiResponses({
			@ApiResponse(code = 201, message = "Loja cadastrada com sucesso", response = StoreResDto.class),
			@ApiResponse(code = 400, message = "Parâmetros inválidos", response = Error.class),
			@ApiResponse(code = 500, message = "Erro interno no servidor", response = Error.class) })
	public StoreResDto createStore(@RequestBody @ApiParam(value = "Dados da modalidade de postagem", required = true) StoreReqDto dto) throws Exception {
		StoreEntity store = storeService.saveStore(dto);
		return new StoreMapper().entityToDto(store);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Atualiza uma loja", notes = "Serviço de atualização de uma loja")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Loja atualiazada com sucesso", response = StoreResDto.class),
			@ApiResponse(code = 400, message = "Parâmetros inválidos", response = Error.class),
			@ApiResponse(code = 500, message = "Erro interno no servidor", response = Error.class) })
	public StoreResDto updateStore(@RequestBody @ApiParam(value = "Dados da modalidade de postagem", required = true) StoreReqDto dto) throws Exception {
		StoreEntity store = storeService.saveStore(dto);
		return new StoreMapper().entityToDto(store);
	}
}
