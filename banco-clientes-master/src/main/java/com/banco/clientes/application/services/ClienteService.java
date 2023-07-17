package com.banco.clientes.application.services;

import com.banco.clientes.domain.model.Cliente;
import com.banco.clientes.domain.repository.ClientesRepository;
import com.banco.clientes.domain.utils.TipoDocumento;
import com.banco.clientes.infrastructure.persistence.ClientesRepositoryImpl;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase que proporciona servicios relacionados con la gestión de clientes.
 */
@Service
public class ClienteService extends ClientesRepositoryImpl {

  public ClienteService(ClientesRepository clientesRepo) {
    super(clientesRepo);
  }

  @Override
  public Flux<Cliente> findAllByIndEliminado(int indEliminado) {
    return clientesRepo.findAllByIndEliminado(indEliminado);
  }

  @Override
  public Mono<Long> countByTipoDocumentoAndNumDocumento(
          TipoDocumento tipoDocumento, String numDocumento) {
    return clientesRepo.countByTipoDocumentoAndNumDocumento(tipoDocumento, numDocumento);
  }

  @Override
  public Mono<Cliente> findFirstByTipoDocumentoAndNumDocumento(
      TipoDocumento tipoDocumento, String numDocumento) {
    return clientesRepo.findFirstByTipoDocumentoAndNumDocumento(tipoDocumento, numDocumento);
  }

  @Override
  public Mono<Cliente> findFirstByIdAndIndEliminado(String id,
      Integer indEliminado) {
    return clientesRepo.findFirstByIdAndIndEliminado(id, indEliminado);
  }

  @Override
  public Mono<Long> countByIdAndIndEliminado(String id, Integer indEliminado) {
    return clientesRepo.countByIdAndIndEliminado(id, indEliminado);
  }

  @Override
  public Mono<Cliente> save(Cliente cliente) {
    return clientesRepo.save(cliente);
  }

}
