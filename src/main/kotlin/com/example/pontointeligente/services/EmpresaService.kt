package com.example.pontointeligente.services

import com.example.pontointeligente.documents.Empresa
import com.example.pontointeligente.repositories.EmpresaRepository
import org.springframework.stereotype.Service

interface IEmpresaService {
    fun buscarPorCnpj(cnpj: String): Empresa?
    fun persistir(empresa: Empresa): Empresa
}

@Service
class EmpresaService(val empresaRepository: EmpresaRepository) : IEmpresaService {
    override fun buscarPorCnpj(cnpj: String): Empresa? = empresaRepository.findByCnpj(cnpj)?.fromModel()
    override fun persistir(empresa: Empresa): Empresa = empresaRepository.save(empresa)
}