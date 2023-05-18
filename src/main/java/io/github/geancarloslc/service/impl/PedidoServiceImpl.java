package io.github.geancarloslc.service.impl;

import io.github.geancarloslc.api.dto.PedidoDTO;
import io.github.geancarloslc.domain.entity.Pedido;
import io.github.geancarloslc.domain.enums.StatusPedido;
import io.github.geancarloslc.domain.repository.PedidoRepository;
import io.github.geancarloslc.exception.PedidoNaoEncontradoException;
import io.github.geancarloslc.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor //Declara os construtores com as variaveis com final
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    @Override
    public Pedido salvar(PedidoDTO pedidoDTO) {
        return null;
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return pedidoRepository.findByIdFetchItensPedidos(id);
    }

    @Override
    @Transactional
    public void atualizaStatus(Integer id, StatusPedido statusPedido) {
        pedidoRepository.findById(id)
                .map( pedido -> {
                            pedido.setStatusPedido(statusPedido);
                            pedidoRepository.save(pedido);
                            return Void.TYPE;
                        }).orElseThrow( () -> new PedidoNaoEncontradoException());
    }
}
