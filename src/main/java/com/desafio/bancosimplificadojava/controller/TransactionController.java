package com.desafio.bancosimplificadojava.controller;

import com.desafio.bancosimplificadojava.dtos.GetTransactionDTO;
import com.desafio.bancosimplificadojava.dtos.SendTransactionDTO;
import com.desafio.bancosimplificadojava.interfaces.IGetTransactionService;
import com.desafio.bancosimplificadojava.interfaces.ISendTransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfer")
@Tag(name = "Transferências", description = "Operações de transferência entre usuários")
public class TransactionController {
    @Autowired
    private ISendTransactionService sendTransactionService;
    @Autowired
    private IGetTransactionService getTransactionService;

    @Operation(summary = "Envia uma transferência", description = "Transfere um valor de um pagador para um recebedor")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Transação realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado", content = @Content),
            @ApiResponse(responseCode = "422", description = "Saldo insuficiente ou usuário inválido", content = @Content),
    })
    @PostMapping
    public ResponseEntity<SendTransactionDTO> sendTransaction(@RequestBody SendTransactionDTO sendTransactionDTO) throws Exception {
        var response = sendTransactionService.Send(sendTransactionDTO);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Obter transferências", description = "Obtém todas as transferências realizadas pelo usuário")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Obteve todas as transferências com sucesso"),
    })
    @GetMapping("/{senderId}")
    public ResponseEntity<List<GetTransactionDTO>> getTransactions(
            @Parameter(description = "ID do usuário enviador", example = "1", required = true)
            @PathVariable("senderId") long senderId) {
        var response = getTransactionService.findBySenderId(senderId);
        return ResponseEntity.ok(response);
    }
}
