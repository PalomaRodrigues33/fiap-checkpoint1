package br.com.fiap.checkpoint1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.checkpoint1.model.Pedido;
import br.com.fiap.checkpoint1.repository.PedidoRepository;

import jakarta.validation.ValidationException;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    @Transactional
    public Pedido salvar(Pedido pedido) {
        validarPedido(pedido);
        return pedidoRepository.save(pedido);
    }

    @Transactional
    public void deletar(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new IllegalArgumentException("Pedido com ID " + id + " não encontrado.");
        }
        pedidoRepository.deleteById(id);
    }

    private void validarPedido(Pedido pedido) {
        if (pedido.getClienteNome() == null || pedido.getClienteNome().trim().isEmpty()) {
            throw new ValidationException("O nome do cliente é obrigatório.");
        }
        if (pedido.getValorTotal() < 0) {
            throw new ValidationException("O valor total não pode ser negativo.");
        }
    }
}
