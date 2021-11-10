package com.cliente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cliente.entity.Cliente;
import com.cliente.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public Cliente insertaActualiza(Cliente obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public List<Cliente> listCliente() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<Cliente> buscarPorId(int cod_cliente) {
		return repository.findById(cod_cliente);
	}

	@Override
	public void eliminaPorId(int cod_cliente) {
		// TODO Auto-generated method stub
		
	}

}
