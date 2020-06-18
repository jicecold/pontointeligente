package com.example.pontointeligente.services

import com.example.pontointeligente.documents.Lancamento
import com.example.pontointeligente.repositories.LancamentoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

interface ILancamentoService {
    fun buscarPorFuncionarioId(funcionarioId: String, pageRequest: PageRequest): Page<Lancamento>
    fun buscarPorId(id: String): Lancamento?
    fun persistir(lancamento: Lancamento): Lancamento
    fun remover(id: String)
}

@Service
class LancamentoService(val lancamentoRepository: LancamentoRepository) : ILancamentoService {
    override fun buscarPorFuncionarioId(funcionarioId: String, pageRequest: PageRequest): Page<Lancamento> =
            lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest)

    override fun buscarPorId(id: String): Lancamento? = lancamentoRepository.findById(id).get()

    override fun persistir(lancamento: Lancamento): Lancamento = lancamentoRepository.save(lancamento)

    override fun remover(id: String) = lancamentoRepository.deleteById(id)
}