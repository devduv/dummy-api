package pe.com.hiper.bmatic.dummyapi.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.com.hiper.bmatic.dummyapi.application.DummyService;
import pe.com.hiper.bmatic.dummyapi.domain.customer.dto.CustomerResponseDTO;
import pe.com.hiper.bmatic.dummyapi.error.DocumentNotAcceptable;

@RestController
@RequestMapping("/customer")
public class DummyController {

	@Autowired
	private DummyService service;

	// @ResponseStatus(HttpStatus.CREATED)
	@GetMapping
	public ResponseEntity<CustomerResponseDTO> segmentationToHost(
			@RequestParam(value = "tipoDocumento", required = true) String documentType,
			@RequestParam(value = "numeroDocumento", required = true) String documentId,
			@RequestParam(value = "areaAtencion", required = false) String attentionArea, HttpServletRequest request) {

		if (documentId.equals("")) {
			throw new RuntimeException();
		}
		
		gg(documentId, documentType);

		CustomerResponseDTO response = this.service.segmentationToHost(documentId, documentType, attentionArea);
		System.out.println(response);
		return ResponseEntity.ok(response);
	}

	private void gg(String documentId, String documentType) {
		if (documentId.equals("72228869") && documentType.equalsIgnoreCase("DNI")) {
			System.out.println(" throw new DocumentNotAcceptable");
			throw new DocumentNotAcceptable("Su fecha de cita aun no está habilitada");
		}
	}

}
