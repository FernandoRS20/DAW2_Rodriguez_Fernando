package com.cliente.service;

import java.util.List;
import java.util.Optional;

import com.cliente.entity.Cliente;

public interface ClienteService {
	
	public abstract List<Cliente> listCliente();
	public abstract Cliente insertaActualiza(Cliente obj);
	public abstract Optional<Cliente> buscarPorId(int cod_cliente);
	public abstract void eliminaPorId(int cod_cliente);
}
