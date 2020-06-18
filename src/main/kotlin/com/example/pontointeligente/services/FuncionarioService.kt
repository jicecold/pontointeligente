package com.example.pontointeligente.services

import com.example.pontointeligente.documents.Funcionario
import com.example.pontointeligente.repositories.FuncionarioRepository
import org.springframework.stereotype.Service

interface IFuncionarioService {
    fun persistir(funcionario: Funcionario): Funcionario
    fun buscarPorCpf(cpf: String): Funcionario?
    fun buscarPorEmail(email: String): Funcionario?
    fun buscarPorId(id: String): Funcionario?
}

@Service
class FuncionarioService(val funcionarioRepository: FuncionarioRepository) : IFuncionarioService {
    override fun persistir(funcionario: Funcionario): Funcionario = funcionarioRepository.save(funcionario)
    override fun buscarPorCpf(cpf: String): Funcionario? = funcionarioRepository.findByCpf(cpf)
    override fun buscarPorEmail(email: String): Funcionario? = funcionarioRepository.findByEmail(email)
    override fun buscarPorId(id: String): Funcionario? {
        val result = funcionarioRepository.findById(id)
        return result.get();
    }
}