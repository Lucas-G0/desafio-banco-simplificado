package com.desafio.bancosimplificadojava.controller;

import com.desafio.bancosimplificadojava.dtos.CreateUserDTO;
import com.desafio.bancosimplificadojava.dtos.GetUserDTO;
import com.desafio.bancosimplificadojava.interfaces.ICreateUserService;
import com.desafio.bancosimplificadojava.interfaces.IGetUserService;
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
@RequestMapping("/users")
@Tag(name = "Usuários", description = "Operações de usuários")
public class UserController {
    @Autowired
    private ICreateUserService createUserService;
    @Autowired
    private IGetUserService getUserService;

    @Operation(summary = "Cria um usuário", description = "Adiciona um usuário na base de dados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário criado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao criar usuário", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody CreateUserDTO createUserDTO) {
        var response = createUserService.CreateAndSave(createUserDTO);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Busca todos os usuários")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuários encontrados")
    })
    @GetMapping
    public ResponseEntity<List<GetUserDTO>> getUsers() {
        var response = getUserService.findAll();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Busca usuário por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<GetUserDTO> getUserById(
            @Parameter(description = "ID do usuário", example = "1", required = true)
            @PathVariable Long id) throws Exception {
        var response = getUserService.getUserDTOById(id);
        return ResponseEntity.ok(response);
    }
}
