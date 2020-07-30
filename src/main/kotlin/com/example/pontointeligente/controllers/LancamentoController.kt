package com.example.pontointeligente.controllers

import com.example.pontointeligente.documents.Lancamento
import com.example.pontointeligente.models.Response
import com.example.pontointeligente.services.FuncionarioService
import com.example.pontointeligente.services.LancamentoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("lancamentos")
class LancamentoController(
        val lancamentoService: LancamentoService,
        val funcionarioService: FuncionarioService
) {

    @PostMapping
    fun adicionar(@RequestBody lancamento: Lancamento): ResponseEntity<Response<Lancamento>> {
        return ResponseEntity.ok(Response(lancamento));
    }

    @GetMapping
    fun listar(): ResponseEntity<Response<String>> {
        return ResponseEntity.ok(Response("Olá Mundo!"));
    }

    @GetMapping("/funcionario/{funcionarioId}")
    fun listarPorFuncionarioId(@PathVariable("funcionarioId") funcionarioId: String) {

    }

}