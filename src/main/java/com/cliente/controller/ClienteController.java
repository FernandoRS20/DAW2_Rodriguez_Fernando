package com.cliente.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cliente.entity.Cliente;
import com.cliente.service.ClienteService;

@RestController
@RequestMapping("/rest/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Cliente>> listCliente(){
		List<Cliente> lista=service.listCliente();
		return ResponseEntity.ok(lista);
	}
	
	/*@PostMapping
	@ResponseBody
	public ResponseEntity<Cliente> registrarCliente(@RequestBody Cliente obj){
		Cliente objSalida=service.insertaActualiza(obj);
		if (objSalida == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(objSalida);
	}
	
	/*@PostMapping
	@ResponseBody
	public ResponseEntity<Cliente> insertaCliente(Cliente obj){
		if (obj == null) {
			return ResponseEntity.noContent().build();
		}else {
			obj.setCod_cliente(0);
			Cliente objSalida = service.insertaActualiza(obj);
			return ResponseEntity.ok(objSalida);
		}
	}*/
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<Cliente> actualizaCliente(@RequestBody Cliente obj){
		if(obj==null) {
			return ResponseEntity.badRequest().build();
		}else {
			Optional<Cliente> optCliente=service.buscarPorId(obj.getCod_cliente());
			if(optCliente.isPresent()) {
				Cliente objActualizado = service.insertaActualiza(obj);
				return ResponseEntity.ok(objActualizado);
			}else {
				return ResponseEntity.badRequest().build();
			}
		}
	}
	
	@DeleteMapping("/{paramId}")
	@ResponseBody
	public ResponseEntity<Cliente> eliminaCliente(@PathVariable("paramId") int cod_Cliente){
		Optional<Cliente> optCliente=service.buscarPorId(cod_Cliente);
		if(optCliente.isPresent()) {
			service.eliminaPorId(cod_Cliente);			
			Optional<Cliente> optEliminado=service.buscarPorId(cod_Cliente);
			if (optEliminado.isPresent()) {
				return ResponseEntity.badRequest().build();
			}else {
				return ResponseEntity.ok(optCliente.get());
			}
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
}
