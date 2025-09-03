package co.com.crediya.usuariosservice.entrypoints.reactiveweb.controller;

import co.com.crediya.solicitudes.infrastructure.service.SolicitudService;
import co.com.crediya.solicitudes.domain.model.Solicitud;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/solicitudes")
@RequiredArgsConstructor
public class SolicitudController {

    private final SolicitudService service;

    @Operation(
            summary = "Registrar nueva solicitud",
            description = "Permite registrar una nueva solicitud de préstamo. " +
                    "Valida el tipo de préstamo y la información obligatoria antes de guardarla."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Solicitud registrada correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Solicitud.class))),
            @ApiResponse(responseCode = "400", description = "Error de validación en los datos enviados"),
            @ApiResponse(responseCode = "500", description = "Error interno en el servidor")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Solicitud> registrarSolicitud(@RequestBody Solicitud solicitud) {
        return service.registrarSolicitud(solicitud);
    }

    @Operation(
            summary = "Obtener todas las solicitudes",
            description = "Devuelve el listado completo de solicitudes registradas."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de solicitudes",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Solicitud.class))),
            @ApiResponse(responseCode = "500", description = "Error interno en el servidor")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Solicitud> obtenerTodas() {
        return service.obtenerTodas();
    }

    @Operation(
            summary = "Obtener solicitud por ID",
            description = "Devuelve la información de una solicitud a partir de su ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Solicitud encontrada",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Solicitud.class))),
            @ApiResponse(responseCode = "404", description = "Solicitud no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno en el servidor")
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Mono<Solicitud> obtenerPorId(@PathVariable String id) {
        return service.obtenerPorId(id);
    }
}
