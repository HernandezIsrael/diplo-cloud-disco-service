package unam.diplomado.pixupih.discoservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import unam.diplomado.pixupih.discoservice.domain.Disquera;

@RequestMapping(path = "api/disqueras/", produces = "application/json")
@CrossOrigin(origins = "*")
@Tag(name = "Disquera", description = "API del recurso Disquera")
public interface DisqueraApi {
	
	/***************** Mètodos GET *****************/
	
	@Operation(summary = "Obtiene el listado completo de Disqueras")
	@ApiResponses(
			value = {
					@ApiResponse(
							responseCode = "200",
							description = "Se ha completado la operaciòn con èxito.",
							content = {
									@Content(
											mediaType = "application/json",
											schema = @Schema(implementation = Disquera.class)
											)
									}
							),
					}
			)
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	Iterable<Disquera> obtenerDisqueras();
	
	//
	
	@Operation(summary = "Obtiene una disquera a travès de un ID")
	@ApiResponses(
			value = {
				@ApiResponse(
						responseCode = "200",
						description = "Se ha completado la acciòn correctamente.",
						content = @Content(
								mediaType = "application/json",
								schema = @Schema(implementation = Disquera.class)
								)
						),
				@ApiResponse(
						responseCode = "404",
						description = "No existe Disquera con el ID proporcionado.",
						content = @Content
						)
					}
			)
	@GetMapping("{id}")
	ResponseEntity<Disquera> obtenerDisqueraById(@PathVariable("id") String id);
	
/***************** Mètodos POST *****************/
	
	@Operation(summary = "Crear Disquera especificando ùnicamente su nombre")
	@ApiResponses(
	    value = {
	        @ApiResponse(
	            responseCode = "201",
	            description = "Disquera creada correctamente.",
	            content = {
	                @Content(
	                    mediaType = "application/json",
	                    schema = @Schema(implementation = Disquera.class)
	                )
	            }
	        ),
	    }
	)
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	Disquera crearDisquera(@RequestBody Disquera nuevo);
	
	/***************** Mètodos PUT *****************/
	
	@Operation(summary = "Actualiza el nombre de una Disquera con el ID especificado en el PATH.")
	@ApiResponses(
			value = {
			@ApiResponse(
					responseCode = "200",
					description = "Se ha actualizado la informaciòn correctamente.",
					content = {
							@Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Disquera.class)
									)
							}
					),
			@ApiResponse(
					responseCode = "404",
					description = "No se encontrò Disquera con el ID especificado.",
					content = @Content
					)
			}
	)
	@PutMapping(path = "{id}", consumes = "application/json")
	public ResponseEntity<Disquera> actualizaDisquera(@PathVariable("id") String id, @RequestBody Disquera nuevo);
	
	/***************** Mètodos DELETE *****************/
	
	@Operation(summary = "Elimina la Disquera con el ID especificado en el PATH.")
	@ApiResponses(
			value = {
				@ApiResponse(
						responseCode = "204",
						description = "Operaciòn de borrado completada (No valida la existencia).",
						content = @Content
						)	
				}
		)
	@DeleteMapping("{id}")
	public void borrarDisqueraPorId(@PathVariable("id") String id);

}
